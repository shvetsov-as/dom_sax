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
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.SAXException;

/**
 *
 * @author User
 */
public class DemoSAX {

    public final static String FILE_NAME = "D://stud/sample.xml ";
    private static List<User> userList = new ArrayList<>();
    
    public static List<User> getUserList() {
        return userList;
    }

    public static void parseXMLBySAX() {
        File file = new File(FILE_NAME);
        if (file.exists()) {
            System.out.println("Fail estb");
            
        } else {
            System.out.println("Faila net");
        }

        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = null;
        try {

            parser = factory.newSAXParser();
            SAXHandler handler = new SAXHandler();

            parser.parse(file, handler);
            userList = handler.getUserList();
            

        } catch (ParserConfigurationException ex) {
            System.out.println("Config error " + ex.getMessage());
        } catch (SAXException ex) {
            System.out.println("SAXException " + ex.getMessage());
        } catch (IOException ex) {
            System.out.println("IOException " + ex.getMessage());
        }
        
    }
    
}
