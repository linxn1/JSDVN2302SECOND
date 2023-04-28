package cn.tedu.reflect;

import cn.tedu.reflect.annotation.AutoRunClass;
import cn.tedu.reflect.annotation.AutoRunMethod;

import java.io.File;
import java.lang.reflect.Method;

/**
 * 自动调用pojo包下的被@AutoRunClass注解修饰的类中的被@AutoRunMethod注解修饰的方法，
 * 并且根据@AutoRunMethod注解传入的参数，来执行对应的次数
 */
public class Test06 {
    public static void main(String[] args) throws Exception {
        File dir = new File(
                //直接定位Test02.class文件所在的目录
                Test06.class.getResource("./pojo").toURI()
        );
        //后去包下所有字节码文件
        File[] subs = dir.listFiles();
        for (File sub : subs) {
            String fileName = sub.getName();
            // subString(a,b)截取字符串中[a , b)范围的内容
            // indexOf( "")获取指定字符串的下标

            String className = fileName.substring(0, fileName.indexOf("."));
            System.out.println(className);
            String allName = Test06.class.getPackage().getName() + ".pojo." + className;
            Class cls = Class.forName(allName);//声明对应类的Class实例，方便后面的反射操作
            if (cls.isAnnotationPresent(AutoRunClass.class)) {
                Object o = cls.newInstance();
                Method[] methods = cls.getDeclaredMethods();
                for (Method method : methods) {
                    if (method.isAnnotationPresent(AutoRunMethod.class)) {
                        AutoRunMethod anno = method.getAnnotation(AutoRunMethod.class);//获取指定方法上的注解
                        int num = anno.value();//获取注解中传入的参数

                        for (int i = 0; i < num; i++) {
                            System.out.println("自动调用了" + className + "类中的" + method.getName() + "方法" + num + "次");
                            method.invoke(o);
                        }
                    }
                }
            }
        }
    }
}

