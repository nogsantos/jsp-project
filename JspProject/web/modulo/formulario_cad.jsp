<%@page import="br.com.jspproject.modulo.FormularioDAO"%>
<%@page import="br.com.jspproject.modulo.ModuloDAO"%>
<%@page import="br.com.jspproject.modulo.Modulo"%>
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
                    <h1>Cadastro de formul&aacute;rio</h1>
                </div>
                <form action="FormularioController" name="form" id="form" method="POST">
                    <% 
                        FormularioDAO formulario = new FormularioDAO();
                        ModuloDAO modulo         = new ModuloDAO();
                    %>
                    <input type="hidden" name="action" id="action" value="" />
                    <input type="hidden" name="codigoFormulario" id="codigoFormulario" value="<%= formulario.formularioNextVal() %>" />
                    <div>
                        <div style="position: relative;float:right;padding-top: 22px;">
                            <a data-toggle="modal" href="modulo_cad_modal.jsp" data-target="#cadModuloAux" class="btn btn-large" id="btCadAux" title="Cadastrar um novo Modulo"><i class="icon-plus"></i></a>
                        </div>
                        <div style="position: relative;width: 95%;">
                            <label for="codigoModulo">Modulo</label>
                            <select name="codigoModulo" id="codigoModulo">
                                <option value=""></option>
                                <% for(Modulo moduloList : modulo.listagemSimples()) { %>
                                <option value="<%= moduloList.getCodigoModulo() %>"><%= moduloList.getNome() %></option>
                                <% } %>
                            </select>
                        </div>
                    </div>
                    <div>
                        <label for="nome">Nome</label>
                        <input type="text" name="nome" id="nome" autocomplete="off" maxlength="250" />
                    </div>
                    <div>
                        <label for="nomeMenu">Nome Menu</label>
                        <input type="text" name="nomeMenu" id="nomeMenu" autocomplete="off" maxlength="20" />
                    </div>
                    <div>
                        <label for="descricao">Descri&ccedil;&atilde;o</label>
                        <textarea name="descricao" id="descricao" maxlength="550"></textarea>
                    </div>
                    <div>
                        <label for="ordem">Ordem</label>
                        <input type="text" name="ordem" id="ordem" autocomplete="off" class="number number-only" />
                    </div>
                    <div>
                        Formul&aacute;rio Oculto: 
                        <label class="checkbox inline">
                            <input type="radio" name="flagOculto" id="sim" value="t" /> Sim
                        </label>
                        <label class="checkbox inline">
                            <input type="radio" name="flagOculto" id="nao" value="f" checked="checked" /> N&atilde;o
                        </label>
                    </div>
                    <br /><br />
                    <div class="well well-large">
                        <input type="button" class="btn btn-large" id="btCancelar" value="Cancelar" />
                        <input type="button" class="btn btn-large btn-primary" id="btSalvar" value="Salvar altera&ccedil;&otilde;es" />
                    </div>
                </form>
            </article>
            <%@include file="/view/footer.jsp" %>
        </div>
        <!-- Modal -->
        <div id="cadModuloAux" class="modal hide fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
          <div class="modal-header">
            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
            <h3 id="myModalLabel">Cadastro de Modulo</h3>
          </div>
          <div class="modal-body"></div>
        </div>
    </body>
</html>