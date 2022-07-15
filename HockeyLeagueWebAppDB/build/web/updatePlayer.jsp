<%-- 
    Document   : updatePlayer
    Created on : Mar. 29, 2021, 6:02:30 p.m.
    Author     : 16476
--%>

<%@page import="beans.Player"%>
<%@page import="data.PlayerDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Update Player</h1>
        <%
            Player player = new Player();
        %>
        <form action="HockeyLeagueServletDB" method="GET">
            <input type="hidden" name="ID" value="<%=player.getID()%>">
            <br>Name: <input type="text" name="name" value="<%=player.getName()%>">
            <br>Address: <input type="text" name="adress" value="<%=player.getAddress()%>">
            <br>Team ID: <input type="text" name="district" value="<%=player.getTeamID()%>">
            <br>Role: <input type="text" name="role" value="<%=player.getRole()%>">
            <br>Active: <input type="text" name="active" value="<%=player.getActive()%>">

            <br><input type="submit" value="Update" name="action">            
        </form>
    </body>
</html>
