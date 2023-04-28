package cn.tedu.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Scanner;

/**
 * 通过反射调用方法
 */
public class ReflectDemo05 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Class cls = Class.forName("cn.tedu.reflect.pojo.Person");
        // newInstance 执行当前构造器，并且接收传入的参数,参数顺序需要和构造器保持一致
        Object o = cls.newInstance();
        //getMethod获取指定的方法
        Method say = cls.getMethod("say");
        //o.say() invoke执行当前方法，并将方法对象作为参数传入
        say.invoke(o);

        Method doSome = cls.getMethod("doSome", String.class);//invoke执行当前方法，并将方法对象作为参数传入，且将方法所需参数传入
        doSome.invoke(o, "打豆豆");

        doSome = cls.getMethod("doSome", String.class, int.class);//获取doSome ( string thing)
        doSome.invoke(o,"喝水",5);
    }
}
