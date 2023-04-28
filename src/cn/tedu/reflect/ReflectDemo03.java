package cn.tedu.reflect;

import java.util.Scanner;

/**
 * 通过反射创建实例对象
 * cn.tedu.reflect.pojo.Person
 * cn.tedu.reflect.pojo.Student
 * java.lang.String
 */
public class ReflectDemo03 {
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        System.out.println("请输入想获取的类的全路径名：");
        String line = new Scanner(System.in).nextLine();
        Class cls = Class.forName(line);
        //newInstance()调用类中的无参且公开构造，创建对象实例
        //InstantiationException 实例化异常，如果没有无参构造，就抛出该异常
        //IllegalAccessException非法访问异常，如果无参构造是非公开的，就抛出该异常
        Object o = cls.newInstance();
        System.out.println(o);

    }
}
