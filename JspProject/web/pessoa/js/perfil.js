 /**
  * Script modulo.
  * 
  */
jQuery(function(){
   var action = jQuery("#action"),
       btSalvar = jQuery("#btSalvar"),
       btEditar = jQuery("#btEditar"),
       btExcluir = jQuery("#btExcluir"),
       btCancelar = jQuery("#btCancelar"),
       divNome = jQuery("#divNome"),
       helpNome = jQuery("#helpNome"),
       divDescricao = jQuery("#divDescricao"),
       codigoPerfil = jQuery("#codigoPerfil"),
       nome = jQuery("#nome"),
       descricao = jQuery("#descricao"),
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
       if(codigoPerfil.val() === ""){
           erro += "- Codigo\n";
       }
       if(jQuery.trim(nome.val()) === ""){
            erro += "- Nome\n";
            errorHelp(divNome, helpNome,"add");
       }
       if(erro !== ""){
            return false;
       }else{
            documentSubmit(form);
       }
   }
});