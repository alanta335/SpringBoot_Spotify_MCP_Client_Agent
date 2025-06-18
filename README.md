# 🌟 Spring Boot MCP Client

This project is a **Spring Boot** application designed as a **Spotify MCP (Model Context Protocol) client agent**. It
was created for **integration with Spotify's MCP services**.

---

## ✨ Features

- 🚀 Implements **MCP client** functionality for chat-based interactions.
- 🛠️ Demonstrates the use of **Spring Boot** for building robust applications.
- 📦 Includes configurations, controllers, and models for handling chat requests and responses.
- 🔄 Centralized exception handling for improved error management.
- 🗂️ Externalized configuration for MCP servers and application settings.

---

## 📂 Project Structure

```plaintext
HELP.md
LICENSE
mvnw
mvnw.cmd
pom.xml
README.md
src/
  main/
    java/
      com/
        example/
          demo/
            DemoApplication.java
            config/
              ChatClientConfig.java
              MCPConfig.java
              WebConfig.java
            controller/
              ChatController.java
            exception/
              GlobalExceptionHandler.java
              LLMServiceException.java
            model/
              request/
                ChatRequestDto.java
              response/
                QueryResultResponseDto.java
            service/
    resources/
      application.yaml
      mcp-servers.json
      static/
      templates/
  test/
    java/
      com/
        example/
          demo/
            DemoApplicationTests.java
```

---

## 🚀 Getting Started

1. **Clone the repository:**
   ```sh
   git clone <repo-url>
   cd mcp-client
   ```
2. **Build the project:**
   ```sh
   ./mvnw clean install
   ```
3. **Run the application:**
   ```sh
   ./mvnw spring-boot:run
   ```

---

## ⚙️ Configuration

- **application.yaml**: Main Spring Boot configuration.
- **mcp-servers.json**: List of MCP server endpoints.

---

## 📬 Usage

- The main chat endpoint is available via `ChatController`.
- Customize MCP server settings in `mcp-servers.json`.

---

## 🧩 Main Components

- `controller/ChatController.java`: Handles chat requests.
- `config/`: Application and client configuration.
- `exception/`: Custom exception handling.
- `model/request/ChatRequestDto.java`: Chat request model.
- `model/response/QueryResultResponseDto.java`: Chat response model.

---

## 📝 License

This project is licensed under the terms of the LICENSE file.

---