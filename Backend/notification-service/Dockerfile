FROM eclipse-temurin:17.0.12_7-jdk
LABEL maintainer="growjong8802 <growjong8802@gmail.com>"
LABEL version="2.1"
COPY build/libs/notification-0.0.1-SNAPSHOT.jar /root
ARG PORT=8080
ENV TZ=Asia/Seoul
EXPOSE ${PORT}
WORKDIR /root
CMD ["java", "-jar", "notification-0.0.1-SNAPSHOT.jar"]