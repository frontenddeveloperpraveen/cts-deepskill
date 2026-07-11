# Week 5: Spring Core & Maven

Weekly content focusing on dependency management, the IoC Container, and Core Spring.

*   **Repository URL:** https://github.com/dhairyagothi/Digital-Nurture-JavaFSE-Cognizant

---

## Study Topics

### 1. Apache Maven
- Maven directory structure and lifecycle
- Managing project dependencies in `pom.xml`
- Customizing settings

### 2. Spring IoC & DI
- Inversion of Control (IoC) and Dependency Injection (DI)
- Spring IoC Container: BeanFactory vs ApplicationContext
- Spring Bean configuration (XML-based and Annotation-based configurations)
- Stereotype Annotations: `@Component`, `@Service`, `@Repository`, `@Controller`
- Constructor Injection, Setter Injection, Autowiring, and resolving conflicts using `@Qualifier`

### 3. Spring AOP (Aspect-Oriented Programming)
- AOP concepts: Aspects, Advice, Pointcuts, Joinpoints, and Proxies
- Intercepting method calls for logging or metrics

### 4. Spring MVC & Spring Boot Introduction
- Spring MVC architecture, Controllers, Models, and Views
- Basic REST/web configurations
- Spring Boot auto-configuration concepts

---

## Weekly Tasks
- Configure a Maven multi-module structure in a project `pom.xml`.
- Define Spring beans using Java configuration classes (`@Configuration`, `@Bean`).
- Inject dependencies using Constructor injection and `@Autowired`.
- Write a Spring AOP aspect logging execution time of service methods.

### Spring Core & Maven Hands-On Exercises
*   [pom.xml](file:///c:/personal%20dg/github_repo/Digital-Nurture-JavaFSE-Cognizant/Week-05-SpringCore-Maven/pom.xml) - Exercise 1 & 4: Maven Setup, core dependencies, compile plugins.
*   [applicationContext.xml](file:///c:/personal%20dg/github_repo/Digital-Nurture-JavaFSE-Cognizant/Week-05-SpringCore-Maven/src/main/resources/applicationContext.xml) - Exercise 1, 2, 3, 5, 6, 7, 8: Spring Beans context declarations, DI constructor/setter, Component scanning, AOP auto-proxying.
*   [BookRepository.java](file:///c:/personal%20dg/github_repo/Digital-Nurture-JavaFSE-Cognizant/Week-05-SpringCore-Maven/src/main/java/com/library/repository/BookRepository.java) - Exercise 1 & 6: BookRepository database stub annotated with `@Repository`.
*   [BookService.java](file:///c:/personal%20dg/github_repo/Digital-Nurture-JavaFSE-Cognizant/Week-05-SpringCore-Maven/src/main/java/com/library/service/BookService.java) - Exercise 1, 2, 5, 6, 7: BookService logic with `@Autowired` constructors and setters.
*   [LoggingAspect.java](file:///c:/personal%20dg/github_repo/Digital-Nurture-JavaFSE-Cognizant/Week-05-SpringCore-Maven/src/main/java/com/library/aspect/LoggingAspect.java) - Exercise 3 & 8: Aspect class intercepting method execution for time tracking.
*   [LibraryManagementApplication.java (Core)](file:///c:/personal%20dg/github_repo/Digital-Nurture-JavaFSE-Cognizant/Week-05-SpringCore-Maven/src/main/java/com/library/LibraryManagementApplication.java) - Exercise 1, 2, 5: App loader for testing context.
*   [LibraryManagementApplication.java (Boot)](file:///c:/personal%20dg/github_repo/Digital-Nurture-JavaFSE-Cognizant/Week-05-SpringCore-Maven/src/main/java/com/library/boot/LibraryManagementApplication.java) - Exercise 9: Spring Boot Main entry point.
*   [BookController](file:///c:/personal%20dg/github_repo/Digital-Nurture-JavaFSE-Cognizant/Week-05-SpringCore-Maven/src/main/java/com/library/boot/BookController.java) - Exercise 9: REST controller managing H2 CRUD queries.
