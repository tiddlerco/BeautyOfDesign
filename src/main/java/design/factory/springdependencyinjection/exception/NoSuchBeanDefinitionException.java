package design.factory.springdependencyinjection.exception;

public class NoSuchBeanDefinitionException extends RuntimeException {
    public NoSuchBeanDefinitionException(String message) {
        super(message);
    }
}
