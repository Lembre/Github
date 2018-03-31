package fileio;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.namespace.QName;
import java.util.ArrayList;

public class SAXparseHandle extends DefaultHandler {
    String value= null;
    int bookindex= 0;
    Book book= null;

    private ArrayList<Book> bookList= new ArrayList<>();
    public ArrayList<Book> getBookList() {
        return bookList;
    }
    //用来遍历xml文件的开始标签
    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        super.startElement(uri, localName, qName, attributes);
        //开始解析book元素的属性
        if(qName.equals("book" )){
            bookindex++;
            book= new Book();
            //已知book元素下属性的名称
            /*String value= attributes.getValue("id" );
            System.out.println(value);*/
            //不知道book元素属性的名称
            int num= attributes.getLength();
            for (int i = 0; i <num ; i++) {
                //遍历元素的属性名
                System.out.print("属性名是：" +attributes.getQName(i));
                System.out.println("属性值是:"+attributes.getValue(i) );
                if(attributes.getQName(i).equals("id" )){
                    book.setId(attributes.getValue(i));//成功保存了这个xml文件的id
                }

            }
        } else if(!qName.equals("book")&&!qName.equals("bookstore" )){
            System.out.println("节点名是："+qName );
        }
    }
    //功能是用来遍历xml文件的结束标签
    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        super.endElement(uri, localName, qName);
        //判断一本书是否遍历结束
        if(qName.equals( "book" )){
            bookList.add(book);//保存书
            book= null;//清空书
            System.out.println("该书遍历结束" );
        }else if(qName.equals("name" )){
            book.setName(value);
        }else if(qName.equals("author" )){
            book.setAuthor(value);
        }else if(qName.equals("price" )){
            book.setPrice(value);
        }
        else if(qName.equals("language" )){
            book.setLanguage(value);
        }
    }
    //用来标识解析开始
    @Override
    public void startDocument() throws SAXException {
        super.startDocument();
        System.out.println("SAX解析开始" );
    }
    //用来标识解析结束
    @Override
    public void endDocument() throws SAXException {
        super.endDocument();
        System.out.println("SAX解析结束" );
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        super.characters(ch, start, length);
        value= new String(ch,start,length);
        if (!value.trim().equals("")) {
            System.out.println(value);
        }
    }
}
