/*
 /**
  * Script formulário modulo.
  * 
  */
jQuery(function(){
   var actionModal = jQuery("#actionModal"),
       btSalvarModal = jQuery("#btSalvarModal"),
       btEditarModal = jQuery("#btEditarModal"),
       btExcluirModal = jQuery("#btExcluirModal"),
       divNomeModal = jQuery("#divNomeModal"),
       helpNomeModal = jQuery("#helpNomeModal"),
       divDescricaoModal = jQuery("#divDescricaoModal"),
       helpDescricaoModal = jQuery("#helpDescricaoModal"),
       divOrdemModal = jQuery("#divOrdemModal"),
       helpOrdemModal = jQuery("#helpOrdemModal"),
       codigoModuloModal = jQuery("#codigoModuloModal"),
       nomeModal = jQuery("#nomeModal"),
       descricaoModal = jQuery("#descricaoModal"),
       ordemModal = jQuery("#ordemModal"),
       btCancelarModal = jQuery("#btCancelarModal"),
       formModal = jQuery("#formModal");
       
   btSalvarModal.click(function(){
        actionModal.val("cadastrar");
        validaSubmict();
   });
   btEditarModal.click(function(){
        actionModal.val("editar");
        validaSubmict();
   });
   btExcluirModal.click(function(){
        actionModal.val("excluir");
        documentSubmit(formModal);
   });
   btCancelarModal.click(function(){
        actionModal.val("cancelar");
        documentSubmit(formModal);
   });
   /*
    * Valida a submissão do formulário.
    */
   function validaSubmict(){
       var erro = "";
       errorHelp(divNomeModal, helpNomeModal,"remove");
       errorHelp(divDescricaoModal, helpDescricaoModal, "remove");
       errorHelp(divOrdemModal, helpOrdemModal, "remove");
       if(codigoModuloModal.val() === ""){
           erro += "- Codigo\n";
       }
       if(jQuery.trim(nomeModal.val()) === ""){
            erro += "- Nome\n";
            errorHelp(divNomeModal, helpNomeModal,"add");
       }
       if(jQuery.trim(descricaoModal.val()) === ""){
            erro += "- Descricao\n";
            errorHelp(divDescricaoModal, helpDescricaoModal,"add");
       }
       if(jQuery.trim(ordemModal.val()) === ""){
            erro += "- Ordem\n";
            errorHelp(divOrdemModal, helpOrdemModal,"add");
       }
       if(erro !== ""){
            return false;
       }else{
            documentSubmit(formModal);
       }
   }
});