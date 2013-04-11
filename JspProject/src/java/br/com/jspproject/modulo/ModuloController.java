/**
 *
 * Descrição:Servlet ModuloServlet
 *
 *
 * @author Fabricio Nogueira
 *
 * @since 11-Apr-2013
 *
 * @version 1.0.0
 *
 */

package br.com.jspproject.modulo;


import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name="ModuloServlet", urlPatterns={"/modulo/ModuloServlet"})
public class ModuloController extends HttpServlet {
   
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        RequestDispatcher rd = null;
        try {
            
            String action  = request.getParameter("action");
            String sCodigoModulo = request.getParameter("codigoModulo");
            String nome = request.getParameter("nome");
            String descricao = request.getParameter("descricao");
            String sOrdem = request.getParameter("ordem");
            
            Integer codigoModulo = Integer.parseInt(sCodigoModulo);
            Integer ordem = Integer.parseInt(sOrdem);
            
            Modulo modulo = new Modulo();
            modulo.setCodigoModulo(codigoModulo);
            modulo.setNome(nome);
            modulo.setDescricao(descricao);
            modulo.setOrdem(ordem);
            
            try {
                ModuloDAO modulodao = new ModuloDAO();
                if (action.equals("salvar")) {
                    String cadastrar = modulodao.cadastrar(modulo);
                    if(cadastrar.equals("sucesso")){
                        out.printf("<div class=\"alert alert-success\">\n" +
"              <button type=\"button\" class=\"close\" data-dismiss=\"alert\">×</button>\n" +
"              <strong>Well done!</strong> You successfully read this important alert message.\n" +
"            </div>");
                        rd = request.getRequestDispatcher("/modulo/modulo.jsp");
                    }else{
                        rd = request.getRequestDispatcher("/view/erros.jsp");
                    }
                }else if (action.equals("editar")) {
                    String editar = modulodao.editar(modulo);
                    if(editar.equals("sucesso")){
                        rd = request.getRequestDispatcher("/modulo/modulo.jsp");
                    }else{
                        rd = request.getRequestDispatcher("/view/erros.jsp");
                    }
                }else if (action.equals("excluir")) {
                    String excluir = modulodao.excluir(modulo);
                    if(excluir.equals("sucesso")){
                        rd = request.getRequestDispatcher("/modulo/modulo.jsp");
                    }else{
                        rd = request.getRequestDispatcher("/view/erros.jsp");
                    }
                }else if(action.equals("cancelar")){
                    rd = request.getRequestDispatcher("/modulo/modulo.jsp");
                }
            } catch (SQLException ex) {
                out.printf(ex.getMessage());
            }
            rd.include(request, response);
        } finally { 
            out.close();
        }
    } 

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
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
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
