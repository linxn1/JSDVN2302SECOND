package cn.tedu.socket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Scanner;
import java.util.logging.Handler;

public class Server {
    /**
     * java.net.ServerSocket
     * 是运行在服务器端的，它具有以下两个作用
     * 1.打开服务器端口（占用一个端口，客户端访问服务器的端口，就是它占用）
     * 2.监听该端口，一旦一个客户端访问服务器，则会立即生成一个Socket实例，并通过这个实例连接客户端
     */
    private ServerSocket sever;
    //    private PrintWriter[] allOut = {};
    private Collection<PrintWriter> allOut = new ArrayList<>();

    public Server() {

        try {
            System.out.println("正在启动服务器");
            /**
             * 实例化ServerSocket，需要指定占用的端口，该端口就是Client类的端口号
             */
            sever = new ServerSocket(8088);
            System.out.println("服务器启动完毕");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void start() {
        while (true) {
            try {
                System.out.println("等待客户端的连接...");
                /**
                 * 监听当前占用的端口号，并且该方法是一个阻塞方法
                 * 当端口号没有被客户端访问是，程序不会向下执行，一直阻塞在此处
                 * 当端口号被客户端访问时，会理解返回一个Socket实例，并且程序继续向下运行
                 * 强调：可以利用该Socket实例和当前来访的客户端进行交互
                 */
                Socket socket = sever.accept();
                System.out.println("一个客户端连接了！！！");
                //当有客户端访问时，可以创建一个线程负责和当前客户端进行交互
                ClientHandler handler = new ClientHandler(socket);
                Thread t = new Thread(handler);
                t.start();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        Server server = new Server();
        server.start();
    }

    /**
     * 定义线程的任务类，负责和客户端进行交户
     */
    private class ClientHandler implements Runnable {
        private Socket socket;
//        private String username;

        public ClientHandler(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            PrintWriter pw = null;//将pw设置为全局作用域
            try {
                /**
                 * Socket的getInputStream();
                 * 可以获取一个低级字节输入流，可以读取来自远端计算机发送过来的字节数据
                 */
                InputStream in = socket.getInputStream();
                //连接输入转换字符流，并指定编码
                InputStreamReader isr = new InputStreamReader(in, StandardCharsets.UTF_8);
                //连接接缓冲输入字符流
                BufferedReader br = new BufferedReader(isr);

                //通过socket获取输出流，用于给客户端发送信息
                OutputStream out = socket.getOutputStream();
                //和转换输出字符流连接，并指定对应的编码
                OutputStreamWriter osw = new OutputStreamWriter(out, StandardCharsets.UTF_8);
                //和缓冲红字符流连接
                BufferedWriter bw = new BufferedWriter(osw);
                //和按行写出字符流连接，并开启按行刷新
                pw = new PrintWriter(bw, true);
//---------------------------------------------------------------------
//                //将该客户端的输出存入到共享数组allOut中
//                //1.对allOut进行扩容
//                allOut = Arrays.copyOf(allOut, allOut.length + 1);
//                //2.将pw存储到allOut中（存储到allOut的最后一个位置）
//                allOut[allOut.length - 1] = pw;

                //将该客户端的输出存入到共享集合allOut中
                allOut.add(pw);
//---------------------------------------------------------------------
//                //广播通知所有客户端用户上线了
//                sendMessage("一个用户上线了！当前在线人数：" + allOut.length);

                //广播通知所有客户端用户上线了
                sendMessage("一个用户上线了！当前在线人数：" + allOut.size());
//---------------------------------------------------------------------

                //循环读取客户端发送的一行字符串
                String line;
                while ((line = br.readLine()) != null) {
                    System.out.println(line);
                    //将客户端发送的信息回复给所有客户端
                    sendMessage(line);
                }
            } catch (IOException e) {
                //e.printStackTrace();
            } finally {
//---------------------------------------------------------------------
//                //将当前客户端的输出流从allOut数组中取出
//                //遍历allOut
//                for (int i = 0; i < allOut.length; i++) {
//                    //找到要删除的元素
//                    if (allOut[i] == pw) {
//                        //将最后一个元素替换到目标元素
//                        allOut[i] = allOut[allOut.length - 1];
//                        //进行数组的缩容（将数组的最后一个元素删除）
//                        allOut = Arrays.copyOf(allOut, allOut.length - 1);
//                        //由于数组中只会存储一个目标元素，所有找到目标元素取出后，就可以停止遍历了
//                        break;
//                    }
//                }
                allOut.remove(pw);
//---------------------------------------------------------------------

                //广播通知所有用户端用户下线了
//                sendMessage("一个用户下线了，当前在线人数：" + allOut.length);
                sendMessage("一个用户下线了，当前在线人数：" + allOut.size());
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        /**
         * 广播通知所有客户端
         *
         * @param message
         */
        private void sendMessage(String message) {
//            for (int i = 0; i < allOut.length; i++) {
//                allOut[i].println(message);
//            }
            for (PrintWriter printWriter : allOut) {
                printWriter.println(message);
            }
        }
    }
}
