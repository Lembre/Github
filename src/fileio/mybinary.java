package fileio;

public class mybinary {
    //转化int为byte
    public static byte[] int2Bytes(int id){
        byte[] arr= new byte[4];
        /*arr[0]= (byte)((int)(id>>0*8)&0xff);
        arr[1]= (byte)((int)(id>>1*8)&0xff);
        arr[2]= (byte)((int)(id>>2*8)&0xff);
        arr[3]= (byte)((int)(id>>3*8)&0xff);*/
        for (int i = 0; i <arr.length ; i++) {
            arr[i]= (byte)((int)(id>>i*8)&0xff);
        }
        return arr;
    }
    //转化byte为int
    public static int bytes2int(byte[] arr){
        /*int rs0= (int)((arr[0]&0xff)<<0*8);
        int rs1= (int)((arr[1]&0xff)<<1*8);
        int rs2= (int)((arr[2]&0xff)<<2*8);
        int rs3= (int)((arr[3]&0xff)<<3*8);
        return rs0+rs1+rs2+rs3;*/
        int result= 0;
        for (int i = 0; i <arr.length ; i++) {
            result+=(int)((arr[i]&0xff)<<i*8);
        }
        return result;
    }
    public static void main(String[] args) throws Exception{
        int A= 1;
        int B= 2;
        int C= 3;
        /*int temp;
        temp= A;
        A= B;
        B= temp;*/
        //利用加减法实现交换
        /*A= A+B;
        B= A-B;
        A= A-B;*/
        //利用异或运算符实现
        A= A^B;
        B= A^B;
        A= A^B;
        int d= 2<<1;//左移运算，左边的二进制丢弃，他右边的补0。10->100即为4
        System.out.println("A:"+A+" B:"+B +" C:"+C );
        System.out.println(d);
        //十进制转化为其他进制
        System.out.println(Integer.toBinaryString(112));
        System.out.println(Integer.toHexString(112));
        System.out.println(Integer.toOctalString(112));
        //其他进制转化为十进制
        System.out.println(Integer.parseInt("101011" ,2));
        System.out.println(Integer.parseInt("27",8 ));
        System.out.println(Integer.parseInt("A3" ,16));

        byte[] arr= mybinary.int2Bytes(8143);
        System.out.println(arr[0]+" "+arr[1]+" "+arr[2]+" "+arr[3]);
        System.out.println(mybinary.bytes2int(arr));
        //字符串与字节数组
        String str = "慕课ABC" ;
        byte[] bt= str.getBytes( "GBK" );//在系统默认UTF-8编码中，中文占用三个字节.而GBK占用两个字节
        String st= new String (str);//注意要修改默认编码方式时要throws
        System.out.println(str);
        for (int i = 0; i <bt.length ; i++) {
            System.out.print(bt[i]+" " );
        }
        System.out.println();
        for(byte b:bt){
            System.out.print(Integer.toHexString(b&0xff)+" " );
        }//当你的字节序列化某种编码时，若之后再将它输出为字符串则也要用这种编码，否则会出现乱码
        String str1= new String(bt,"GBK" );//不加GBK会导致乱码
        System.out.println();
        System.out.println(str1);
    }//文本文件就是字节序列，可以是任意编码序列，记事本可以认识任意编码的文件，但是已经被读成XX编码的文件必须以XX编码打开才不会乱码
}
