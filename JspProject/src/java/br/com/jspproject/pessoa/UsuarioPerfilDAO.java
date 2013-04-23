/**
 *
 * Descrição:Classe UsuarioPerfilDAO
 *
 *
 * @author Fabricio Nogueira
 *
 * @since 22-Apr-2013
 *
 * @version 1.0.0
 *
 */

package br.com.jspproject.pessoa;

import br.com.jspproject.conexao.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class UsuarioPerfilDAO {
    /*
     * Instancição dos atributos da classe
     */
    private Connection connection  = new Conexao().getConnection();
    private StringBuilder sSql     = new StringBuilder();
    private StringBuilder mensagem = new StringBuilder();
    private PreparedStatement preStatement;
    private Statement statement;
    private ResultSet resultSet;
    /**
     * Contrutor
     */
    public UsuarioPerfilDAO() {
        this.preStatement = null;
        this.statement    = null;
        this.resultSet    = null;
    }
    /**
     * Método cadastrar
     *
     * @author Fabricio Nogueira
     * @version 1.0.0
     * @return boolean
     */
    public String cadastrar(Usuario usuario, Perfil perfil) throws SQLException{
        try {
            this.sSql.append(" INSERT INTO usuario_perfil ( ");
            this.sSql.append(" codigo_pessoa, ");
            this.sSql.append(" codigo_perfil ");
            this.sSql.append(" ) values ( ");
            this.sSql.append(" ?,? ");
            this.sSql.append(" ) ");
            this.preStatement = this.connection.prepareStatement(this.sSql.toString());
            this.preStatement.setString(1, usuario.getCodigoPessoa());
            this.preStatement.setInt(2, perfil.getCodigoPerfil());
            this.preStatement.executeUpdate();
            return "sucesso";
        } catch (SQLException e) {
            this.mensagem.append("##ERRO.PERFILUSUARIO.IMPLEMENTACAO.CADASTRAR::");
            this.mensagem.append("Erro na inserção dos dados.");
            this.mensagem.append(e.getMessage());
            return this.mensagem.toString();
        } 
    }
    /**
     * Método editar
     *
     * @author Fabricio Nogueira
     * @version 1.0.0
     * @return boolean
     */
    public String editar(String codigoPessoa, Integer codigoPerfil) throws SQLException{
        return "";
    }
    /**
     * Método excluir
     *
     * @author Fabricio Nogueira
     * @version 1.0.0
     * @return boolean
     */
    public String excluir(String codigoPessoa, Integer codigoPerfil) throws SQLException{
        return "";
    }
}
