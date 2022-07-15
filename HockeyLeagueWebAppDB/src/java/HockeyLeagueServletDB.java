/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import beans.Player;
import data.DBManager;
import data.PlayerDAO;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
import java.sql.Connection;
import java.sql.DriverManager;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import static javax.servlet.jsp.tagext.TagAttributeInfo.ID;

/**
 *
 * @author 16476
 */
@WebServlet(urlPatterns = {"/HockeyLeagueServletDB"})
public class HockeyLeagueServletDB extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    
    String action = request.getParameter("action");
    PlayerDAO playerDAO = new PlayerDAO();

    if (action.equals ("Add")) {
            DBManager dbm = new DBManager();
                    String sql = "SELECT * from hockeyleaguedb.players WHERE PlayerID=" + ID + ";";
        String name = request.getParameter("name");
        String address = request.getParameter("address");
        String teamID = request.getParameter("teamID");
        String role = request.getParameter("role");
        String active = request.getParameter("active");
        sql = "UPDATE hockeyleaguedb.players"
                + " SET playerName='" + name + "', playerAddress='" + address + "', "
                + "teamID='" + teamID + "', playerRole=" + role + "',playerActiveStatus=" + active + " "
                + "WHERE PlayerID=" + ID + " ; ";
        dbm.executeUpdate(sql);
        response.sendRedirect("viewTeams.jsp");
    }
        try {
            Connection con = getConnection();

        } catch (Exception e) {
            System.out.println("Error Adding Player" + e);
        }


    if (action.equals ( 
        "Delete")) {
            int ID = Integer.parseInt(request.getParameter("ID"));
        playerDAO.deletePlayer(ID);
        response.sendRedirect("viewTeams.jsp");
    }

    if (action.equals ( 
        "Update")) {
            Player player = new Player();
        player.setID(Integer.parseInt(request.getParameter("ID")));
        player.setName(request.getParameter("name"));
        player.setAddress(request.getParameter("address"));
        player.setRole(request.getParameter("role"));
        player.setActive(request.getParameter("active"));
        playerDAO.updatePlayer(player);
        response.sendRedirect("viewTeams.jsp");

    }

}
                

    public Connection getConnection() {
        Connection con = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/hockeyleaguedb", "root", "pass"
            );
        } catch (Exception e) {
            System.out.println("Error Adding Item: " + e);
        }
        return con;
    }

// <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
/**
 * Handles the HTTP <code>GET</code> method.
 *
 * @param request servlet request
 * @param response servlet response
 * @throws ServletException if a servlet-specific error occurs
 * @throws IOException if an I/O error occurs
 */
@Override
        protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
        protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
        public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
