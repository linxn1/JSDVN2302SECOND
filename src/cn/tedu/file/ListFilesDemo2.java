package cn.tedu.file;

import java.io.File;
import java.io.FileFilter;

/**
 * 通过案例学习通过File的listFiles方法获取符合过滤条件的目录中所有子项
 * 重载listFiles方法
 * File[] listFiles(FileFilter filter)
 * 该方法要求传入一个文件过滤器，然后该方法会自动根据文件过滤器要求，将符合条件的文件返回
 */

public class ListFilesDemo2 {
    public static void main(String[] args) {
        //指定当前项目的目录，只需要写一个"."即可
        File dir = new File(".");
        //创建文件过滤器实例，定义过滤规则(一般使用匿名内部类创建，且重写accept方法)
        FileFilter fileFilter = new FileFilter() {
            /**
             * accept方法就是用于定义过滤规则
             * @param pathname 默认的，表示listFiles（要过滤的每一个文件）
             * @return 布尔值，如果返回true则表示符合规则，反之不符合
             */
            @Override
            public boolean accept(File pathname) {
                //定义过滤规则（要求获取子项名字中包含"o"）
                //获取过滤的文件名字
                String pathnameName = pathname.getName();
                //contains判断是否包含，包含返回true，不包含返回false
                return pathnameName.contains("o");
            }
        };
        //将文件过滤器传入listFiles()方法获取的指定目录中的每一个子项
        File[] subs = dir.listFiles(fileFilter);
        for (int i = 0; i < subs.length; i++) {
            System.out.println(subs[i]);
        }
    }
}

