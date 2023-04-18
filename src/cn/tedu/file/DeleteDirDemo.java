package cn.tedu.file;

import java.io.File;

/**
 * 创建File目录
 */
public class DeleteDirDemo {
    public static void main(String[] args) {
        File dir = new File("./demo/a");
        if (dir.exists()) {
            /**
             * delete方法，只能删除一个文件或者目录
             * 原因是delete不能删除非空目录
             */
            dir.delete();//删除目录
            System.out.println("目录删除成功！");
        } else {
            System.out.println("目录不存在！！删除失败！！");
        }
    }
}
