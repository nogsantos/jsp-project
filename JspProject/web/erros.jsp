<%@ page info=" 
        Documento : errors
        Autor     : Fabricio Nogueira
        Criado em : 10-Apr-2013, 14:04:15
"%>

<%@page isErrorPage="true"%>
<%! private int accessCount = 0;%>
<%! private String modulo = ""; %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Erros</title>
        <style type="text/css" media="screen">@import url(../css/default.css);</style>
        <style type="text/css" media="screen">@import url(../css/bootstrap.min.css);</style>
        <style type="text/css" media="screen">@import url(../css/bootstrap-responsive.min.css);</style>
        <script type="text/javascript" src="../js/jquery-1.9.1.min.js"></script>
        <script type="text/javascript" src="../js/bootstrap.min.js"></script>
        <script type="text/javascript" src="../js/script.js"></script>
    </head>
    <body>
        <% accessCount++;%>
         <div class="container">
            <%@include file="/view/nav.jsp" %>
            <article>
                <h1>Erro!</h1>
            </article>
            <%@include file="/view/footer.jsp" %>
        </div>
    </body>
</html>
