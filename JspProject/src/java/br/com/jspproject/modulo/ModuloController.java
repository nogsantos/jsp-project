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
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name="ModuloServlet", urlPatterns={"/modulo/ModuloServlet"})
public class ModuloController extends HttpServlet {
    private ModuloDAO moduloData = new ModuloDAO();
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
            try {
                if (action.equals("cadastrar")) {
                    /*
                     * Cadastrar
                     */
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

                    ModuloDAO modulodao = new ModuloDAO();
                    
                    String cadastrar = modulodao.cadastrar(modulo);
                    if(cadastrar.equals("sucesso")){
                        StringBuilder str = new StringBuilder();
                        str.append("<div class=\"alert alert-success\">");
                        str.append("<button type=\"button\" class=\"close\" data-dismiss=\"alert\">×</button>");
                        str.append("<strong>Sucesso!</strong> Modulo cadastrado com sucesso.");
                        str.append("</div>");
                        /*
                         * mensagem e redirecionamento de sucesso
                         */
                        out.printf(str.toString());
                        rd = request.getRequestDispatcher("/modulo/modulo.jsp");
                        rd.include(request, response);
                    }else{
                        /*
                         * mensagem e redirecionamento de erro
                         */
                        out.printf(cadastrar);
                        rd = request.getRequestDispatcher("/erros.jsp");
                        rd.include(request, response);
                    }
                }else if (action.equals("editar")) {
                    /*
                     * Editar
                     */
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

                    ModuloDAO modulodao = new ModuloDAO();
                    String editar = modulodao.editar(modulo);
                    if(editar.equals("sucesso")){
                        StringBuilder str = new StringBuilder();
                        str.append("<div class=\"alert alert-success\">");
                        str.append("<button type=\"button\" class=\"close\" data-dismiss=\"alert\">×</button>");
                        str.append("<strong>Sucesso!</strong> Modulo editado com sucesso.");
                        str.append("</div>");
                        /*
                         * mensagem e redirecionamento de sucesso
                         */
                        out.printf(str.toString());
                        rd = request.getRequestDispatcher("/modulo/modulo.jsp");
                        rd.include(request, response);
                    }else{
                        /*
                         * mensagem e redirecionamento de erro
                         */
                        out.printf(editar);
                        rd = request.getRequestDispatcher("/erros.jsp");
                        rd.include(request, response);
                    }
                }else if (action.equals("excluir")) {
                    /*
                     * Excluir
                     */
                    String sCodigoModulo = request.getParameter("codigoModulo");
                    Integer codigoModulo = Integer.parseInt(sCodigoModulo);
                    Modulo modulo = new Modulo();
                    modulo.setCodigoModulo(codigoModulo);
                    ModuloDAO modulodao = new ModuloDAO();
                    String excluir = modulodao.excluir(modulo);
                    if(excluir.equals("sucesso")){
                        StringBuilder str = new StringBuilder();
                        str.append("<div class=\"alert alert-success\">");
                        str.append("<button type=\"button\" class=\"close\" data-dismiss=\"alert\">×</button>");
                        str.append("<strong>Sucesso!</strong> Modulo excluido com sucesso.");
                        str.append("</div>");
                        /*
                         * mensagem e redirecionamento de sucesso
                         */
                        out.printf(str.toString());
                        rd = request.getRequestDispatcher("/modulo/modulo.jsp");
                        rd.include(request, response);
                    }else{
                        /*
                         * mensagem e redirecionamento de erro
                         */
                        StringBuilder str = new StringBuilder();
                        str.append("<div class=\"alert alert-error\">");
                        str.append("<button type=\"button\" class=\"close\" data-dismiss=\"alert\">×</button>");
                        str.append(excluir);
                        str.append("</div>");
                        out.printf(str.toString());
                        rd = request.getRequestDispatcher("/erros.jsp");
                        rd.include(request, response);
                    }
                }else if(action.equals("cancelar")){
                    /*
                     * Cancelamento de ação
                     */
                    rd = request.getRequestDispatcher("/modulo/modulo.jsp");
                    rd.include(request, response);
                }
            } catch (SQLException ex) {
                out.close();
                out.printf(ex.getMessage());
            } 
        } finally { 
            out.close();
            rd = request.getRequestDispatcher("/erros.jsp");
            rd.include(request, response);
        }
    } 
    /**
     * Serviço para listagem dos dados.
     *
     * @author Fabricio Nogueira
     * @version 1.0.0
     * @since 25-Mar-2013
     * @return void
     *
     */
    public List<Modulo> listar() {
        List<Modulo> listaDeModulos = null;
        try {
            listaDeModulos = this.moduloData.listar();
        } catch (SQLException ex) {
            System.err.println(ex.getSQLState());
        }
        if (listaDeModulos.isEmpty()) {
            return null;
        } else {
            return listaDeModulos;
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
