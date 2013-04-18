<%@page import="br.com.jspproject.pessoa.UsuarioController"%>
<%@page import="br.com.jspproject.pessoa.Usuario"%>
<%@ page info=" 
         Documento : usuario
         Autor     : Fabricio Nogueira
         Criado em : 10-Apr-2013, 15:01:02
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
                    <h1>Usu&aacute;rio</h1>
                </div>
                <div class="well">
                    <a href="usuario_cad.jsp" class="btn btn-large btn-inverse">Cadastrar</a>
                </div>
                <% UsuarioController usuario = new UsuarioController();%>
                <table class="table table-hover">
                    <tr>
                        <th>C&oacute;digo</th>
                        <th>Nome</th>
                        <th>Logradouro</th>
                        <th>Email</th>
                        <th>Telefone</th>
                        <th>Login</th>
                        <th>Senha</th>
                        <th style="text-align: center;">&spadesuit;</th>
                    </tr>
                    <% for (Usuario usuarioList : usuario.listar()) {%>
                    <tr>
                        <td><%= usuarioList.getCodigoPessoa() %></td>
                        <td><%= usuarioList.getNome() %></td>
                        <td><%= usuarioList.getLogradouro() %></td>
                        <td><%= usuarioList.getEmail() %></td>
                        <td><%= usuarioList.getTelefone() %></td>
                        <td><%= usuarioList.getLogin() %></td>
                        <td><%= usuarioList.getSenha() %></td>
                        <td style="text-align: center;">
                            <a href=<%="usuario_edit.jsp?codigoPessoa="+usuarioList.getCodigoPessoa() %> class="btn btn-warning">Editar</a>
                            <a href=<%="usuario_excl.jsp?codigoPessoa="+usuarioList.getCodigoPessoa() %> class="btn btn-danger">Excuir</a>
                        </td>
                    </tr>
                    <%}%>
                </table>
            </article>
            <%@include file="/view/footer.jsp" %>
        </div>
    </body>
</html>