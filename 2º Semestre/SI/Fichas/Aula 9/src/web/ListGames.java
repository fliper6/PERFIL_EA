/*
 * ListGames
 * ruicouto in 10/abr/2017
 */
package web;

import business.GMSFacade;
import business.Game;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ruicouto
 */
@WebServlet(name = "ListGames", urlPatterns = {"/ListGames"})
public class ListGames extends HttpServlet {

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

        System.out.println("Testing...");

        List<Game> list;

        String p = request.getParameter("page");
        if (p == null) {
            request.setAttribute("nrP", 0);
            list = GMSFacade.listGames(0);
        }
        else {
            int pag = Integer.parseInt(p);
            request.setAttribute("nrP", pag);
            list = GMSFacade.listGames(pag);
        }

        System.out.println(list.toString());
        request.setAttribute("games", list);
        request.setAttribute("username", "Filipa Santos");
        request.setAttribute("page", "pageGames");
        request.setAttribute("maxP", 3);


        getServletConfig().getServletContext()
                .getRequestDispatcher("/WEB-INF/Template.jsp").forward(request,response);
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
