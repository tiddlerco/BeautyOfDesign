package java8.fanxin.fanxinbound;

import java.util.List;

/**
 * @Author 喻可
 * @Date 2021/8/25 11:18
 */
public class fanxinbound {
    /**
     * Producer extends: 如果我们需要一个 List 提供类型为 T 的数据(即希望从 List 中读取 T 类型的数据),
     * 那么我们需要使用 ? extends T, 例如 List<? extends Integer>. 但是我们不能向这个 List 添加数据.
     * <p>
     * Consumer Super: 如果我们需要一个 List 来消费 T 类型的数据(即希望将 T 类型的数据写入 List 中),
     * 那么我们需要使用 ? super T, 例如 List<? super Integer>. 但是这个 List 不能保证从它读取的数据的类型.
     * <p>
     * 如果我们既希望读取, 也希望写入, 那么我们就必须明确地声明泛型参数的类型, 例如 List<Integer>.
     */

    /**
     * 对于 List<? super Integer> l1:
     *
     * 正确的理解: ? super Integer 限定的是泛型参数. 令 l1 的泛型参数是 T, 则 T 是 Integer 或 Integer 的父类,
     * 因此 Integer 或 Integer 的子类的对象就可以添加到 l1 中.
     *
     * 错误的理解: ? super Integer限定的是插入的元素的类型, 因此只要是 Integer 或 Integer 的父类的对象都可以插入 l1 中
     *
     * 对于 List<? extends Integer> l2:
     *
     * 正确的理解: ? extends Integer 限定的是泛型参数. 令 l2 的泛型参数是 T, 则 T 是 Integer 或 Integer 的子类,
     * 进而我们就不能找到一个类 X, 使得 X 是泛型参数 T 的子类, 因此我们就不可以向 l2 中添加元素.
     * 不过由于我们知道了泛型参数 T 是 Integer 或 Integer 的子类这一点,
     * 因此我们就可以从 l2 中读取到元素(取到的元素类型是 Integer 或 Integer 的子类), 并可以存放到 Integer 中.
     *
     * 错误的理解: ? extends Integer 限定的是插入元素的类型, 因此只要是 Integer 或 Integer 的子类的对象都可以插入 l2 中
     */

    public static <T> void copy(List<? super T> dest, List<? extends T> src) {

        for (int i = 0; i < src.size(); i++)
            dest.set(i, src.get(i));
    }


}
