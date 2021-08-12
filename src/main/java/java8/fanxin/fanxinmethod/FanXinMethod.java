package java8.fanxin.fanxinmethod;

/**
 * 泛型类，是在实例化类的时候指明泛型的具体类型；
 * 泛型方法，是在调用方法的时候指明泛型的具体类型
 *
 * @Author 喻可
 * @Date 2021/8/12 15:06
 */
public class FanXinMethod {

    /**
     * 泛型方法的基本介绍在Generic里
     *
     * @param tClass 传入的泛型实参
     * @return T 返回值为T类型
     * 说明：
     * 1）public 与 返回值中间<T>非常重要，可以理解为声明此方法为泛型方法。
     * 2）只有声明了<T>的方法才是泛型方法，泛型类中的使用了泛型的成员方法并不是泛型方法。
     * 3）<T>表明该方法将使用泛型类型T，此时才可以在方法中使用泛型类型T。
     * 4）与泛型类的定义一样，此处T可以随便写为任意标识，常见的如T、E、K、V等形式的参数常用于表示泛型。
     */
    public <T> T genericMethod(Class<T> tClass) throws InstantiationException, IllegalAccessException {

        T instance = tClass.newInstance();

        return instance;
    }

    //泛型方法与可变参数
    public <T> void printMsg(T... args) {
        for (T t : args) {
            System.out.println("泛型测试" + "t is " + t);
        }
    }
    //printMsg("111",222,"aaaa","2323.4",55.55);


    /**
     * 如果在类中定义使用泛型的静态方法，需要添加额外的泛型声明（将这个方法定义成泛型方法）
     * 即使静态方法要使用泛型类中已经声明过的泛型也不可以。
     * 如：public static void show(T t){..},此时编译器会提示错误信息：
     "StaticGenerator cannot be refrenced from static context"
     */
    public static <T> void show(T t){

    }


}
