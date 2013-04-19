<%@page import="br.com.jspproject.modulo.FuncaoDAO"%>
<%@page import="br.com.jspproject.modulo.FormularioDAO"%>
<%@page import="br.com.jspproject.modulo.ModuloDAO"%>
<%@page import="br.com.jspproject.modulo.Modulo"%>
<%! private int accessCount = 0;%>
<%! private String modulo = "modulo";%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style type="text/css" media="screen">@import url(../css/default.css);</style>
        <style type="text/css" media="screen">@import url(../css/bootstrap.min.css);</style>
        <style type="text/css" media="screen">@import url(../css/bootstrap-responsive.min.css);</style>
        <script type="text/javascript" src="../js/jquery-1.9.1.min.js"></script>
        <script type="text/javascript" src="../js/bootstrap.min.js"></script>
        <script type="text/javascript" src="../js/script.js"></script>
        <script type="text/javascript" src="js/funcao.js"></script>
    </head>
    <body>
        <div class="container">
            <% accessCount++;%>
            <%@include file="/view/header.jsp" %> 
            <%@include file="/view/nav.jsp" %>
            <article>
                <div class="page-header">
                    <h1>Cadastro de fun&ccedil;&atilde;o</h1>
                </div>
                <form action="FuncaoController" name="form" id="form" method="POST">
                    <%
                        FuncaoDAO funcao = new FuncaoDAO();
                        ModuloDAO modulo = new ModuloDAO();
                    %>
                    <input type="hidden" name="action" id="action" value="" />
                    <input type="hidden" name="codigoFuncao" id="codigoFuncao" value="<%= funcao.funcaoNextVal()%>" />
                    <div id="divCodigoModulo" class="control-group">
                        <label class="control-label" for="codigoModulo">
                            Modulo* <span id="helpCodigoModulo" class="help-inline" style="display: none;">(Obrigat&oacute;rio)</span>
                        </label>
                        <div class="controls">
                            <select name="codigoModulo" id="codigoModulo">
                                <option value=""></option>
                                <% for (Modulo moduloList : modulo.listagemSimples()) {%>
                                <option value="<%= moduloList.getCodigoModulo()%>"><%= moduloList.getNome()%></option>
                                <% }%>
                            </select>
                        </div>
                    </div>
                    <div id="divCodigoFormulario" class="control-group">
                        <label class="control-label" for="nome">
                            Formul&aacute;rio* <span id="helpCodigoFormulario" class="help-inline" style="display: none;">(Obrigat&oacute;rio)</span>
                        </label>
                        <div class="controls">
                            <img src="../img/ajax-loader.gif"  border="0" alt="" id="ajax-load" style="position:fixed;display:none;"/>
                            <select name="codigoFormulario" id="codigoFormulario" disabled >
                                <option value=""></option>
                            </select>
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
                    <div id="divDescricao" class="control-group">
                        <label class="control-label" for="nome">
                            Descri&ccedil;&atilde;o
                        </label>
                        <div class="controls">
                            <textarea name="descricao" id="descricao" maxlength="550"></textarea>
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