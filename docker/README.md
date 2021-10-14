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
