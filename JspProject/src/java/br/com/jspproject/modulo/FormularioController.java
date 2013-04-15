/**
 *
 * Descrição:Servlet FormularioController
 *
 *
 * @author Fabricio Nogueira
 *
 * @since 15-Apr-2013
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

@WebServlet(name="FormularioController", urlPatterns={"/modulo/FormularioController"})
public class FormularioController extends HttpServlet {
    private FormularioDAO formularioData = new FormularioDAO();
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
                    String sCodigoFormulario = request.getParameter("codigoFormulario");
                    String sCodigoModulo = request.getParameter("codigoModulo");
                    String nome = request.getParameter("nome");
                    String nomeMenu = request.getParameter("nomeMenu");
                    String descricao = request.getParameter("descricao");
                    String sOrdem = request.getParameter("ordem");
                    String flagOculto = request.getParameter("flagOculto");

                    Integer codigoFormulario = Integer.parseInt(sCodigoFormulario);
                    Integer codigoModulo = Integer.parseInt(sCodigoModulo);
                    Integer ordem = Integer.parseInt(sOrdem);

                    Formulario formulario = new Formulario();
                    formulario.setCodigoFormulario(codigoFormulario);
                    formulario.setCodigoModulo(codigoModulo);
                    formulario.setNome(nome);
                    formulario.setNomeMenu(nomeMenu);
                    formulario.setDescricao(descricao);
                    formulario.setOrdem(ordem);
                    formulario.setFlagOculto(flagOculto);

                    FormularioDAO formularioDAO = new FormularioDAO();

                    String cadastrar = formularioDAO.cadastrar(formulario);
                    if (cadastrar.equals("sucesso")) {
                        StringBuilder str = new StringBuilder();
                        str.append("<div class=\"alert alert-success\">");
                        str.append("<button type=\"button\" class=\"close\" data-dismiss=\"alert\">×</button>");
                        str.append("<strong>Sucesso!</strong> Formulário cadastrado com sucesso.");
                        str.append("</div>");
                        /*
                         * mensagem e redirecionamento de sucesso
                         */
                        out.printf(str.toString());
                        rd = request.getRequestDispatcher("/modulo/formulario.jsp");
                        rd.include(request, response);
                    } else {
                        /*
                         * mensagem e redirecionamento de erro
                         */
                        out.printf(cadastrar);
                        rd = request.getRequestDispatcher("/erros.jsp");
                        rd.include(request, response);
                    }
                } else if (action.equals("editar")) {
                    /*
                     * Editar
                     */
                    String sCodigoFormulario = request.getParameter("codigoFormulario");
                    String sCodigoModulo = request.getParameter("codigoModulo");
                    String nome = request.getParameter("nome");
                    String nomeMenu = request.getParameter("nomeMenu");
                    String descricao = request.getParameter("descricao");
                    String sOrdem = request.getParameter("ordem");
                    String flagOculto = request.getParameter("flagOculto");

                    Integer codigoFormulario = Integer.parseInt(sCodigoFormulario);
                    Integer codigoModulo = Integer.parseInt(sCodigoModulo);
                    Integer ordem = Integer.parseInt(sOrdem);

                    Formulario formulario = new Formulario();
                    formulario.setCodigoFormulario(codigoFormulario);
                    formulario.setCodigoModulo(codigoModulo);
                    formulario.setNome(nome);
                    formulario.setNomeMenu(nomeMenu);
                    formulario.setDescricao(descricao);
                    formulario.setOrdem(ordem);
                    formulario.setFlagOculto(flagOculto);

                    FormularioDAO formularioDAO = new FormularioDAO();
                            
                    String editar = formularioDAO.editar(formulario);
                    if (editar.equals("sucesso")) {
                        StringBuilder str = new StringBuilder();
                        str.append("<div class=\"alert alert-success\">");
                        str.append("<button type=\"button\" class=\"close\" data-dismiss=\"alert\">×</button>");
                        str.append("<strong>Sucesso!</strong> Formulario editado com sucesso.");
                        str.append("</div>");
                        /*
                         * mensagem e redirecionamento de sucesso
                         */
                        out.printf(str.toString());
                        rd = request.getRequestDispatcher("/modulo/formulario.jsp");
                        rd.include(request, response);
                    } else {
                        /*
                         * mensagem e redirecionamento de erro
                         */
                        out.printf(editar);
                        rd = request.getRequestDispatcher("/erros.jsp");
                        rd.include(request, response);
                    }
                } else if (action.equals("excluir")) {
                    /*
                     * Excluir
                     */
                    String sCodigoFormulario = request.getParameter("codigoFormulario");
                    Integer codigoFormulario = Integer.parseInt(sCodigoFormulario);
                    Formulario formulario = new Formulario();
                    formulario.setCodigoFormulario(codigoFormulario);
                    FormularioDAO formularioDAO = new FormularioDAO();
                    String excluir = formularioDAO.excluir(formulario);
                    if (excluir.equals("sucesso")) {
                        StringBuilder str = new StringBuilder();
                        str.append("<div class=\"alert alert-success\">");
                        str.append("<button type=\"button\" class=\"close\" data-dismiss=\"alert\">×</button>");
                        str.append("<strong>Sucesso!</strong> Formulário excluido com sucesso.");
                        str.append("</div>");
                        /*
                         * mensagem e redirecionamento de sucesso
                         */
                        out.printf(str.toString());
                        rd = request.getRequestDispatcher("/modulo/formulario.jsp");
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
                    rd = request.getRequestDispatcher("/modulo/formulario.jsp");
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
    public List<Formulario> listar() {
        List<Formulario> listaDeFormularios = null;
        try {
            listaDeFormularios = this.formularioData.listar();
        } catch (SQLException ex) {
            System.err.println(ex.getSQLState());
        }
        if (listaDeFormularios.isEmpty()) {
            return null;
        } else {
            return listaDeFormularios;
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
