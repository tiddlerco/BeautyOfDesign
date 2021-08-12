package java8.fanxin.fanxininterface;

import java8.fanxin.fanxinclass.Generic;
import lombok.extern.java.Log;

/**
 * 未传入泛型实参时，与泛型类的定义相同，在声明类的时候，需将泛型的声明也一起加到类中
 * 即：class FruitGenerator<T> implements Generator<T>{
 * 如果不声明泛型，如：class FruitGenerator implements Generator<T>，编译器会报错："Unknown class"
 */
@Log
public class FruitGenerator<T> implements Generator<T> {

    @Override
    public T next() {
        return null;
    }

    public static void showKeyValue(Generic<Number> obj) {
        System.out.println("泛型测试" + "key value is " + obj.getKey());
    }

    //需要一个在逻辑上可以表示同时是Generic<Integer>和Generic<Number>父类的引用类型
    //使用通配符？
    public static void showKeyValueWithCommon(Generic<?> obj) {
        System.out.println("泛型测试" + "key value is " + obj.getKey());
    }

    public static void main(String[] args) {
        Generic<Integer> gInteger = new Generic<>(123);
        Generic<Number> gNumber = new Generic<>(456);
        //showKeyValue(gInteger); 编译会报错
        showKeyValueWithCommon(gInteger);
    }

}
