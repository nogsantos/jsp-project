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
        <script type="text/javascript" src="../js/script.js"></script>
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
                <div class="alert alert-block" id="divAlerta" style="display: none;">
                    <button type="button" class="close" data-dismiss="alert">&times;</button>
                    <h4>Alerta!</h4>
                    H&aacute; campos de preenchimento obrigat&oacute;rio em branco, corrija os erros antes de submeter o formul&aacute;rio.
                </div>
                <form action="UsuarioController" name="form" id="form" method="POST">
                    <ul class="nav nav-tabs" id="myTab">
                        <li id="dadosAction" class="active"><a href="#dadosTab">Dados</a></li>
                        <li id="loginAction"><a href="#loginTab">Informa&ccedil;&otilde;es de Login</a></li>
                        <li id="grupoAction"><a href="#perfilTab">Perfil</a></li>
                    </ul>
                    <div class="tab-content">
                        <div class="tab-pane active" id="dadosTab">
                            <table>
                                <tr>
                                    <td>
                                        <input type="hidden" name="action" id="action" value="" />
                                        <div id="divCodigoPessoa" class="control-group">
                                            <label class="control-label" for="codigoPessoa">
                                                Codigo identificador (cpf/cnpj)* <span id="helpCodigoPessoa" class="help-inline" style="display: none;">(Obrigat&oacute;rio)</span>
                                            </label>
                                            <div class="controls">
                                                <input type="text" name="codigoPessoa" class="number-only" id="codigoPessoa" autocomplete="off" maxlength="15" value="" placeholder="Somente n&uacute;meros (at&eacute; 15 digitos)" />
                                            </div>
                                        </div>
                                        <div id="divNome" class="control-group">
                                            <label class="control-label" for="nome">
                                                Nome* <span id="helpNome" class="help-inline" style="display: none;">(Obrigat&oacute;rio)</span>
                                            </label>
                                            <div class="controls">
                                                <input type="text" name="nome" id="nome" autocomplete="off" maxlength="250" value="" />
                                            </div>
                                        </div>
                                        <div id="divLogradouro" class="control-group">
                                            <label class="control-label" for="logradouro">
                                                Logradouro
                                            </label>
                                            <div class="controls">
                                                <input type="text" name="logradouro" id="logradouro" autocomplete="off" maxlength="550" value="" />
                                            </div>
                                        </div>
                                        <div id="divEmail" class="control-group">
                                            <label class="control-label" for="email">
                                                Email
                                            </label>
                                            <div class="controls">
                                                <input type="text" name="email" id="email" autocomplete="off" maxlength="250" value="" />
                                            </div>
                                        </div>
                                        <div id="divTelefone" class="control-group">
                                            <label class="control-label" for="telefone">
                                                Telefone
                                            </label>
                                            <div class="controls">
                                                <input type="text" name="telefone" class="number-only" id="telefone" autocomplete="off" maxlength="10" value="" placeholder="Somente n&uacute;meros (10 digitos)" />
                                            </div>
                                        </div>
                                    </td>
                                </tr>
                            </table>
                        </div>
                        <div class="tab-pane" id="loginTab">
                            <table>
                                <tr>
                                    <td>
                                        <div id="divLogin" class="control-group">
                                            <label class="control-label" for="login">
                                                Login* <span id="helpLogin" class="help-inline" style="display: none;">(Obrigat&oacute;rio)</span>
                                            </label>
                                            <div class="controls">
                                                <input type="text" name="login" id="login" autocomplete="off" maxlength="30" value="" />
                                            </div>
                                        </div>
                                        <div id="divSenha" class="control-group">
                                            <label class="control-label" for="senha">
                                                Senha* <span id="helpSenha" class="help-inline" style="display: none;">(Obrigat&oacute;rio)</span>
                                            </label>
                                            <div class="controls">
                                                <input type="password" id="senha" name="senha" autocomplete="off" value="" />
                                            </div>
                                        </div>
                                    </td>
                                </tr>
                            </table>
                        </div>
                        <div class="tab-pane" id="perfilTab">
                            <table>
                                <tr>
                                    <td style="width: 40%;">
                                        <% PerfilController perfil = new PerfilController();%>
                                        <label for="selPerfilDisponiveis">Perfis Dispon&iacute;veis</label>
                                        <select multiple id="selPerfilDisponiveis" class="selPerfil">
                                            <% for (Perfil perfilList : perfil.listar()) {%>
                                            <option value="<%= perfilList.getCodigoPerfil()%>"><%= perfilList.getNome()%></option>  
                                            <%}%>
                                        </select>  
                                    </td>
                                    <td style="width: 10%;text-align: center;">
                                        <a href="#" id="btAdd" class="btn marginBotton10"><i class="icon-arrow-right"></i><br />Adicionar perfil</a>
                                        <br />
                                        <a href="#" id="btRemove" class="btn">Remover perfil<br /><i class="icon-arrow-left"></i></a>  
                                    </td>
                                    <td style="width: 40%">
                                        <label for="selPerfis">Perfis Cadastrados</label>
                                        <select multiple id="selPerfis" name="perfil" class="selPerfil"></select>  
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
<%@page import="br.com.jspproject.pessoa.UsuarioDAO"%>
<%@page import="br.com.jspproject.pessoa.PerfilController"%>
<%@page import="br.com.jspproject.pessoa.Perfil"%>