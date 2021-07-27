package principle.isp;

import principle.isp.config.KafkaConfig;
import principle.isp.config.MysqlConfig;
import principle.isp.config.RedisConfig;
import principle.isp.handler.ScheduledUpdater;
import principle.isp.handler.SimpleHttpServer;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Author 喻可
 * @Date 2021/7/27 10:12
 */
public class Application {

//    ConfigSource configSource = new ZookeeperConfigSource();
//
//    public RedisConfig redisConfig = new RedisConfig(configSource);
//    public KafkaConfig kafkaConfig = new KafkaConfig(configSource);
//    public MysqlConfig mysqlConfig = new MysqlConfig(configSource);

    @Autowired
    private RedisConfig redisConfig;
    @Autowired
    private KafkaConfig kafkaConfig;
    @Autowired
    private MysqlConfig mysqlConfig;


    public void main(String[] args) {
        ScheduledUpdater redisConfigUpdater =
                new ScheduledUpdater(redisConfig, 300, 300);
        redisConfigUpdater.run();

        ScheduledUpdater kafkaConfigUpdater =
                new ScheduledUpdater(kafkaConfig, 60, 60);
        redisConfigUpdater.run();

        SimpleHttpServer simpleHttpServer = new SimpleHttpServer("127.0 .0 .1", 2389);
        simpleHttpServer.addViewers("/config", redisConfig);
        simpleHttpServer.addViewers("/config", mysqlConfig);
        simpleHttpServer.run();
    }
}
