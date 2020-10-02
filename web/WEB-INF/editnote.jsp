<%-- 
    Document   : editnote
    Created on : 30-Sep-2020, 5:50:42 PM
    Author     : Cashton
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Edit Note</title>
    </head>
    <body>
        <h1>Simple Note Keeper</h1>
        <form method="post" action="note">
            <table border="0" cellspacing="5">
                <tbody>
                    <tr>
                        <td>
                            Title: <input type="text" name="title" value="${title}" />
                        </td>
                    </tr>
                    <tr>
                        <td>
                            Contents:
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <textarea rows="5" name="content" value="${content}">${content}</textarea>
                        </td>
                    </tr>
                </tbody>
            </table>
            <input type="submit" value="save" name="save"/>
        </form>
        
    </body>
</html>
