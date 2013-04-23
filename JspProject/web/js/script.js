/* 
 * Defaults js
 */
jQuery(function() {
    /*
     * Somente números em campos texto
     */
    jQuery('.number-only').keydown(function(event) {
        var tecla = (window.event) ? event.keyCode : event.which;
        if ((tecla > 47 && tecla < 58)    || 
            (tecla >= 96 && tecla <= 105) || 
            (tecla === 9 || tecla === 0))
            return true;
        else {
            if (tecla !== 8)
                return false;
            else
                return true;
        }
    });
});
/*
 * Adiciona ou remove erros nos campos obrigatórios.
 * 
 * @param obj div
 * @param obj help
 * @param string tipo (add, remove)
 */
function errorHelp(div, help, tipo){
    if(tipo === "add"){
         div.addClass("error");
         help.show();
    }else if( tipo === "remove"){
         div.removeClass("error");
         help.hide();
    }
}
/*
* Envia o formulário.
*/
function documentSubmit(formulario){
     formulario.submit();
}

