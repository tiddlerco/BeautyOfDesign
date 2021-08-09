package design.structure.bridge.example2.remotecontrol;

import design.structure.bridge.example2.device.Device;

/**
 * 高级远程控制器
 *
 * @Author 喻可
 * @Date 2021/8/9 10:25
 */
public class AdvancedRemote extends BasicRemote {

    public AdvancedRemote(Device device) {
        super.device = device;
    }

    public void mute() {
        System.out.println("Remote: mute");
        device.setVolume(0);
    }
}
