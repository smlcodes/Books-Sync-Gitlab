Docker – Dockerfile 
====================

Docker file is text file is simple text which contains instructions to Build
image.

![](media/bdbff9d34f196edfe91e3eeac78e29d1.png)

Dockerfile example
------------------

1.Create a new file called \`Dockerfile\` without extension

FROM \<BASE-IMAGE\>/\<SCRATCH\>

MAINTAINER \<Author_name\> \<email\>

RUN \<to run any cmds\>

CMD ["echo", "To run anything once container is running"]

\# example

FROM ubuntu

MAINTAINER satya \<staya\@gmail.com\>

RUN apt-get update

CMD ["echo", "Hello SatyaCodes.com"]

2.Build an Image

docker build \<file-location\>

docker build -t [tag name]:[version] \<file-location\>

docker build -t SATYAIMAGE:1.0.1 .

![](media/ad0ca9a4165c8efabb91e004b10df201.png)

3.Check images

![](media/193fed60cf09f9c1c357579b6b694f1d.png)

4.Run created image

![](media/857e3fe85e4288cf4309dcdd452ce9a2.png)

<https://github.com/wsargent/docker-cheat-sheet>

[21 Days of Docker-Day 5-Introduction to Dockerfile - Prashant Lakhera -
Medium](https://medium.com/@devopslearning/21-days-of-docker-day-5-introduction-to-dockerfile-98d46f3ddcf)
