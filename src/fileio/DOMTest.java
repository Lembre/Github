package fileio;

import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class DOMTest {
    public static void main(String[] args) {
        DocumentBuilderFactory dbf= DocumentBuilderFactory.newInstance();
        try {
            //创建DocumentBuilder对象
            DocumentBuilder db= dbf.newDocumentBuilder();
            //调用方法parse将加载books.xml到当前项目下
            Document document=db.parse("books.xml" );
            //获取所有book节点的集合
            NodeList bookList = document.getElementsByTagName("book" );
            //获取bookList的长度
            System.out.println("一共有"+ bookList.getLength()+"本书" );
            //遍历每一个book节点
            for (int i = 0; i <bookList.getLength() ; i++) {
                System.out.println("下面开始遍历" +(i+1)+"节点的属性值" );
                //获取一个节点
                Node book= bookList.item(i);
                //遍历book属性
                NamedNodeMap arrs= book.getAttributes();
                System.out.println("第"+(i+1)+"本书公有"+arrs.getLength()+"个属性。"   );
                for (int j= 0;j<arrs.getLength();j++){

                    //获取节点的某个属性
                    Node attr= arrs.item(j);
                    //获取属性名
                    System.out.println("属性名" +attr.getNodeName());
                    //获取属性值
                    System.out.println("属性值" +attr.getNodeValue());
                }
                //解析book节点的子节点
                NodeList childNodes= book.getChildNodes();
                //遍历childNode获取每个子节点的节点名和节点值
                for(int k= 0;k<childNodes.getLength();k++){
                    //区分出text类型的node和element类型的node
                    if(childNodes.item(k).getNodeType()==Node.ELEMENT_NODE ){
                        //获取了Element类型的node
                        System.out.println(childNodes.item(k).getNodeName());
                        //获取了该node下的子node的节点值
                        System.out.println(childNodes.item(k).getFirstChild().getNodeValue());
                    }
                }
                System.out.println("结束第"+(i+1)+"个节点的遍历  " );
            }


        }catch(ParserConfigurationException e){
            e.printStackTrace();
        }catch (SAXException e){
            e.printStackTrace();
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
