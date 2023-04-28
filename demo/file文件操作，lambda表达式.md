# file文件操作

**1.访问文件或者目录的属性信息**

```java
//文件的长度
file.length();
//文件是否存在
file.exist();
//是否是文件
file.isFile();
//是否是目录
file.isDirectory();
//获取文件名
file.getName();
```

**2.创建和删除目录或文件**

```java
//创建文件
file.creatNewFile();
//创建目录
file.mkdir();
file.mkdirs();
//删除文件或目录
file.delete();

//获取指定目录的下一级子项
file.listFiles();
//获取指定目录下符合条件的一级子项
file.listFiles(FileFilter filter);

```

**过滤指定目录下的指定类型文件（通过重写accept方法）**

```java
        //创建文件过滤器实例，定义过滤规则(一般使用匿名内部类创建，且重写accept方法)
        FileFilter fileFilter = new FileFilter() {
            /**
             * accept方法就是用于定义过滤规则
             * @param pathname 默认的，表示listFiles（要过滤的每一个文件）
             * @return 布尔值，如果返回true则表示符合规则，反之不符合
             */
            @Override
            public boolean accept(File pathname) {
                //定义过滤规则（要求获取子项名字中包含"o"）
                //获取过滤的文件名字
                String pathnameName = pathname.getName();
                //contains判断是否包含，包含返回true，不包含返回false
                return pathnameName.contains("o");
            }
        };
        //将文件过滤器传入listFiles()方法获取的指定目录中的每一个子项
        File[] subs = dir.listFiles(fileFilter);
        for (int i = 0; i < subs.length; i++) {
            System.out.println(subs[i]);
        }
```

# **Lambda表达式**

使用前提要求简化的匿名内部类接口中只能存在一个抽象方法

```java
FileFilter f1 = new FileFilter() {
            //1.不使用lambda表达式的匿名内部类写法
            @Override
            public boolean accept(File pathname) {
                return pathname.getName().contains("o");
            }
        };
        //2.使用lambda表达式忽略接口名和方法名
        /**
         * 1.将new FileFilter(){}删除
         * 2.public boolean accept
         * 3.在方法参数和方法体之间添加“->”
         */
        FileFilter f2 = (File pathname) -> {
            return pathname.getName().contains("o");
        };
        //3.使用lambda表达式忽略参数类型
        FileFilter f3 = (pathname) -> {
            return pathname.getName().contains("o");
        };
        //4.如果要重写的方法中只有一个形参时，name参数的"()"也可以省略
        FileFilter f4 = pathname -> {
            return pathname.getName().contains("o");
        };
        //5.如果方法体中只有一句代码，那么可以将方法体的"{}"省略，如果代码包含return，return也需要一同省略
        FileFilter f5 = pathname -> pathname.getName().contains("o");

        File dir = new File(".");
        File[] subs = dir.listFiles(file -> file.getName().contains("o"));
        for (int i = 0; i < subs.length; i++) {
            System.out.println(subs[i].getName());
        }
```

# 节点流

可以从一个固定的地方读取或创建

## FileInputStream

**从指定文件中读取**

```java
		//创建文件字节输入流并绑定
        FileInputStream fis = new FileInputStream("./demo/fos.txt");
        //读取一个字节
        /**
         * int read()
         * 读取1个子节，并将该子节转换为整数返回，如果读取到了文件的末尾，则返回-1
         * 连续调用read方法时，会连续读取指定文件中的字节数据
         */
        int d = fis.read();
        System.out.println((char)d);
        System.out.println((char) fis.read());
        System.out.println((char) fis.read());
        System.out.println((char) fis.read());
        System.out.println((char) fis.read());
        System.out.println(fis.read());
        System.out.println(fis.read());
```



## FileOutputStream

**从指定文件中输出**

```java
  //一、创建流对象
        //   第一种方式
        // 创建File实例，绑定目标文件
//        File file = new File("./demo/fos.txt");
        // 创建文件字节输出流，并将file传入到该实例中
//        FileOutputStream fos = new FileOutputStream(file);

        //   第二种方式
        // 创建字节流的同时，将目标文件路径传入该实例汇总
//        fos = new FileOutputStream("./demo/fos.txt");

        //   第三种方式
        // 创建文件字节流的同时，将目标文件传入该实例中
        FileOutputStream fos = new FileOutputStream("./demo/fos.txt", true);//追加模式

        //二、通过字节流输出流向指定的文件中输出字节数据
        // 1.输出单字节数据
        /**
         * void write(int b)
         * 参数类型是整数，表示一个字节
         * 该方法每次调用，都会向绑定的文件中写出一个字节的数据
         */
        fos.write(97);//a
        fos.write(98);//b
        fos.write(99);//c
        fos.write(100);//d
        fos.write(13);//回车符（将光标移动到行首\r）
        fos.write(10);//换行符（将光标移到下一行\n）
        /**
         * byte[]  getByte()
         * 将字符串转换为字节数据，储存到字节数组中
         */
        // 2.一次性输出多个字节数据（依赖字节数组）
        fos.write("Hello JSDVN2302!\r\n".getBytes());//getByte()将字符串转成字符数组

        //输出字节流的一部分数据
        //ABCDEFGH\r\n -> FGH\r\n
        /**
         * void write(byte b[], int off, int len)
         * off: 表示要输出的头字节的下标，下标5的位置就是F
         * len: 表示从要输出的头字节之后的几个字节的数据
         */
        fos.write("ABCDEFGH\r\n".getBytes(), 5, 5);
        System.out.println("写出完毕！！！");
        //三、关闭流资源，否则会占用资源
        fos.close();
```

```java
//使用循环，连续读取文件中的字节数据
        int data;
        while ((data = fis.read()) != -1) {
            System.out.print((char) data);
        }
        // 关闭流
        fis.close();

```

## 复制文件操作

```java
		FileInputStream fis = new FileInputStream("./demo/bridge.jpg");
        FileOutputStream fos = new FileOutputStream("./demo/bridge_01.jpg");

        int data;
        long start = System.currentTimeMillis();
        //循环读取目标文件中的字节数据
        while ((data = fis.read()) != -1) {
            //将本次读取的字节数据，写出到复制文件中
            fos.write(data);
        }
        long end = System.currentTimeMillis();
        System.out.println("复制完毕,复制该图片共耗时" + (end - start) + "ms");

        //关闭流
        fis.close();
        fos.close();
```

## 块读复制文件操作（不改变文件大小）

```
		FileInputStream fis = new FileInputStream("./demo/bridge.jpg");
        FileOutputStream fos = new FileOutputStream("./demo/bridge_01.jpg");

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
```

## 实现一个简易的写日志功能（利用FileOutputStream）

```java
		Scanner scanner = new Scanner(System.in);
        System.out.println("请开始输入内容，单独输入exit退出！");

        FileOutputStream fos = new FileOutputStream("./demo/note.txt");
        while (true) {
            //获取在控制台输入的字符串
            String line = scanner.nextLine();
            //判断控制台的字符串是否是exit
            if ("exit".equals(line)) {
                //跳出循环，结束程序
                break;
            } else {
                fos.write(line.getBytes(StandardCharsets.UTF_8));
            }
        }
        fos.close();
```

# 处理流

对一个已存在的流链接和封装，通过所封装的流的功能调用实现数据读写

### 处理流和节点流的特点

- 处理流的构造方法总是要带一个其他的流对象做参数,一个流对象经过其他流的多次包装,成为流的链接.
- 通常节点流也被称之为低级流.处理流也被称之为高级流或者过滤流

# 字符流

字符流是高级流

除了转换字符流以外的字符流,直接和字节流相连时，是会报错的,必须要经由转换字符流连接，才可以让字符流和字节流相连。

## OutputStreamWriter输出转换字符流

```java
//低级的文件字节输出流
        FileOutputStream fos = new FileOutputStream("./demo/osw.txt");
        //高级的字符输出流，需要指定编码
        OutputStreamWriter osw = new OutputStreamWriter(fos, StandardCharsets.UTF_8);
        //利用输出字符流，自动将写出的字符串按照编码写出
        osw.write("鹅鹅鹅");
        osw.write("曲项向刀割");
        osw.write("拔毛烧开水");
        osw.write("铁锅炖大鹅");
        System.out.println("写出完毕！");
        osw.close();//关闭流，刷出缓存区
```



## InputStreamReader输入转换字符流

```java
FileInputStream fis = new FileInputStream("./demo/osw.txt");
        InputStreamReader isr = new InputStreamReader(fis, StandardCharsets.UTF_8);
        int d;
        //使用字符流读取内容时，是一个字符一个字符读取，比如一次性可以将“鹅”这个字符读进来
        //在UTF-8中，一个中文由三个字节组成
        while ((d = isr.read()) != -1) {
            System.out.print((char) d);
        }
        isr.close();
```

