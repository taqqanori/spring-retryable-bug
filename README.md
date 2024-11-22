# Spring @Retryable demo

Demonstrates strange behavior when using `@Retryable`, `@Async`, and `@Value` together in Spring Boot framework.

```bash
% ./gradlew bootRun
```

then open http://localhost:8080, you will see below in the log.

```
non-retryable non-final: demo
non-retryable final: demo
retryable non-final: demo
retryable final: null
```
