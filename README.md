# Microservice App with SpringBoot, Consul, Vault, and Angular

Welcome to the Microservice App project! This project is built using SpringBoot for the backend services, Consul for service discovery and configuration management, Vault for secret management, and Angular for the front-end application. This README.md file provides an overview of the project structure, setup instructions, and additional information to help you get started.

## Project Structure

The project is organized into several modules:

- **Config-service**: Responsible for managing configuration properties for all services.
- **Gateway-service**: Acts as an API gateway, routing requests to the appropriate microservices.
- **Customer-service**: Handles customer-related operations.
- **Inventory-service**: Manages inventory and stock-related operations.
- **Order-service**: Deals with order processing and management.
- **Billing-service**: Manages billing and payment operations.

```
├───Management_app
    ├───Config-service
    ├───gateway-service
    ├───customer-service
    ├───Inventory-service
    ├───order-service
    └───billing-service
```

## Technologies Used

- **SpringBoot**: Backend framework for building Java-based microservices.
- **Consul**: Service discovery and configuration management tool.
- **Vault**: Secret management tool for securing sensitive information.
- **Angular**: Front-end framework for building dynamic web applications.

## Prerequisites

Before you begin, ensure you have the following installed:

- Java Development Kit (JDK)
- Node.js and npm (for Angular development)
- Consul and Vault setup and running
- IDE (such as IntelliJ IDEA or Eclipse) for Java development
- Angular CLI (for Angular development)

## Setup Instructions

1. **Clone the Repository**:

    ```bash
    git clone <repository_url>
    cd Management_app
    ```

2. **Backend Setup**:
    - run `consul` server with the command bellow:
    ```bash
    consul agent -server -bootstrap-expect=1 -data-dir=consul-data -ui -bind=<YOUR IP@>
   ```
    - run the `Vault` server and follow the instructions to configure your environment:
    ```bash
    vault server -dev
    ```
    - Open each microservice in your preferred IDE and configure the necessary properties in the `application.properties` file. This includes database configurations, service endpoints, and other settings.
    - Build and run each microservice individually.

3. **Frontend Setup**:

    - Navigate to the Angular app folder.
    - Install dependencies:

        ```bash
        npm install
        ```

    - Start the Angular development server:

        ```bash
        ng serve
        ```

4. **Consul and Vault Configuration**:

    - Configure Consul and Vault with the appropriate settings. Ensure that service registration, discovery, and configuration are properly set up.

5. **Accessing the Application**:

    - Once all microservices are up and running, and the Angular app is compiled, you can access the application in your browser at `http://localhost:4200` or the specified Angular development server URL.

## ToDo

- [x] **Security**: Ensure that proper security measures are implemented, including authentication and authorization mechanisms for both microservices and the Angular app.
- [ ] **Error Handling**: Implement comprehensive error handling and logging mechanisms to identify and troubleshoot issues effectively.
- [ ] **Scalability**: Design the microservices architecture to be scalable, allowing easy addition of new services or instances as the application grows.
- [ ] **Documentation**: Maintain detailed documentation for API endpoints, data models, and overall system architecture for future reference and collaboration.

Feel free to modify and enhance the project as needed. Happy coding!