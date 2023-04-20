package cn.tedu.file;

import java.io.File;
import java.io.FileFilter;


public class LambdaDemo {
    public static void main(String[] args) {
        FileFilter f1 = new FileFilter() {
            //不使用lambda表达式的匿名内部类写法
            @Override
            public boolean accept(File file) {
                return file.getName().contains("o");
            }
        };
        //②使用λ表达式忽略接口名和方法名
        /*
         * 1) 将new FileFilter() {}删除
         * 2) public boolean accept
         * 3) 在方法参数和方法体之间添加'->'
         */
        FileFilter f2 = (File file) -> {
            return file.getName().contains("o");
        };

        //③使用λ表达式忽略参数类型
        FileFilter f3 = (file) -> {
            return file.getName().contains("o");
        };
        //④如果要重写的方法中只有一个形参时,那么参数的'()'也可以省略
        FileFilter f4 = file -> {
            return file.getName().contains("o");
        };
        //⑤如果方法体中只有一句代码,那么可以将方法体的'{}'省略,如果代码包含return,return也需要一同省略
        FileFilter f5 = file -> file.getName().contains("o");

        File dir = new File(".");
        File[] subs = dir.listFiles(file -> file.getName().contains("o"));
        for (int i = 0; i < subs.length; i++) {
            System.out.println(subs[i].getName());
        }

    }
}
