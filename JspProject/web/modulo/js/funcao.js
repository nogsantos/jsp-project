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
       divCodigoFormulario = jQuery("#divCodigoFormulario"),
       helpCodigoFormulario = jQuery("#helpCodigoFormulario"),
       divNome = jQuery("#divNome"),
       helpNome = jQuery("#helpNome"),
       divDescricao = jQuery("#divDescricao"),
       helpDescricao = jQuery("#helpDescricao"),
       codigoFormulario = jQuery("#codigoFormulario"),
       codigoModulo = jQuery("#codigoModulo"),
       codigoFuncao = jQuery("#codigoFuncao"),
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
   function validaSubmict(){
       var erro = "";
       errorHelp(divCodigoModulo, helpCodigoModulo,"remove");
       errorHelp(divCodigoFormulario, helpCodigoFormulario, "remove");
       errorHelp(divNome, helpNome,"remove");
       if(codigoFuncao.val() === ""){
           erro += "- Codigo Função\n ";
       }
       if(jQuery.trim(codigoModulo.val()) === ""){
           erro += "- Codigo Modulo\n ";
           errorHelp(divCodigoModulo, helpCodigoModulo,"add");
       }
       if(jQuery.trim(codigoFormulario.val()) === ""){
           erro += "- Codigo Formulario\n ";
           errorHelp(divCodigoFormulario, helpCodigoFormulario, "add");
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