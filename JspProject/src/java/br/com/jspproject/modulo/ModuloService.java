/**
 *
 * Descrição:Classe ModuloService
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

import java.sql.SQLException;
import java.util.List;


public class ModuloService {

     /*
     * Instância da implementação DAO do módulo.
     */
    private ModuloDAO moduloData = new ModuloDAO();
    private Modulo modulo         = new Modulo();
    /**
     * Sobrecarga no Construtor
     * @param null
     */
    public ModuloService() {}
    /**
     * Sobrecarga Construtor 
     * Apenas código como parametro.
     * 
     * @param Integer Codigo perfil
     */
    public ModuloService(Integer codigoModulo) {
        this.modulo.setCodigoModulo(codigoModulo);
    }
    /**
     * Sobrecarga Construtor 
     * Todos os parametros.
     * 
     * @param Integer codigoPerfil
     * @param String nome
     * @param String descricao
     * @param int ordem
     */
    public ModuloService(Integer codigoModulo, String nome, 
            String descricao, int ordem) {
        this.modulo.setCodigoModulo(codigoModulo);
        this.modulo.setDescricao(descricao);
        this.modulo.setNome(nome);
        this.modulo.setOrdem(ordem);
    }
    /**
     * Serviço para cadastro dos dados.
     * 
     * @author Fabricio Nogueira
     * @version 1.0.0
     * @since 25-Mar-2013
     * @return void
     *
     */
    public String cadastrar(){
        try {
            return this.moduloData.cadastrar(this.modulo);
        } catch (SQLException ex) {
            return ex.getSQLState();
        }
    }
    /**
     * Serviço para edição dos dados.
     * 
     * @author Fabricio Nogueira
     * @version 1.0.0
     * @since 25-Mar-2013
     * @return boolean
     *
     */
    public String editar(){
        try {
            return this.moduloData.editar(this.modulo);
        } catch (SQLException ex) {
            return ex.getSQLState();
        }
    }
    /**
     * Serviço para exclusão dos dados.
     * 
     * @author Fabricio Nogueira
     * @version 1.0.0
     * @since 25-Mar-2013
     * @return void
     *
     */
    public String excluir(){
        try {
            return this.moduloData.excluir(this.modulo);
        } catch (SQLException e) {
            return e.getSQLState();
        }
    }
    /**
     * Serviço para listagem dos dados.
     * 
     * @author Fabricio Nogueira
     * @version 1.0.0
     * @since 25-Mar-2013
     * @return void
     *
     */
    public List<Modulo> listar(){
        List<Modulo> listaDeModulos = null;
        try {
            listaDeModulos = this.moduloData.listar();
        } catch (SQLException ex) {
            System.err.println(ex.getSQLState());
        }
        int count = 0;
        if (listaDeModulos.isEmpty()) {
            return null;
        } else {
            return listaDeModulos;
        }
    }
}
