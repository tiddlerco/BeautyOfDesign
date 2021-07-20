package design.behavior.state.example3;

import design.behavior.state.example3.mariostate.IMario;

/**
 * 额外补充：
 * 状态接口中定义了所有的事件函数，
 * 这就导致，即便某个状态类并不需要支持其中的某个或者某些事件，
 * 但也要实现所有的事件函数。
 * 不仅如此，添加一个事件到状态接口，所有的状态类都要做相应的修改
 * <p>
 * 解决：可以在接口和实现类中间加一层抽象类MarioAbstract解决此问题，
 * 抽象类实现状态接口，状态类继承抽象类，只需要重写需要的方法即可
 *
 * @Author 喻可
 * @Date 2021/7/20 15:24
 */
public abstract class MarioAbstract implements IMario {

    @Override
    public State getName() {
        return null;
    }

    @Override
    public void obtainMushRoom() {

    }

    @Override
    public void obtainCape() {

    }

    @Override
    public void obtainFireFlower() {

    }

    @Override
    public void meetMonster() {

    }
}
