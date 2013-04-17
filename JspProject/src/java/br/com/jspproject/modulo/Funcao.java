/**
 *
 * Descrição:Classe Funcao
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


public class Funcao {

    private Integer codigoFuncao;
    private Integer codigoFormulario;
    private Integer codigoModulo;
    private String nomeFormulario;
    private String nomeModulo;
    private String nome;
    private String descricao;

    public Integer getCodigoFuncao() {
        return codigoFuncao;
    }

    public Integer getCodigoModulo() {
        return codigoModulo;
    }

    public void setCodigoModulo(Integer codigoModulo) {
        this.codigoModulo = codigoModulo;
    }
    public void setCodigoFuncao(Integer codigoFuncao) {
        this.codigoFuncao = codigoFuncao;
    }

    public Integer getCodigoFormulario() {
        return codigoFormulario;
    }

    public void setCodigoFormulario(Integer codigoFormulario) {
        this.codigoFormulario = codigoFormulario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getNomeFormulario() {
        return nomeFormulario;
    }

    public void setNomeFormulario(String nomeFormulario) {
        this.nomeFormulario = nomeFormulario;
    }

    public String getNomeModulo() {
        return nomeModulo;
    }

    public void setNomeModulo(String nomeModulo) {
        this.nomeModulo = nomeModulo;
    }
}
