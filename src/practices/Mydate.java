package practices;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Mydate {
    public static void main(String[] args) {
        Date d= new Date();//使用默认构造方法创建出的对象代表当前时间。
        System.out.println(d);
        SimpleDateFormat sdf= new SimpleDateFormat("yyyy年MM月dd日 HH时mm分ss秒");
        String str= sdf.format(d);
        System.out.println(str);
        System.out.println("***********************" );
        String str1= "2018年03月21日 19时02分05秒" ;
        SimpleDateFormat sdf1= new SimpleDateFormat("yyyy年MM月dd日 HH时mm分ss秒");
        try{
        Date d2= sdf1.parse(str1);//调用 SimpleDateFormat 对象的 parse() 方法时可能会出现转换异常，
            // 即 ParseException ，因此需要进行异常处理
            System.out.println(d2);
        }catch(ParseException e){
            e.getErrorOffset();
    }
        System.out.println("***********" );
        Calendar c = Calendar.getInstance();

        // 将Calendar对象转换为Date对象
        Date date = c.getTime();

        // 创建SimpleDateFormat对象，指定目标格式
        SimpleDateFormat sdf3 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        // 将日期转换为指定格式的字符串
        String now = sdf3.format(date);
        System.out.println("当前时间：" + now);

}
}