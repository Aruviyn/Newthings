FROM openjdk:8
RUN mkdir /StatisticApp
COPY api/Server/build/libs/Server-1.0-SNAPSHOT.jar /StatisticApp
EXPOSE 8080
CMD java -jar /StatisticApp/Server-1.0-SNAPSHOT.jar
