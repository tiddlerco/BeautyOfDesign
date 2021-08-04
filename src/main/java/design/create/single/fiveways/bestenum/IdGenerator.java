package design.create.single.fiveways.bestenum;


import java.util.concurrent.atomic.AtomicLong;

public enum IdGenerator {
    INSTANCE;

    private AtomicLong id = new AtomicLong(0);

    public long getId() {
        return id.incrementAndGet();
    }
}
