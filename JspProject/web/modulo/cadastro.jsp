<%@page import="br.com.jspproject.modulo.ModuloDAO"%>
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
        <script type="text/javascript" src="js/modulo.js"></script>
    </head>
    <body>
        <div class="container">
            <% accessCount++;%>
            <%@include file="/view/header.jsp" %> 
            <%@include file="/view/nav.jsp" %>
            <article>
                <div class="page-header">
                    <h1>Cadastro de m&oacute;dulos</h1>
                </div>
                <form action="ModuloServlet" name="form" id="form" method="POST">
                    <% ModuloDAO modulo = new ModuloDAO();%>
                    <input type="hidden" name="action" id="action" value="" />
                    <input type="hidden" name="codigoModulo" id="codigoModulo" value="<%= modulo.moduloNextVal() %>" />
                    <label for="nome">Nome</label>
                    <input type="text" name="nome" id="nome" autocomplete="off" />
                    <label for="descricao">Descri&ccedil;&atilde;o</label>
                    <input type="text" name="descricao" id="descricao" autocomplete="off" />
                    <label for="ordem">Ordem</label>
                    <input type="number" name="ordem" id="ordem" autocomplete="off" min="1" max="100" />
                    <div class="well well-large">
                        <input type="button" class="btn btn-large" id="btSalvar" value="Salvar" />
                        <input type="button" class="btn btn-large" id="btCancelar" value="Cancelar" />
                    </div>
                </form>
            </article>
            <%@include file="/view/footer.jsp" %>
        </div>
    </body>
</html>