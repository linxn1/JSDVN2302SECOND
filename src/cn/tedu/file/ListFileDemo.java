package cn.tedu.file;

import java.io.File;
import java.util.Arrays;

/**
 * 使用File获取指定目录下的一层子项目
 */
public class ListFileDemo {
    public static void main(String[] args) {
        File dir = new File("./Demo");
        /**
         * isDirectory()判断是否为目录
         */
        if (dir.isDirectory()) {
            /**
             * File[] subs = dir.listFiles();
             * 将当前调用的File表示的目录的一层子项，各自实例化为File，并储存到File数组之中
             */
            File[] subs = dir.listFiles();
            System.out.println("demo目录下，有" + subs.length + "个子项！");
            for (int i = 0; i < subs.length; i++) {
                System.out.println(subs[i].getName());
            }
        } else {
            System.out.println("是文件！！！");
        }
    }
}
