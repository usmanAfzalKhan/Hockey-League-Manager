<%-- 
    Document   : vBlueTeam
    Created on : Mar. 28, 2021, 8:49:35 p.m.
    Author     : 16476
--%>
<%@page import="data.TeamDAO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="beans.Player"%>
<%@page import="beans.Team"%>
<%@page import="data.PlayerDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            TeamDAO teamDAO = new TeamDAO();
            ArrayList<Team> teams = teamDAO.retrieveAllTeams();
            for (Team t : teams) {
                if ((t.getID() == 1) && t.getName().equals("Red Team")) {
        %>
        <h1>All Players</h1>
        <table>
            <tr><td>Player ID</td>        <Td>Player Name</td>        <td>Player Address</td>        <td>Team ID</td>        <td>Player Role</td>        <td>Player Active Status</td></tr>
                    <%
                        PlayerDAO PlayerDAO = new PlayerDAO();
                        ArrayList<Player> players = PlayerDAO.retrieveAllPlayers();

                        for (Player player : players) {
                    %>
            <tr><td><%=player.getID()%></td>        <td><%=player.getName()%></td>        <td><%=player.getAddress()%></td>         <td><%=t.getName()%></td>        <td><%=player.getRole()%></td>    <td><%=player.getActive()%></td>
                <td>
                    <form action="updatePlayer.jsp" method="GET">
                        <input type="hidden" name="ID" value="<%=player.getID()%>">
                        <input type="submit" name="action" value="Edit">
                    </form>
                </td>
                <td>
                    <form action="HockeyLeagueServletDB" method="GET">
                        <input type="hidden" name="ID" value="<%=player.getID()%>">
                        <input type="submit" name="action" value="Delete">
                    </form>
                </td>
            </tr>
            <%}
        }
    }%>
        </table>

    <td>
        <form action="addPlayer.jsp" method="GET">
            <input type="submit" name="action" value="Add">
        </form>
    </td>
</body>
</html>
