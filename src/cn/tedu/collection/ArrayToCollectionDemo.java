package cn.tedu.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 数组转化为集合
 */
public class ArrayToCollectionDemo {
    public static void main(String[] args) {
        String[] array = {"A", "B", "C", "D", "E"};
        System.out.println("数组array = " + Arrays.toString(array));
        List<String> list = Arrays.asList(array);
        System.out.println("集合list = " + list);
    }
}
