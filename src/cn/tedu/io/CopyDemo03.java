package cn.tedu.io;
/**
 * 通过此案例学习多字节复制文件
 * 由于块读是，最后一次如果不满足data数组长度，则会导致最后一次写入数据时，
 * 会将上次多余的数据残留
 */

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopyDemo03 {
    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream("./demo/bridge.jpg");
        FileOutputStream fos = new FileOutputStream("./demo/bridge_03.jpg");

        long start = System.currentTimeMillis();

        byte[] data = new byte[10 * 1024];//10kb的字节数组
        int len;//定义len记录本次读取的字节量
        while ((len = fis.read(data)) != -1) {
            //根据len，保证本次写入的字节的个数为世纪的个数
            fos.write(data, 0, len);
        }
        long end = System.currentTimeMillis();
        System.out.println("复制完毕,复制该图片共耗时" + (end - start) + "ms");

        //关闭流
        fis.close();
        fos.close();
    }
}
