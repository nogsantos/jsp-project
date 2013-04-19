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
                    <h1>Excluir fun&ccedil;&atilde;o</h1>
                </div>
                <div class="alert">
                    <strong>Cuidado!</strong> Confirma a exclus&atilde;o da fun&ccedil;&atilde;o abaixo?<br />
                    Essa opera&ccedil;&atilde;o n&atilde;o poder&aacute; ser desfeita.
                </div>
                <form action="FuncaoController" name="form" id="form" method="POST">
                    <% 
                        FuncaoDAO funcaoDAO = new FuncaoDAO();
                        ModuloDAO modulo = new ModuloDAO();
                        
                        FormularioDAO formulario =  new FormularioDAO();
                        
                        Integer codigoFuncao = Integer.parseInt(request.getParameter("codigoFuncao"));
                        Funcao funcao = new Funcao();
                        funcao = funcaoDAO.recuperarPorCodigo(codigoFuncao);
                    %>
                    <input type="hidden" name="action" id="action" value="" />
                    <input type="hidden" name="codigoFuncao" id="codigoFuncao" value="<%= funcao.getCodigoFuncao() %>" />
                    <p><b><i>Codigo: </i></b><%= funcao.getCodigoFuncao() %></p>
                    <p><b><i>Modulo: </i></b><%= funcao.getNomeModulo() %></p>
                    <p><b><i>Formul&aacute;rio: </i></b><%= funcao.getNomeFormulario() %></p>
                    <p><b><i>Nome: </i></b><%= funcao.getNome() %></p>
                    <p><b><i>Descri&ccedil;&atilde;o: </i></b><%= funcao.getDescricao() %></p>
                    <div class="well well-large">
                        <input type="button" class="btn btn-large" id="btCancelar" value="Cancelar" />
                        <input type="button" class="btn btn-large btn-primary" id="btExcluir" value="Excluir altera&ccedil;&otilde;es" />
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