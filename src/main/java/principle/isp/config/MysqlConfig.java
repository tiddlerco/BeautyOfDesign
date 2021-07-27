package principle.isp.config;

import principle.isp.ZookeeperConfigSource;
import principle.isp.inter_face.Viewer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @Author 喻可
 * @Date 2021/7/27 10:13
 */
@Component
public class MysqlConfig implements Viewer {

//    private ConfigSource configSource;
//
//    public MysqlConfig(ConfigSource configSource) {
//        this.configSource = configSource;
//    }
    @Autowired
    private ZookeeperConfigSource configSource;


    //...省略其他属性和方法...
    @Override
    public String outputInPlainText() {
        configSource.add();
        return null;
    }

    @Override
    public Map<String, String> output() {
        return null;
    }
}
