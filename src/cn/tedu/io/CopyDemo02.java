package cn.tedu.io;
/**
 * 通过此案例学习多字节复制文件
 * 单字节复制文件，由于需要频繁内存和硬盘进行交互，导致效率极低
 * 所以可以提高每次交互时读写的字节数量，减少交互次数，进而提高读写效率
 * 一组字节一组字节的读写方式称为：块读方式
 */

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopyDemo02 {
    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream("./demo/bridge.jpg");
        FileOutputStream fos = new FileOutputStream("./demo/bridge_02.jpg");

        long start = System.currentTimeMillis();
        //使用块读的方式复制图片
        /*
         *
         */
        byte[] data = new byte[10 * 1024];//10kb的字节数组
        //每次读取10kb的字节数据
        while(fis.read(data)!=-1){
            //每次读取的字节数据，都会存储到data中，所以直接将data写出即可
            fos.write(data);
        }
        long end = System.currentTimeMillis();
        System.out.println("复制完毕,复制该图片共耗时" + (end - start) + "ms");

        //关闭流
        fis.close();
        fos.close();
    }
}
