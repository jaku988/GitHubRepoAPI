package org.example.githubrepoapi;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.mockito.ArgumentMatchers.anyString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class GitHubControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private GitHubService gitHubService;

    @Test
    @DisplayName("✅ Powinno zwrócić listę repozytoriów dla poprawnego użytkownika")
    void shouldReturnRepositoriesForValidUsername() throws Exception {
        RepositoryResponse repo = new RepositoryResponse("repo1", "octocat", List.of());
        Mockito.when(gitHubService.getUserRepositories("octocat")).thenReturn(List.of(repo));

        mockMvc.perform(get("/api/github/repositories/octocat"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$").isArray())
                .andExpect(jsonPath("$[0].name").value("repo1"))
                .andExpect(jsonPath("$[0].ownerLogin").value("octocat"));
    }

    @Test
    @DisplayName("❌ Should return 404 if the user does not exist")
    void shouldReturn404WhenUserNotFound() throws Exception {
        Mockito.when(gitHubService.getUserRepositories("unknown-user"))
                .thenThrow(new CustomHttpException("Not Found", 404));

        mockMvc.perform(get("/api/github/repositories/unknown-user"))
                .andExpect(status().isNotFound())
                .andExpect(jsonPath("$.message").value("Not Found"))
                .andExpect(jsonPath("$.statusCode").value(404));
    }

    @Test
    @DisplayName("❌ Should return 400 if the user is empty")
    void shouldReturn400ForEmptyUsername() throws Exception {
        mockMvc.perform(get("/api/github/repositories/"))
                .andExpect(status().isNotFound()); //
    }

    @Test
    @DisplayName("❌ Should return 400 if the user containts forbidden characters")
    void shouldReturn400ForInvalidUsername() throws Exception {
        String invalidUsername = "user@#!";

        Mockito.when(gitHubService.getUserRepositories(invalidUsername))
                .thenThrow(new CustomHttpException("Invalid username", 400));

        mockMvc.perform(get("/api/github/repositories/" + invalidUsername))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.message").value("Invalid username"))
                .andExpect(jsonPath("$.statusCode").value(400));
    }

    @Test
    @DisplayName("❌ Should return 500 if unexpected error occurs")
    void shouldReturn500OnServerError() throws Exception {
        Mockito.when(gitHubService.getUserRepositories(anyString()))
                .thenThrow(new RuntimeException("Unexpected error"));

        mockMvc.perform(get("/api/github/repositories/octocat"))
                .andExpect(status().isInternalServerError())
                .andExpect(jsonPath("$.message").value("Unexpected error"))
                .andExpect(jsonPath("$.statusCode").value(500));
    }
}
