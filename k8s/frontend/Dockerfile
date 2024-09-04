FROM nginx:stable-alpine3.20
LABEL maintainer="growjong8802 <growjong8802@gmail.com>"
LABEL version="1.1"
COPY default.conf /etc/nginx/conf.d/default.conf
ENV TZ=Asia/Seoul
EXPOSE 80
CMD ["nginx", "-g", "daemon off;"]