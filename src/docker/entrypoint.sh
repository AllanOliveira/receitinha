#!/bin/bash
set -e

RECEITINHA_API_JMX_OPTS="${RECEITINHA_API_JMX_OPTS:--Dcom.sun.management.jmxremote -Dcom.sun.management.jmxremote.authenticate=false -Dcom.sun.management.jmxremote.ssl=false -Dcom.sun.management.jmxremote.local.only=false -Dcom.sun.management.jmxremote.port=9191 }"

RECEITINHA_API_JAVA_OPTS="${RECEITINHA_API_JAVA_OPTS:--Djava.security.egd=file:/dev/./urandom}"

exec $JAVA_HOME/bin/java \
          $RECEITINHA_API_HEAP_OPTS \
          $RECEITINHA_API_JMX_OPTS \
          $RECEITINHA_API_JAVA_OPTS \
          -jar "$RECEITINHA_API_HOME/receitinha-api.jar" \
          $*
