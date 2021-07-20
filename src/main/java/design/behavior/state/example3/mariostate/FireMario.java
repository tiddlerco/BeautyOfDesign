package design.behavior.state.example3.mariostate;

import design.behavior.state.example3.MarioStateMachine;
import design.behavior.state.example3.State;

/**
 * @Author 喻可
 * @Date 2021/7/20 10:08
 */

//状态类需要更新 MarioStateMachine 中的两个变量，score 和 currentState
public class FireMario implements IMario {


    private MarioStateMachine stateMachine;

    public FireMario(MarioStateMachine stateMachine) {
        this.stateMachine = stateMachine;
    }

    @Override
    public State getName() {
        return State.FIRE;
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
