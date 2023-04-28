package cn.tedu.io;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

/**
 * 利用PrintWriter实现简易的记事本，并可以按行写入
 */
public class TestNote02 {
    public static void main(String[] args) throws FileNotFoundException {
        //创建低级的文件字节输出流 1.绑定文件 2.开启追加模式
        FileOutputStream fos = new FileOutputStream("./demo/note_pw.txt", true);
        //创建高级的转换输出字符流 1.衔接字节流和字符流 2.将写出的字符自动转换为字节数据
        OutputStreamWriter osw = new OutputStreamWriter(fos, StandardCharsets.UTF_8);
        //创建高级的缓冲字符输出流 1.提高块写文本数据的效率
        BufferedWriter bw = new BufferedWriter(osw);
        //创建高级的按行刷新字符流 1.按行插入字符串 2.开启自动刷新
        PrintWriter pw = new PrintWriter(bw, true);
        //完成简易记事本的录入
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String line = scanner.nextLine();
            if ("exit".equals(line)) {
                break;
            }
            //将控制台录入的字符串写到文件中
            pw.println(line);
        }
        //释放流资源
        pw.close();
    }
}
