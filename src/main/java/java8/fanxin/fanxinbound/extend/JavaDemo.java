package java8.fanxin.fanxinbound.extend;

import java8.fanxin.fanxin_common_sympol.resolve.Message;

/**
 * @title: JavaDemo2
 * @Author yuke
 * @Date: 2021/10/30 17:59
 */
public class JavaDemo {

    public static void main(String args[]) {
        Message<Apple> msgA = new Message<>() ;
        Message<Orange> msgB = new Message<>() ;
        fun(msgA) ;    //引用传递
        fun(msgB) ;
    }

    public static void fun(Message<? extends Fruit> temp) {
        System.out.println(temp.getContent()) ;
    }

}
