package cn.tedu.file;

import java.io.File;

/**
 * 使用递归(recursionDir),借助listFiles实现获取指定目录下的所有目录和文件名
 * 1.判断当前File是否为文件(防止第一次传入的是文件)
 * 1.1.如果file是文件, 输出: "文件不支持递归!"
 * 1.2.如果file是目录, 则继续执行第2步
 * 2.获取当前目录下的所有子目录及子文件对象组成的File数组
 * 3.遍历当前目录下的所有子目录及子文件对象
 * 4.判断当前遍历的是目录还是文件
 * 4.1.如果当前遍历的是文件, 输出该文件的路径+名称
 * 4.2.如果当前遍历的是目录, 输出当前目录的路径+名称
 * 并以此目录作为根, 接着遍历该目录下的所有子目录和子文件, 输出该目录下的所有目录和文件名
 */
public class ListDirDemo {
    public static void main(String[] args) {
        File dir = new File("./demo");
        //调用recursionDir，递归遍历上面的目录
        recursionDir(dir);
    }

    /**
     * 递归遍历指定的目录
     *
     * @param dir 要遍历的目录
     */
    private static void recursionDir(File dir) {
        //1.1.如果file是文件, 输出: "文件不支持递归!"
        if (dir.isFile()) {
            System.out.println("文件不支持递归！");
            return;
        } else {
            //1.2.如果file是目录, 则继续执行第2步
            //2.获取当前目录下的所有子目录及子文件对象组成的File数组
            File[] subs = dir.listFiles();
            //3.遍历当前目录下的所有子目录及子文件对象
            for (int i = 0; i < subs.length; i++) {
                //4.判断当前遍历的是目录还是文件
                if (subs[i].isFile()) {
                    //4.1.如果当前遍历的是文件, 输出该文件的路径+名称
                    System.out.println("文件：" + subs[i]);
                } else {
                    //4.2.如果当前遍历的是目录, 输出当前目录的路径+名称
                    System.out.println("目录：" + subs[i]);
                    //以此目录作为根, 接着遍历该目录下的所有子目录和子文件, 输出该目录下的所有目录和文件名
                    recursionDir(subs[i]);
                }
            }
        }
    }
}
