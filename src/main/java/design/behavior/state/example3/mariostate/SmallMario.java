package design.behavior.state.example3.mariostate;

import design.behavior.state.example3.MarioStateMachine;
import design.behavior.state.example3.State;

/**
 * @Author 喻可
 * @Date 2021/7/20 10:03
 */

//状态类需要更新 MarioStateMachine 中的两个变量，score 和 currentState
public class SmallMario implements IMario {

    private MarioStateMachine stateMachine;

    public SmallMario(MarioStateMachine stateMachine) {
        this.stateMachine = stateMachine;
    }

    @Override
    public State getName() {
        return State.SMALL;
    }

    //这里的stateMachine由MarioStateMachine构造器通过引用传递
    //所以也对应Demo里new出来的marioStateMachine
    @Override
    public void obtainMushRoom() {
        stateMachine.setCurrentState(new SuperMario(stateMachine));
        stateMachine.setScore(stateMachine.getScore() + 100);
    }

    @Override
    public void obtainCape() {
        stateMachine.setCurrentState(new CapeMario(stateMachine));
        stateMachine.setScore(stateMachine.getScore() + 200);
    }

    @Override
    public void obtainFireFlower() {
        stateMachine.setCurrentState(new FireMario(stateMachine));
        stateMachine.setScore(stateMachine.getScore() + 300);
    }

    @Override
    public void meetMonster() {
        // do nothing...
    }
}