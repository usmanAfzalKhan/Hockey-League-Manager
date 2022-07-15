<%-- 
    Document   : index
    Created on : Mar. 28, 2021, 7:10:46 p.m.
    Author     : 16476
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="beans.*"%>
<%@page import="data.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        
        
        <h1>Hockey League</h1>
        <form action="viewTeams.jsp" method="GET">
        <select name="team">
            
        <%
        TeamDAO teamDAO = new TeamDAO();
         ArrayList<Team> teams = teamDAO.retrieveAllTeams();
        for(Team t: teams){
            out.println("<option value='"+t.getID()+"'>"+t.getName()+"</option>");
        }
        %>
        <br><input type="submit" value ="View">
        </select>
        

        </form>

    </body>
</html>
