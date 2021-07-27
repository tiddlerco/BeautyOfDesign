package principle.isp.config;


import principle.isp.ZookeeperConfigSource;
import principle.isp.inter_face.Updater;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Author 喻可
 * @Date 2021/7/27 10:13
 */

@Component
public class KafkaConfig implements Updater {

//    private ConfigSource configSource;
//
//    public KafkaConfig(ConfigSource configSource) {
//        this.configSource = configSource;
//    }

    @Autowired
    private ZookeeperConfigSource configSource;

    //...省略其他属性和方法...
    @Override
    public void update() {
        configSource.add();
    }

}

