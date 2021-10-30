package java8.fanxin.fanxin_common_sympol.resolve;

/**
 * 解决
 * @title: Message
 * @Author yuke
 * @Date: 2021/10/30 17:51
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
