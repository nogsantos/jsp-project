<%@page import="br.com.jspproject.modulo.Formulario"%>
<%@page import="br.com.jspproject.modulo.FormularioDAO"%>
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
                    <h1>Exclus&atilde;o de formul&aacute;rio</h1>
                </div>
                <div class="alert">
                    <strong>Cuidado!</strong> Confirma a exclus&atilde;o do formul&aacute;rio abaixo?<br />
                    Essa opera&ccedil;&atilde;o n&atilde;o poder&aacute; ser desfeita.
                </div>
                <form action="FormularioController" name="form" id="form" method="POST">
                    <% 
                        Integer codigoFormulario = Integer.parseInt(request.getParameter("codigoFormulario"));
                        FormularioDAO formularioDao = new FormularioDAO();
                        Formulario formulario = new Formulario();
                        formulario = formularioDao.recuperarPorCodigo(codigoFormulario);
                    %>
                    <input type="hidden" name="action" id="action" value="" />
                    <input type="hidden" name="codigoFormulario" id="codigoFormulario" value="<%= formulario.getCodigoFormulario()%>" />
                    <p><b><i>C&oacute;digo:</i></b> <%= formulario.getCodigoFormulario() %></p>
                    <p><b><i>Modulo:</i></b> <%= formulario.getNomeModulo()%></p>
                    <p><b><i>Nome:</i></b> <%= formulario.getNome() %></p>
                    <p><b><i>Descri&ccedil;&atilde;o:</i></b> <%= formulario.getDescricao() %></p>
                    <p><b><i>Ordem:</i></b> <%= formulario.getOrdem() %></p>
                    <p><b><i>Visibilidade:</i></b> <%= formulario.getFlagOculto() %></p>
                    <div class="well well-large">
                        <input type="button" class="btn btn-large" id="btExcluir" value="Excluir" />
                        <input type="button" class="btn btn-large" id="btCancelar" value="Cancelar" />
                    </div>
                </form>
            </article>
            <%@include file="/view/footer.jsp" %>
        </div>
    </body>
</html>