package design.structure.bridge.example2.device;

/**
 * 所有设备的通用接口
 * 实现部分
 *
 * @Author 喻可
 * @Date 2021/8/9 10:23
 */
public interface Device {
    boolean isEnabled();

    void enable();

    void disable();

    int getVolume();

    void setVolume(int percent);

    int getChannel();

    void setChannel(int channel);

    void printStatus();
}
