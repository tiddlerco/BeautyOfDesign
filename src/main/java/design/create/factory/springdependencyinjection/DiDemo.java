package design.create.factory.springdependencyinjection;

import design.create.factory.springdependencyinjection.applicationcontext.ApplicationContext;
import design.create.factory.springdependencyinjection.applicationcontext.ClassPathXmlApplicationContext;
import design.create.factory.springdependencyinjection.beans.RateLimiter;

public class DiDemo {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("beans.xml");
        RateLimiter rateLimiter = (RateLimiter) applicationContext.getBean("rateLimiter");
        Boolean isValid = rateLimiter.isValid();
        System.out.println("RateLimiter call isValid method, result: " + isValid);
    }
}
