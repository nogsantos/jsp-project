<%@ page info=" 
    Document   : index
    Created on : 09-Apr-2013, 10:17:50
    Author     : Fabricio Nogueira
    "
%>
<%-- 
Controla o uso dos buffers de saída da página JSP. 
Se o valor for “none” então não existirão buffers e a
saída será escrita diretamente no PrintWriter
apropriado. Por padrão o valor é de 8kb.
--%>
<%@ page buffer="none" %>
<%-- 
Quando atribuído true esvazia o buffer de saída logo
quando ele ficar cheio.
--%>
<%@ page autoFlush="true" %>
<%-- 
Define qual a pagina que será usada para tratar os
erros, deve ser um endereço URL para uma página de erro
--%>
<%! private int accessCount = 0;%>
<%! private String modulo = "jspProject"; %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style type="text/css" media="screen">@import url(css/default.css);</style>
        <style type="text/css" media="screen">@import url(css/bootstrap.min.css);</style>
        <style type="text/css" media="screen">@import url(css/bootstrap-responsive.min.css);</style>
        <script type="text/javascript" src="js/jquery-1.9.1.min.js"></script>
        <script type="text/javascript" src="js/bootstrap.min.js"></script>
        <script type="text/javascript" src="js/script.js"></script>
    </head>
    <body>
        <div class="container">
            <% accessCount++;%>
            <%@include file="/view/header.jsp" %> 
            <%@include file="/view/nav.jsp" %>
            <article>
                <div class="hero-unit">
                    <h1>Bem vindo ao sistema!</h1>
                    <p>JspProject</p>
                    <div class="alert alert-info">
                        <strong>Fabricio Nogueira.</strong> Introdução a java web jsp com servlets.
                    </div>
                </div>
            </article>
            <%@include file="/view/footer.jsp" %>
        </div>
    </body>
</html>