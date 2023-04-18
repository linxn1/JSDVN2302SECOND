package cn.tedu.file;

import java.io.File;

/**
 * 创建File目录
 */
public class MKDirDemo {
    public static void main(String[] args) {
        File dir = new File("./demo/h/l/l/o");
        if (dir.exists()) {
            System.out.println("该目录已存在！");
        } else {
            /**
             * mkdir() 创建目录时要求该目录必须存在，否则无法创建
             * mkdirs() 创建目录时，会将不存在的目录一同创建出来（推荐）
             */
            dir.mkdirs();//mk
            System.out.println("目录制作完毕！！");
        }
    }
}
