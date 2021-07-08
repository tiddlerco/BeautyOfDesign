package design.factory.springdependencyinjection;

import design.factory.springdependencyinjection.applicationcontext.ApplicationContext;
import design.factory.springdependencyinjection.applicationcontext.ClassPathXmlApplicationContext;
import design.factory.springdependencyinjection.beans.RateLimiter;

public class DiDemo {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml");
        RateLimiter rateLimiter = (RateLimiter) applicationContext.getBean("rateLimiter");
        Boolean isValid = rateLimiter.isValid();
        System.out.println("RateLimiter call isValid method, result: " + isValid);
    }
}
