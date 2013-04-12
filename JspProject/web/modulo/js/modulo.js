jQuery(function(){
   var action = jQuery("#action"),
       btSalvar = jQuery("#btSalvar"),
       btEditar = jQuery("#btEditar"),
       btExcluir = jQuery("#btExcluir"),
       codigoModulo = jQuery("#codigoModulo"),
       nome = jQuery("#nome"),
       descricao = jQuery("#descricao"),
       ordem = jQuery("#ordem"),
       btCancelar = jQuery("#btCancelar");
       
   btSalvar.click(function(){
        action.val("salvar");
        validaSubmict();
   });
   btEditar.click(function(){
        action.val("editar");
        validaSubmict();
   });
   btExcluir.click(function(){
        action.val("excluir");
        documentSubmit();
   });
   btCancelar.click(function(){
        action.val("cancelar");
        documentSubmit();
   });
   function validaSubmict(){
       var erro = "";
       if(codigoModulo.val() === ""){
           erro += "- Codigo\n ";
       }
       if(nome.val() === ""){
           erro += "- Nome\n";
       }
       if(descricao.val() === ""){
           erro += "- Descricao\n";
       }
       if(ordem.val() === ""){
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
        document.form.submit();
   }
});