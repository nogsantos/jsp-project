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
       codigoFormulario = jQuery("#codigoFormulario"),
       codigoModulo = jQuery("#codigoModulo"),
       nome = jQuery("#nome"),
       nomeMenu = jQuery("#nomeMenu"),
       descricao = jQuery("#descricao"),
       ordem = jQuery("#ordem");
       
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
        documentSubmit();
   });
   btCancelar.click(function(){
        action.val("cancelar");
        documentSubmit();
   });
   function validaSubmict(){
       var erro = "";
       if(codigoModulo.val() === ""){
           erro += "- Codigo Modulo\n";
       }
       if(codigoFormulario.val() === ""){
           erro += "- Codigo Formulario\n";
       }
       if(nome.val() === ""){
           erro += "- Nome\n";
       }
       if(nomeMenu.val() === ""){
           erro += "- Nome Menu\n";
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
        jQuery("#form").submit();
   }
});