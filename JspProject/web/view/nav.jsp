<%
    String moduloMenu = "";
    String homeActive = "";
    String moduloActive = "";
    if(modulo.equals("jspProject")){
        moduloMenu = "modulo";
        homeActive = "active";
        moduloActive = "";
    }else if(modulo.equals("modulo")){
        moduloMenu = "/JspProject/modulo";
        homeActive = "";
        moduloActive = "active";
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
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown">Modulo <b class="caret"></b></a>
                            <ul class="dropdown-menu">
                                <li><a href=<%= moduloMenu + "/cadastro.jsp" %>>Cadastrar</a></li>
                                <li><a href=<%= moduloMenu + "/modulo.jsp" %>>Listagem</a></li>
                            </ul>
                        </li>
                    </ul>
                </div>
            </div>
        </div>
    </div>
</nav>