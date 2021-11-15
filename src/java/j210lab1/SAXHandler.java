/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package j210lab1;

import java.util.ArrayList;
import java.util.List;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;



/**
 *
 * @author User
 */
public class SAXHandler extends DefaultHandler{
    
    

public static String currentTag = "";

    private static final String TAG_USER = "user";
    private static final String TAG_FIRST_NAME = "first-name";
    private static final String TAG_FAMILY = "family";
    //private static final String DEPARTMENT = "department";//department

    private int id;
    private String role;
    private String department;
    private String firstName;
    private String family;

    private boolean isUser = false;
    private boolean isFirstName = false;
    private boolean isFamily = false;
    //private boolean isDepartment = false;

    //private User user = new User();
    private List<User> userList = new ArrayList<>();

    public List<User> getUserList() {
        return userList;
    }

    @Override
    public void startDocument() throws SAXException {
        System.out.println("Начало разбора");
    }

    @Override
    public void endDocument() throws SAXException {
        System.out.println("Конец разбора");
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        int numAttr = attributes.getLength();
        //if (qName.equals(TAG_USER)) {
        //isUser = true;

        //System.out.print(numAttr);
        for (int i = 0; i < numAttr; i++) {
            //System.out.println(attributes.getQName(i) + "=" + attributes.getValue(i));
            if (attributes.getQName(i).equals("id")) {
                try {
                    id = Integer.parseInt(attributes.getValue(i));
                } catch (NumberFormatException ex) {
                    //System.out.println("id not a number " + ex.getMessage());
                }

            } else if (attributes.getQName(i).equals("role")) {
                role = attributes.getValue(i);
            } else {

                department = attributes.getValue(i);

            }

        }
        currentTag = qName;
        //System.out.println(" ID " + id + " ROLE " + role + " DEPARTMENT " + department);

        switch (currentTag) {
            case TAG_USER:
                isUser = true;
                //System.out.println("########User = true");
                break;
            case TAG_FIRST_NAME:
                isFirstName = true;
                //System.out.println("########FirstName = true");
                break;
            case TAG_FAMILY:
                isFamily = true;
                //System.out.println("########Family = true");
                break;
        }
        //}

    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        currentTag = qName;
//        if (isUser) {
//            isDepartment = false;
//            currentTag = "first-name";
//
//            isFirstName = true;
//            
//        }
//        if(currentTag.equals(TAG_FIRST_NAME)){
//            isFirstName = false;
//            currentTag = "family";
//            isFamily = true;
//        }
//            
//            
//        if(currentTag.equals(TAG_FAMILY)){
//            isFamily = false;
//            currentTag = "department";
//            isDepartment = true;
//            
//            isUser = false;
//        }

        switch (currentTag) {
            case TAG_USER:
                User user = new User(id, role, firstName, family, department);
//                user.setId(id);
//                user.setRole(role);
//                user.setFirstNmae(firstName);
//                user.setFamily(family);
//                user.setDepartment(department);

                userList.add(user);

                isUser = false;
                //System.out.println("isUser = false");
                break;
            case TAG_FIRST_NAME:
                isFirstName = false;
                //System.out.println("isFirstName = false");
                break;
            case TAG_FAMILY:
                isFamily = false;
                //System.out.println("isFamily = false");
                break;
        }

    }

    @Override
    public void characters(char[] chars, int i, int i1) throws SAXException {
        if (isFirstName) {
            System.out.println(" FirstName " + (firstName = new String(chars, i, i1)));
            isFirstName = false;
        }

        if (isFamily) {
            System.out.println(" isFamily " + (family = new String(chars, i, i1)));
            isFamily = false;
        }
    }
    
}
