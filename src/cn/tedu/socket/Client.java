package cn.tedu.socket;


import java.io.*;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Client {
    /**
     * java.net.Socket 套接字，愿意是插座
     * Socket封装了TCP写一的通信细节，我们使用它可以与远端计算机建立TCP连接，并基于一堆流的操作完成与远端计算机的数据交互
     */
    private Socket socket;
    private static String name;

    /**
     * 初始化客户端
     */
    public Client() {
        try {
            System.out.println("正在连接服务器...");
            /**
             * 实例化Socket时，需要传入两个参数
             * 1.要连接的远端计算机（服务器）IP地址
             *  a.如果连接的是非本机IP，则需要查询对方的IP地址，进行连接
             *  b.如果连接的是本机，则可以选取如下值：
             *      i.真实IP（通过ipconfig查询出来的）
             *      ii.127.0.0.1（会自动映射本机的真实IP）
             *      iii.localhost（是127.0.0.1的域名）
             * 2.要连接的远端计算机（服务器）端口
             */
            socket = new Socket("localhost", 8088);//全局socket
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 客户端开始工作的方法
     */
    public void start() {
        try {
            //启动一个线程来读取服务器端发送的信息
            ServerHandler handler = new ServerHandler();
            Thread t = new Thread(handler);
            t.setDaemon(true);
            t.start();
            /**
             * 通过Socket的getOutputStream方法
             * 获取字节输出流写出的字节会通过网络发送给远端计算机
             */
            OutputStream out = socket.getOutputStream();
            //和转换输出字符流连接，并指定对应的编码
            OutputStreamWriter osw = new OutputStreamWriter(out, StandardCharsets.UTF_8);
            //和缓冲红字符流连接
            BufferedWriter bw = new BufferedWriter(osw);
            //和按行写出字符流连接，并开启按行刷新
            PrintWriter pw = new PrintWriter(bw, true);


            Scanner scanner = new Scanner(System.in);
            while (true) {
                String line = scanner.nextLine();//这是阻塞方法，程序只有在敲击回车时才会向下执行，导致不敲击回车就不能向下执行
                if ("exit".equals(line)) {
                    break;
                }
                pw.println(name + "说：" + line);


            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                /**
                 * Socket提供的close方法
                 * 1.可以断开和远端计算机的连接，并挥手示意
                 * 2.可以将socket所连接的流进行关闭
                 */
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("请输入您的用户名：");
        name = new Scanner(System.in).nextLine();
        Client client = new Client();
        client.start();
    }

    /**
     * 该线程负责读取服务器发送的信息
     */
    private class ServerHandler implements Runnable {
        @Override
        public void run() {
            try {
                //通过socket获取输入流读取服务器发送的信息
                InputStream in = socket.getInputStream();
                //连接输入转换字符流，并指定编码
                InputStreamReader isr = new InputStreamReader(in, StandardCharsets.UTF_8);
                //连接接缓冲输入字符流
                BufferedReader br = new BufferedReader(isr);

                //创建流之后，开始循环读取服务器发送的信息
                String line;
                while ((line = br.readLine()) != null) {
                    System.out.println(line);
                }

            } catch (IOException e) {
                //此处只有当链接断开时，才会触发异常，但是控制不了，索性忽视该异常
                //e.printStackTrace();
            }
        }
    }
}
