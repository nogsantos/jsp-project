jQuery(function(){
   var actionModal = jQuery("#actionModal"),
       btSalvarModal = jQuery("#btSalvarModal"),
       codigoModuloModal = jQuery("#codigoModuloModal"),
       nomeModal = jQuery("#nomeModal"),
       descricaoModal = jQuery("#descricaoModal"),
       ordemModal = jQuery("#ordemModal"),
       btCancelarModal = jQuery("#btCancelarModal");
   
   btSalvarModal.click(function(){
        actionModal.val("cadastrar");
        validaSubmict();
   });
   btCancelarModal.click(function(){
        actionModal.val("cancelar");
        documentSubmit();
   });
   function validaSubmict(){
       var erro = "";
       if(codigoModuloModal.val() === ""){
           erro += "- Codigo\n ";
       }
       if(nomeModal.val() === ""){
           erro += "- Nome\n";
       }
       if(descricaoModal.val() === ""){
           erro += "- Descricao\n";
       }
       if(ordemModal.val() === ""){
           erro += "- Ordem\n";
       }
       if(erro !== ""){
            alert("Erro encontrados campos vazios\n" + erro);
            return false;
       }else{
           documentSubmit();
       }
   }
   function documentSubmit(){
       jQuery("#formModal").submit();
   }
});