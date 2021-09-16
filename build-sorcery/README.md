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
NPM, Inc. is a company founded in 2014, and was acquired by GitHub in 2020. npm is a critical part of the JavaScript community and helps support one of the largest developer ecosystems in the world.

The command line tool `npm` is a package management solution for Javascript-based development. It is used to create and use node packaged modules and is built into the Javascript platform [Node.js](https://nodejs.org/en/)

you can see NPM version by this command `npm --version`
Let's dive more into NPM.


### NPM Repository
NXRM supports the npm registry format for proxy repositories. This allows us to take advantage of the packages in the npm registry and other public registries without incurring repeated downloads of packages, since they will be proxied in the repository manager.

Creating and managing repositories is an essential part of your Nexus Repository Manager configuration, since it allows you to expose more components to your users. It supports proxy repositories, hosted repositories and repository groups using a number of different repository formats.

The binary parts of a repository are stored in blob stores
A default blob store that is based on a file system storage within the `$data-dir` is automatically configured.


#### Blob Stores
A blob store is the internal storage mechanism for the binary parts of components and their assets.
They can be local file system or cloud-based using Amazon S3 (Pro and OSS) or Microsoft Azure (Pro only).
Each blob store can be used by one or multiple repositories and repository groups.

There are two things to know about NPM repository.
1. It is an online repository for the publishing of open-source Node.js projects.
2. It is a command-line utility for interacting with said repository that aids in package installation, version management, and dependency management.
[NPM repository](https://www.npmjs.com/) where you can find all sorts of fun node modules to incorporate into your nodejs projects.

There are three types of registries on NPM.


#### Proxying NPM Registries.
This is a repository that is linked to a remote repository.
Any request for a component is verified against the local content of the proxy repository.

If no local component is found, the request is forwarded to the remote repository.

The component is then retrieved and stored locally in the repository manager, which acts as a cache.
Subsequent requests for the same component are then fulfilled from the local storage, therefore eliminating the network bandwidth and time overhead of retrieving the component from the remote repository again.

There are few default npm access registry:

1.  By default npm accesses https://registry.npmjs.org registry directly.
    This is to reduce duplicate downloads and improve download speeds for your developers and CI servers.
    To proxy an external npm registry, you simply create a new npm (proxy) as documented in Repository Management.
    Here is how:
    - Define Name  
    - Define URL for the remote storage
    - Select Blob store for storage.


#### Private NPM Registries.
A private npm registry can be used to upload your own packages as well as third-party packages.
We can create a private npm registry by setting up a hosted repository with the npm format in the repository manager.
It is good practice to create two separate hosted repositories for these purposes.
A hosted repository, is a repository that stores components in the repository manager as the authoritative location for these components.

To create a hosted repository with npm format, simply create a new npm (hosted):
- Define Name
- Select Blob store for storage


#### Grouping npm Registries
A repository with the type group, also known as repository group, represents a powerful feature of Nexus Repository Manager.
They allow you to combine multiple repositories and other repository groups in a single repository.
This in turn means that your users can rely on a single URL for their configuration needs, while the administrators can add more repositories and therefore components to the repository group.

To create a new repository group:
-   Define Name
-   Select Blob store for storage
-   Add npm repositories to the Members list in the desired order

#### Modules in Node and How does it work
Module in node is a simple/complex functionality organized in single/multiple JavaScript files that can be reused inside node application

Node implements modules standard which refers to a group of volunteers that define JS standards for web servers, desktop and console application

Three type of modules are:

| Modules| Description |
| --- | --- |
| Core Modules | Include minimum functionalities of Node. These modules are complied into binary distribution and loads when node process starts. However, before you actually can utilize any of the modules, you have to `import` these modules in node controllers. Example: http, fs, url |
| Local Modules | Modules that were created locally in Node application. These modules include different functionalities of your application in seprate files/folders. Example: if you need to connect to redisDB and fetch data, you can create a module for that purpose and is reusable in your application |
| Export Modules | The `module.exports` is a special object which is included in every JS file in node application by default. The module is a variable that represents the current module. SO whatever you assign to `module.exports` will be exposed as module  |



Here is how you use Node/NPM modules:
| Modules| How to use |
| --- | --- |
| Core Modules | you need to import using `require()` keyword: `var module = require ('module_name')` the require function will return object, function, property depending on the specified module|
| Local Modules | To use local modules in your node application, you have to load using `require` function same as core module. However, you have to specify the path of JS file of the module. Example: `var LocalModule = require('./Log.js');` |
| Export Modules | since `exports` is an object, it exposes whatever you assigned to it as a module. Example: in message.js, `module.exports = 'Hello Malaysia';`, now, import this message module and use it: in app.js, `var test = require('.Message.js'); console.log(test);`. It will give 'Hello Malaysia' as the output |

#### NPM dependencies
NPM package dependencies were listed under a dependencies key in the `package.json` file. Dependencies value is used to specify any other modules that a given module - represented by the package.json requires to work.

Hence,
When `npm install` is run from the root folder of any given module, it will install any modules listed in that dependecy . Note that `npm install <package-name>` is a method to add dependencies in your node project

Example:
`mdx-deck` is the dependency in node project below
```
{
  "name": "nodejs",
  "version": "1.0.0",
  "description": "testNodeJS",
  "author": "wawaSM",
  "dependencies": {
    "mdx-deck": "^4.1.1"
  }
}
```


### Package.Json


## Gradle
Gradle is a build system (open source) which is used to automate building, testing, deployment etc.
The process becomes more consistent with the help of build automation tools.
The building process includes compiling, linking, and packaging the code.
It builds up on ANT, Maven and lvy repositories and supports groovy based Domain Specific Language (DSL) over the XML.

Every Android project needs a gradle for generating an apk from the .java and .xml files in the project.
Simply put, a gradle takes all the source files (java and XML) and apply appropriate tools.
For example, it converts the java files into dex files and compresses all of them into a single file known as apk that is actually used.

Now you have a rough idea about gradle, lets look into it deeper.

[Reference](https://www.geeksforgeeks.org/android-build-gradle/)

### How does gradle works?
Gradle builds are used to define a project and its tasks.
At least one Gradle build file is located in the root folder of the project.
A task represents the work that a Gradle build has to perform, for example, compiling the source code of the program.
You can execute multiple tasks at a time under one build file.
These tasks can be dynamically created and extended at runtime.


### Why do people use gradle?
Below are the reasons why people use gradle:
- Gradle resolves all the issues faced on other build tools like Maven and ANT.
- The tool focuses on maintainability, usability, extendibility, performance, and flexibility.
- Gradle is popular to provide high-speed performance, nearly twice as fast as Maven. It is well-known to be highly customizable when it comes to different projects dealing with various technologies. We may use Gradle in several ways, like Java projects, Android projects, and Groovy projects.
- The tools support a wide variety of IDE's, which provide a better user experience, as different people prefer working on a different IDE. It provides the users that like to work on the terminal with the command-line interface, which offers features like Gradle tasks, Command line completion, etc.

[Reference](https://www.simplilearn.com/tutorials/gradle-tutorial/what-is-gradle#why_is_gradle_used)


### How gradle solve the problem of maven and ant
One of the reason why people use gradle is because it resolves all the issues on other build tools such as Maven and Ant, but **HOW?***
From the discussion on top, we know that Ant and Maven shared considerable success in the JAVA marketplace.
However, Both Ant and Maven has their drawbacks:
| Tool | Drawbacks |
| --- | --- |
| Ant |  XML is used as a format to write the build scripts. Being hierarchical is not good for procedural programming. XML is relatively unmanageable |
| Maven | It does not handle the conflicts between versions of the same library. Complex customised build scripts are difficult to write in Maven, as compared to writing the build scripts in **ANT** |


Gradle then came in with efficient features from both tools:
| Features | Description |
| --- | --- |
| Declarative builds and build-by-convention | Gradle is available with separate Domain Specific Language (DSL) based on Groovy language. It provides the declarative language elements. Those elements also provide build-by-convention support for Java, Groovy, OSGI, Web and Scala. |
| Language for dependency based programming | The declarative language lies on a top of a general purpose task graph, which can be fully supported in the build. |
| Structured build | Gradle allows you to apply common design principles to your build. It will give you a perfect structure for build, so that, you can design well-structured and easily maintained, comprehensible build. |
| Deep API | By using this API, you can monitor and customise its configuration and execution behavior to the core. |
| Gradle scales | Gradle can easily increase the productivity, from simple and single project builds to huge enterprise multi-project builds. |
| Multi-project builds | Gradle supports the multi-project builds and partial builds. If you build a subproject, Gradle takes care of building all the subprojects, that the subproject depends on. |
| Different ways to manage your builds | Gradle supports different strategies to manage your dependencies. |
| Gradle is the first build integration tool | Gradle is fully supported for your ANT tasks, Maven and lvy repository infrastructure for publishing and retrieving dependencies. It also provides a converter for turning a Maven pom.xml to Gradle script. |
| Ease of migration | Gradle can easily adapt to any structure. Therefore, you can always develop your Gradle build in the same branch, where you can build live script. |
| Gradle Wrapper | Gradle Wrapper allows you to execute the Gradle builds on machines, where Gradle is not installed. This is useful for continuous integration of servers. |
| Free open source | Gradle is an open source project, and licensed under the Apache Software License (ASL). |
| Groovy | Gradle's build script are written in Groovy programming language. The whole design of Gradle is oriented towards being used as a language and not as a rigid framework. Groovy allows you to write your own script with some abstractions. The whole Gradle API is fully designed in Groovy language. |


With these features from gradle, it is able to solve most of the conflict on maven and ant tool.

[Reference](https://www.jrebel.com/blog/comparison-of-gradle-maven-and-ant)


### Gradle Wrapper
Gradle Wrapper is script that allows you to run a Gradle build even if you don’t have Gradle installed.
It downloads Gradle as a shell and batch scripts, and provides Gradle functionality as if you had it installed, without actually installing it.
That way you don’t have to worry if other developers have Gradle installed on their local machines and what version.
This is useful for continuous integration of servers.

Heres how you could do it:
First, open `build.gradle` and add `wrapper` like shown below:
```
task wrapper(type: Wrapper) {
    gradleVersion = '1.4'
}
```
Once that is done, run `gradle wrapper` task to download and cache the Gradle binaries, and initialize the wrapper scripts:
```
project_root
└── gradlew
└── gradlew.bat
└── gradle
    └── wrapper
        └── gradle-wrapper.jar
        └── gradle-wrapper.properties
```
Now wrapper scripts can be used.
`gradlew` for linux
`gradlew.bat` for windows
With this, there is no need to go through gradle installation.
These scripts are meant to be included in thx version control so that anyone can use them for the build.
To execute build task using wrapper just run:
```
./gradlew build
```

#### How do I add the Gradle wrapper to an existing project?
- This is useful if you have a project which doesn’t have a wrapper. Navigate to the project directory and run `gradle wrapper`

#### How do I execute a Gradle build using the wrapper?
That’s precisely what `gradlew` / `gradlew.bat` are for.
When you run these scripts a Gradle build will start using the configured version of Gradle.
This is what you will see on **Linux**:
```
$ ./gradlew

> Task :help

Welcome to Gradle 6.9.

To run a build, run gradlew <task> ...

To see a list of available tasks, run gradlew tasks

To see a list of command-line options, run gradlew --help

To see more detail about a task, run gradlew help --task <task>

For troubleshooting, visit https://help.gradle.org

Deprecated Gradle features were used in this build, making it incompatible with Gradle 7.0.
Use '--warning-mode all' to show the individual deprecation warnings.
See https://docs.gradle.org/6.9/userguide/command_line_interface.html#sec:command_line_warnings

BUILD SUCCESSFUL in 548ms
1 actionable task: 1 executed
```
And Here is what you see on **Windows**:
```
c:\workspace\wrapper-test>gradlew.bat

> Task :help

Welcome to Gradle 6.9.

To run a build, run gradlew <task> ...

To see a list of available tasks, run gradlew tasks

To see a list of command-line options, run gradlew --help

To see more detail about a task, run gradlew help --task <task>

For troubleshooting, visit https://help.gradle.org

Deprecated Gradle features were used in this build, making it incompatible with Gradle 7.0.
Use '--warning-mode all' to show the individual deprecation warnings.
See https://docs.gradle.org/6.9/userguide/command_line_interface.html#sec:command_line_warnings

BUILD SUCCESSFUL in 1s
1 actionable task: 1 executed
```
By default, if you don’t pass a task name to the Gradle wrapper script, the help task is executed.
You can pass a task name using the format `./gradlew <task-name>`.

To view more information on what kind of task gradle can build for you, key in `./gradlew tasks` to find out:
```
$ ./gradlew tasks

> Task :tasks

------------------------------------------------------------
Tasks runnable from root project 'wrapper-test'
------------------------------------------------------------

Build Setup tasks
-----------------
init - Initializes a new Gradle build.
wrapper - Generates Gradle wrapper files.

Help tasks
----------
buildEnvironment - Displays all buildscript dependencies declared in root project 'wrapper-test'.
dependencies - Displays all dependencies declared in root project 'wrapper-test'.
dependencyInsight - Displays the insight into a specific dependency in root project 'wrapper-test'.
help - Displays a help message.
javaToolchains - Displays the detected java toolchains. [incubating]
outgoingVariants - Displays the outgoing variants of root project 'wrapper-test'.
projects - Displays the sub-projects of root project 'wrapper-test'.
properties - Displays the properties of root project 'wrapper-test'.
tasks - Displays the tasks runnable from root project 'wrapper-test'.

To see all tasks and more detail, run gradlew tasks --all

To see more detail about a task, run gradlew help --task <task>

BUILD SUCCESSFUL in 464ms
1 actionable task: 1 executed
```
[Reference](https://tomgregory.com/what-is-the-gradle-wrapper-and-why-should-you-use-it/)
