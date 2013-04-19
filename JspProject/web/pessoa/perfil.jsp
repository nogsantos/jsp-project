<%@ page info=" 
         Documento : perfil
         Autor     : Fabricio Nogueira
         Criado em : 19-Apr-2013, 14:17:06
         "%>
<%! private int accessCount = 0;%>
<%! private String modulo = "pessoa";%>
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
    </head>
    <body>
        <div class="container">
            <% accessCount++;%>
            <%@include file="/view/header.jsp" %> 
            <%@include file="/view/nav.jsp" %>
            <article>
                <div class="page-header">
                    <h1>Perfil</h1>
                </div>
                <div class="well">
                    <a href="perfil_cad.jsp" class="btn btn-large btn-inverse">Cadastrar</a>
                </div>
                <% PerfilController perfil = new PerfilController();%>
                <table class="table table-hover">
                    <tr>
                        <th>C&oacute;digo</th>
                        <th>Nome</th>
                        <th>Descri&ccedil;&atilde;o</th>
                        <th style="text-align: center;">&spadesuit;</th>
                    </tr>
                    <% for (Perfil perfilList : perfil.listar()) {%>
                    <tr>
                        <td><%= perfilList.getCodigoPerfil()%></td>
                        <td><%= perfilList.getNome()%></td>
                        <td><%= perfilList.getDescricao()%></td>
                        <td style="text-align: center;">
                            <a href=<%="perfil_edit.jsp?codigoPerfil=" + perfilList.getCodigoPerfil()%> class="btn btn-warning">Editar</a>
                            <a href=<%="perfil_excl.jsp?codigoPerfil=" + perfilList.getCodigoPerfil()%> class="btn btn-danger">Excuir</a>
                        </td>
                    </tr>
                    <%}%>
                </table>
            </article>
            <%@include file="/view/footer.jsp" %>
        </div>
    </body>
</html>
<%@page import="br.com.jspproject.pessoa.Perfil"%>
<%@page import="br.com.jspproject.pessoa.PerfilController"%>