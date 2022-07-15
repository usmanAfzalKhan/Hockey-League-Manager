<%-- 
    Document   : addPlayer
    Created on : Mar. 30, 2021, 11:49:45 p.m.
    Author     : 16476
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="data.PlayerDAO"%>
<%@page import="beans.Player"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="HockeyLeagueServletDB" method="GET">
            <br>Name: <input type="text" name="name" >
            <br>Address: <input type="text" name="address">
            <br>Team ID:  <input type="text" name="teamID">
            <br>Role: <input type="text" name="role" >
            <br>Active: <input type="text" name="active">

            <br><input type="submit" name="action" value="Add" >            
        </form>
    </body>
</html>
