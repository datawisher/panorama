## Introduction

Panorama is to help learners master the fundamentals and advanced skills of Vue.js and Java programming languages through hands-on project-based learning. We will demonstrate how to develop modern web applications by combining Vue.js and Java backend technologies in a comprehensive project. The project will cover the following aspects:

1. **Vue.js Frontend Development**:
   - Learn the basics of Vue.js, including components, directives, and state management.
   - Master advanced Vue.js concepts such as routing, and the usage of state management libraries like Vuex.
   - Practice common frontend development patterns and best practices.
2. **Java Backend Development**:
   - Understand Java basics and object-oriented programming concepts.
   - Learn Spring Framework and Spring Boot for building enterprise-level Java applications.
   - Master RESTful API development and database integration.
3. **Full-stack Project Implementation**:
   - Develop a complete web application including frontend interface and backend services.
   - Use Vue.js to build a modern user interface with good user experience and responsive design.
   - Utilize Java backend for handling business logic, managing data, and providing RESTful APIs.
4. **Integration of Technology Stack**:
   - Integrate frontend and backend to achieve bidirectional data transfer and interaction.
   - Learn best practices for frontend-backend collaboration such as handling cross-origin requests, authentication, and authorization.

By completing this project, you will gain the following benefits:

- In-depth understanding and practical experience of Vue.js and Java development.
- Mastery of key skills required to build modern web applications.
- Enhanced problem-solving and independent development capabilities.
- Showcase your project work on GitHub to attract potential employers or collaborators.

Whether you are a beginner or an experienced developer, this project will provide you with a structured learning path and practical opportunities to quickly grasp Vue.js and Java development skills.

## Feature

Panorama adopts a set of modern frontend and backend technologies with the following features:

### Frontend Technology Stack

- **Vue.js**: As the frontend framework, it provides reactive data binding and component-based development, making building user interfaces more efficient and flexible.
- **Vuex**: Used for centralized state management, facilitating the management of state and data flow in large-scale applications.
- **Vue Router**: Provides client-side routing functionality, simplifying the development and navigation of single-page applications.
- **axios**: Used for handling HTTP requests and interacting with the backend for data exchange.

### Backend Technology Stack

- **Java**: Serving as the primary backend programming language, it has widespread adoption and a robust ecosystem.
- **Spring Boot**: Streamlines the development and deployment of Spring framework-based applications, improving development efficiency.
- **Spring Framework**: Provides comprehensive infrastructure support, including dependency injection, aspect-oriented programming, etc.
- **Spring Data JPA**: Simplifies the process of interacting with databases, providing a JPA-based persistence solution.

### Data Storage

- **MySQL**: As a relational database, it is used for storing and managing application data.

### Development Tools and Environment

- **IntelliJ IDEA / Visual Studio Code**: Serving as the primary integrated development environment, it provides rich plugins and debugging features, facilitating frontend and backend development.
- **Maven**: Used for building and managing dependencies of Java projects.
- **Git**: Version control tool used for team collaboration and code management.

By using these technologies, this project aims to help learners master modern full-stack development skills and understand how to effectively integrate frontend and backend technologies to build high-performance, scalable, and maintainable web applications.

## Install and use

- Get the project code

```
git clone https://github.com/datawisher/panorama.git
```

- Install dependencies

```
cd vue-project

pnpm install
```

- run

```
pnpm serve
```

- build

```
pnpm build
```

- docker

The dockerFile is located in the project root directory and supports differential deployment.
build image

```
docker build -t vue-project .
```

Use environment variables to achieve differentiated container deployment. Specify service endpoint by assigning `VG_BASE_URL`. In the following example, `http://localhost:3333` is used as the back-end service address and the container is mapped to port `6666`:

```
docker run --name vue-project -d -p 6666:80  -e VG_BASE_URL=http://localhost:3333 vue-project
```

Then you can navigate to `http://localhost:6666`

## How to contribute

You are very welcome to join！Raise an issue or submit a Pull Request。

**Pull Request:**

1. Fork code!
2. Create your own branch: `git checkout -b feat/xxxx`
3. Submit your changes: `git commit -am 'feat(function): add xxxxx'`
4. Push your branch: `git push origin feat/xxxx`
5. submit`pull request`

## Browser support

The `Chrome 80+` browser is recommended for local development

Support modern browsers, doesn't include IE

| [![ Edge](https://raw.githubusercontent.com/alrra/browser-logos/master/src/edge/edge_48x48.png)](http://godban.github.io/browsers-support-badges/) IE | [![ Edge](https://raw.githubusercontent.com/alrra/browser-logos/master/src/edge/edge_48x48.png)](http://godban.github.io/browsers-support-badges/) Edge | [![Firefox](https://raw.githubusercontent.com/alrra/browser-logos/master/src/firefox/firefox_48x48.png)](http://godban.github.io/browsers-support-badges/) Firefox | [![Chrome](https://raw.githubusercontent.com/alrra/browser-logos/master/src/chrome/chrome_48x48.png)](http://godban.github.io/browsers-support-badges/) Chrome | [![Safari](https://raw.githubusercontent.com/alrra/browser-logos/master/src/safari/safari_48x48.png)](http://godban.github.io/browsers-support-badges/) Safari |
| ------------------------------------------------------------ | ------------------------------------------------------------ | ------------------------------------------------------------ | ------------------------------------------------------------ | ------------------------------------------------------------ |
| not support                                                  | last 2 versions                                              | last 2 versions                                              | last 2 versions                                              | last 2 versions                                              |