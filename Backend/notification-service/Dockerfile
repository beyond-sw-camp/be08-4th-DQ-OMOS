FROM eclipse-temurin:17.0.12_7-jdk
LABEL maintainer="eunhee78 <dmsgml4579@gmail.com>"
LABEL version="2.1"
COPY build/libs/notification-0.0.1-SNAPSHOT.jar /root
ARG PROFILE=dev
ARG PORT=9005
ENV TZ=Asia/Seoul
ENV PROFILE=${PROFILE}
EXPOSE ${PORT}
WORKDIR /root
CMD ["java", "-jar", "notification-0.0.1-SNAPSHOT.jar", "--spring.profiles.active=${PROFILE}"]