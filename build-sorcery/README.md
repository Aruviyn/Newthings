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

Maven is a build automation tool used primarily for Java projects. Maven can also be used to build and manage projects written in C#, Ruby, Scala, and other languages. The Maven project is hosted by the Apache Software Foundation, where it was formerly part of the Jakarta Project.

### Project Object Model

POM is  the fundamental unit of work in Maven.  It is an XML file that contains information about the project and configuration details used by Maven to build the project. It contains default values for most projects. Examples for this is the build directory, which is `target` the source directory, which is `src/main/java`the test source directory, which is `src/test/java`and so on. When executing a task or goal, Maven looks for the POM in the current directory. It reads the POM, gets the needed configuration information, then executes the goal.

Some of the configuration that can be specified in the POM are the project dependencies, the plugins or goals that can be executed, the build profiles, and so on. Other information such as the project version, description, developers, mailing lists and such can also be specified.

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
    <testSourceDirectory>${basedir}/src/test/java               
                                         </testSourceDirectory>     
    <outputDirectory>${basedir}/target/classes
                                             </outputDirectory>     
  </build>
</project>
```
### Build Lifecycle 
A Build Lifecycle is a well-defined sequence of phases, which define the order in which the goals are to be executed. Here phase represents a stage in life cycle. As an example, a typical Maven Build Lifecycle consists of the following sequence of phases.

| Phases | Description |
| --- | --- |
| Compile | compile the source code of the project |
| Test Compile | compile the test source code into the test destination directory |
| Test | run tests using a suitable unit testing framework. These tests should not require the code be packaged or deployed |
| Package | take the compiled code and package it in its distributable format, such as a JAR |
| Integration-testprocess and deploy the package if necessary into an environment where integration tests can be run |
| Verify | run any checks to verify the package is valid and meets quality criteria |
| Install | install the package into the local repository, for use as a dependency in other projects locally |
| Deploy | done in an integration or release environment, copies the final package to the remote repository for sharing with other developers and projects |

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

To browse the content of central maven repository, maven community has provided a URL: 
https://search.maven.org/#browse

Using this library, a developer can search all the available libraries in central repository.

#### Remote Repository
There are times when Maven is unable to search for dependencies in the central repository as well. 
It then stops the build process and output error message to console.

To prevent such situation, Maven provides concept of **Remote Repository**,
which is developer's own custom repository containing required libraries or other project jars.

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
