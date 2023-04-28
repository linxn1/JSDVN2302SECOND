package cn.tedu.reflect;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/**
 * 自动调用Person类中含有"s"的无参公开方法
 */
public class Test01 {
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, InvocationTargetException {
        Class cls = Class.forName("cn.tedu.reflect.pojo.Person");
        Object o = cls.newInstance();
        //获取Person类中所有方法
        Method[] methods = cls.getMethods();
        for (Method method : methods) {
            //筛选出名字含有"s"的方法
            if (method.getName().contains("s")) {
                //筛选出公开的方法getModifiers 获取方法的权限
                if (method.getModifiers() == Modifier.PUBLIC) {
                    //筛选出无参的方法getParameterCount() 获取方法参数个数
                    if (method.getParameterCount() == 0) {
                        System.out.println("自动执行" + method.getName() + "类中方法：" + method.getName());
                        method.invoke(o);
                    }
                }
            }
        }
    }
}
