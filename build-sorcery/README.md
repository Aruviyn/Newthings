# Introduction

In software engineering, the art of build has evolved from manual script to managed build lifecycle. Back in the days builds were just merely compiling sources out of the compiler themselves like fortran and lisp, they evolve into having their own SDK (Software Development Kit) like java by its own and proprietary softwares. In modern software development these build mechanism evolve into a more robust tools that could manage the whole lifecycle of a software.

The reason why build mechanism is important is that the build mechanism dictate how the software is being built. Build script that shapes the build mechanism includes definition of dependencies of the software build. Build script also define the step of the software being build. Any programmer could read and execute the build in sequence so they get the build right. That is the goal of build mechanism, to get the build right.

# Older build mechanisms

## Make

Many of legacy software are still build using make script. To me the oldest build mechanism is make, I don't know if there are any older build mechanism than make. Most C programs are built using make. [Git](https://github.com/git/git) program, for example.

Make uses a file called Makefile. Makefile are usually scripted for unix environment. Running make in windows require some tools to be installed before it can be executed.

Software developers has been using Make to make build mechanism uniform across the software development team.

Make inspires a lot of modern build mechanism like C#'s Cake and Ant.

## Ant

Due to using Make is such a hassle being it skew towards Unix and the script is so open ended, readability of makefile is getting worse over time, Ant was created to get the scripting more organized and it is cross-platform. Ant is written in XML, a markup language that is more accessible and extensible. Ant commands are called tasks, open source community has been contributing tasks, making the process of writing ant scripts more convenient.

Most legacy java programs are still using ant script. Oracle's Netbeans platform still provide ant's build.xml when creating java project in Netbeans IDE. Some of Microsoft's .Net programs are built using NAnt, the .Net's implementation of Ant.

Ant is known as a build mechanism that can be described as Configuration Over Convention. This is due the nature of Ant's open ended style of build. Ant script are highly configurable, which is similar to Make. This makes the readability desaturate when the bigger the program gets. Maven fixes this by going Convention over Configuration.

---

# Modern build mechanisms

## Maven

Maven is a build automation tool used primarily for Java projects. Maven can also be used to build and manage projects written in C#, Ruby, Scala, and other languages (through various maven plugins). The Maven project is hosted by the Apache Software Foundation, where it was formerly part of the Jakarta Project.

### Project Object Model

POM is  the fundamental unit of work in Maven.  It is an XML file that contains information about the project and configuration details used by Maven to build the project. It contains default values for most projects. Examples for this is the build directory, which is `target` the source directory, which is `src/main/java`the test source directory, which is `src/test/java`and so on. When executing a task or goal, Maven looks for the POM in the current directory. It reads the POM, gets the needed configuration information, then executes the goal.

Some of the configuration that can be specified in the POM are the project dependencies, the plugins or goals that can be executed, the build profiles, and so on. Other information such as the project version, description, developers, mailing lists and such can also be specified.

#### parent-child project relationship

In some modular project, most module inherit the information written in the POM so that the information, dependencies and builds are consistent. These kind of project relationship is called parent-child project. There is a top most POM that every children inherit by declaring the top most POM as their `<parent>`.

Children project will inherit all of the attribute of the parent but they may expand the pom to personalize the dependencies and build. This will ensure that the information carried in the build are consistent with the parent however the build is personalized to the need of the children.

For example, the parent POM might dictate that the whole project will use a particular dependencies, as a sample, JUnit

```
<!-- https://mvnrepository.com/artifact/junit/junit -->
<dependency>
    <groupId>junit</groupId>
    <artifactId>junit</artifactId>
    <version>4.13.2</version>
    <scope>test</scope>
</dependency>
```

This way the version of JUnit for the whole project will follow the parent using version 4.13.2

One of the child might declare dependency specific to the need of its build, so in the POM of the child, they may declare to use spotify docker-client library during its build

```
<!-- https://mvnrepository.com/artifact/com.spotify/docker-client -->
<dependency>
    <groupId>com.spotify</groupId>
    <artifactId>docker-client</artifactId>
    <version>8.16.0</version>
</dependency>
```

### Convention Over Configuration

Maven uses Convention over Configuration, which means developers are not required to create build process themselves.
Developers do not have to mention each and every configuration detail. Maven provides sensible default behavior for projects. When a Maven project is created, Maven creates default project structure. Developer is only required to place files accordingly and he/she need not to define any configuration in pom.xml.

Convention over configuration is one of the main design philosophies behind Apache Maven. Let's go through a few examples.
A complete Maven project can be created using the following configuration file (`pom.xml`):
```
<project>
  <modelVersion>4.0.0</modelVersion>
  <groupId>com.packt</groupId>
  <artifactId>sample-one</artifactId>
  <version>1.0.0</version>
</project>
```

The Maven POM file starts with `<project>` element. Always define `<project>` element with schema. Some tools can't validate the file without it:
```
<project xmlns=http://maven.apache.org/POM/4.0.0
         xmlns:xsi=………
         xsi:schemaLocation="…">
```

Copy the previous configuration element and create a `pom.xml` file out of it. Then, place it in a directory called `chapter-01` and create the following child directories under it:

`chapter-01/src/main/java`
`chapter-01/src/test/java`


Now, you can place your Java code under `chapter-01/src/main/java` and test cases under `chapter-01/src/test/java`. Use the following command to run the Maven build from where the `pom.xml` is:

`$ mvn clean install`

This little configuration that you found in the sample pom.xml file is tied up with many conventions:
- Java source code is available at `{base-dir}/src/main/java`
- Test cases are available at `{base-dir}/src/test/java`
- The type of the artifact produced is a JAR file
- Compiled class files are copied to `{base-dir}/target/classes`
- The final artifact is copied to `{base-dir}/target`
- http://repo.maven.apache.org/maven2, is used as the repository URL.

If someone needs to override the default, conventional behavior of Maven, that is possible too. The following sample `pom.xml` file shows how to override some of the preceding default values:
```
<project>
  <modelVersion>4.0.0</modelVersion>
  <groupId>com.packt</groupId>
  <artifactId>sample-one</artifactId>
  <version>1.0.0</version>
  <packaging>jar</packaging>

  <build>    
    <sourceDirectory>${basedir}/src/main/java</sourceDirectory>              
    <testSourceDirectory>${basedir}/src/test/java</testSourceDirectory>     
    <outputDirectory>${basedir}/target/classes</outputDirectory>     
  </build>
</project>
```

### Maven quickstart

Using maven archetype:generate, you can create a simple java project with the conventional project structure.

Below is an example of generating a maven project using the maven-archetype-quickstart project archetype interactively:

```
~/checkouts >>> mvn archetype:generate -DarchetypeArtifactId=maven-archetype-quickstart                                                                                                                           
[INFO] Scanning for projects...
[INFO]
[INFO] ------------------< org.apache.maven:standalone-pom >-------------------
[INFO] Building Maven Stub Project (No POM) 1
[INFO] --------------------------------[ pom ]---------------------------------
[INFO]
[INFO] >>> maven-archetype-plugin:3.2.0:generate (default-cli) > generate-sources @ standalone-pom >>>
[INFO]
[INFO] <<< maven-archetype-plugin:3.2.0:generate (default-cli) < generate-sources @ standalone-pom <<<
[INFO]
[INFO]
[INFO] --- maven-archetype-plugin:3.2.0:generate (default-cli) @ standalone-pom ---
[INFO] Generating project in Interactive mode
Downloading from central: https://repo.maven.apache.org/maven2/org/apache/maven/archetypes/maven-archetype-quickstart/1.0/maven-archetype-quickstart-1.0.pom
Downloaded from central: https://repo.maven.apache.org/maven2/org/apache/maven/archetypes/maven-archetype-quickstart/1.0/maven-archetype-quickstart-1.0.pom (703 B at 1.8 kB/s)
Downloading from central: https://repo.maven.apache.org/maven2/org/apache/maven/archetypes/maven-archetype-bundles/2/maven-archetype-bundles-2.pom
Downloaded from central: https://repo.maven.apache.org/maven2/org/apache/maven/archetypes/maven-archetype-bundles/2/maven-archetype-bundles-2.pom (1.5 kB at 4.2 kB/s)
Downloading from central: https://repo.maven.apache.org/maven2/org/apache/maven/archetype/maven-archetype-parent/1/maven-archetype-parent-1.pom
Downloaded from central: https://repo.maven.apache.org/maven2/org/apache/maven/archetype/maven-archetype-parent/1/maven-archetype-parent-1.pom (1.3 kB at 3.7 kB/s)
Downloading from central: https://repo.maven.apache.org/maven2/org/apache/maven/archetypes/maven-archetype-quickstart/1.0/maven-archetype-quickstart-1.0.jar
Downloaded from central: https://repo.maven.apache.org/maven2/org/apache/maven/archetypes/maven-archetype-quickstart/1.0/maven-archetype-quickstart-1.0.jar (4.3 kB at 12 kB/s)
Define value for property 'groupId': com.organization.name
Define value for property 'artifactId': ProjectName
Define value for property 'version' 1.0-SNAPSHOT: :
Define value for property 'package' com.organization.name: :
Confirm properties configuration:
groupId: com.organization.name
artifactId: ProjectName
version: 1.0-SNAPSHOT
package: com.organization.name
 Y: :
[INFO] ----------------------------------------------------------------------------
[INFO] Using following parameters for creating project from Old (1.x) Archetype: maven-archetype-quickstart:1.0
[INFO] ----------------------------------------------------------------------------
[INFO] Parameter: basedir, Value: /home/fazreil/checkouts
[INFO] Parameter: package, Value: com.organization.name
[INFO] Parameter: groupId, Value: com.organization.name
[INFO] Parameter: artifactId, Value: ProjectName
[INFO] Parameter: packageName, Value: com.organization.name
[INFO] Parameter: version, Value: 1.0-SNAPSHOT
[INFO] project created from Old (1.x) Archetype in dir: /home/fazreil/checkouts/ProjectName
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  55.565 s
[INFO] Finished at: 2021-09-07T02:15:15+08:00
[INFO] ------------------------------------------------------------------------
```
Building the project using maven will yield such output on the cli:
```
~/checkouts/ProjectName >>> mvn clean install                                                                                                                                                                     
[INFO] Scanning for projects...
[INFO]
[INFO] -----------------< com.organization.name:ProjectName >------------------
[INFO] Building ProjectName 1.0-SNAPSHOT
[INFO] --------------------------------[ jar ]---------------------------------
[INFO]
[INFO] --- maven-clean-plugin:2.5:clean (default-clean) @ ProjectName ---
[INFO] Deleting /home/fazreil/checkouts/ProjectName/target
[INFO]
[INFO] --- maven-resources-plugin:2.6:resources (default-resources) @ ProjectName ---
[WARNING] Using platform encoding (UTF-8 actually) to copy filtered resources, i.e. build is platform dependent!
[INFO] skip non existing resourceDirectory /home/fazreil/checkouts/ProjectName/src/main/resources
[INFO]
[INFO] --- maven-compiler-plugin:3.1:compile (default-compile) @ ProjectName ---
[INFO] Changes detected - recompiling the module!
[WARNING] File encoding has not been set, using platform encoding UTF-8, i.e. build is platform dependent!
[INFO] Compiling 1 source file to /home/fazreil/checkouts/ProjectName/target/classes
[INFO]
[INFO] --- maven-resources-plugin:2.6:testResources (default-testResources) @ ProjectName ---
[WARNING] Using platform encoding (UTF-8 actually) to copy filtered resources, i.e. build is platform dependent!
[INFO] skip non existing resourceDirectory /home/fazreil/checkouts/ProjectName/src/test/resources
[INFO]
[INFO] --- maven-compiler-plugin:3.1:testCompile (default-testCompile) @ ProjectName ---
[INFO] Changes detected - recompiling the module!
[WARNING] File encoding has not been set, using platform encoding UTF-8, i.e. build is platform dependent!
[INFO] Compiling 1 source file to /home/fazreil/checkouts/ProjectName/target/test-classes
[INFO]
[INFO] --- maven-surefire-plugin:2.12.4:test (default-test) @ ProjectName ---
[INFO] Surefire report directory: /home/fazreil/checkouts/ProjectName/target/surefire-reports
Downloading from central: https://repo.maven.apache.org/maven2/org/apache/maven/surefire/surefire-junit3/2.12.4/surefire-junit3-2.12.4.pom
Downloaded from central: https://repo.maven.apache.org/maven2/org/apache/maven/surefire/surefire-junit3/2.12.4/surefire-junit3-2.12.4.pom (1.7 kB at 1.5 kB/s)
Downloading from central: https://repo.maven.apache.org/maven2/org/apache/maven/surefire/surefire-junit3/2.12.4/surefire-junit3-2.12.4.jar
Downloaded from central: https://repo.maven.apache.org/maven2/org/apache/maven/surefire/surefire-junit3/2.12.4/surefire-junit3-2.12.4.jar (26 kB at 64 kB/s)

-------------------------------------------------------
 T E S T S
-------------------------------------------------------
Running com.organization.name.AppTest
Tests run: 1, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.002 sec

Results :

Tests run: 1, Failures: 0, Errors: 0, Skipped: 0

[INFO]
[INFO] --- maven-jar-plugin:2.4:jar (default-jar) @ ProjectName ---
[INFO] Building jar: /home/fazreil/checkouts/ProjectName/target/ProjectName-1.0-SNAPSHOT.jar
[INFO]
[INFO] --- maven-install-plugin:2.4:install (default-install) @ ProjectName ---
[INFO] Installing /home/fazreil/checkouts/ProjectName/target/ProjectName-1.0-SNAPSHOT.jar to /home/fazreil/.m2/repository/com/organization/name/ProjectName/1.0-SNAPSHOT/ProjectName-1.0-SNAPSHOT.jar
[INFO] Installing /home/fazreil/checkouts/ProjectName/pom.xml to /home/fazreil/.m2/repository/com/organization/name/ProjectName/1.0-SNAPSHOT/ProjectName-1.0-SNAPSHOT.pom
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  3.024 s
[INFO] Finished at: 2021-09-07T02:21:27+08:00
[INFO] ------------------------------------------------------------------------
```

The project structure of after building looks like below:

```
~/checkouts/ProjectName >>> tree                                                                                                                                                                                  
.
├── pom.xml
├── src
│   ├── main
│   │   └── java
│   │       └── com
│   │           └── organization
│   │               └── name
│   │                   └── App.java
│   └── test
│       └── java
│           └── com
│               └── organization
│                   └── name
│                       └── AppTest.java
└── target
    ├── classes
    │   └── com
    │       └── organization
    │           └── name
    │               └── App.class
    ├── maven-archiver
    │   └── pom.properties
    ├── maven-status
    │   └── maven-compiler-plugin
    │       ├── compile
    │       │   └── default-compile
    │       │       ├── createdFiles.lst
    │       │       └── inputFiles.lst
    │       └── testCompile
    │           └── default-testCompile
    │               ├── createdFiles.lst
    │               └── inputFiles.lst
    ├── ProjectName-1.0-SNAPSHOT.jar
    ├── surefire-reports
    │   ├── com.organization.name.AppTest.txt
    │   └── TEST-com.organization.name.AppTest.xml
    └── test-classes
        └── com
            └── organization
                └── name
                    └── AppTest.class

28 directories, 13 files

```
To most java developers, these structure are conventional, making it easier for java developers to understand the project structure.

### Build Lifecycle
A Build Lifecycle is a well-defined sequence of phases, which define the order in which the goals are to be executed. Here phase represents a stage in life cycle. As an example, a typical Maven Build Lifecycle consists of the following sequence of phases.

| Phases | Description |
| --- | --- |
| Compile | compile the source code of the project |
| Test Compile | compile the test source code into the test destination directory |
| Test | run tests using a suitable unit testing framework. These tests should not require the code be packaged or deployed |
| Package | take the compiled code and package it in its distributable format, such as a JAR |
| Integration-test | process and deploy the package if necessary into an environment where integration tests can be run |
| Verify | run any checks to verify the package is valid and meets quality criteria |
| Install | install the package into the local repository, for use as a dependency in other projects locally |
| Deploy | done in an integration or release environment, copies the final package to the remote repository for sharing with other developers and projects |

The build lifecycle has been predetermined as a default, with the concept of convention over configuration, you don't have to define the lifecycle but it has been defined for you. The phases described in the table above from compile up to install are carried out for you when you do `mvn install`.

### Repositories
In Maven terminology, a repository is a directory where all the project jars, library jar, plugins or any other project specific artifacts are stored and can be used by Maven easily.

Maven repository are of three types. The following illustration will give an idea regarding these three types:
- Local
- Central
- Remote

#### Local Repository
Maven local repository is a folder location on your machine. It gets created when you run any maven command for the first time.

It keeps all your project dependencies. When you run a Maven build, then Maven automatically downloads all the dependency jars into the local repository. It helps to avoid references to dependencies stored on remote machine every time a project is build.

Maven local repository by default get created by Maven in `%USER_HOME%` directory. To override the default location, mention another path in Maven settings.xml file available at `%M2_HOME%\conf` directory:

```
<settings xmlns = "http://maven.apache.org/SETTINGS/1.0.0"
   xmlns:xsi = "http://www.w3.org/2001/XMLSchema-instance"
   xsi:schemaLocation = "http://maven.apache.org/SETTINGS/1.0.0
   http://maven.apache.org/xsd/settings-1.0.0.xsd">
   <localRepository>C:/MyLocalRepository</localRepository>
</settings>
```
When you run Maven command, Maven will download dependencies to your custom path.

#### Central Repository
Maven central repository is repository provided by Maven community. It contains a large number of commonly used libraries

When it does not find any dependencies in local repository, it will start searching in the central repository using the following URL:
https://repo1.maven.org/maven2/

Key concepts of Central repository are such as:
- This repository is managed by Maven community.
- It is not required to be configured.
- It requires internet access to be searched.

Other popular public [repositories](https://mvnrepository.com/repos) are:
- [Sonatype](https://oss.sonatype.org/content/repositories/releases/)
- [Atlassian](https://packages.atlassian.com/mvn/maven-atlassian-external/)
- [Spring Plugins](https://repo.spring.io/plugins-release/)

To browse the content of central maven repository, maven community has provided a URL:
https://search.maven.org/#browse (alternatively [mvnrepository](https://mvnrepository.com))

Using this library, a developer can search all the available libraries in central repository.

#### Remote Repository
There are times when Maven is unable to search for dependencies in the central repository as well.
It then stops the build process and output error message to console.

To prevent such situation, Maven provides concept of **Remote Repository**,
which is developer's own custom repository containing required libraries or other project jars.

Previously before maven, software developers need to build all of the dependencies (if they are not downloading them and place the libraries in proper classpath). With Remote Repository, proprietary dependencies can be built and stored on the organization's own repository. By having organization's own repository, the proprietary builds can be stored safely and not made available to the public.

For example, using below mentioned POM.xml,
Maven will download dependency (not available in central repository) from Remote Repositories mentioned in the same pom.xml.

```
<project xmlns = "http://maven.apache.org/POM/4.0.0"
   xmlns:xsi = "http://www.w3.org/2001/XMLSchema-instance"
   xsi:schemaLocation = "http://maven.apache.org/POM/4.0.0
   http://maven.apache.org/xsd/maven-4.0.0.xsd">
   <modelVersion>4.0.0</modelVersion>
   <groupId>com.companyname.projectgroup</groupId>
   <artifactId>project</artifactId>
   <version>1.0</version>
   <dependencies>
      <dependency>
         <groupId>com.companyname.common-lib</groupId>
         <artifactId>common-lib</artifactId>
         <version>1.0.0</version>
      </dependency>
   <dependencies>
   <repositories>
      <repository>
         <id>companyname.lib1</id>
         <url>http://download.companyname.org/maven2/lib1</url>
      </repository>
      <repository>
         <id>companyname.lib2</id>
         <url>http://download.companyname.org/maven2/lib2</url>
      </repository>
   </repositories>
</project>
```

#### How Dependency Search Sequence Works?
When we execute Maven build commands, Maven starts looking for dependency libraries in the following sequence:

| Steps | Description |
| --- | --- |
| Step 1 | Search dependency in local repository, if not found, move to step 2 else perform the further processing |
| Step 2 | Search dependency in central repository, if not found and remote repository/repositories is/are mentioned then move to step 4. Else it is downloaded to local repository for future reference |
| Step 3 | If a remote repository has not been mentioned, Maven simply stops the processing and throws error (Unable to find dependency) |
| Step 4 | Search dependency in remote repository or repositories, if found then it is downloaded to local repository for future reference. Otherwise, Maven stops processing and throws error (Unable to find dependency) |

## Node Package Manager (NPM)
[NPM repository](https://www.npmjs.com/) where you can find all sorts of fun node modules to incorporate into your nodejs projects.

## Gradle
More and more people are switching to Gradle. It is written in groovy (an evolution of java programming language). Written to be the ultimate build mechanism for many popular programming language.
