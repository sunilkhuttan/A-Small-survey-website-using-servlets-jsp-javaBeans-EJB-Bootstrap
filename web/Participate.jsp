<%-- 
    Document   : Participate
    Created on : 16/04/2016, 11:48:11 PM
    Author     : sunil
--%>

<%@page import="java.util.HashMap"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
                <link rel="stylesheet" type="text/css" href="bootstrap.css">
                <link rel="stylesheet" type="text/css" href="style.css">
    </head>
    <body>
        <jsp:useBean id="list" class="beans.ListOfAllSurveys" scope="session" />
        <div class="bodycontainer">
        <table class="table table-striped table-hover table-condensed" id="dataTable">
            <thead>
                <tr>
                    <th>Survey Number</th>
                    <th>Survey Topic</th>
                </tr>
            </thead>
            <tbody>
                <%
                HashMap<Integer, String> map = list.getSurveys();
                for (HashMap.Entry<Integer, String> entry : map.entrySet()) {%>
                  
                                 <tr class="info">
                                <td ><%=entry.getKey()%> </td>
                                <td><%= entry.getValue()%></td>
                               </tr>       

        <%}
        %>
            </tbody>
        </table>
            </div>
    </body>
</html>
