package java8.fanxin.fanxinmethod.fanxin_method_infanxin_class;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author 喻可
 * @Date 2021/8/12 15:22
 */
public class Fruit{
    @Override
    public String toString() {
        return "fruit";
    }


    public static void main(String[] args) {
        List<Apple> fruitList = new ArrayList<>();
        addToList(fruitList, new Apple());      // 添加 Apple 对象
        addToList(fruitList, new RedApple());   // 添加 RedApple 对象（假设 RedApple 是 Apple 的子类）


        Box<Fruit> fruitBox = new Box<>();
        fruitBox.setItem(new Fruit());      // 设置 Fruit 对象
        fruitBox.setItem(new Apple());      // 设置 Apple 对象
        fruitBox.setItem(new RedApple());   // 设置 RedApple 对象（假设 RedApple 是 Apple 的子类）

    }

    /**
     * <? super Apple> 表示可以持有 Apple 类型或其父类的列表。我们可以向该列表添加 Apple 类型或 Apple 的子类对象
     * @param list
     * @param apple
     */
    public static void addToList(List<? super Apple> list, Apple apple) {
        list.add(apple);
    }



}