<%
    String moduloMenu      = "/JspProject/modulo";
    String pessoaMenu      = "/JspProject/pessoa";
    String permissaoMenu   = "/JspProject/permissao";
    String homeActive      = "";
    String moduloActive    = "";
    String pessoaActive    = "";
    String permissaoActive = "";
    
    if(modulo.equals("jspProject")){
        moduloMenu      = "modulo";
        pessoaMenu      = "pessoa";
        permissaoMenu   = "permissao";
        homeActive      = "active";
        moduloActive    = "";
        pessoaActive    = "";
        permissaoActive = "";
    }else if(modulo.equals("modulo")){
        homeActive      = "";
        moduloActive    = "active";
        pessoaActive    = "";
        permissaoActive = "";
    }else if(modulo.equals("pessoa")){
        homeActive      = "";
        moduloActive    = "";
        pessoaActive    = "active";
        permissaoActive = "";
    }else if(modulo.equals("permissao")){
        homeActive      = "";
        moduloActive    = "";
        pessoaActive    = "";
        permissaoActive = "active";
    }
%>
<nav>
    <div class="navbar">
        <div class="navbar-inner">
            <div class="container">
                <a class="btn btn-navbar" data-toggle="collapse" data-target=".navbar-responsive-collapse">
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </a>
                <a class="brand" href="#">JspProject</a>
                <div class="nav-collapse collapse navbar-responsive-collapse">
                    <ul class="nav">
                        <li class=<%= homeActive %>><a href="/JspProject">Home</a></li>
                        <li class= <%= moduloActive +" dropdown"%>>
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown">Modulos<b class="caret"></b></a>
                            <ul class="dropdown-menu">
                                <li class="nav-header">Modulos</li>
                                <li><a href=<%= moduloMenu + "/modulo_cad.jsp" %>>Cadastrar Modulo</a></li>
                                <li><a href=<%= moduloMenu + "/modulo.jsp" %>>Listagem de Modulo</a></li>
                                <li class="divider"></li>
                                <li class="nav-header">Formul&aacute;rios</li>
                                <li><a href=<%= moduloMenu + "/formulario_cad.jsp" %>>Cadastrar Formul&aacute;rio</a></li>
                                <li><a href=<%= moduloMenu + "/formulario.jsp" %>>Listagem de Formul&aacute;rio</a></li>
                                <li class="divider"></li>
                                <li class="nav-header">Fun&ccedil;&otilde;es</li>
                                <li><a href=<%= moduloMenu + "/funcao_cad.jsp" %>>Cadastrar Fun&ccedil;&atilde;o</a></li>
                                <li><a href=<%= moduloMenu + "/funcao.jsp" %>>Listagem de Fun&ccedil;&atilde;o</a></li>
                            </ul>
                        </li>
                        <li class= <%= pessoaActive +" dropdown"%>>
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown">Pessoas <b class="caret"></b></a>
                            <ul class="dropdown-menu">
                                <li class="nav-header">Usu&aacute;rios</li>
                                <li><a href=<%= pessoaMenu + "/usuario_cad.jsp" %>>Cadastrar Usu&aacute;rio </a></li>
                                <li><a href=<%= pessoaMenu + "/usuario.jsp" %>>Listagem Usu&aacute;rio </a></li>
                            </ul>
                        </li>
                        <li class= <%= permissaoActive +" dropdown"%>>
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown">Permiss&otilde;es <b class="caret"></b></a>
                            <ul class="dropdown-menu">
                                <li><a href=<%= permissaoMenu + "/permissao_cad.jsp" %>>Cadastrar Permiss&atilde;o </a></li>
                                <li><a href=<%= permissaoMenu + "/permissao.jsp" %>>Listagem Permiss&atilde;o </a></li>
                            </ul>
                        </li>
                    </ul>
                </div>
            </div>
        </div>
    </div>
</nav>