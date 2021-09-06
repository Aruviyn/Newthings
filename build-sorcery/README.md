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

# Modern build mechanisms

## Maven
![Maven Definitive Guide](https://images-na.ssl-images-amazon.com/images/I/91O1y%2Bb7YmL.jpg) See O'Reilly put a picture of an anteater as the cover of maven book, savage.

## Node Package Manager (NPM)
[NPM repository](https://www.npmjs.com/) where you can find all sorts of fun node modules to incorporate into your nodejs projects.

## Gradle
More and more people are switching to Gradle. It is written in groovy (an evolution of java programming language). Written to be the ultimate build mechanism for many popular programming language.
