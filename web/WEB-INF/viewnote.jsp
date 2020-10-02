<%-- 
    Document   : viewnote
    Created on : 30-Sep-2020, 5:50:29 PM
    Author     : Cashton
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%--<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>--%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Note Keeper</title>
    </head>
    <body>
        <h1>Simple Note Keeper</h1>
            <table border="0" cellspacing="0">
                <tbody>
                    <tr>
                        <td>
                            <h4>Title: <p>${title}</p>
                            </h4>
                        </td>
                        <td>
                            
                        </td>    
                    </tr>
                    <tr>
                        <td>
                            <h3>Contents: </h3>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            ${content}
                        </td>
                    </tr>
                </tbody>
            </table>      
                        <br>
            <a href="note?edit">Edit</a>
        <!--</form>-->
        
    </body>
</html>
