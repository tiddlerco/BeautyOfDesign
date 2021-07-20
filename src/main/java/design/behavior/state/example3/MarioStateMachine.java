package design.behavior.state.example3;

import design.behavior.state.example3.mariostate.IMario;
import design.behavior.state.example3.mariostate.SmallMario;

/**
 * 状态模式通过将事件触发的状态转移和动作执行，拆分到不同的状态类中
 * 来避免分支判断逻辑
 *
 * @Author 喻可
 * @Date 2021/7/20 10:02
 */


public class MarioStateMachine {

    private int score;
    private IMario currentState; // 不再使用枚举来表示状态

    public MarioStateMachine() {
        this.score = 0;
        this.currentState = new SmallMario(this);
    }

    public void obtainMushRoom() {
        this.currentState.obtainMushRoom();
    }

    public void obtainCape() {
        this.currentState.obtainCape();
    }

    public void obtainFireFlower() {
        this.currentState.obtainFireFlower();
    }

    public void meetMonster() {
        this.currentState.meetMonster();
    }

    public int getScore() {
        return this.score;
    }

    public State getCurrentState() {
        return this.currentState.getName();
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void setCurrentState(IMario currentState) {
        this.currentState = currentState;
    }
}
