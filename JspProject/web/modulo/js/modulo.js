 /**
  * Script modulo.
  * 
  */
jQuery(function(){
   var action = jQuery("#action"),
       btSalvar = jQuery("#btSalvar"),
       btEditar = jQuery("#btEditar"),
       btExcluir = jQuery("#btExcluir"),
       divNome = jQuery("#divNome"),
       helpNome = jQuery("#helpNome"),
       divDescricao = jQuery("#divDescricao"),
       helpDescricao = jQuery("#helpDescricao"),
       divOrdem = jQuery("#divOrdem"),
       helpOrdem = jQuery("#helpOrdem"),
       codigoModulo = jQuery("#codigoModulo"),
       nome = jQuery("#nome"),
       descricao = jQuery("#descricao"),
       ordem = jQuery("#ordem"),
       btCancelar = jQuery("#btCancelar"),
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
   /*
    * Valida a submissão do formulário.
    */
   function validaSubmict(){
       var erro = "";
       errorHelp(divNome, helpNome,"remove");
       errorHelp(divDescricao, helpDescricao, "remove");
       errorHelp(divOrdem, helpOrdem, "remove");
       if(codigoModulo.val() === ""){
           erro += "- Codigo\n";
       }
       if(jQuery.trim(nome.val()) === ""){
            erro += "- Nome\n";
            errorHelp(divNome, helpNome,"add");
       }
       if(jQuery.trim(descricao.val()) === ""){
            erro += "- Descricao\n";
            errorHelp(divDescricao, helpDescricao,"add");
       }
       if(jQuery.trim(ordem.val()) === ""){
            erro += "- Ordem\n";
            errorHelp(divOrdem, helpOrdem,"add");
       }
       if(erro !== ""){
            return false;
       }else{
            documentSubmit(form);
       }
   }
});