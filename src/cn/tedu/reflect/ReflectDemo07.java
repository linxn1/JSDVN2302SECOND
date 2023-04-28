package cn.tedu.reflect;

import cn.tedu.reflect.annotation.AutoRunClass;

import java.lang.reflect.InvocationTargetException;

/**
 * 通过反射判断类上是否被指定注解修饰
 */
public class ReflectDemo07 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Class cls = Class.forName("cn.tedu.reflect.pojo.Person");
        if (cls.isAnnotationPresent(AutoRunClass.class)) {
            System.out.println(cls.getSimpleName() + "被@AutoRunClass修饰了");
        } else {
            System.out.println(cls.getSimpleName() + "没有被@AutoRunClass修饰了");
        }
    }
}
