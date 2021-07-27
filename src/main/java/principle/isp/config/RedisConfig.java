package principle.isp.config;

import principle.isp.ZookeeperConfigSource;
import principle.isp.inter_face.Updater;
import principle.isp.inter_face.Viewer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @Author 喻可
 * @Date 2021/7/27 10:14
 */

@Component
public class RedisConfig implements Updater, Viewer {

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

    @Override
    public String outputInPlainText() {
        configSource.add();
        return null;
    }

    @Override
    public Map<String, String> output() {
        configSource.add();
        return null;
    }
}
