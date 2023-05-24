package java8.fanxin.fanxinmethod.fanxin_method_infanxin_class;


/**
 * @Author tiddler
 * @Date 2023/5/24 21:46
 */
public class Box<T extends Fruit> {

    private T item;

    public void setItem(T item) {
        this.item = item;
    }

    public T getItem() {
        return item;
    }

}
