package design.create.factory.springdependencyinjection.applicationcontext;

import design.create.factory.springdependencyinjection.configparser.BeanConfigParser;
import design.create.factory.springdependencyinjection.configparser.XmlBeanConfigParser;
import design.create.factory.springdependencyinjection.BeansFactory;
import design.create.factory.springdependencyinjection.BeanDefinition;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class ClassPathXmlApplicationContext implements ApplicationContext{
    private BeansFactory beansFactory;
    private BeanConfigParser beanConfigParser;

    public ClassPathXmlApplicationContext(String configLocation) {
        this.beansFactory = new BeansFactory();
        this.beanConfigParser = new XmlBeanConfigParser();
        //这里如果使用spring注解注入，这个方法上面是不是应该加上@PostConstruct注解
        loadBeanDefinitions(configLocation);
    }

    private void loadBeanDefinitions(String configLocation) {
        InputStream in = null;
        try {
            in = this.getClass().getResourceAsStream("/config/" + configLocation);
            if (in == null) {
                throw new RuntimeException(("Can not find config file: " + configLocation));
            }

            List<BeanDefinition> beanDefinitions = beanConfigParser.parse(in);
            beansFactory.addBeanDefinitions(beanDefinitions);
        } finally {
            if(in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                }
            }
        }
    }

    @Override
    public Object getBean(String beanId) {
        return beansFactory.getBean(beanId);
    }
}
