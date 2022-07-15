/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import beans.Player;
import beans.Team;
import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author 16476
 */
public class PlayerDAO {

    DBManager dbm = new DBManager();

    public Player retrievePlayer(int ID) {
        Player player = null;
        try {
            String sql = "SELECT * from hockeyleaguedb.player WHERE PlayerID=" + ID + ";";
            ResultSet rs = dbm.executeQuery(sql);
            if (rs.next()) {
                player = new Player();
                player.setID(rs.getInt("playerID"));
                player.setName(rs.getString("playerName"));
                player.setAddress(rs.getString("playerAddress"));
                player.setTeamID(rs.getInt("teamID"));
                player.setRole(rs.getString("playerRole"));
                player.setActive(rs.getString("playerActiveStatus"));
            }
        } catch (Exception e) {
            System.out.println("error retrieving player " + e);
        }
        return player;
    }

    public ArrayList<Player> retrieveAllPlayers() {
        ArrayList<Player> players = new ArrayList<Player>();
        try {
            String sql = " SELECT * FROM hockeyleaguedb.players;   ";
            ResultSet rs = dbm.executeQuery(sql);
            while (rs.next()) {
                Player player = new Player();
                player.setID(rs.getInt("playerID"));
                player.setName(rs.getString("playerName"));
                player.setAddress(rs.getString("playerAddress"));
                player.setTeamID(rs.getInt("teamID"));
                player.setRole(rs.getString("playerRole"));
                player.setActive(rs.getString("playerActiveStatus"));

                players.add(player);  // you need to add the player to the arraylist.
            }
        } catch (Exception e) {
            System.out.println("error retrieving player " + e);
        }
        return players;
    }

    public ArrayList<Player> retrieveAllPlayersByTeam() {
        ArrayList<Player> players = new ArrayList<Player>();
        try {
            String sql = " SELECT * FROM hockeyleaguedb.players;   ";
            ResultSet rs = dbm.executeQuery(sql);
            while (rs.next()) {
                Player player = new Player();
                if (player.getTeamID() == 1) {
                    player.setID(rs.getInt("playerID"));
                    player.setName(rs.getString("playerName"));
                    player.setAddress(rs.getString("playerAddress"));
                    player.setRole(rs.getString("playerRole"));
                    player.setActive(rs.getString("playerActiveStatus"));

                    players.add(player);  // you need to add the player to the arraylist.
                }
                if (player.getTeamID() == 2) {
                    player.setID(rs.getInt("playerID"));
                    player.setName(rs.getString("playerName"));
                    player.setAddress(rs.getString("playerAddress"));
                    player.setRole(rs.getString("playerRole"));
                    player.setActive(rs.getString("playerActiveStatus"));

                    players.add(player);
                }
            }
        } catch (Exception e) {
            System.out.println("error retrieving player " + e);
        }
        return players;
    }

    public void createPlayer(Player player) {
        String sql = "INSERT INTO hockeyleaguedb.players (PlayerID, playerName, playerAddress, teamID, playerRole, playerActiveStatus) "
                + "VALUES ( '" + player.getID() + "', '" + player.getName() + "'," + player.getAddress() + "'," + player.getTeamID() + "'," + player.getRole() + "'," + " '" + player.getActive() + " );";
        dbm.executeUpdate(sql);
    }

    public void updatePlayer(Player player) {
        String sql = "UPDATE hockeyleaguedb.players"
                + " SET playerName='" + player.getName() + "', playerAddress='" + player.getAddress() + "', "
                + "teamID='" + player.getTeamID() + "', playerRole=" + player.getRole() + "',playerActiveStatus=" + player.getActive() + " "
                + "WHERE PlayerID=" + player.getID() + " ; ";
        dbm.executeUpdate(sql);
    }

    public void deletePlayer(int ID) {
        String sql = "DELETE FROM  hockeyleaguedb.players  WHERE PlayerID=" + ID + ";";
        dbm.executeUpdate(sql);
    }

}
