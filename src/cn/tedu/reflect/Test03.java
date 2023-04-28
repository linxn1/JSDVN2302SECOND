package cn.tedu.reflect;

import java.io.File;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/**
 * 自动调用pojo包下所有类中的方法名含有"s"的无参且公开的方法
 */
public class Test03 {
    public static void main(String[] args) throws Exception {
        File dir = new File(
                //直接定位Test02.class文件所在的目录
                Test03.class.getResource("./pojo").toURI()
        );
        //后去包下所有字节码文件
        File[] subs = dir.listFiles();
        for (File sub : subs) {
            String fileName = sub.getName();
            String className = fileName.substring(0, fileName.indexOf("."));
            System.out.println(className);
            Class cls = Class.forName(Test03.class.getPackage().getName() + ".pojo." + className);
            System.out.println(cls);

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
