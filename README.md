# Spring @Retryable strange behavior demo

Demonstrates strange behavior when using `@Retryable`, and `@Value` together in Spring Boot framework.

## code

```java
@Service
public class RetryableService {

	@Value("${spring.application.name}")
	private String value;

	@Retryable
	public void retryable() {
		// just declared, never called
	}

	public void nonFinal() {
		System.out.println("retryable non-final: " + value);
	}

	public final void _final() {
		System.out.println("retryable final: " + value);
	}

}
```

```java
@Service
public class NonRetryableService {

	@Value("${spring.application.name}")
	private String value;

	public void nonFinal() {
		System.out.println("non-retryable non-final: " + value);
	}

	public final void _final() {
		System.out.println("non-retryable final: " + value);
	}

}
```

## run

```bash
% ./gradlew bootRun
```

then open http://localhost:8080, you will see below in the log.

```
retryable final: null
retryable non-final: demo
non-retryable final: demo
non-retryable non-final: demo
```
