package design.create.single.solveconstructor.way1;

/**
 * 单例不支持有参数的构造函数
 */
public class Singleton {
    private static Singleton instance = null;
    private final int paramA;
    private final int paramB;

    private Singleton(int paramA, int paramB) {
        this.paramA = paramA;
        this.paramB = paramB;
    }

    public static Singleton getInstance() {
        if (instance == null) {
            throw new RuntimeException("Run init() first.");
        }
        return instance;
    }

    public synchronized static Singleton init(int paramA, int paramB) {
        if (instance != null){
            throw new RuntimeException("Singleton has been created!");
        }
        instance = new Singleton(paramA, paramB);
        return instance;
    }
    //使用
    public static void main(String[] args) {
        Singleton.init(10, 50); // 先init，再使用
        Singleton singleton = Singleton.getInstance();
    }
}


