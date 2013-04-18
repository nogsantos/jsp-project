jQuery(function(){
    var action = jQuery("#action"),
        btSalvar = jQuery("#btSalvar"),
        btEditar = jQuery("#btEditar"),
        btExcluir = jQuery("#btExcluir"),
        btCancelar = jQuery("#btCancelar"),
        codigoPessoa = jQuery("#codigoPessoa"),
        nome = jQuery("#nome"),
        logradouro = jQuery("#logradouro"),
        email = jQuery("#email"),
        telefone = jQuery("#telefone"),
        login = jQuery("#login"),
        senha = jQuery("#senha"),
        selPerfilDisponiveis = jQuery("#selPerfilDisponiveis"),
        selPerfis = jQuery("#selPerfis"),
        btRemove = jQuery("#btRemove"),
        btAdd = jQuery("#btAdd"),
        form = jQuery("#form");
    /*
     * 
     */    
    btSalvar.click(function() {
        action.val("cadastrar");
        validaSubmict();
    });
    btEditar.click(function() {
        action.val("editar");
        validaSubmict();
    });
    btExcluir.click(function() {
        action.val("excluir");
        documentSubmit();
    });
    btCancelar.click(function() {
        action.val("cancelar");
        documentSubmit();
    });
    function validaSubmict() {
        var erro = "";
        if (jQuery.trim(codigoPessoa.val()) === "") {
            erro += "- Codigo Identificador\n";
        }
        if (jQuery.trim(nome.val()) === "") {
            erro += "- Nome\n";
        }
        if (jQuery.trim(login.val()) === "") {
            erro += "- Login\n";
        }
        if (jQuery.trim(senha.val()) === "") {
            erro += "- Senha\n";
        }
        if (erro !== "") {
            alert("Erro encontrados campos vazios\n" + erro);
            return false;
        } else {
            documentSubmit();
        }
    }
    function documentSubmit() {
        form.submit();
    }        
    /*
     * Tabs
     */
    jQuery('#myTab a').click(function(e) {
        e.preventDefault();
        jQuery(this).tab('show');
    });
    /*
     * Selects
     */
    jQuery().ready(function() {
        btAdd.click(function() {
            return !jQuery('#selPerfilDisponiveis option:selected').remove().appendTo(selPerfis);
        });
        btRemove.click(function() {
            return !jQuery('#selPerfis option:selected').remove().appendTo(selPerfilDisponiveis);
        });
    });  
});