<%@page import="br.com.jspproject.modulo.Modulo"%>
<%@page import="br.com.jspproject.modulo.ModuloDAO"%>
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
        <script type="text/javascript" src="js/modulo.js"></script>
        <script type="text/javascript" src="../js/script.js"></script>
    </head>
    <body>
        <div class="container">
            <% accessCount++;%>
            <%@include file="/view/header.jsp" %> 
            <%@include file="/view/nav.jsp" %>
            <article>
                <div class="page-header">
                    <h1>Edi&ccedil;&atilde;o de m&oacute;dulo</h1>
                </div>
                <form action="ModuloServlet" name="form" id="form" method="POST">
                    <% 
                        Integer codigoModulo = Integer.parseInt(request.getParameter("codigoModulo"));
                        ModuloDAO moduloDao = new ModuloDAO();
                        Modulo modulo = new Modulo();
                        modulo = moduloDao.recuperarPorCodigo(codigoModulo);
                    %>
                    <input type="hidden" name="action" id="action" value="" />
                    <input type="hidden" name="modal_form" id="modal_form" value="" />
                    <label for="nome">C&oacute;digo</label>
                    <input type="text" name="codigoModulo" id="codigoModulo" autocomplete="off" readonly="readonly" value="<%= modulo.getCodigoModulo() %>" />
                    <div id="divNome" class="control-group">
                        <label class="control-label" for="nome">
                            Nome* <span id="helpNome" class="help-inline" style="display: none;">(Obrigat&oacute;rio)</span>
                        </label>
                        <div class="controls">
                            <input type="text" name="nome" id="nome" autocomplete="off" maxlength="250" value="<%= modulo.getNome() %>" />
                        </div>
                    </div>
                    <div id="divDescricao" class="control-group">
                        <label class="control-label" for="descricao">
                            Descri&ccedil;&atilde;o* <span id="helpDescricao" class="help-inline" style="display: none;">(Obrigat&oacute;rio)</span>
                        </label>
                        <div class="controls">
                            <textarea name="descricao" id="descricao" maxlength="550"><%= modulo.getDescricao() %></textarea>
                        </div>
                    </div>
                    <div id="divOrdem" class="control-group">
                        <label class="control-label" for="ordem">
                            Ordem* <span id="helpOrdem" class="help-inline" style="display: none;">(Obrigat&oacute;rio)</span>
                        </label>
                        <div class="controls">
                            <input type="text" name="ordem" id="ordem" autocomplete="off" value="<%= modulo.getOrdem() %>" class="number number-only" />
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