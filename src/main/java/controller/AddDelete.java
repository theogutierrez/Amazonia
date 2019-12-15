/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Properties;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.DAO;
import model.DataSourceFactory;

/**
 *
 * @author reguig
 */
@WebServlet(name = "AddDelete", urlPatterns = {"/AddDelete"})
public class AddDelete extends HttpServlet {

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
                response.setContentType("text/html;charset=UTF-8");
                DAO dao = new DAO(DataSourceFactory.getDataSource());
                String AddOrDel=request.getParameter("AddOrDel");
		String prodname = request.getParameter("produit");
                 prodname = (prodname == null) ? "" : prodname;
		String clientname =findUserInSession(request);
                clientname = (clientname == null) ? "" : clientname;
                String libel = request.getParameter("libel");
                libel = (libel == null) ? "" : libel;
                String q = request.getParameter("quant");
                q = (q == null) ? "" : q;
                int quant=Integer.parseInt(q);
                
                String p = request.getParameter("prix");
                p = (p == null) ? "" : p;
                float prix=Float.parseFloat(p);
		String message;
                if (clientname!=null){
		try {
                    switch(AddOrDel){
                        case "Add":
                            dao.AddPanier(prodname, clientname,libel,quant,prix);
                            message = String.format("Le produit %s est ajouté  au Panier", prodname);
                            break;
                        case "Del":
                            dao.delPanier(prodname);
                            message = String.format("Produit %s est suppprimer du panier", prodname);
                        
                        default:
                            message="erreur";
                            
                            
                            
                            
                    }
			
		} catch (NumberFormatException | SQLException ex) {
			response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
			message = ex.getMessage();
		}
                
                }
                
                else{
                    message="erreur";
                }
		
		Properties resultat = new Properties();
             
		resultat.put("message", message);

		try (PrintWriter out = response.getWriter()) {
			// On spécifie que la servlet va générer du JSON
			response.setContentType("application/json;charset=UTF-8");
			// Générer du JSON
			Gson gson = new Gson();
			out.println(gson.toJson(resultat));
		}
    }
    
    private String findUserInSession(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        return (session == null) ? null : (String) session.getAttribute("userName");
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
