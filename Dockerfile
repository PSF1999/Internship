FROM openjdk:11
COPY ./target/internship-0.0.1-SNAPSHOT.jar /usr/app/
WORKDIR /usr/app
RUN sh -c 'touch project-0.0.1-SNAPSHOT.jar'
ENTRYPOINT ["java","-jar","internship-0.0.1-SNAPSHOT.jar"]