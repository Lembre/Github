package fileio;

import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;

public class SAXTest {
    public static void main(String[] args) {
        //获取一个SAXParserFactory实例
        SAXParserFactory factory= SAXParserFactory.newInstance();
        //通过factory获取SAXParser实例
        try {
            SAXParser parser= factory.newSAXParser();
            //需要创建Handle对象
            SAXparseHandle handle=new SAXparseHandle();

            parser.parse("books.xml" ,handle);
            System.out.println("公有" +handle.getBookList().size()+"书" );
            for (Book book:handle.getBookList()){
                System.out.println(book.getId());
                System.out.println(book.getName());
                System.out.println(book.getAuthor());
                System.out.println(book.getLanguage());
                System.out.println(book.getPrice());
                System.out.println(book.getYear());
                System.out.println("********finish*********" );
            }
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }catch (IOException e) {
            e.printStackTrace();
        }

    }
}
