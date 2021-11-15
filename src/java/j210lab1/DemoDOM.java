/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package j210lab1;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 *
 * @author User
 */
public class DemoDOM {

    public final static String FILE_NAME = "D://stud/sample.xml ";

    public static List<User> parseXMLByDOM() {
        File file = new File(FILE_NAME);
        if (file.exists()) {
            System.out.println("Fail estb");
        } else {
            System.out.println("Faila net");
        }

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder docBuilder = null;
        try {
            docBuilder = factory.newDocumentBuilder();
        } catch (ParserConfigurationException ex) {
            System.out.println("Config error DOM parser " + ex.getMessage());
        }
        Document document = null;//w3.dom
        if (docBuilder != null) {
            try {
                document = docBuilder.parse(file);
            } catch (SAXException ex) {
                System.out.println("DOMException " + ex.getMessage());
            } catch (IOException ex) {
                System.out.println("IODOMException " + ex.getMessage());
            }
        } else {
            System.out.println("DocumentBuilder = " + docBuilder);
            return null;
        }
        System.out.println("DocumentBuilder = " + docBuilder);
        System.out.println("Document created: " + document);

        NodeList nodeList = document.getElementsByTagName("user");
        System.out.println("Node " + nodeList);

        List<User> users = new ArrayList<>();
        for (int i = 0; i < nodeList.getLength(); i++) {
            users.add(getUserFromNode(nodeList.item(i)));
        }

        return users;
    }

    private static User getUserFromNode(Node item) {

        User user = null;
        if (item.getNodeType() == Node.ELEMENT_NODE) {//ybejdaemsia chto eto Element

            Element element = (Element) item;//element - teg sv kotorom mb atrib i soderjimoe
            String firstName = getTagValue(element, "first-name");
            String family = getTagValue(element, "family");
            //System.out.println("firstName = " + firstName + " family = " + family);
            int id = -1;
            try {
                id = Integer.parseInt(element.getAttribute("id"));
            } catch (NumberFormatException ex) {
                System.out.println("id ne celoe chislo " + ex.getMessage());
            }
            
            String role = element.getAttribute("role");
            
            NodeList depList = element.getElementsByTagName("department");
            String department = ((Element)depList.item(0)).getAttribute("title");
            
            
            
            System.out.println("department " + department);
            
            
            user = new User(id, role, firstName, family, department);
            
            
            
            
        }
        return user;
    }

    private static String getTagValue(Element element, String tag) {
        NodeList nodeList = element.getElementsByTagName(tag).item(0).getChildNodes();
        Node node = (Node) nodeList.item(0);
        return node.getNodeValue();
    }
}
