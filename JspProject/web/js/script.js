/* 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
jQuery(function() {
    /*
     * Somente números em campos texto
     */
    jQuery('.number-only').keydown(function(event) {
        var tecla = (window.event) ? event.keyCode : event.which;
        if ((tecla > 47 && tecla < 58 || tecla >= 96 && tecla <= 105))
            return true;
        else {
            if (tecla !== 8)
                return false;
            else
                return true;
        }
    });
});

