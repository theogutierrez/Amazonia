/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.DAO;
import model.DAOException;
import model.DataSourceFactory;
import model.commandeClient;

/**
 *
 * @author Benjamin
 */
@WebServlet(name = "panierCommande", urlPatterns = {"/protected/panierCommande"})
public class panierCommandeController extends HttpServlet{
    
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, DAOException {
       
    
        //UTF-8
        request.setCharacterEncoding("UTF-8");
        
        String jspView = "../views/protected/panierCommande.jsp";
        
        String userName = findUserInSession(request);
        DAO dao = new DAO(DataSourceFactory.getDataSource());
        commandeClient result = dao.Commandes(userName);
        
        request.setAttribute("commande", result);
        request.setAttribute("nom", result.numero);
        
        request.getRequestDispatcher(jspView).forward(request, response);
    }
    
    
    
    
    
    
    
    private String findUserInSession(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        return (session == null) ? null : (String) session.getAttribute("userName");
    }
}