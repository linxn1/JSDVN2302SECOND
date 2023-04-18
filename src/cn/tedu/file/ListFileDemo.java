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
            System.out.println("是目录！");
            File[] subs = dir.listFiles();
            System.out.println(Arrays.toString(subs));
        } else {
            System.out.println("是文件！！！");
        }
    }
}
