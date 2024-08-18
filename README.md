Management tool api

Management Tool is a simplified Trello-like application built with Java Spring Boot for the backend, H2 as the in-memory database, and Angular for the frontend. Users can create boards, lists, cards and add description to cards
to manage tasks efficiently.

## Features
- Create boards.
- Add lists to boards.
- Add cards to lists.
- Add descriptions to cards.

## Technologies Used
- **Backend:** Java Spring Boot, Spring Data JPA, H2 Database
- **Frontend:** Angular
- **Build Tools:** Maven
- **Version Control:** Git

## Getting Started
These instructions will help you set up and run the project on your local machine.

### Prerequisites
- Java 21 or later
- Node.js (for Angular)
- Maven 

### Installation
1. Clone the repository:
   ```bash
   git clone <your-repo-url>

Navigate to the project directory:
cd management-tool

Start the Spring Boot application.

## Configuration
- The H2 database is stored in a file under the `data/` directory (configured in `application.properties`).
- You can change the port and other configurations in the `application.properties` file.

## Note on `.gitignore`
The `data` directory, which contains the H2 database files, has been added to `.gitignore`. This means that the database files will not be tracked by Git. This is generally a good practice to avoid committing large files or sensitive data to the repository. 

If you need to persist data across application restarts, make sure to backup the database files manually or use an external database solution in a production environment.


## API Endpoints
Here are the main API endpoints:

- **Boards**
  - GET `/boards` - List all boards
  - POST `/boards` - Create a new board

- **Lists**
  - GET `/lists` - List all lists
  - POST `/lists` - Create a new list

- **Cards**
  - GET `/cards` - List all cards
  - POST `/cards` - Create a new card

- **Messages**
  - GET `/messages` - List all messages
  - POST `/messages` - Create a new message

## Acknowledgments
- Spring Boot Documentation
- Angular Documentation


