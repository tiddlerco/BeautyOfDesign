package design.factory.springdependencyinjection.applicationcontext;

public interface ApplicationContext {
    Object getBean(String beanId);
}
