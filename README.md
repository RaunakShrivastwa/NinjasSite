# EduHub - Spring Boot and React

Welcome to the Teaching Website project! This is a platform for online education, where students can enroll in various courses and access a secure dashboard for their educational journey.

## Table of Contents

- [Introduction](#introduction)
- [Features](#features)
- [Technologies](#technologies)
- [Getting Started](#getting-started)
- [Project Structure](#project-structure)
- [Configuration](#configuration)
- [Usage](#usage)
- [Contributing](#contributing)
- [License](#license)

## Introduction

The Teaching Website is a full-stack web application built using Spring Boot for the backend and React for the frontend. It offers a comprehensive educational experience, allowing students to explore and enroll in various courses. The website incorporates the Razorpay payment gateway for easy course enrollment and provides students with a secure dashboard for tracking their progress.

## Features

- **Course Enrollment**: Students can browse a variety of courses and enroll in the ones that suit their needs.
- **Student Dashboard**: A secure, authenticated dashboard for students to access course materials, track progress, and view payment history.
- **Payment Gateway Integration**: The integration of Razorpay for secure and hassle-free payments.
- **Database Integration**: Utilizes MySQL and JPA for database management and Spring Security for authentication.

## Technologies

- Spring Boot
- React
- MySQL
- JPA (Java Persistence API)
- Razorpay
- Spring Security
- Devtools
- Thymeleaf
- Lombok

## Getting Started

To run this project on your local machine, follow these steps:

1. Clone the repository:
   ```sh
   git clone https://github.com/yourusername/teaching-website.git
   ```

2. Navigate to the project's root directory:
   ```sh
   cd teaching-website
   ```

3. Set up the backend:
   - Configure your MySQL database settings in `application.properties`.
   - Build and run the Spring Boot application.

4. Set up the frontend:
   - Navigate to the `frontend` directory.
   - Install Node.js and the required dependencies:
     ```sh
     npm install
     ```
   - Start the React development server:
     ```sh
     npm start
     ```

5. Access the application in your browser: [http://localhost:3000](http://localhost:3000)

## Project Structure

The project is structured as follows:

- `backend/`: Contains the Spring Boot application.
- `frontend/`: Contains the React frontend.

## Configuration

Before running the project, make sure to configure the necessary settings. Key configuration files to check are:

- `backend/src/main/resources/application.properties`: Configure your database and Razorpay API settings.
- `frontend/src/config.js`: Set your frontend configurations if necessary.

## Usage

- Visit [http://localhost:3000](http://localhost:3000) to access the website.
- Explore the courses, enroll, and enjoy your learning journey.

## Contributing

We welcome contributions from the community. If you'd like to contribute to the project, please follow our [Contributing Guidelines](CONTRIBUTING.md).

## License

This project is licensed under the [MIT License](LICENSE).

---

Thank you for using our Teaching Website project. We hope it helps you create a compelling online education platform! If you have any questions or need assistance, feel free to reach out to us.
