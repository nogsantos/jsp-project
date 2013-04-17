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
                    <h1>Exclus&atilde;o de m&oacute;dulo</h1>
                </div>
                <div class="alert">
                    <strong>Cuidado!</strong> Confirma a exclus&atilde;o do m&oacute;dulo abaixo?<br />
                    Essa opera&ccedil;&atilde;o n&atilde;o poder&aacute; ser desfeita.
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
                    <input type="hidden" name="codigoModulo" id="codigoModulo" value="<%= modulo.getCodigoModulo() %>" />
                    <p><b><i>C&oacute;digo:</i></b> <%= modulo.getCodigoModulo() %></p>
                    <p><b><i>Nome:</i></b> <%= modulo.getNome() %></p>
                    <p><b><i>Descri&ccedil;&atilde;o:</i></b> <%= modulo.getDescricao() %></p>
                    <p><b><i>Ordem:</i></b> <%= modulo.getOrdem() %></p>
                    <div class="well well-large">
                        <input type="button" class="btn btn-large" id="btCancelar" value="Cancelar" />
                        <input type="button" class="btn btn-large btn-danger" id="btExcluir" value="Excluir" />
                    </div>
                </form>
            </article>
            <%@include file="/view/footer.jsp" %>
        </div>
    </body>
</html>