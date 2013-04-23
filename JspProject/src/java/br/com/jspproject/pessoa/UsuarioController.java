/**
 *
 * Descrição:Servlet UsuarioController
 *
 *
 * @author Fabricio Nogueira
 *
 * @since 17-Apr-2013
 *
 * @version 1.0.0
 *
 */

package br.com.jspproject.pessoa;


import br.com.jspproject.modulo.Funcao;
import br.com.jspproject.modulo.FuncaoDAO;
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

@WebServlet(name="UsuarioController", urlPatterns={"/pessoa/UsuarioController"})
public class UsuarioController extends HttpServlet {
    private UsuarioDAO usuarioData = new UsuarioDAO();   
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
                        Integer count = 0;
                        String codigoPessoa = request.getParameter("codigoPessoa");
                        String nome = request.getParameter("nome");
                        String logradouro = request.getParameter("logradouro");
                        String email = request.getParameter("email");
                        String telefone = request.getParameter("telefone");
                        String login = request.getParameter("login");
                        String senha = request.getParameter("senha");
                        String[] codigoPerfil = request.getParameterValues("perfil");
                        
                        Pessoa pessoa = new Pessoa();
                        pessoa.setCodigoPessoa(codigoPessoa);
                        pessoa.setNome(nome);
                        pessoa.setLogradouro(logradouro);
                        pessoa.setEmail(email);
                        pessoa.setTelefone(telefone);
                        PessoaDAO pessoaDAO = new PessoaDAO();
                        /*
                         * Cadastro pessoa
                         */
                        String cadastrarPessoa = pessoaDAO.cadastrar(pessoa);
                        if(cadastrarPessoa.equals("sucesso")){
                            pessoaDAO.PessoaCommit();
                            count += 1;
                            Usuario usuario = new Usuario();
                            usuario.setCodigoPessoa(codigoPessoa);
                            usuario.setLogin(login);
                            usuario.setSenha(senha);
                            UsuarioDAO usuarioDAO = new UsuarioDAO();
                            /*
                             * cadastro usuario
                             */
                            String cadastrarUsuario = usuarioDAO.cadastrar(usuario, pessoa);
                            if(cadastrarUsuario.equals("sucesso")){
                                count += 1;
                                /*
                                 * cadastro perfil
                                 */
                                try {
                                    if(codigoPerfil != null) {
                                        String cadastrarPerfilUsuario;
                                        for (int i = 0; i < codigoPerfil.length; i++) {
                                            Perfil perfil = new Perfil();
                                            UsuarioPerfilDAO usuarioperfilDAO = new UsuarioPerfilDAO();
                                            perfil.setCodigoPerfil(Integer.parseInt(codigoPerfil[i]));
                                            cadastrarPerfilUsuario = usuarioperfilDAO.cadastrar(usuario,perfil);
                                            if(cadastrarPerfilUsuario.equals("sucesso")){
                                                count += 1;
                                                continue;
                                            }else{
                                                StringBuilder str = new StringBuilder();
                                                str.append("<div class=\"alert alert-error\">");
                                                str.append("<button type=\"button\" class=\"close\" data-dismiss=\"alert\">×</button>");
                                                str.append("<strong>ERRO! </strong>");
                                                str.append(cadastrarPerfilUsuario);
                                                str.append("</div>");
                                                out.printf(str.toString());
                                                rd = request.getRequestDispatcher("/erros.jsp");
                                                rd.include(request, response);
                                                break;
                                            }
                                        }
                                    }
                                } catch (Exception ex) {
                                    out.printf(ex.getMessage());
                                    rd = request.getRequestDispatcher("/erros.jsp");
                                    rd.include(request, response);
                                }
                            }else{
                                pessoaDAO.pessoaRolback();
                               /*
                                * mensagem e redirecionamento de erro
                                */
                                out.printf(cadastrarPessoa);
                                rd = request.getRequestDispatcher("/erros.jsp");
                                rd.include(request, response);
                            }
                        } else {
                            /*
                             * mensagem e redirecionamento de erro
                             */
                            out.printf(cadastrarPessoa);
                            rd = request.getRequestDispatcher("/erros.jsp");
                            rd.include(request, response);
                        }
                        if(count >= 2){
                            /*
                             * mensagem e redirecionamento de sucesso
                             */
                            StringBuilder str = new StringBuilder();
                            str.append("<div class=\"alert alert-success\">");
                            str.append("<button type=\"button\" class=\"close\" data-dismiss=\"alert\">×</button>");
                            str.append("<strong>Sucesso!</strong> Usuario cadastrada com sucesso.");
                            str.append("</div>");
                            out.printf(str.toString());
                            rd = request.getRequestDispatcher("/pessoa/usuario.jsp");
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
                } else if (action.equals("cancelar")) {
                    /*
                     * Cancelamento de ação
                     */
                    rd = request.getRequestDispatcher("/pessoa/usuario.jsp");
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
    public List<Usuario> listar() {
        PrintWriter out = null;
        List<Usuario> listaDeUsuarios = null;
        try {
            listaDeUsuarios = this.usuarioData.listar();
        } catch (SQLException ex) {
            out.println(ex.getSQLState());
        }
        if (listaDeUsuarios.isEmpty()) {
            return null;
        } else {
            return listaDeUsuarios;
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
