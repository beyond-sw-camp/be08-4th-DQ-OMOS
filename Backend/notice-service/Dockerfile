FROM eclipse-temurin:17.0.12_7-jdk
LABEL maintainer="growjong8802 <growjong8802@gmail.com>"
LABEL version="2.1"
COPY build/libs/notice-0.0.1-SNAPSHOT.jar /root
ARG PROFILE=dev
ARG PORT=9002
ENV TZ=Asia/Seoul
ENV PROFILE=${PROFILE}
EXPOSE ${PORT}
WORKDIR /root
CMD ["java", "-jar", "notice-0.0.1-SNAPSHOT.jar", "--spring.profiles.active=${PROFILE}"]