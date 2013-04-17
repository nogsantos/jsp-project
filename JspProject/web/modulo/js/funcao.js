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
       codigoFuncao = jQuery("#codigoFuncao"),
       nome = jQuery("#nome"),
       descricao = jQuery("#descricao");
       
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
           erro += "- Codigo Modulo\n ";
       }
       if(codigoFormulario.val() === ""){
           erro += "- Codigo Formulario\n ";
       }
       if(codigoFuncao.val() === ""){
           erro += "- Codigo Função\n ";
       }
       if(nome.val() === ""){
           erro += "- Nome\n";
       }
       if(descricao.val() === ""){
           erro += "- Descricao\n";
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
   /*
    * 
    */
   codigoModulo.change(function(){
       if(jQuery(this).val() !== ""){
            codigoFormulario.removeAttr("disabled");
            formularioAjax(jQuery(this).val());
       }else{
            codigoFormulario.prop("disabled", "disabled").empty();
       }
   });
   /*
    * Ajax, Preenche o select de formulários de acordo com o módulo escolhido.
    */
   function formularioAjax(iCodigoModulo){
       var opt = "",
           load = jQuery("#ajax-load");
       load.show();
       jQuery.post("FuncaoController",{
            action: "consultarFormularios",
            codigo_modulo : iCodigoModulo
        }, function(formularios){
            load.hide();
            if(formularios.length > 0){
                codigoFormulario.empty();
                jQuery.each(formularios, function(indice,valores){
                    opt += '<option value="'+valores.codigoFormulario+'">'+valores.nome+'</option>';
                });
                codigoFormulario.append(opt);
            }else{
                codigoFormulario.empty();
                opt = "";
                codigoFormulario.append(opt);
                codigoFormulario.prop("disabled", "disabled").empty();
            }
        }, "json");
   }
});