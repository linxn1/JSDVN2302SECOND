package cn.tedu.io;


import java.io.FileNotFoundException;
import java.io.PrintStream;

/**
 * 缓冲字符流
 * PrinterWriter是实际开发中使用的缓冲字符输出流
 * 功能：
 * 1.可以提高写出字符的效率
 * 2.可以按行写出字符串
 * 3.可以自动行刷新
 */
public class PWDemo {
    public static void main(String[] args) throws FileNotFoundException {
        PrintStream pw = new PrintStream("./demo/pw.txt");
        //按行写出字符串
        pw.println("无竹令人俗，");
        pw.println("无肉使人瘦。");
        pw.println("不俗又不瘦，");
        pw.println("竹笋焖猪肉。");
        pw.println("--苏轼《竹笋焖猪肉》");
        pw.close();
    }
}
