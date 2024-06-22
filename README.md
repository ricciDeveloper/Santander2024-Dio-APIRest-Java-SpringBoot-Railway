# Santander API Rest - User Service 🚀

## Technologies Used 🛠️
- Java
- Spring Boot
- Spring Data JPA
- Docker
- PostgreSQL (or your preferred database)
- Railway (for cloud deployment)

## Development Setup 🛠️
### Prerequisites 📝
- JDK (Java Development Kit) installed
- Maven or Gradle installed
- IDE (like IntelliJ IDEA, Eclipse) with Spring Boot support
- Docker (for running PostgreSQL container locally)
  
Access the deployed API:

API URL: [https://s2024api.up.railway.app](https://s2024api.up.railway.app)

# Diagrama de classes: 
```mermaid
classDiagram
  class User {
    -String name
    -Account account
    -Feature[] features
    -Card card
    -News[] news
  }

  class Account {
    -String number
    -String agency
    -Number balance
    -Number limit
  }

  class Feature {
    -String icon
    -String description
  }

  class Card {
    -String number
    -Number limit
  }

  class News {
    -String icon
    -String description
  }

  User "1" *-- "1"  Account
  User  "1" *--  "N"Feature
  User  "1" *-- "1" Card
  User "1" *-- "N" News

    
```
