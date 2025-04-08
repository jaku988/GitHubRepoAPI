# GitHub Repo API


## <b><u>English</u></b>
A simple Spring Boot REST API that fetches public, non-fork repositories for a given GitHub user.  
It returns the repository name, owner's login, and a list of branches with the last commit SHA.
Application works on endpoint: GET /api/github/repositories/{username}

## 🛠 Technologies Used

- Java 21
- REST API
- Spring Boot
- Spring Web
- Spring Test (MockMvc)

## 🔧 How to Run

Make sure you have **Java 21** and **Maven** (or Gradle) installed.

```bash
# Clone the repository
git clone https://github.com/your-username/github-repo-api.git
cd github-repo-api

# Build and run the project
./mvnw spring-boot:run
```

Then check the URL: 

```
localhost:8080/api/github/repositories/{username}
```

### Example response:
```Json
[
  {
    "name": "my-repo",
    "ownerLogin": "octocat",
    "branches": [
      {
        "name": "main",
        "lastCommitSha": "f84c90b1a9a1..."
      }
    ]
  }
]
```

## <b><u>Polski</u></b>

Prosta aplikacja REST API stworzona w Spring Boot, która pobiera publiczne repozytoria użytkownika GitHub (z pominięciem forków).  
Zwraca nazwę repozytorium, login właściciela oraz listę gałęzi z ostatnim SHA commita.  
Aplikacja działa pod endpointem: `GET /api/github/repositories/{username}`

## 🛠 Wykorzystane technologie

- Java 21
- Spring Boot
- Spring Web
- Spring Test (MockMvc)
- JUnit 5
- Mockito

## 🔧 Jak uruchomić projekt

Upewnij się, że masz zainstalowane **Java 21** oraz **Maven** (lub Gradle).

```bash
# Sklonuj repozytorium
git clone https://github.com/your-username/github-repo-api.git
cd github-repo-api

# Zbuduj i uruchom aplikację
./mvnw spring-boot:run
```

Po czym sprawdź URL:
```
localhost:8080/api/github/repositories/{username}
```


### Przykładowa odpowiedź:
```Json
[
  {
    "name": "my-repo",
    "ownerLogin": "octocat",
    "branches": [
      {
        "name": "main",
        "lastCommitSha": "f84c90b1a9a1..."
      }
    ]
  }
]
```

