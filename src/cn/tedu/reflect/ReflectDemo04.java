package cn.tedu.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Scanner;

/**
 * 通过反射创建指定参数实例对象
 * cn.tedu.reflect.pojo.Person
 * cn.tedu.reflect.pojo.Student
 * java.lang.String
 */
public class ReflectDemo04 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Class cls = Class.forName("cn.tedu.reflect.pojo.Person");
        //获取指定的构造器
        Constructor c = cls.getConstructor(String.class, int.class);
        // newInstance 执行当前构造器，并且接收传入的参数,参数顺序需要和构造器保持一致
        Object o = c.newInstance("张飞", 34);
        System.out.println(o);
    }
}
