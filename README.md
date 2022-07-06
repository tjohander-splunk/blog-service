A simple service that makes to independent calls to a mock Blog API.  

Users: `https://jsonplaceholder.typicode.com/users` 

Posts: `https://jsonplaceholder.typicode.com/posts`

The payload from the responses are stitched together and returned.

# Branches:
`opentelemetry-java-auto-instrumentation` is intended to demonstrate the capabilities of pure Java Agent auto-instrumentation.

In order to run this branch, execute the following in either an IDE Run Config or from the command-line.  Note: running from the command line will require adding the additional `-jar <my-app.jar>` to the program arguments
```bash
-javaagent:./splunk-otel-javaagent.jar
-Dotel.resource.attributes=service.name=blog-service-local,deployment.environment=tj-devlab
-Dsplunk.profiler.enabled=true
-Dsplunk.metrics.enabled=true
-Dotel.javaagent.debug=true
-Dsplunk.metrics.export.interval=3s
```

## Generate Load
Run the `./loadgen` script in the root of this project.

To verify the metrics being emitted by Micrometer, head to `http://localhost:8085/actuator/metrics`

Of particular interest is the reason that we don't see `http.client.requests.xxxx` metrics.  You can confirm that Micrometer is emitting them by hitting `http://localhost:8085/actuator/metrics/http.client.requests`.  Metrics Finder comes up empty, though

`opentelemetry-java-api` is intended to demonstrate the added capabilities of using the OpenTelemetry Java API to decorate and enhance telemetry data

