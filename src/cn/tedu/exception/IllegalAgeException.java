package cn.tedu.exception;

/**
 * 自定义异常：非法的年龄异常
 * 自定义异常步骤：
 * 1.类要见名知意（一般是XxxxxException的格式，要求可以直观的表明异常的类型）
 * 2.需要该类直接或间接继承Exception类（表明当前类是异常子类）
 * 3.提供父类中的所有构造器
 */
public class IllegalAgeException extends Exception {
    public IllegalAgeException() {
    }

    public IllegalAgeException(String message) {
        super(message);
    }

    public IllegalAgeException(String message, Throwable cause) {
        super(message, cause);
    }

    public IllegalAgeException(Throwable cause) {
        super(cause);
    }

    public IllegalAgeException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
