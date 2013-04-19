/*
 * 
 * Formulário
 * 
 */
jQuery(function(){
   var action = jQuery("#action"),
       btSalvar = jQuery("#btSalvar"),
       btEditar = jQuery("#btEditar"),
       btExcluir = jQuery("#btExcluir"),
       btCancelar = jQuery("#btCancelar"),
       divCodigoModulo = jQuery("#divCodigoModulo"),
       helpCodigoModulo = jQuery("#helpCodigoModulo"),
       divNome = jQuery("#divNome"),
       helpNome = jQuery("#helpNome"),
       divNomeMenu = jQuery("#divNomeMenu"),
       helpNomeMenu = jQuery("#helpNomeMenu"),
       divDescricao = jQuery("#divDescricao"),
       helpDescricao = jQuery("#helpDescricao"),
       divOrdem = jQuery("#divOrdem"),
       helpOrdem = jQuery("#helpOrdem"),
       codigoFormulario = jQuery("#codigoFormulario"),
       codigoModulo = jQuery("#codigoModulo"),
       nome = jQuery("#nome"),
       nomeMenu = jQuery("#nomeMenu"),
       descricao = jQuery("#descricao"),
       ordem = jQuery("#ordem"),
       form = jQuery("#form");
       
   btSalvar.click(function(){
        action.val("cadastrar");
        validaSubmict();
   });
   btEditar.click(function(){
        action.val("editar");
        validaSubmict();
   });
   btExcluir.click(function(){
        action.val("excluir");
        documentSubmit(form);
   });
   btCancelar.click(function(){
        action.val("cancelar");
        documentSubmit(form);
   });
   function validaSubmict(){
       var erro = "";
       errorHelp(divCodigoModulo, helpCodigoModulo,"remove");
       errorHelp(divNome, helpNome,"remove");
       errorHelp(divNomeMenu, helpNomeMenu, "remove");
       errorHelp(divDescricao, helpDescricao, "remove");
       errorHelp(divOrdem, helpOrdem, "remove");
       if(codigoFormulario.val() === "" ){
           erro += "- Codigo Formulario\n";
       }
       if(codigoModulo.val() === "" ){
           erro += "- Codigo Modulo\n";
           errorHelp(divCodigoModulo, helpCodigoModulo,"add");
       }
       if(jQuery.trim(nome.val()) === ""){
           erro += "- Nome\n";
           errorHelp(divNome, helpNome,"add");
       }
       if(jQuery.trim(nomeMenu.val()) === ""){
           erro += "- Nome Menu\n";
           errorHelp(divNomeMenu, helpNomeMenu, "add");
       }
       if(jQuery.trim(descricao.val()) === ""){
           erro += "- Descricao\n";
           errorHelp(divDescricao, helpDescricao, "add");
       }
       if(jQuery.trim(ordem.val()) === ""){
           erro += "- Ordem\n";
           errorHelp(divOrdem, helpOrdem, "add");
       }
       if(erro !== ""){
            return false;
       }else{
           documentSubmit(form);
       }
   }
});