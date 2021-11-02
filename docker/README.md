## Docker.
- Docker is an open platform for developing, shipping, and running application. It enables separation of applications from infrastructures.
---
## Getting started with docker.
- Upon completion of docker installation, you may clone your repository from github which contains everything you need to build an image and run it as a container.
- When using docker, the first command on your terminal or command prompt **MUST** always start with `docker`.
- Clone the repository by running Git in a container:
```
docker run --name repo alpine/git clone \ https://github.com/docker/getting-started.git
docker cp repo:/git/getting-started/ .
```
- After cloning the `getting getting-started` docker repository, you can now build the image.
- First checkout to `getting-started`.
- Then build docker101tutorial as shown below:
```
cd getting-started
docker build -t docker101tutorial .
```
- Once it has finished building, you can now run your first container with this command:
```
docker run -d -p 80:80 \ --name docker-tutorial docker101tutorial
```
- Now you can save and share your image on Docker Hub to let other users download and run the image.
- Below is the command line to save and share your image:
```
docker tag docker101tutorial testing/docker101tutorial
docker push testing/docker101tutorial
```
- To view your repository on docker, click [here](https://hub.docker.com/) and navigate to repositories.
---
## Docker Cheatsheet
Here are a few essential commands with docker:

#### Managing images

 `docker images`

List all local docker images

Sample output:
```
~/.../Newthings/project >>> docker images
REPOSITORY                                      TAG                    IMAGE ID       CREATED          SIZE    
newthings-javadoc                               latest                 7fcb5e69f312   33 minutes ago   139MB
docker101tutorial                               latest                 6bcc24e239cb   5 days ago       28.3MB
<none>                                          <none>                 bc32cb49da7e   5 days ago       105MB
```

Should you like to get the image to be available in [hub.docker.com](https://hub.docker.com/r/fab52/newthings-javadoc) container registry, you shall run the following line:<br/>
```
~/.../Newthings/project >>> docker tag newthings-javadoc fab52/newthings-javadoc                                     
~/.../Newthings/project >>> docker push fab52/newthings-javadoc:latest                                                                                                                                            
The push refers to repository [docker.io/fab52/newthings-javadoc]
945550f28385: Pushed
bf4cb6a71436: Pushed
5792ac1517fc: Pushed
53c77568e9ed: Pushed
d6e97adfe450: Pushed
87c8a1d8f54f: Pushed
latest: digest: sha256:455752b9572b8f489e2442d8dfcd9a54047af1a3ddd3b1e6ff79fa38a54d8d99 size: 1576
```

Running the image will spawn an instance of the image called container. To run the newthings-javadoc image, one should perform:<br/>
```
~/.../Newthings/project >>> docker run -p 80:80 fab52/newthings-javadoc:latest                                                                                                                                    
AH00558: httpd: Could not reliably determine the server's fully qualified domain name, using 172.17.0.2. Set the 'ServerName' directive globally to suppress this message
AH00558: httpd: Could not reliably determine the server's fully qualified domain name, using 172.17.0.2. Set the 'ServerName' directive globally to suppress this message
[Sun Oct 31 19:19:53.660217 2021] [mpm_event:notice] [pid 1:tid 140306166105216] AH00489: Apache/2.4.46 (Unix) configured -- resuming normal operations
[Sun Oct 31 19:19:53.660300 2021] [core:notice] [pid 1:tid 140306166105216] AH00094: Command line: 'httpd -D FOREGROUND'
```
Or run it in detached mode with `-d`
```
~/.../Newthings/project >>> docker run -d -p 80:80 fab52/newthings-javadoc:latest                                                                                                                                 
6f2ab32546e990320a026ea779854e46c2497426027a669220d836df59ba44f4
```

#### Managing containers

`docker container ls -a`

List all local docker containers. Stopped containers and running

Sample output:
```
~/.../Newthings/project >>> docker container ls -a                                                                                   
CONTAINER ID   IMAGE                       COMMAND                  CREATED          STATUS                     PORTS                               NAMES
04643728e159   newthings-javadoc:latest    "httpd-foreground"       54 minutes ago   Up 6 seconds               0.0.0.0:80->80/tcp, :::80->80/tcp   sharp_poincare
2224ac8a4948   devops-infra_maven          "/usr/local/bin/mvn-…"   2 days ago       Exited (137) 2 days ago                                        devops-infra-maven-1
8bf99dd344bb   jenkins/jenkins:lts-jdk11   "/sbin/tini -- /usr/…"   2 days ago       Exited (143) 2 days ago                                        devops-infra-jenkins-1
```

From the output above we can see that the topmost container (with id `04643728e159`) is a container instance out of image `newthings-javadoc:latest`. The container is running the command stated under the `COMMAND` column. It has been created 54 minutes ago and has a 6 seconds runtime since it was re-started. It has a network mapping of it's port 80 to `0.0.0.0:80` (accept all ip from port 80) and was given a random name `sharp_poincare`.

To stop this container one would provide the following command:<br/>
`docker stop sharp_poincare`

The bottom two containers were created and stopped around 2 days ago.

To start the container called devops-infra-maven-1, one should provide the following command: <br/>```docker start devops-infra-maven-1```

#### Managing docker builds

Building docker would require Dockerfile. A Dockerfile manifests what is happening in the image it is building. Below is a sample Dockerfile:

```
FROM openjdk:8
RUN mkdir /StatisticApp
COPY api/Server/build/libs/Server-1.0-SNAPSHOT.jar /StatisticApp
EXPOSE 8080
CMD java -jar /StatisticApp/Server-1.0-SNAPSHOT.jar
```
|Line|Command|Description|
|---|---|---|
|1|`FROM openjdk:8`|states that the image being build is based on another image called openjdk, tagged as 8. You may find the said image in [hub.docker.com](https://hub.docker.com/layers/openjdk/library/openjdk/8/images/sha256-f50710e8b3212ac2cb390e745bed5a40400ea43da026cc7b85a973def658d73e?context=explore)|
|2|`RUN mkdir /StatisticApp`|will run the given command in the image. The command here will create a path /StatisticApp in the new image.|
|3|`COPY api/Server/build/libs/Server-1.0-SNAPSHOT.jar /StatisticApp`|will copy path `api/Server/build/libs/Server-1.0-SNAPSHOT.jar` locally into the image's path `/StatisticApp`|
|4|`EXPOSE 8080`|Exposes the port 8080 when it runs as a container|
|5|`CMD java -jar /StatisticApp/Server-1.0-SNAPSHOT.jar`|Runs this command when the image starts as a container|

building this docker image would be done by running the following command:<br>
`docker build -t newthings-javadoc .`

Such build will end up in your local repository. Refer to `docker images` to see images available in the local repository.

---
## Docker Fun Time
- Now that we have gone through our first image building, lets try another.
- First, lets pull wenight's [funbox](https://hub.docker.com/r/wernight/funbox).
- This pull can be either used in your terminal or command prompt:
```
docker pull wernight/funbox
```
- Now that we have pulled, this should appear on your terimnal or command prompt:
```
Using default tag: latest
latest: Pulling from wernight/funbox
f2b6b4884fc8: Pull complete
24876304c826: Pull complete
dc2853569c8e: Pull complete
f1feacc76ece: Pull complete
47b0568134ef: Pull complete
Digest: sha256:5cbbebc6fd1627b122bf7b5e4f562077de9dd52ed58bec2ede0d82071dea5298
Status: Downloaded newer image for wernight/funbox:latest
docker.io/wernight/funbox:latest
```
- Here's the fun part.
- Run this command:
```
docker run --rm -it wernight/funbox
```
- A menu wil appear and you will be prompt to key in a number from 1 to 22:
```
                         _       _     _      ____             _
__      _____ _ __ _ __ (_) __ _| |__ | |_   / / _|_   _ _ __ | |__   _____  __
\ \ /\ / / _ \ '__| '_ \| |/ _` | '_ \| __| / / |_| | | | '_ \| '_ \ / _ \ \/ /
 \ V  V /  __/ |  | | | | | (_| | | | | |_ / /|  _| |_| | | | | |_) | (_) >  <
  \_/\_/ \___|_|  |_| |_|_|\__, |_| |_|\__/_/ |_|  \__,_|_| |_|_.__/ \___/_/\_\
                           |___/

Screensavers / inifite animations:
  1) `aafire` - Fire pit
  2) `asciiquarium` - Aquarium
  3) `cacademo` - caca-utils demo
  4) `cmatrix` - Matrix
  5) `falling-hearts` - Falling Hearts screensaver
  6) `nyancat` - Nyan cat
  7) `pipes` - Pipes screensaver
  8) `xaos` - real-time interactive fractal zoomer
Demos / short animations:
  9) `bb` - ASCII art demo
 10) `sl` - Train passing by
 11) `youtube` - Alias to watch YouTube video using `youtube-dl`, `vlc` and `caca`
Static ASCII art:
  * Text`formatting:
     12) `cowsay` - Talking cow (or actually many others, run with `-l` to get a list and via `-f <name>` to use one)
     13) `figlet` - ASCII large text print
     14) `toilet` - ASCII large text print
  * Other:
     15) `aview` - Convert image to ASCII art
     16) `cacaview` - Convert image to ASCII art
     17) `boxes` - Put various frames around given block of ASCII art.
     18) `binclock` - Current time in binary.
     19) `linuxlogo` - Standard linux logos
     20) `lolcat` - Colorful `cat`
Random text generator:
 21) `rig` - Kind of person ID
 22) `fortune` - Random fortune cookie message

Menu:
```
- Simply key in any number from the menu and you will have a spectacular view of your command prompt or terminal.
- But it's not done yet!
- you can also have nyancat for you to be nyaned in your terminal or command prompt by keying in this:
```
docker run --rm -it wernight/funbox nyancat
```
- For more exciting views in your terminal or command prompt, do view wernight's [funbox](https://hub.docker.com/r/wernight/funbox).
