package java8.fanxin.fanxin_common_sympol.resolve;

/**
 * @title: JavaDemo
 * @Author yuke
 * @Date: 2021/10/30 17:51
 */
public class JavaDemo {

    public static void main(String args[]) {
        Message<Integer> msgA = new Message<>() ;
        Message<String> msgB = new Message<>() ;
        msgA.setContent(110) ;
        fun(msgA) ;    //引用传递
        msgB.setContent("www.mldn.cn") ;
        fun(msgB) ;
    }

    //泛型通配符的使用场景
    //同一个方法可能被多个不同的实例对象调用的时候
    //方法在被调用的时候需要使用具体的实体类
    public static void fun(Message<?> temp) {
        System.out.println(temp.getContent()) ;
    }
}
