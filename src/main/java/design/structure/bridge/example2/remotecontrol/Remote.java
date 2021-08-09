package design.structure.bridge.example2.remotecontrol;

/**
 * 所有远程控制器的通用接口
 * 抽象部分
 * @Author 喻可
 * @Date 2021/8/9 10:24
 */
public interface Remote {
    void power();

    void volumeDown();

    void volumeUp();

    void channelDown();

    void channelUp();
}
