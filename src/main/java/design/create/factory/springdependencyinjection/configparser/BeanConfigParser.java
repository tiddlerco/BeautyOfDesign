package design.create.factory.springdependencyinjection.configparser;

import design.create.factory.springdependencyinjection.BeanDefinition;

import java.io.InputStream;
import java.util.List;

public interface BeanConfigParser {
    List<BeanDefinition> parse(InputStream inputStream);
}
