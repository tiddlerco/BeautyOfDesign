package design.factory.springdependencyinjection.configparser;

import design.factory.springdependencyinjection.BeanDefinition;

import java.io.InputStream;
import java.util.List;

public interface BeanConfigParser {
    List<BeanDefinition> parse(InputStream inputStream);
}
