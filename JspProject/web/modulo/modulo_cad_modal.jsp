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
        <script type="text/javascript" src="js/modulo-modal.js"></script>
        <script type="text/javascript" src="../js/script.js"></script>
    </head>
    <body>
        <article>
            <form action="ModuloServlet" name="form" id="formModal" method="POST">
                <input type="hidden" name="action" id="actionModal" value="" />
                <input type="hidden" name="modal_form" id="modal_form" value="formulario_cad" />
                <% ModuloDAO modulo = new ModuloDAO();%>
                <input type="hidden" name="codigoModulo" id="codigoModuloModal" value="<%= modulo.moduloNextVal() %>" />
                <label for="nome">Nome</label>
                <input type="text" name="nome" id="nomeModal" autocomplete="off" maxlength="250" value="" />
                <label for="descricao">Descri&ccedil;&atilde;o</label>
                <textarea name="descricao" id="descricao" maxlength="550"></textarea>
                <label for="ordem">Ordem</label>
                <input type="text" name="ordem" id="ordemModal" autocomplete="off" value="" class="number number-only" />
                <div class="well well-large">
                    <input type="button" class="btn btn-large" id="btCancelarModal" data-dismiss="modal" aria-hidden="true" value="Cancelar" />
                    <input type="button" class="btn btn-large btn-primary" id="btSalvarModal" value="Salvar altera&ccedil;&otilde;es" />
                </div>
            </form>
        </article>
    </body>
</html>
<%@page import="br.com.jspproject.modulo.ModuloDAO"%>