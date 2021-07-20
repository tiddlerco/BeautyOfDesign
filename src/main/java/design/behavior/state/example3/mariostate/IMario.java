package design.behavior.state.example3.mariostate;


import design.behavior.state.example3.State;

/**
 * @Author 喻可
 * @Date 2021/7/20 10:01
 */

//所有状态类的接口
public interface IMario {

    State getName();
    //以下是定义的事件
    void obtainMushRoom();
    void obtainCape();
    void obtainFireFlower();
    void meetMonster();
}






