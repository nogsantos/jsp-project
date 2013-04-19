<%! private int accessCount = 0;%>
<%! private String modulo = "pessoa";%>
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
        <script type="text/javascript" src="js/perfil.js"></script>
        <script type="text/javascript" src="../js/script.js"></script>
    </head>
    <body>
        <div class="container">
            <% accessCount++;%>
            <%@include file="/view/header.jsp" %> 
            <%@include file="/view/nav.jsp" %>
            <article>
                <div class="page-header">
                    <h1>Exclus&atilde;o de perfil</h1>
                </div>
                <form action="PerfilController" name="form" id="form" method="POST">
                    <% 
                        Integer codigoPerfil = Integer.parseInt(request.getParameter("codigoPerfil"));
                        PerfilDAO PerfilDAO = new PerfilDAO();
                        Perfil perfil = new Perfil();
                        perfil = PerfilDAO.recuperarPorCodigo(codigoPerfil);
                    %>
                    <input type="hidden" name="action" id="action" value="" />
                    <input type="hidden" name="codigoPerfil" id="codigoPerfil" value="<%= perfil.getCodigoPerfil()%>" />
                    <div id="divCodigo" class="control-group">
                        <b><i>Codigo: </i></b><%= perfil.getCodigoPerfil()%>
                    </div>
                    <div id="divNome" class="control-group">
                        <b><i>Nome: </i></b><%= perfil.getNome() %>
                    </div>
                    <div id="divDescricao" class="control-group">
                        <b><i>Descri&ccedil;&atilde;o: </i></b><%= perfil.getDescricao() %>
                    </div>
                    <div class="well well-large">
                        <input type="button" class="btn btn-large" id="btCancelar" value="Cancelar" />
                        <input type="button" class="btn btn-large btn-danger" id="btExcluir" value="Excluir altera&ccedil;&otilde;es" />
                    </div>
                </form>
            </article>
            <%@include file="/view/footer.jsp" %>
        </div>
    </body>
</html>
<%@page import="br.com.jspproject.pessoa.Perfil"%>
<%@page import="br.com.jspproject.pessoa.PerfilDAO"%>