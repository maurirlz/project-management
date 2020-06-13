FROM ubuntu-java11

MAINTAINER Mauricio Ezequiel Benitez

ENV version=aws-db-usage
ENV dbuser=
ENV dbpass=
ENV jdbcurl=jdbc:postgresql://pmadatabaseaws.ci0uunoxatqy.us-east-1.rds.amazonaws.com:5432/postgres

WORKDIR /usr/local/bin

ADD target/project-management-1.0.0.jar .

ENTRYPOINT ["java", "-jar", "project-management-1.0.0.jar"]