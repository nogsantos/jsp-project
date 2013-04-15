<%@page import="br.com.jspproject.modulo.FormularioController"%>
<%@page import="br.com.jspproject.modulo.Formulario"%>
<%@ page info=" 
         Documento : formulario
         Autor     : Fabricio Nogueira
         Criado em : 10-Apr-2013, 15:01:02
         "%>
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
        <script type="text/javascript" src="../js/script.js"></script>
    </head>
    <body>
        <div class="container">
            <% accessCount++;%>
            <%@include file="/view/header.jsp" %> 
            <%@include file="/view/nav.jsp" %>
            <article>
                <div class="page-header">
                    <h1>Formul&aacute;rio</h1>
                </div>
                <div class="well">
                    <a href="formulario_cad.jsp" class="btn btn-large btn-inverse">Cadastrar</a>
                </div>
                <% FormularioController formulario = new FormularioController();%>
                <table class="table table-hover">
                    <tr>
                        <th>C&oacute;digo</th>
                        <th>Modulo</th>
                        <th>Nome</th>
                        <th>Nome Menu</th>
                        <th>Descri&ccedil;&atilde;o</th>
                        <th>Ordem</th>
                        <th>Visibilidade</th>
                        <th style="text-align: center;">&spadesuit;</th>
                    </tr>
                    <% for (Formulario formularioList : formulario.listar()) { %>
                    <tr>
                        <td><%= formularioList.getCodigoFormulario()%></td>
                        <td><%= formularioList.getNomeModulo()%></td>
                        <td><%= formularioList.getNome()%></td>
                        <td><%= formularioList.getNomeMenu()%></td>
                        <td><%= formularioList.getDescricao()%></td>
                        <td><%= formularioList.getOrdem()%></td>
                        <td><%= formularioList.getFlagOculto()%></td>
                        <td style="text-align: center;">
                            <a href=<%="formulario_edit.jsp?codigoFormulario="+formularioList.getCodigoFormulario()%> class="btn btn-warning">Editar</a>
                            <a href=<%="formulario_excl.jsp?codigoFormulario="+formularioList.getCodigoFormulario()%> class="btn btn-danger">Excuir</a>
                        </td>
                    </tr>
                    <% } %>
                </table>
            </article>
            <%@include file="/view/footer.jsp" %>
        </div>
    </body>
</html>