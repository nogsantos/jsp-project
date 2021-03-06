<%@page import="br.com.jspproject.modulo.FuncaoController"%>
<%@page import="br.com.jspproject.modulo.Funcao"%>
<%@ page info=" 
         Documento : funcao
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
                    <h1>Fun&ccedil;&atilde;o</h1>
                </div>
                <div class="well">
                    <a href="funcao_cad.jsp" class="btn btn-large btn-inverse">Cadastrar</a>
                </div>
                <% FuncaoController funcao = new FuncaoController();%>
                <table class="table table-hover">
                    <tr>
                        <th>C&oacute;digo</th>
                        <th>Modulo</th>
                        <th>Formul&aacute;rio</th>
                        <th>Nome</th>
                        <th>Descri&ccedil;&atilde;o</th>
                        <th style="text-align: center;">&spadesuit;</th>
                    </tr>
                    <% for (Funcao funcaoList : funcao.listar()) {%>
                    <tr>
                        <td><%= funcaoList.getCodigoFuncao() %></td>
                        <td><%= funcaoList.getNomeModulo() %></td>
                        <td><%= funcaoList.getNomeFormulario() %></td>
                        <td><%= funcaoList.getNome() %></td>
                        <td><%= funcaoList.getDescricao() %></td>
                        <td style="text-align: center;">
                            <a href=<%="funcao_edit.jsp?codigoFuncao="+funcaoList.getCodigoFuncao()%> class="btn btn-warning">Editar</a>
                            <a href=<%="funcao_excl.jsp?codigoFuncao="+funcaoList.getCodigoFuncao()%> class="btn btn-danger">Excuir</a>
                        </td>
                    </tr>
                    <%}%>
                </table>
            </article>
            <%@include file="/view/footer.jsp" %>
        </div>
    </body>
</html>