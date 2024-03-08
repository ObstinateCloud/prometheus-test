FROM adoptopenjdk/openjdk8
MAINTAINER legendyun
COPY *.jar /usr/local/app.jar
WORKDIR /user/local
EXPOSE 7001
CMD java -jar /usr/local/app.jar