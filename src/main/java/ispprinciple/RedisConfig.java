//package ispprinciple;
//
///**
// * @Author 喻可
// * @Date 2021/6/28 18:19
// */
//
//
//public class RedisConfig {
//    private ConfigSource configSource; //配置中心（比如zookeeper）
//    private String address;
//    private int timeout;
//    private int maxTotal;
//    //省略其他配置: maxWaitMillis,maxIdle,minIdle...
//
//    public RedisConfig(ConfigSource configSource) {
//        this.configSource = configSource;
//    }
//
//    public String getAddress() {
//        return this.address;
//    }
//    //...省略其他get()、init()方法...
//
//    public void update() {
//        //从configSource加载配置到address/timeout/maxTotal...
//    }
//}
//
//public class KafkaConfig {
//    //...省略...
//}
//
//public class MysqlConfig {
//    //...省略...
//}