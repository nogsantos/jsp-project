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
                    <input type="text" name="codigoFormulario" id="codigoFormulario" autocomplete="off" readonly="readonly" value="<%= formulario.getCodigoFormulario() %>" />
                    <label for="codigoModulo">Modulo</label>
                    <select name="codigoModulo" id="codigoModulo">
                        <option value=""></option>
                        <% for(Modulo moduloList : modulo.listagemSimples()) { %>
                        <option value="<%= moduloList.getCodigoModulo() %>" <%= moduloList.getCodigoModulo() == formulario.getCodigoModulo() ? "selected" : "" %>><%= moduloList.getNome() %></option>
                        <% } %>
                    </select>
                    <label for="nome">Nome</label>
                    <input type="text" name="nome" id="nome" autocomplete="off"  maxlength="250" value="<%= formulario.getNome() %>" />
                    <label for="nomeMenu">Nome Menu</label>
                    <input type="text" name="nomeMenu" id="nomeMenu" autocomplete="off"  maxlength="20" value="<%= formulario.getNomeMenu()%>" />
                    <label for="descricao">Descri&ccedil;&atilde;o</label>
                    <textarea name="descricao" id="descricao" maxlength="550"><%= formulario.getDescricao() %></textarea>
                    <label for="ordem">Ordem</label>
                    <input type="text" name="ordem" id="ordem" autocomplete="off" value="<%= formulario.getOrdem() %>" class="number-only" />
                    Formul&aacute;rio Oculto:
                    <label class="checkbox inline">
                        <input type="radio" name="flagOculto" id="sim" value="t" <%= formulario.getFlagOculto().equals("Oculto") ? "checked" : ""  %> /> Sim
                    </label>
                    <label class="checkbox inline">
                        <input type="radio" name="flagOculto" id="nao" value="f" <%= formulario.getFlagOculto().equals("Visivel") ? "checked" : ""  %> /> N&atilde;o
                    </label>
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