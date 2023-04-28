package cn.tedu.reflect;

import cn.tedu.reflect.annotation.AutoRunClass;

import java.io.File;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/**
 * 自动调用pojo包下的被@AutoRunClass注解修类中的方法名含有"s"的无参且公开的方法
 */
public class Test04 {
    public static void main(String[] args) throws Exception {
        File dir = new File(
                //直接定位Test02.class文件所在的目录
                Test04.class.getResource("./pojo").toURI()
        );
        //后去包下所有字节码文件
        File[] subs = dir.listFiles();
        for (File sub : subs) {
            String fileName = sub.getName();
            // substring(a,b)截取字符串中[a , b)范围的内容
            // indexof( "")获取指定字符串的下标

            String className = fileName.substring(0, fileName.indexOf("."));
            System.out.println(className);
            String allName = Test04.class.getPackage().getName() + ".pojo." + className;
            Class cls = Class.forName(allName);//声明对应类的Class实例，方便后面的反射操作
            if (cls.isAnnotationPresent(AutoRunClass.class)) {
                Object o = cls.newInstance();
                Method[] methods = cls.getDeclaredMethods();
                for (Method method : methods) {
                    //筛选出名字含有"s"的方法
                    if (method.getName().contains("s") &&
                            method.getModifiers() == Modifier.PUBLIC &&
                            method.getParameterCount() == 0) {
                        System.out.println("自动执行" + method.getName() + "类中方法：" + method.getName());
                        method.invoke(o);//调用方法
                    }
                }
            }
        }
    }
}
