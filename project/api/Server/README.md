# Server
Server subproject is the program that is going to host REST API.

## Introduction
Server subproject is a standalone program. It will not contain any logic except for pieces of codes necessary for running the server

## Swagger
The server will leverage on Swagger to run the server esp hosting *Swagger UI* to display the REST API exposed.

### Running springboot server
execute gradle script:
```
~/.../Newthings/project >>> gradle :api:Server:bootRun
```

Sample output of the gradle task:
```
> Task :api:Server:bootRun

  .   ____          _            __ _ _
 /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
 \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
  '  |____| .__|_| |_|_| |_\__, | / / / /
 =========|_|==============|___/=/_/_/_/
 :: Spring Boot ::                (v2.4.2)

2021-09-17 03:45:11.672  INFO 226362 --- [           main] com.aruviyn.project.server.App           : Starting App using Java 11.0.12 on Legion5 with PID 226362 (/home/fazreil/checkouts/Newthings/project/api/Server/build/classes/java/main started by fazreil in /home/fazreil/checkouts/Newthings/project/api/Server)
2021-09-17 03:45:11.674  INFO 226362 --- [           main] com.aruviyn.project.server.App           : No active profile set, falling back to default profiles: default
2021-09-17 03:45:12.422  INFO 226362 --- [           main] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat initialized with port(s): 8080 (http)
2021-09-17 03:45:12.429  INFO 226362 --- [           main] o.apache.catalina.core.StandardService   : Starting service [Tomcat]
2021-09-17 03:45:12.429  INFO 226362 --- [           main] org.apache.catalina.core.StandardEngine  : Starting Servlet engine: [Apache Tomcat/9.0.41]
2021-09-17 03:45:12.465  INFO 226362 --- [           main] o.a.c.c.C.[Tomcat].[localhost].[/]       : Initializing Spring embedded WebApplicationContext
2021-09-17 03:45:12.465  INFO 226362 --- [           main] w.s.c.ServletWebServerApplicationContext : Root WebApplicationContext: initialization completed in 761 ms
2021-09-17 03:45:12.767  INFO 226362 --- [           main] o.s.b.a.e.web.EndpointLinksResolver      : Exposing 2 endpoint(s) beneath base path '/actuator'
2021-09-17 03:45:12.837  INFO 226362 --- [           main] o.s.s.concurrent.ThreadPoolTaskExecutor  : Initializing ExecutorService 'applicationTaskExecutor'
2021-09-17 03:45:12.919  INFO 226362 --- [           main] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat started on port(s): 8080 (http) with context path ''
2021-09-17 03:45:12.927  INFO 226362 --- [           main] d.s.w.p.DocumentationPluginsBootstrapper : Context refreshed
2021-09-17 03:45:12.941  INFO 226362 --- [           main] d.s.w.p.DocumentationPluginsBootstrapper : Found 1 custom documentation plugin(s)
2021-09-17 03:45:12.947  INFO 226362 --- [           main] s.d.s.w.s.ApiListingReferenceScanner     : Scanning for api listing references
2021-09-17 03:45:12.995  INFO 226362 --- [           main] com.aruviyn.project.server.App           : Started App in 1.58 seconds (JVM running for 1.838)
```

Browse to http://localhost:8080/swagger-ui.html to view Swagger-UI

# Reference:
- https://spring.io/guides/gs/spring-boot/
- https://www.baeldung.com/swagger-2-documentation-for-spring-rest-api
- https://www.tutorialspoint.com/spring_boot/spring_boot_enabling_swagger2.htm
- https://start.spring.io/
