# Uol Challenge Backend

## Overview
This project is a backend application built with Spring Boot, designed for managing players and their group nicknames (e.g., Avengers, Justice League). It features RESTful APIs, web views with Thymeleaf, and uses an H2 database for data persistence. The project is containerized with Docker and includes infrastructure-as-code (IaC) for cloud provisioning using Terraform.

## Features
- Player registration and management
- Unique nickname enforcement within groups
- RESTful API endpoints
- Web interface using Thymeleaf
- H2 file-based database
- Docker and Docker Compose support
- Infrastructure automation with Terraform

## Project Structure
```
├── src/main/java/uol_host_backend/
│   ├── application/
│   │   ├── dtos/                # Data Transfer Objects (AvengersDTO, JusticeLeagueDTO, NicknameDTO)
│   │   ├── interfaces/          # Repository interfaces (NicknameRepository)
│   │   └── services/            # Business logic (NicknameService, PlayerService)
│   ├── domain/
│   │   ├── entities/            # Domain entities (Player)
│   │   ├── enums/               # Enum types (GroupNickname)
│   │   └── repositories/        # Repository implementations (AvengersRepository, etc.)
│   ├── exception/               # Custom exceptions (GroupNicknameUnavailableException)
│   └── infraestructure/
│       └── controllers/         # REST and web controllers (PlayerController, ListAllPlayers)
├── src/main/resources/
│   ├── application.properties   # Spring Boot configuration
│   ├── schema.sql               # Database schema
│   └── templates/               # Thymeleaf HTML templates
├── data/                        # H2 database files (persisted with Docker volume)
├── iac/                         # Infrastructure as Code (Terraform files)
├── Dockerfile                   # Docker build instructions
├── docker-compose.yml           # Multi-container orchestration
├── pom.xml                      # Maven build configuration
├── HELP.md                      # Spring Boot help and references
└── README.md                    # Project documentation (this file)
```

## Getting Started

### Prerequisites
- Java 21+
- Maven 3.9+
- Docker & Docker Compose (optional, for containerized deployment)
- Terraform (optional, for IaC)

### Running Locally
1. **Build the project:**
   ```sh
   mvn clean package
   ```
2. **Run with Maven:**
   ```sh
   mvn spring-boot:run
   ```
3. **Or run with Docker Compose:**
   ```sh
   docker-compose up --build
   ```

### Accessing the Application
- Web UI: [http://localhost:8080](http://localhost:8080)
- H2 Console: [http://localhost:8080/h2-console](http://localhost:8080/h2-console)
  - JDBC URL: `jdbc:h2:file:./data/players`
  - User: `sa`
  - Password: (leave blank)

## Infrastructure as Code (IaC)
Terraform files are located in the `iac/` directory. These files can be used to provision cloud resources (e.g., IAM, databases). Sensitive files and state are excluded via `.gitignore`.

## Testing
Run tests with:
```sh
mvn test
```

## License
This project is for demonstration and educational purposes.

