/**
 *
 * Descrição:Servlet PerfilController
 *
 *
 * @author Fabricio Nogueira
 *
 * @since 19-Apr-2013
 *
 * @version 1.0.0
 *
 */

package br.com.jspproject.pessoa;


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

@WebServlet(name="PerfilController", urlPatterns={"/pessoa/PerfilController"})
public class PerfilController extends HttpServlet {
    private PerfilDAO perfilData = new PerfilDAO();
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
            String action = request.getParameter("action");
            try {
                if (action.equals("cadastrar")) {
                    /*
                     * Cadastrar
                     */
                    try {
                        String sCodigoPerfil = request.getParameter("codigoPerfil");
                        String nome = request.getParameter("nome");
                        String descricao = request.getParameter("descricao");

                        Integer codigoPerfil = Integer.parseInt(sCodigoPerfil);

                        Perfil perfil = new Perfil();
                        perfil.setCodigoPerfil(codigoPerfil);
                        perfil.setNome(nome);
                        perfil.setDescricao(descricao);

                        PerfilDAO perfilDAO = new PerfilDAO();

                        String cadastrar = perfilDAO.cadastrar(perfil);
                        if (cadastrar.equals("sucesso")) {
                            StringBuilder str = new StringBuilder();
                            str.append("<div class=\"alert alert-success\">");
                            str.append("<button type=\"button\" class=\"close\" data-dismiss=\"alert\">×</button>");
                            str.append("<strong>Sucesso!</strong> Perfil cadastrada com sucesso.");
                            str.append("</div>");
                            /*
                             * mensagem e redirecionamento de sucesso
                             */
                            out.printf(str.toString());
                            rd = request.getRequestDispatcher("/pessoa/perfil.jsp");
                            rd.include(request, response);
                        } else {
                            /*
                             * mensagem e redirecionamento de erro
                             */
                            out.printf(cadastrar);
                            rd = request.getRequestDispatcher("/erros.jsp");
                            rd.include(request, response);
                        }
                    } catch (NumberFormatException e) {
                        StringBuilder str = new StringBuilder();
                        str.append("<div class=\"alert alert-error\">");
                        str.append("<button type=\"button\" class=\"close\" data-dismiss=\"alert\">×</button>");
                        str.append("<strong>ERRO! </strong>");
                        str.append(e.toString());
                        str.append("</div>");
                        out.printf(str.toString());
                        rd = request.getRequestDispatcher("/erros.jsp");
                        rd.include(request, response);
                    }
                } else if (action.equals("editar")) {
                    /*
                     * Editar
                     */
                    try {
                        
                        String sCodigoPerfil = request.getParameter("codigoPerfil");

                        Integer codigoPerfil = Integer.parseInt(sCodigoPerfil);
                        String nome = request.getParameter("nome");
                        String descricao = request.getParameter("descricao");

                        Perfil perfil = new Perfil();
                        perfil.setCodigoPerfil(codigoPerfil);
                        perfil.setNome(nome);
                        perfil.setDescricao(descricao);
                        
                        PerfilDAO perfilDAO = new PerfilDAO();

                        String editar = perfilDAO.editar(perfil);
                        if (editar.equals("sucesso")) {
                            StringBuilder str = new StringBuilder();
                            str.append("<div class=\"alert alert-success\">");
                            str.append("<button type=\"button\" class=\"close\" data-dismiss=\"alert\">×</button>");
                            str.append("<strong>Sucesso!</strong> Perfil editado com sucesso.");
                            str.append("</div>");
                            /*
                             * mensagem e redirecionamento de sucesso
                             */
                            out.printf(str.toString());
                            rd = request.getRequestDispatcher("/pessoa/perfil.jsp");
                            rd.include(request, response);
                        } else {
                            /*
                             * mensagem e redirecionamento de erro
                             */
                            out.printf(editar);
                            rd = request.getRequestDispatcher("/erros.jsp");
                            rd.include(request, response);
                        }
                    } catch (NumberFormatException e) {
                        StringBuilder str = new StringBuilder();
                        str.append("<div class=\"alert alert-error\">");
                        str.append("<button type=\"button\" class=\"close\" data-dismiss=\"alert\">×</button>");
                        str.append("<strong>ERRO! </strong>");
                        str.append(e.toString());
                        str.append("</div>");
                        out.printf(str.toString());
                        rd = request.getRequestDispatcher("/erros.jsp");
                        rd.include(request, response);
                    }
                } else if (action.equals("excluir")) {
                    /*
                     * Excluir
                     */
                    String sCodigoPerfil = request.getParameter("codigoPerfil");
                    Integer codigoPerfil = Integer.parseInt(sCodigoPerfil);
                    
                    Perfil perfil = new Perfil();
                    
                    perfil.setCodigoPerfil(codigoPerfil);
                    
                    PerfilDAO perfilDAO = new PerfilDAO();
                    
                    String excluir = perfilDAO.excluir(perfil);
                    
                    if (excluir.equals("sucesso")) {
                        StringBuilder str = new StringBuilder();
                        str.append("<div class=\"alert alert-success\">");
                        str.append("<button type=\"button\" class=\"close\" data-dismiss=\"alert\">×</button>");
                        str.append("<strong>Sucesso!</strong> Perfil excluido com sucesso.");
                        str.append("</div>");
                        /*
                         * mensagem e redirecionamento de sucesso
                         */
                        out.printf(str.toString());
                        rd = request.getRequestDispatcher("/pessoa/perfil.jsp");
                        rd.include(request, response);
                    } else {
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
                } else if (action.equals("cancelar")) {
                    /*
                     * Cancelamento de ação
                     */
                    rd = request.getRequestDispatcher("/pessoa/perfil.jsp");
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
    public List<Perfil> listar() {
        PrintWriter out = null;
        List<Perfil> listaDePefis = null;
        try {
            listaDePefis = this.perfilData.listar();
        } catch (SQLException ex) {
            out.println(ex.getSQLState());
        }
        if (listaDePefis.isEmpty()) {
            return null;
        } else {
            return listaDePefis;
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
