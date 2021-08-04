package design.create.single.fiveways.doublecheck;


import java.util.concurrent.atomic.AtomicLong;

public class IdGenerator {
    private AtomicLong id = new AtomicLong(0);
    private static IdGenerator instance;
    private IdGenerator() {}
    public static IdGenerator getInstance() {
        if (instance == null) {
            //当第一个线程执行完new IdGenerator（）语句后，便会退出锁定区域
            // 此时，第二个线程便可以进入synchronized语句块,所以需要判断
            synchronized(IdGenerator.class) { // 此处为类级别的锁
                if (instance == null) {
                    instance = new IdGenerator();
                }
            }
        }
        return instance;
    }
    public long getId() {
        return id.incrementAndGet();
    }
}