package java8.fanxin.fanxin_common_sympol;

/**
 * 通配符问题的产生
 * @title: JavaDemo
 * @Author yuke
 * @Date: 2021/10/30 17:36
 */
public class JavaDemo {

    public static void main(String args[]) {
        Message<String> msg = new Message<>() ;
        msg.setContent("www.mldn.cn") ;
        fun(msg) ;    //引用传递
    }
    //问题的关键在于fun()方法上，如果真的去使用泛型，不可能只是一种类型
    // 也就是说fun()方法应该可以接收任意种泛型类型的Message对象
    // 但是这个时候它只能够接收“Message”类型
    public static void fun(Message<String> temp) {
        System.out.println(temp.getContent()) ;
    }    //执行结果：www.mldn.cn
}

