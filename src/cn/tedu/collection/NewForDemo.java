package cn.tedu.collection;

import java.util.ArrayList;
import java.util.Collection;

/**
 * JDK5推出时，推出了一个新的特性:增强型for循环
 * 通常也称为新循环
 * 新循环不能取代传统for循环的工作，它的出现仅为了使用相同的格式遍历集合和数组
 * 语法:
 * for(元素类型e :集合或数组){
 * <p>
 * }
 */
public class NewForDemo {
    public static void main(String[] args) {
        String[] arr = {"A", "B", "C", "D", "E"};
        System.out.println("==========传统for循环遍历数组========");
        //arr.fori
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i] + "\t");
        }
        System.out.println("==========增强for循环遍历数组========");
        //arr.for
        for (String s : arr) {
            System.out.println(s + "\t");
        }

        Collection c = new ArrayList();
        c.add("1");
        c.add("2");
        c.add("3");
        c.add("4");
        c.add("5");
        System.out.println("==========增强for循环遍历数组========");
        //TODO object用在这里并不合适，可以考虑泛型
        for (Object o : c) {
            System.out.println(o + "\t");
        }

    }
}
