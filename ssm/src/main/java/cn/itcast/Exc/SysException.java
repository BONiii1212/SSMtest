package cn.itcast.Exc;

/**
 * 自定义的异常类
 */
public class SysException extends Exception{
    //存储提示的信息
    private String message;

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public SysException(String message){
        this.message=message;
    }
}