package design.structure.bridge.example2;

import design.structure.bridge.example2.device.Device;
import design.structure.bridge.example2.device.Radio;
import design.structure.bridge.example2.device.Tv;
import design.structure.bridge.example2.remotecontrol.AdvancedRemote;
import design.structure.bridge.example2.remotecontrol.BasicRemote;

/**
 * @Author 喻可
 * @Date 2021/8/9 10:26
 */
public class Demo {
    public static void main(String[] args) {
        testDevice(new Tv());
        testDevice(new Radio());
    }

    public static void testDevice(Device device) {
        System.out.println("Tests with basic remote.");
        BasicRemote basicRemote = new BasicRemote(device);
        basicRemote.power();
        device.printStatus();

        System.out.println("Tests with advanced remote.");
        AdvancedRemote advancedRemote = new AdvancedRemote(device);
        advancedRemote.power();
        advancedRemote.mute();
        device.printStatus();
    }
}
