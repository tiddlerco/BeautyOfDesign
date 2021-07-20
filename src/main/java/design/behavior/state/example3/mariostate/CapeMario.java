package design.behavior.state.example3.mariostate;

import design.behavior.state.example3.MarioStateMachine;
import design.behavior.state.example3.State;

/**
 * 方式2中触发的事件只是加减积分所以可以使用二维数组来表示
 * 如果涉及到复杂的数据库操作逻辑就不能再使用二维数组了
 * 这里把触发的事件拆出来变成单独的类
 *
 * @Author 喻可
 * @Date 2021/7/20 10:08
 */

//状态类需要更新 MarioStateMachine 中的两个变量，score 和 currentState
public class CapeMario implements IMario {

    private MarioStateMachine stateMachine;

    public CapeMario(MarioStateMachine stateMachine) {
        this.stateMachine = stateMachine;
    }


    @Override
    public State getName() {
        return State.CAPE;
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
        stateMachine.setCurrentState(new SmallMario(stateMachine));
        stateMachine.setScore(stateMachine.getScore() - 100);
    }
}
