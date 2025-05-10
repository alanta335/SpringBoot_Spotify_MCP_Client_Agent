# 🌟 Spring Boot MCP Client

This project is a **Spring Boot** application designed as an **MCP (Model Context Protocol) client**. It was created for **learning** and **experimentation** purposes.

---

## ✨ Features

- 🚀 Implements **MCP client** functionality.
- 🛠️ Demonstrates the use of **Spring Boot** for building robust applications.
- 📦 Includes configurations, controllers, and models for handling chat requests and responses.

---

## 📂 Project Structure

```plaintext
HELP.md
LICENSE
mvnw
mvnw.cmd
pom.xml
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
                        controller/
                            ChatController.java
                        model/
                            request/
                                ChatRequestDto.java
                            response/
                                QueryResultResponseDto.java
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

## 🛠️ Prerequisites

- **Java 17** or higher
- **Maven 3.8** or higher

---

## 🚀 Getting Started

1. **Clone the repository:**

   ```bash
   git clone <repository-url>
   ```

2. **Navigate to the project directory:**

   ```bash
   cd mcp-client
   ```

3. **Build the project using Maven:**

   ```bash
   ./mvnw clean install
   ```

4. **Run the application:**

   ```bash
   ./mvnw spring-boot:run
   ```

5. **Access the application:**

   Open your browser and navigate to `http://localhost:8080`.

---

## ⚙️ Configuration

- The application configuration is located in `src/main/resources/application.yaml`.
- MCP server details are specified in `src/main/resources/mcp-servers.json`.

---

## 📜 License

This project is licensed under the terms of the [LICENSE](LICENSE) file.

---

## 🙏 Acknowledgments

This project was created as a **learning exercise** to explore **Spring Boot** and **MCP client development**.
