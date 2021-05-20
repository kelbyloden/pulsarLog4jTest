# pulsarLog4jTest

Sample application to test usage of Log4j appender to Pulsar in a Spring Boot application.

To execute (assuming Pulsar is running at http://localhost:6650):
```
./gradlew clean build
./gradlew bootRun -Dapp.name=pulsarLog4jTest -Dlog.level=INFO -Dpulsar.host=localhost
```
