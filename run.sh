#!/bin/bash

export OTEL_SERVICE_NAME='blog-service'
export OTEL_RESOURCE_ATTRIBUTES='deployment.environment=tj-devlab'
export OTEL_EXPORTER_OTLP_ENDPOINT='http://localhost:4317'

java -javaagent:./splunk-otel-javaagent.jar -Dsplunk.profiler.enabled=true -Dsplunk.metrics.enabled=true -jar ./build/libs/demo-0.0.1-SNAPSHOT.jar