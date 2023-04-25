package cn.tedu.io;
/**
 * 通过此案例学习单字节复制文件
 */

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopyDemo01 {
    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream("./demo/bridge.jpg");
        FileOutputStream fos = new FileOutputStream("./demo/bridge_01.jpg");

        int data;
        long start = System.currentTimeMillis();
        //循环读取目标文件中的字节数据
        while ((data = fis.read()) != -1) {
            //将本次读取的字节数据，写出到复制文件中
            fos.write(data);
        }
        long end = System.currentTimeMillis();
        System.out.println("复制完毕,复制该图片共耗时" + (end - start) + "ms");

        //关闭流
        fis.close();
        fos.close();
    }
}
