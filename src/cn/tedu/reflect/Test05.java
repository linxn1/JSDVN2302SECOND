package cn.tedu.reflect;

import cn.tedu.reflect.annotation.AutoRunClass;
import cn.tedu.reflect.annotation.AutoRunMethod;

import java.io.File;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/**
 * 自动调用pojo包下的被@AutoRunClass注解修类中的方法名被@AutoRunMethod修饰的方法
 */
public class Test05 {
    public static void main(String[] args) throws Exception {
        File dir = new File(
                //直接定位Test02.class文件所在的目录
                Test05.class.getResource("./pojo").toURI()
        );
        //后去包下所有字节码文件
        File[] subs = dir.listFiles();
        for (File sub : subs) {
            String fileName = sub.getName();
            // substring(a,b)截取字符串中[a , b)范围的内容
            // indexof( "")获取指定字符串的下标

            String className = fileName.substring(0, fileName.indexOf("."));
            System.out.println(className);
            String allName = Test05.class.getPackage().getName() + ".pojo." + className;
            Class cls = Class.forName(allName);//声明对应类的Class实例，方便后面的反射操作
            if (cls.isAnnotationPresent(AutoRunClass.class)) {
                Object o = cls.newInstance();
                Method[] methods = cls.getDeclaredMethods();
                for (Method method : methods) {
                    if (method.isAnnotationPresent(AutoRunMethod.class)) {
                        System.out.println("自动调用了" + className + "类中的" + method.getName() + "方法");
                        method.invoke(o);
                    }
                }
            }
        }
    }
}

