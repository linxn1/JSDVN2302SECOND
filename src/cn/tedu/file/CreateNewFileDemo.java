package cn.tedu.file;

import java.io.File;
import java.io.IOException;

/**
 * 学习使用File创建文件
 */
public class CreateNewFileDemo {
    public static void main(String[] args) throws IOException {
        //idea中，相对路径中“./”可以不写，会默认识别，建议写上
        //File file = new File("demo/new.txt");
        File file = new File("./demo/new.txt");
        /**
         * boolean exists()
         * 判断调用的File实例是否存在，存在返回true
         * File可能是目录也可能是文件
         */
        if (file.exists()) {
            System.out.println("文件已存在！");
        } else {
            //方法报红线错误，按alt+enter，然后再直接按回车
            file.createNewFile();//创建新的文件
            System.out.println("该文件创建完毕！");
        }
        /**
         * 返回文件的长度
         */
        if (file.exists()) {
            System.out.println("文件的长度是：" + file.length());
            System.out.println("文件名是：" + file.getName());
        }
    }
}
