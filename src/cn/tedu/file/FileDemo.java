package cn.tedu.file;

import java.io.File;

public class FileDemo {
    public static void main(String[] args) {
        //访问当前项目下的demo目录中的demo.text文件
        /**
         * 路径分为两种，绝对路径和相对路径
         * 1.绝对路径：
         *     右键->Copy Path->Absolute Path，复制绝对路径
         *     "G:\\JSDVN2302SE\\demo\\demo.txt"
         * 2.相对路径：
         *      在idea中使用"./"表示当前项目的目录
         *      在本项目中，"./"就表示"G:\\JSDVN2302SE\\"
         *      "demo/demo.txt"
         */
        File file = new File("./demo/demo.txt");
        //获取文件名字(绑定的字符串的名字)
        String fileName = file.getName();
        System.out.println("name = " + fileName);

        //获取文件长度（字节），英文字母算一个字节算一个，中文字母是算三个字节
        long fileLength = file.length();
        System.out.println("长度为 = " + fileLength + "个字节");
    }
}
