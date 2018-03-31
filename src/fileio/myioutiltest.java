package fileio;

import java.io.IOException;

public class myioutiltest {
    public static void main(String[] args) {
       /* try{
            myioutils.printHex("F:\\JavaProject\\myGithub\\src\\fileio\\Myfile.java" );
        }catch(IOException e){
            e.printStackTrace();
        }*/
       try{
           myioutils.printHexByByteArrays("F:\\JavaProject\\myGithub\\src\\fileio\\Myfile.java" );
       }catch (IOException e){
           e.printStackTrace();
       }
    }
}
