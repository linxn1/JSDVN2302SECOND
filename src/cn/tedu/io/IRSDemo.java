package cn.tedu.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

/**
 * 使用输入字符转换流读取文本内容
 */
public class IRSDemo {
    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream("./demo/osw.txt");
        InputStreamReader isr = new InputStreamReader(fis, StandardCharsets.UTF_8);
        int d;
        //使用字符流读取内容时，是一个字符一个字符读取，比如一次性可以将“鹅”这个字符读进来
        //在UTF-8中，一个中文由三个字节组成
        while ((d = isr.read()) != -1) {
            System.out.print((char) d);
        }
        isr.close();
    }
}
