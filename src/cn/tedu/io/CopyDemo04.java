package cn.tedu.io;

import java.io.*;

/**
 * 此案例使用缓冲流高效复制文件
 */
public class CopyDemo04 {
    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream("./demo/bridge.jpg");
        BufferedInputStream bis = new BufferedInputStream(fis);
        FileOutputStream fos = new FileOutputStream("./demo/bridge_04");
        BufferedOutputStream bos = new BufferedOutputStream(fos);

        int data;
        long start = System.currentTimeMillis();
        //循环通过高级流单字节读取数据
        while ((data = bis.read()) != -1){
            //通过高级流写出该子节数据
            bos.write(data);
        }
        long end = System.currentTimeMillis();
        System.out.println("复制完毕,复制该图片共耗时" + (end - start) + "ms");

        //关闭流（关闭高级流，会将所连的低级流也一同关闭）
        bis.close();
        bos.close();

    }
}
