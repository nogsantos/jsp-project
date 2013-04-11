/**
 *
 * Descrição:Classe Modulo
 *
 *
 * @author Fabricio Nogueira
 *
 * @since 10-Apr-2013
 *
 * @version 1.0.0
 *
 */

package br.com.jspproject.modulo;


public class Modulo {

    private Integer codigoModulo;
    private String nome;
    private String descricao;
    private Integer ordem;

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

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Integer getOrdem() {
        return ordem;
    }

    public void setOrdem(Integer ordem) {
        this.ordem = ordem;
    }
}
