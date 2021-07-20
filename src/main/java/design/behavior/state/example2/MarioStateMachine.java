package design.behavior.state.example2;


import static design.behavior.state.example2.State.*;

/**
 * 状态机实现方二：查表法
 * 查表法的代码实现更加清晰，可读性和可维护性更好。
 * 当修改状态机时，我们只需要修改 transitionTable 和 actionTable 两个二维数组即可
 * 注意需要画出状态图 对照写出二维数组
 */

public class MarioStateMachine {

    private int score;
    private State currentState;
    private static final State[][] transitionTable = {
            {SUPER, CAPE, FIRE, SMALL},
            {SUPER, CAPE, FIRE, SMALL},
            {CAPE, CAPE, CAPE, SMALL},
            {FIRE, FIRE, FIRE, SMALL}};

    private static final int[][] actionTable = {
            {+100, +200, +300, +0},
            {+0, +200, +300, -100},
            {+0, +0, +0, -200},
            {+0, +0, +0, -300}};

    public MarioStateMachine() {
        this.score = 0;
        this.currentState = SMALL;
    }

    public void obtainMushRoom() {
        executeEvent(Event.GOT_MUSHROOM);
    }

    public void obtainCape() {
        executeEvent(Event.GOT_CAPE);
    }

    public void obtainFireFlower() {
        executeEvent(Event.GOT_FIRE);
    }

    public void meetMonster() {
        executeEvent(Event.MET_MONSTER);
    }

    private void executeEvent(Event event) {
        int stateValue = currentState.getValue();
        int eventValue = event.getValue();
        //当前状态遇到的事件
        this.currentState = transitionTable[stateValue][eventValue];
        //遇到的事件对应加的分数
        this.score += actionTable[stateValue][eventValue];
    }

    public int getScore() {
        return this.score;
    }

    public State getCurrentState() {
        return this.currentState;
    }
}