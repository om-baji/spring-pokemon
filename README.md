# Pokémon REST API

A simple Spring Boot RESTful service to manage Pokémon data, including CRUD operations and searching by name or type.

---

## Features

* Retrieve all Pokémon
* Get Pokémon by ID
* Create a new Pokémon
* Search Pokémon by name
* Search Pokémon by type

---

## Technologies Used

* Java 17+
* Spring Boot
* Spring Data JPA
* Hibernate
* MySQL (or any relational database)
* Lombok

---

## API Endpoints

Base URL: `/api`

| Method | Endpoint          | Description             | Request Parameters/Body      | Response                 |
| ------ | ----------------- | ----------------------- | ---------------------------- | ------------------------ |
| GET    | `/pokemons`       | Get list of all Pokémon | None                         | List of all PokémonModel |
| GET    | `/pokemon/{id}`   | Get a Pokémon by its ID | Path variable: `id` (String) | Optional PokémonModel    |
| POST   | `/pokemon`        | Create a new Pokémon    | JSON body of `PokemonModel`  | Created PokémonModel     |
| GET    | `/pokemon/byName` | Get Pokémon by name     | Query param: `name` (String) | PokémonModel             |
| GET    | `/pokemon/byType` | Get Pokémon by type     | Query param: `type` (String) | List of PokémonModel     |

---

## Sample Requests

### Get all Pokémon

```bash
curl -X GET http://localhost:8080/api/pokemons
```

### Get Pokémon by ID

```bash
curl -X GET http://localhost:8080/api/pokemon/123e4567-e89b-12d3-a456-426614174000
```

### Create a new Pokémon

```bash
curl -X POST http://localhost:8080/api/pokemon \
-H "Content-Type: application/json" \
-d '{"name":"Pikachu","types":["Electric"]}'
```

### Get Pokémon by name

```bash
curl -X GET "http://localhost:8080/api/pokemon/byName?name=Pikachu"
```

### Get Pokémon by type

```bash
curl -X GET "http://localhost:8080/api/pokemon/byType?type=Electric"
```

---

## Setup Instructions

1. Clone the repository

   ```bash
   git clone https://github.com/yourusername/pokemon-rest-api.git
   cd pokemon-rest-api
   ```

2. Configure your database connection in `src/main/resources/application.properties`:

   ```properties
   spring.datasource.url=jdbc:mysql://localhost:3306/pokemonrest
   spring.datasource.username=root
   spring.datasource.password=your_password
   spring.jpa.hibernate.ddl-auto=update
   ```

3. Create the database in MySQL if not already done:

   ```sql
   CREATE DATABASE pokemonrest;
   ```

4. Build and run the application with Maven:

   ```bash
   ./mvnw spring-boot:run
   ```

5. Access the API at `http://localhost:8080/api`

---

## Notes

* The `id` field for Pokémon is auto-generated as a UUID.
* The `types` field supports multiple Pokémon types as a set.
* The API currently assumes exact match searches for name and type.
