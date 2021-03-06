<%! private int accessCount = 0;%>
<%! private String modulo = "modulo";%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style type="text/css" media="screen">@import url(../css/bootstrap.min.css);</style>
        <style type="text/css" media="screen">@import url(../css/bootstrap-responsive.min.css);</style>
        <style type="text/css" media="screen">@import url(../css/default.css);</style>
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
                    <h1>Editar fun&ccedil;&atilde;o</h1>
                </div>
                <form action="FuncaoController" name="form" id="form" method="POST">
                    <%
                        FuncaoDAO funcaoDAO = new FuncaoDAO();
                        ModuloDAO modulo = new ModuloDAO();

                        FormularioDAO formulario = new FormularioDAO();

                        Integer codigoFuncao = Integer.parseInt(request.getParameter("codigoFuncao"));
                        Funcao funcao = new Funcao();
                        funcao = funcaoDAO.recuperarPorCodigo(codigoFuncao);
                    %>
                    <input type="hidden" name="action" id="action" value="" />
                    <input type="text" name="codigoFuncao" id="codigoFuncao" autocomplete="off" readonly="readonly" value="<%= funcao.getCodigoFuncao()%>" />
                    <div id="divCodigoModulo" class="control-group">
                        <label class="control-label" for="codigoModulo">
                            Modulo* <span id="helpCodigoModulo" class="help-inline" style="display: none;">(Obrigat&oacute;rio)</span>
                        </label>
                        <div class="controls">
                            <select name="codigoModulo" id="codigoModulo">
                                <option value=""></option>
                                <% for (Modulo moduloList : modulo.listagemSimples()) {%>
                                <option value="<%= moduloList.getCodigoModulo()%>" <%= moduloList.getCodigoModulo() == funcao.getCodigoModulo() ? "selected" : ""%>><%= moduloList.getNome()%></option>
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
                            <select name="codigoFormulario" id="codigoFormulario">
                                <option value=""></option>
                                <% for (Formulario formularioList : formulario.consultarFormulariosPorModulo(funcao.getCodigoModulo())) {%>
                                <option value="<%= formularioList.getCodigoFormulario()%>" <%= formularioList.getCodigoFormulario() == funcao.getCodigoFormulario() ? "selected" : ""%>><%= formularioList.getNome()%></option>
                                <% }%>
                            </select>
                        </div>
                    </div>     
                    <div id="divNome" class="control-group">
                        <label class="control-label" for="nome">
                            Nome* <span id="helpNome" class="help-inline" style="display: none;">(Obrigat&oacute;rio)</span>
                        </label>
                        <div class="controls">
                            <input type="text" name="nome" id="nome" autocomplete="off" maxlength="250" value="<%= funcao.getNome()%>" />
                        </div>
                    </div>
                    <div id="divDescricao" class="control-group">
                        <label class="control-label" for="nome">
                            Descri&ccedil;&atilde;o
                        </label>
                        <div class="controls">
                            <textarea name="descricao" id="descricao" maxlength="550"><%= funcao.getDescricao()%></textarea>
                        </div>
                    </div>
                    <div class="well well-large">
                        <input type="button" class="btn btn-large" id="btCancelar" value="Cancelar" />
                        <input type="button" class="btn btn-large btn-primary" id="btEditar" value="Editar altera&ccedil;&otilde;es" />
                    </div>
                </form>
            </article>
            <%@include file="/view/footer.jsp" %>
        </div>
    </body>
</html>
<%@page import="br.com.jspproject.modulo.FuncaoDAO"%>
<%@page import="br.com.jspproject.modulo.Funcao"%>
<%@page import="br.com.jspproject.modulo.FormularioDAO"%>
<%@page import="br.com.jspproject.modulo.Formulario"%>
<%@page import="br.com.jspproject.modulo.ModuloDAO"%>
<%@page import="br.com.jspproject.modulo.Modulo"%>