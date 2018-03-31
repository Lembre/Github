package fileio;

import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.IOException;

public class Mydomtest {
    public DocumentBuilder getDocumentBuilder(){
        DocumentBuilderFactory dbf= DocumentBuilderFactory.newInstance();
        DocumentBuilder db = null;
        try {
            db = dbf.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }
        return db;
    }
    public void xmlPaser(){
        try {
            Document document= getDocumentBuilder().parse("books.xml" );
            document.setXmlStandalone(true);
            //获取所有book节点的集合
            NodeList bookList = document.getElementsByTagName("book");
            //获取bookList的长度
            System.out.println("一共有" + bookList.getLength() + "本书");
            //遍历每一个book节点
            for (int i = 0; i < bookList.getLength(); i++) {
                System.out.println("下面开始遍历" + (i + 1) + "节点的属性值");
                //获取一个节点handle.getBookList().size();
                Node book = bookList.item(i);
                //遍历book属性
                NamedNodeMap arrs = book.getAttributes();
                System.out.println("第" + (i + 1) + "本书公有" + arrs.getLength() + "个属性。");
                for (int j = 0; j < arrs.getLength(); j++) {

                    //获取节点的某个属性
                    Node attr = arrs.item(j);
                    //获取属性名
                    System.out.println("属性名" + attr.getNodeName());
                    //获取属性值
                    System.out.println("属性值" + attr.getNodeValue());
                }
                //解析book节点的子节点
                NodeList childNodes = book.getChildNodes();
                //遍历childNode获取每个子节点的节点名和节点值
                for (int k = 0; k < childNodes.getLength(); k++) {
                    //区分出text类型的node和element类型的node
                    if (childNodes.item(k).getNodeType() == Node.ELEMENT_NODE) {
                        //获取了Element类型的node
                        System.out.println(childNodes.item(k).getNodeName());
                        //获取了该node下的子node的节点值
                        System.out.println(childNodes.item(k).getFirstChild().getNodeValue());
                    }
                }
                System.out.println();
                System.out.println("结束第" + (i + 1) + "个节点的遍历  ");
            }

        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void creatXML(){
        DocumentBuilder db= getDocumentBuilder();
        Document document= db.newDocument();
        Element bookstore= document.createElement("bookstore" );
        //向bookstore节点中添加根节点
        Element book= document.createElement("book" );
        Element name= document.createElement("name" );
        name.setTextContent("小王子" );
        book.appendChild(name);
        book.setAttribute("id","1" );
        //将book节点添加到bookstore根节点中
        bookstore.appendChild(book);
        //将bookstore添加到dom树中。
        document.appendChild(bookstore);
        //创建TransformerFactory对象
        TransformerFactory tff=TransformerFactory.newInstance();
        try{
            Transformer tf= tff.newTransformer();
            tf.setOutputProperty(OutputKeys.INDENT,"yes" );
            tf.transform(new DOMSource(document),new StreamResult(new File("books1.xml" )));
        }catch (TransformerConfigurationException e){
            e.printStackTrace();
        }catch (TransformerException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        Mydomtest mytest= new Mydomtest();
        mytest.creatXML();
        //mytest.xmlPaser();

    }
}
