package design.behavior.strategy.example2.improve3;

import design.behavior.strategy.example2.commonsort.*;

import java.util.HashMap;
import java.util.Map;

/**
 * 每种排序类都是无状态的，我们没必要在每次使用的时候，都重新创建一个新的对象。
 * 所以，我们可以使用工厂模式对对象的创建进行封装
 * 经过上面两次重构之后，现在的代码实际上已经符合策略模式的代码结构了
 *
 * @Author 喻可
 * @Date 2021/7/13 15:46
 */

public class SortAlgFactory {
    private static final Map<String, ISortAlg> algs = new HashMap<>();

    static {
        algs.put("QuickSort", new QuickSort());
        algs.put("ExternalSort", new ExternalSort());
        algs.put("ConcurrentExternalSort", new ConcurrentExternalSort());
        algs.put("MapReduceSort", new MapReduceSort());
    }

    public static ISortAlg getSortAlg(String type) {
        if (type == null || type.isEmpty()) {
            throw new IllegalArgumentException("type should not be empty.");
        }
        return algs.get(type);
    }
}


