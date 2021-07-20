package design.behavior.state.example3;


/**
 * @Author 喻可
 * @Date 2021/7/20 14:11
 */
public class Demo {

    public static void main(String[] args) {

        MarioStateMachine marioStateMachine = new MarioStateMachine();

        marioStateMachine.obtainMushRoom();

        marioStateMachine.obtainCape();

        marioStateMachine.meetMonster();

        marioStateMachine.obtainFireFlower();

        System.out.println(marioStateMachine.getCurrentState()+""+marioStateMachine.getScore());

    }
}
