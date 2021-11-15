<%-- 
    Document   : index
    Created on : Apr 15, 2021, 6:14:24 PM
    Author     : User
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>J210 XML</title>
    </head>
    <body>
        <h1>DOM & SAX TEST</h1>
        
        <form action="CheckSAX">
            
           <p>Search with SAX: 
               <input type="text" name="field" value="" />
               <input type="submit" value="Search" name="findSAX" />
           </p>
           
           
            
            
            
        </form>
        <form action="CheckDOM">
            
           <p>Search with DOM: 
               <input type="text" name="field" value="" />
               <input type="submit" value="Search" name="findDOM" />
           </p>

        </form>
        <% String result = (String) request.getAttribute("result");
        if(result != null){ %>
        
        <%=result%>
        <% } %>
        
    </body>
</html>
