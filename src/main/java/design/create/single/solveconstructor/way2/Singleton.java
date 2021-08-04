package design.create.single.solveconstructor.way2;

/**
 * 单例不支持有参数的构造函数
 * 问题：类本身的初始化过程就只允许有一次,第二次的参数（20，30）没有起作用
 * 不推荐
 */
public class Singleton {
    private static Singleton instance = null;
    private final int paramA;
    private final int paramB;

    private Singleton(int paramA, int paramB) {
        this.paramA = paramA;
        this.paramB = paramB;
    }

    public synchronized static Singleton getInstance(int paramA, int paramB) {
        if (instance == null) {
            instance = new Singleton(paramA, paramB);
        }
        return instance;
    }

    public static void main(String[] args) {
        Singleton singleton1 = Singleton.getInstance(10, 50);
        //第二次的参数（20，30）没有起作用
        Singleton singleton2 = Singleton.getInstance(20, 30);
    }

}


