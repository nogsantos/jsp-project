/**
 *
 * Descrição:Servlet FuncaoController
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

import com.google.gson.Gson;
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

@WebServlet(name = "FuncaoController", urlPatterns = {"/modulo/FuncaoController"})
public class FuncaoController extends HttpServlet {

    private FuncaoDAO funcaoData = new FuncaoDAO();

    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
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
                        String sCodigoFormulario = request.getParameter("codigoFormulario");
                        String sCodigoFuncao = request.getParameter("codigoFuncao");
                        String nome = request.getParameter("nome");
                        String descricao = request.getParameter("descricao");

                        Integer codigoFormulario = Integer.parseInt(sCodigoFormulario);
                        Integer codigoFuncao = Integer.parseInt(sCodigoFuncao);

                        Funcao funcao = new Funcao();
                        funcao.setCodigoFormulario(codigoFormulario);
                        funcao.setCodigoFuncao(codigoFuncao);
                        funcao.setNome(nome);
                        funcao.setDescricao(descricao);

                        FuncaoDAO funcaoDAO = new FuncaoDAO();

                        String cadastrar = funcaoDAO.cadastrar(funcao);
                        if (cadastrar.equals("sucesso")) {
                            StringBuilder str = new StringBuilder();
                            str.append("<div class=\"alert alert-success\">");
                            str.append("<button type=\"button\" class=\"close\" data-dismiss=\"alert\">×</button>");
                            str.append("<strong>Sucesso!</strong> Função cadastrada com sucesso.");
                            str.append("</div>");
                            /*
                             * mensagem e redirecionamento de sucesso
                             */
                            out.printf(str.toString());
                            rd = request.getRequestDispatcher("/modulo/funcao.jsp");
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
                        
                        String sCodigoFormulario = request.getParameter("codigoFormulario");
                        String sCodigoFuncao = request.getParameter("codigoFuncao");

                        Integer codigoFormulario = Integer.parseInt(sCodigoFormulario);
                        Integer codigoFuncao = Integer.parseInt(sCodigoFuncao);
                        String nome = request.getParameter("nome");
                        String descricao = request.getParameter("descricao");

                        Funcao funcao = new Funcao();
                        funcao.setCodigoFormulario(codigoFormulario);
                        funcao.setCodigoFuncao(codigoFuncao);
                        funcao.setNome(nome);
                        funcao.setDescricao(descricao);
                        FuncaoDAO funcaoDAO = new FuncaoDAO();

                        String editar = funcaoDAO.editar(funcao);
                        if (editar.equals("sucesso")) {
                            StringBuilder str = new StringBuilder();
                            str.append("<div class=\"alert alert-success\">");
                            str.append("<button type=\"button\" class=\"close\" data-dismiss=\"alert\">×</button>");
                            str.append("<strong>Sucesso!</strong> Função editada com sucesso.");
                            str.append("</div>");
                            /*
                             * mensagem e redirecionamento de sucesso
                             */
                            out.printf(str.toString());
                            rd = request.getRequestDispatcher("/modulo/funcao.jsp");
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
                    String sCodigoFuncao = request.getParameter("codigoFuncao");
                    Integer codigoFuncao = Integer.parseInt(sCodigoFuncao);
                    Funcao funcao = new Funcao();
                    funcao.setCodigoFuncao(codigoFuncao);
                    FuncaoDAO funcaoDAO = new FuncaoDAO();
                    String excluir = funcaoDAO.excluir(funcao);
                    if (excluir.equals("sucesso")) {
                        StringBuilder str = new StringBuilder();
                        str.append("<div class=\"alert alert-success\">");
                        str.append("<button type=\"button\" class=\"close\" data-dismiss=\"alert\">×</button>");
                        str.append("<strong>Sucesso!</strong> Função excluida com sucesso.");
                        str.append("</div>");
                        /*
                         * mensagem e redirecionamento de sucesso
                         */
                        out.printf(str.toString());
                        rd = request.getRequestDispatcher("/modulo/funcao.jsp");
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
                } else if (action.equals("consultarFormularios")) {
                    /*
                     * Ajax para consultar formulários por módulo.
                     */
                    String sCodigoModulo = request.getParameter("codigo_modulo");
                    Integer codigoModulo = Integer.parseInt(sCodigoModulo);
                    out.println(consultaFormulariosPorModulo(codigoModulo));

                } else if (action.equals("cancelar")) {
                    /*
                     * Cancelamento de ação
                     */
                    rd = request.getRequestDispatcher("/modulo/funcao.jsp");
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
    public List<Funcao> listar() {
        List<Funcao> listaDeFuncoes = null;
        try {
            listaDeFuncoes = this.funcaoData.listar();
        } catch (SQLException ex) {
            System.err.println(ex.getSQLState());
        }
        if (listaDeFuncoes.isEmpty()) {
            return null;
        } else {
            return listaDeFuncoes;
        }
    }
    /*
     *
     */

    private String consultaFormulariosPorModulo(Integer codigoModulo) {
        Gson json = new Gson();
        List<Formulario> listaDeFormulariosPorModulo = null;
        try {
            FormularioDAO formularioDAO = new FormularioDAO();
            listaDeFormulariosPorModulo = formularioDAO.consultarFormulariosPorModulo(codigoModulo);
        } catch (SQLException ex) {
            return ex.getSQLState().toString();
        }
        return json.toJson(listaDeFormulariosPorModulo);
    }
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">

    /**
     * Handles the HTTP
     * <code>GET</code> method.
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
     * Handles the HTTP
     * <code>POST</code> method.
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
