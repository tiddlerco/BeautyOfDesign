package java8.fanxin.fanxin_common_sympol;

/**
 * 通配符问题的产生
 * @title: Message
 * @Author yuke
 * @Date: 2021/10/30 17:36
 */
public class Message <T> {
    private T content ;
    public void setContent(T content) {
        this.content = content ;
    }
    public T getContent() {
        return this.content ;
    }
}
