A simple service that makes to independant calls to a mock Blog API.  

Users:

Posts:

The payload from the responses are stitched together and returned.

Branches:
`opentelemetry-java-auto-instrumentation` is intended to demonstrate the capabilities of pure Java Agent auto-instrumentation.

In order to run this branch, execute the following in either an IDE Run Config or from the command-line.  Note: running from the command line will requre adding the additional `-jar <my-app.jar>` to the program arguments
```bash
-javaagent:./splunk-otel-javaagent.jar \
-Dotel.resource.attributes=service.name=blog-service-local,deployment.environment=tj-devlab \
-Dsplunk.profiler.enabled=true \
-Dsplunk.metrics.enabled=true \
-Dotel.javaagent.debug=true
```


`opentelemetry-java-api` is intended to demonstrate the added capabilities of using the OpenTelemetry Java API to decorate and enhance telemetry data

