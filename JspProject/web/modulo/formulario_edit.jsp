<%@page import="br.com.jspproject.modulo.Formulario"%>
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
        <style type="text/css" media="screen">@import url(../css/bootstrap.min.css);</style>
        <style type="text/css" media="screen">@import url(../css/bootstrap-responsive.min.css);</style>
        <style type="text/css" media="screen">@import url(../css/default.css);</style>
        <script type="text/javascript" src="../js/jquery-1.9.1.min.js"></script>
        <script type="text/javascript" src="../js/bootstrap.min.js"></script>
        <script type="text/javascript" src="js/formulario.js"></script>
        <script type="text/javascript" src="../js/script.js"></script>
    </head>
    <body>
        <div class="container">
            <% accessCount++;%>
            <%@include file="/view/header.jsp" %> 
            <%@include file="/view/nav.jsp" %>
            <article>
                <div class="page-header">
                    <h1>Edi&ccedil;&atilde;o formul&aacute;rio</h1>
                </div>
                <form action="FormularioController" name="form" id="form" method="POST">
                    <%
                        Integer codigoFormulario = Integer.parseInt(request.getParameter("codigoFormulario"));
                        FormularioDAO formularioDao = new FormularioDAO();

                        Formulario formulario = new Formulario();
                        formulario = formularioDao.recuperarPorCodigo(codigoFormulario);

                        ModuloDAO modulo = new ModuloDAO();
                    %>
                    <input type="hidden" name="action" id="action" value="" />
                    <label for="nome">C&oacute;digo</label>
                    <input type="text" name="codigoFormulario" id="codigoFormulario" autocomplete="off" readonly="readonly" value="<%= formulario.getCodigoFormulario()%>" />
                    <div id="divCodigoModulo" class="control-group">
                        <div style="position: relative;float:right;padding-top: 22px;">
                            <a data-toggle="modal" href="modulo_cad_modal.jsp" data-target="#cadModuloAux" class="btn btn-large" id="btCadAux" title="Cadastrar um novo Modulo"><i class="icon-plus"></i></a>
                        </div>
                        <label class="control-label" for="codigoModulo">
                            Modulo* <span id="helpCodigoModulo" class="help-inline" style="display: none;">(Obrigat&oacute;rio)</span>
                        </label>
                        <div class="controls">
                            <select name="codigoModulo" id="codigoModulo" style="width:95% !important;">
                                <option value=""></option>
                                <% for (Modulo moduloList : modulo.listagemSimples()) {%>
                                <option value="<%= moduloList.getCodigoModulo()%>" <%= moduloList.getCodigoModulo() == formulario.getCodigoModulo() ? "selected" : ""%>><%= moduloList.getNome()%></option>
                                <% }%>
                            </select>
                        </div>
                    </div>
                    <div id="divNome" class="control-group">
                        <label class="control-label" for="nome">
                            Nome* <span id="helpNome" class="help-inline" style="display: none;">(Obrigat&oacute;rio)</span>
                        </label>
                        <div class="controls">
                            <input type="text" name="nome" id="nome" autocomplete="off" maxlength="250" value="<%= formulario.getNome()%>" />
                        </div>
                    </div>
                    <div id="divNomeMenu" class="control-group">
                        <label class="control-label" for="nomeMenu">
                            Nome Menu* <span id="helpNomeMenu" class="help-inline" style="display: none;">(Obrigat&oacute;rio)</span>
                        </label>
                        <div class="controls">
                            <input type="text" name="nomeMenu" id="nomeMenu" autocomplete="off" maxlength="20" value="<%= formulario.getNomeMenu()%>" />
                        </div>
                    </div>
                    <div id="divDescricao" class="control-group">
                        <label class="control-label" for="descricao">
                            Descricao* <span id="helpDescricao" class="help-inline" style="display: none;">(Obrigat&oacute;rio)</span>
                        </label>
                        <div class="controls">
                            <textarea name="descricao" id="descricao" maxlength="550"><%= formulario.getDescricao()%></textarea>
                        </div>
                    </div>
                    <div id="divOrdem" class="control-group">
                        <label class="control-label" for="ordem">
                            Ordem* <span id="helpOrdem" class="help-inline" style="display: none;">(Obrigat&oacute;rio)</span>
                        </label>
                        <div class="controls">
                            <input type="text" name="ordem" id="ordem" autocomplete="off" class="number number-only" value="<%= formulario.getOrdem()%>" />
                        </div>
                    </div>
                    <div>
                        <label>Formul&aacute;rio Oculto: </label>
                        <label class="checkbox inline">
                            <input type="radio" name="flagOculto" id="sim" value="t" /> Sim
                        </label>
                        <label class="checkbox inline">
                            <input type="radio" name="flagOculto" id="nao" value="f" checked="checked" /> N&atilde;o
                        </label>
                    </div>
                    <br /><br />
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