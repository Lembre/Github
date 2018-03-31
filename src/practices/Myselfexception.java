package practices;

public class Myselfexception extends Exception{
    public Myselfexception(){

    }
    public Myselfexception(String message){//为自定义异常添加带有一个字符串类型的构造器
        super(message);
    }
}
