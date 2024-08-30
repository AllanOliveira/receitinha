FROM amazoncorretto:22.0.2-alpine3.20 as build

# Cria o JRE com os módulos necessários
RUN $JAVA_HOME/bin/jlink \
    --compress=2 \
    --module-path $JAVA_HOME/jmods \
    --add-modules java.base,java.logging,java.xml,jdk.unsupported,java.sql,java.naming,java.desktop,java.management,java.security.jgss,java.instrument,jdk.management.agent,jdk.jdwp.agent \
    --output /jdk-minimal

# cria um layer de cache para o docker
WORKDIR /build

#---------------------------------
FROM alpine:3.14

RUN apk add --no-cache bash

# Install
ARG VERSION
ARG JAR_FILE

ENV RECEITINHA_API_VERSION=${VERSION}
ENV RECEITINHA_API_HOME=/opt/receitinha-api
ENV JAVA_HOME /opt/jdk/

LABEL version=${VERSION}

WORKDIR /opt/receitinha-api

# Copia os artefatos do build para esta imagem
ADD /target/${JAR_FILE} /opt/receitinha-api/receitinha-api.jar
COPY --from=build /jdk-minimal /opt/jdk/

ADD /src/docker/entrypoint.sh /opt/receitinha-api/entrypoint.sh

RUN chmod +x /opt/receitinha-api/entrypoint.sh

ENTRYPOINT [ "/opt/receitinha-api/entrypoint.sh" ]

