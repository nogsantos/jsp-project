/**
 *
 * Descrição:Classe Perfil
 *
 *
 * @author Fabricio Nogueira
 *
 * @since 19-Apr-2013
 *
 * @version 1.0.0
 *
 */

package br.com.jspproject.pessoa;


public class Perfil {

    private Integer codigoPerfil;
    private String nome;
    private String descricao;

    public Integer getCodigoPerfil() {
        return codigoPerfil;
    }

    public void setCodigoPerfil(Integer codigoPerfil) {
        this.codigoPerfil = codigoPerfil;
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
}
