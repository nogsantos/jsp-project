<%@page import="br.com.jspproject.pessoa.UsuarioDAO"%>
<%! private int accessCount = 0;%>
<%! private String modulo = "pessoa";%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style type="text/css" media="screen">@import url(../css/default.css);</style>
        <style type="text/css" media="screen">@import url(../css/bootstrap.min.css);</style>
        <style type="text/css" media="screen">@import url(../css/bootstrap-responsive.min.css);</style>
        <style type="text/css" media="screen">@import url(css/usuario.css);</style>
        <script type="text/javascript" src="../js/jquery-1.9.1.min.js"></script>
        <script type="text/javascript" src="../js/bootstrap.min.js"></script>
        <script type="text/javascript" src="js/usuario.js"></script>
    </head>
    <body>
        <div class="container">
            <% accessCount++;%>
            <%@include file="/view/header.jsp" %> 
            <%@include file="/view/nav.jsp" %>
            <article>
                <div class="page-header">
                    <h1>Cadastro de usu&aacute;rio</h1>
                </div>
                <form action="UsuarioController" name="form" id="form" method="POST">
                    <ul class="nav nav-tabs" id="myTab">
                        <li id="dadosAction" class="active"><a href="#dadosTab">Dados</a></li>
                        <li id="loginAction"><a href="#loginTab">Login</a></li>
                        <li id="grupoAction"><a href="#perfilTab">Perfil</a></li>
                    </ul>
                    <div class="tab-content">
                        <div class="tab-pane active" id="dadosTab">
                            <table>
                                <tr>
                                    <td>
                                        <input type="hidden" name="action" id="action" value="" />
                                        <label for="codigoPessoa"><span class="label label-important">Codigo identificador (cpf/cnpj)*</span></label>
                                        <input type="text" name="codigoPessoa" id="codigoPessoa" autocomplete="off" maxlength="15" />
                                        <label for="nome"><span class="label label-important">Nome*</span></label>
                                        <input type="text" name="nome" id="nome" autocomplete="off" maxlength="250" />
                                        <label for="logradouro">Logradouro</label>
                                        <input type="text" name="logradouro" id="logradouro" autocomplete="off" maxlength="550" />
                                        <label for="email">Email</label>
                                        <input type="text" name="email" id="email" autocomplete="off" maxlength="250" />
                                        <label for="telefone">Telefone</label>
                                        <input type="text" name="telefone" id="telefone" autocomplete="off" maxlength="10" />
                                    </td>
                                </tr>
                            </table>
                        </div>
                        <div class="tab-pane" id="loginTab">
                            <table>
                                <tr>
                                    <td>
                                        <label for="login"><span class="label label-important">Login*</span></label>
                                        <input type="text" name="login" id="login" autocomplete="off" maxlength="30" />
                                        <label for="senha"><span class="label label-important">Senha*</span></label>
                                        <input type="password" id="senha" name="senha" autocomplete="off" />
                                    </td>
                                </tr>
                            </table>
                        </div>
                        <div class="tab-pane" id="perfilTab">
                            <table>
                                <tr>
                                    <td style="width: 40%;">
                                        <label for="selPerfilDisponiveis">Perfis Dispon&iacute;veis</label>
                                        <select multiple id="selPerfilDisponiveis" class="selPerfil">
                                            <option value="1">Option 1</option>  
                                            <option value="2">Option 2</option>  
                                            <option value="3">Option 3</option>  
                                            <option value="4">Option 4</option>  
                                        </select>  
                                    </td>
                                    <td style="width: 10%;text-align: center;">
                                        <a href="#" id="btAdd" class="btn marginBotton10"><i class="icon-arrow-right"></i><br />Adicionar perfil</a>
                                        <br />
                                        <a href="#" id="btRemove" class="btn">Remover perfil<br /><i class="icon-arrow-left"></i></a>  
                                    </td>
                                    <td style="width: 40%">
                                        <label for="selPerfis">Perfis Cadastrados</label>
                                        <select multiple id="selPerfis" name="perfis" class="selPerfil">
                                        </select>  
                                    </td>
                                </tr>
                            </table>
                        </div>
                    </div>
                    <div class="well well-large">
                        <input type="button" class="btn btn-large" id="btCancelar" value="Cancelar" />
                        <input type="button" class="btn btn-large btn-primary" id="btSalvar" value="Salvar altera&ccedil;&otilde;es" />
                    </div>
                </form>
            </article>
            <%@include file="/view/footer.jsp" %>
        </div>
    </body>
</html>