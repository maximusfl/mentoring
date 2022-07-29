FROM mysql
MAINTAINER csgeek@mail.com

ENV MYSQL_ROOT_PASSWORD root
ADD src/main/resources/Dump20220629.sql /docker-entrypoint-initdb.d

EXPOSE 3306