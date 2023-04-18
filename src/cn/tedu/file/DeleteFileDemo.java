package cn.tedu.file;

import java.io.File;
import java.io.IOException;

/**
 * File删除文件
 */
public class DeleteFileDemo {
    public static void main(String[] args) throws IOException {
        //idea中，相对路径中“./”可以不写，会默认识别，建议写上
        //File file = new File("demo/new.txt");
        File file = new File("./demo/new.txt");
        /**
         * boolean exists()
         * 判断调用的File实例是否存在，存在返回true
         * File可能是目录也可能是文件
         */
        if (file.exists()) {
            file.delete();//delete删除
            System.out.println("文件删除成功！");
        } else {
            //方法报红线错误，按alt+enter，然后再直接按回车
            System.out.println("文件不存在，无法删除！");
        }
    }
}
