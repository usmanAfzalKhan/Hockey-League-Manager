/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import beans.Team;
import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author 16476
 */
public class TeamDAO {

    DBManager dbm = new DBManager();

    public Team retrieveTeam(int ID) {
        Team team = null;
        try {
            String sql = "SELECT * from hockeyleaguedb.teams WHERE teamID=" + ID + ";";
            ResultSet rs = dbm.executeQuery(sql);
            if (rs.next()) {
                team = new Team();
                team.setID(rs.getInt("teamID"));
                team.setName(rs.getString("teamname"));
            }
        } catch (Exception e) {
            System.out.println("error retrieving team " + e);
        }

        return team;
    }

    public ArrayList<Team> retrieveAllTeams() {
        ArrayList<Team> teams = new ArrayList<Team>();
        try {
            String sql = " SELECT * FROM hockeyleaguedb.teams;   ";
            ResultSet rs = dbm.executeQuery(sql);
            while (rs.next()) {
                Team team = new Team();
                team.setID(rs.getInt("teamID"));
                team.setName(rs.getString("teamName"));
                teams.add(team); 
            }

        } catch (Exception e) {
            System.out.println("error retrieving teams " + e);
        }
        return teams;
    }
    
    public void createTeams(Team team) {
        String sql = "INSERT INTO hockeyleaguedb.teams (teamID,teamName)"
                + "VALUES ( '" + team.getID() + "', '" + team.getName() + " );";
        dbm.executeUpdate(sql);
    }
    public void updateTeams(Team team){
        String sql = "UPDATE hockeyleaguedb.teams "
        + " SET Name='"+team.getName()+"' "
        + "WHERE ID="+team.getID()+" ; ";
        dbm.executeUpdate(sql);
    }
    
        public void deleteTeam(int ID) {
        String sql = "DELETE FROM  hockeyleaguedb.teams  WHERE teamID=" + ID + ";";
        dbm.executeUpdate(sql);
    }

}
