jQuery(function(){
    var action = jQuery("#action"),
        btSalvar = jQuery("#btSalvar"),
        btEditar = jQuery("#btEditar"),
        btExcluir = jQuery("#btExcluir"),
        btCancelar = jQuery("#btCancelar"),
        btRemove = jQuery("#btRemove"),
        btAdd = jQuery("#btAdd"),
        divCodigoPessoa = jQuery("#divCodigoPessoa"),
        helpCodigoPessoa = jQuery("#helpCodigoPessoa"),
        divNome = jQuery("#divNome"),
        helpNome = jQuery("#helpNome"),
        divLogin = jQuery("#divLogin"),
        helpLogin = jQuery("#helpLogin"),
        divSenha = jQuery("#divSenha"),
        helpSenha = jQuery("#helpSenha"),
        codigoPessoa = jQuery("#codigoPessoa"),
        nome = jQuery("#nome"),
        logradouro = jQuery("#logradouro"),
        email = jQuery("#email"),
        telefone = jQuery("#telefone"),
        login = jQuery("#login"),
        senha = jQuery("#senha"),
        selPerfilDisponiveis = jQuery("#selPerfilDisponiveis"),
        selPerfis = jQuery("#selPerfis"),
        divAlerta = jQuery("#divAlerta"),
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
        documentSubmit(form);
    });
    btCancelar.click(function() {
        action.val("cancelar");
        documentSubmit(form);
    });
    function validaSubmict() {
        var erro = "";
        errorHelp(divCodigoPessoa, helpCodigoPessoa,"remove");
        errorHelp(divNome, helpNome,"remove");
        errorHelp(divLogin, helpLogin,"remove");
        errorHelp(divSenha, helpSenha,"remove");
        divAlerta.hide();
        if (jQuery.trim(codigoPessoa.val()) === "") {
            erro += "- Codigo Identificador\n";
            errorHelp(divCodigoPessoa, helpCodigoPessoa,"add");
        }
        if (jQuery.trim(nome.val()) === "") {
            erro += "- Nome\n";
            errorHelp(divNome, helpNome,"add");
        }
        if (jQuery.trim(login.val()) === "") {
            erro += "- Login\n";
            errorHelp(divLogin, helpLogin,"add");
        }
        if (jQuery.trim(senha.val()) === "") {
            erro += "- Senha\n";
            errorHelp(divSenha, helpSenha,"add");
        }
        if (erro !== "") {
            divAlerta.show();
            return false;
        } else {
            documentSubmit(form);
        }
    }
    /*
     * Tabs
     */
    jQuery('#myTab a').click(function(e) {
        e.preventDefault();
        jQuery(this).tab('show');
    });
    /*
     * Multi Selects
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