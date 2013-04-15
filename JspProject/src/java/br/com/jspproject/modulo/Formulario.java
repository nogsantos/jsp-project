/**
 *
 * Descrição:Classe Formulario
 *
 *
 * @author Fabricio Nogueira
 *
 * @since 15-Apr-2013
 *
 * @version 1.0.0
 *
 */

package br.com.jspproject.modulo;


public class Formulario {

    private Integer codigoFormulario;
    private Integer codigoModulo;
    private String nomeModulo;
    private String nome;
    private String nomeMenu;
    private String descricao;
    private int ordem;
    private String flagOculto;

    public String getNomeModulo() {
        return nomeModulo;
    }

    public void setNomeModulo(String nomeModulo) {
        this.nomeModulo = nomeModulo;
    }
    public Integer getCodigoFormulario() {
        return codigoFormulario;
    }

    public void setCodigoFormulario(Integer codigoFormulario) {
        this.codigoFormulario = codigoFormulario;
    }

    public Integer getCodigoModulo() {
        return codigoModulo;
    }

    public void setCodigoModulo(Integer codigoModulo) {
        this.codigoModulo = codigoModulo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNomeMenu() {
        return nomeMenu;
    }

    public void setNomeMenu(String nomeMenu) {
        this.nomeMenu = nomeMenu;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getOrdem() {
        return ordem;
    }

    public void setOrdem(int ordem) {
        this.ordem = ordem;
    }

    public String getFlagOculto() {
        return flagOculto;
    }

    public void setFlagOculto(String flagOculto) {
        this.flagOculto = flagOculto;
    }
}
