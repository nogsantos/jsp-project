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

import br.com.jspproject.conexao.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ModuloDAO {
    /*
     * Instancição dos atributos da classe
     */
    private Connection connection  = new Conexao().getConnection();
    private StringBuilder sSql     = new StringBuilder();
    private StringBuilder mensagem = new StringBuilder();
    private PreparedStatement preStatement;
    private Statement statement;
    private ResultSet resultSet;
    /*
     * Construtor
     */
    public ModuloDAO() {
        this.preStatement = null;
        this.statement    = null;
        this.resultSet    = null;
    }
    /**
     * Método cadastrar.
     *
     * @author Fabricio Nogueira
     * @version 1.0.0
     *
     */
    public String cadastrar(Modulo modulo) throws SQLException {
        try {
            this.sSql.append("INSERT INTO modulo ( ");
            this.sSql.append(" codigo_modulo, ");
            this.sSql.append(" nome, ");
            this.sSql.append(" descricao, ");
            this.sSql.append(" ordem ");
            this.sSql.append(") values ( ");
            this.sSql.append(" ?,?,?,? ");
            this.sSql.append(") ");
            this.preStatement = this.connection.prepareStatement(this.sSql.toString());
            this.preStatement.setInt(1, modulo.getCodigoModulo());
            this.preStatement.setString(2, modulo.getNome());
            this.preStatement.setString(3, modulo.getDescricao());
            this.preStatement.setInt(4, modulo.getOrdem());
            this.connection.setAutoCommit(true);
            this.preStatement.executeUpdate();
            return "sucesso";
        } catch (SQLException e) {
            this.mensagem.append("##ERRO.MODULO.IMPLEMENTACAO.CADASTRAR::");
            this.mensagem.append("Erro na inserção dos dados.");
            this.mensagem.append(e.getMessage());
            return this.mensagem.toString();
        } 
    }
    /**
     * Retorna o próximo número da sequência na listagem dos modulos.
     *
     * @author Fabricio Nogueira
     * @version 1.0.0
     * @return Integer Próximo codigo na sequencia regitrado na tabela
     */
    public Integer moduloNextVal() throws SQLException {
        String valor = "";
        try {
            this.sSql.append("SELECT MAX(codigo_modulo) + 1 as max FROM modulo");
            this.statement = this.connection.createStatement();
            this.connection.setAutoCommit(true);
            this.resultSet = this.statement.executeQuery(this.sSql.toString());
            while (this.resultSet.next()) {
                valor = this.resultSet.getString("MAX");
            }
        } catch (SQLException e) {
            throw new SQLException(e.getMessage());
        }
        return Integer.parseInt(valor);
    }
    /**
     * Método editar
     *
     * @author Fabricio Nogueira
     * @version 1.0.0
     *
     */
    public String editar(Modulo modulo) throws SQLException {
        try {
            this.sSql.append(" UPDATE modulo SET ");
            this.sSql.append(" nome = ?, ");
            this.sSql.append(" descricao = ?, ");
            this.sSql.append(" ordem = ? ");
            this.sSql.append(" WHERE ");
            this.sSql.append(" codigo_modulo = ? ");
            this.preStatement = this.connection.prepareStatement(
                this.sSql.toString()
            );
            this.preStatement.setString(1, modulo.getNome());
            this.preStatement.setString(2, modulo.getDescricao());
            this.preStatement.setInt(3, modulo.getOrdem());
            this.preStatement.setInt(4, modulo.getCodigoModulo());
            this.connection.setAutoCommit(true);
            this.preStatement.executeUpdate();
            return "sucesso";
        } catch (SQLException e) {
            this.mensagem.append("##ERRO.MODULO.IMPLEMENTACAO.EDIÇÃO::");
            this.mensagem.append("Erro na edição do dado.");
            this.mensagem.append(e.getMessage());
            return this.mensagem.toString();
        }
    }
    /**
     * Método excluir
     *
     * @author Fabricio Nogueira
     * @version 1.0.0
     *
     */
    public String excluir(Modulo modulo) throws SQLException {
        try {
            this.sSql.append(" DELETE ");
            this.sSql.append(" FROM modulo ");
            this.sSql.append(" WHERE ");
            this.sSql.append(" codigo_modulo = ? ");
            this.preStatement = this.connection.prepareStatement(
                this.sSql.toString()
            );
            this.preStatement.setInt(1, modulo.getCodigoModulo());
            this.connection.setAutoCommit(true);
            this.preStatement.executeUpdate();
            return "sucesso";
        } catch (SQLException e) {
            this.mensagem.append("##ERRO.MODULO.IMPLEMENTACAO.EXCLUSÃO::");
            this.mensagem.append("Erro na exclusão do dado.");
            this.mensagem.append(e.getMessage());
            return this.mensagem.toString();
        }
    }
    /**
     * Método listar
     *
     * @author Fabricio Nogueira
     * @version 1.0.0
     *
     */
    public List<Modulo> listar() throws SQLException {
        try {
            List<Modulo> listaDeModulos = new ArrayList();
            this.sSql.append(" SELECT ");
            this.sSql.append(" codigo_modulo, ");
            this.sSql.append(" nome, ");
            this.sSql.append(" descricao, ");
            this.sSql.append(" ordem ");
            this.sSql.append(" FROM ");
            this.sSql.append(" modulo ");
            this.sSql.append(" ORDER BY ");
            this.sSql.append(" codigo_modulo DESC ");
            this.statement = this.connection.createStatement();
            this.resultSet = statement.executeQuery(this.sSql.toString());
            while (this.resultSet.next()) {
                Modulo moduloList = new Modulo();
                moduloList.setCodigoModulo(this.resultSet.getInt("codigo_modulo"));
                moduloList.setNome(this.resultSet.getString("nome"));
                moduloList.setDescricao(this.resultSet.getString("descricao"));
                moduloList.setOrdem(this.resultSet.getInt("ordem"));
                listaDeModulos.add(moduloList);
            }
            return listaDeModulos;
        } catch (SQLException e) {
            this.mensagem.append("##ERRO.MODULO.IMPLEMENTACAO.LISTAGEM::");
            this.mensagem.append("Erro na listagem dos dados.");
            this.mensagem.append(e.getSQLState());
            throw new SQLException(this.mensagem.toString());
        }
    }
    /**
     * Recuperar por código
     *
     * @author Fabricio Nogueira
     * @version 1.0.0
     *
     */
    public Modulo recuperarPorCodigo(Integer codigoModulo) throws SQLException {
        try {
            this.sSql.append(" SELECT ");
            this.sSql.append(" codigo_modulo, ");
            this.sSql.append(" nome, ");
            this.sSql.append(" descricao, ");
            this.sSql.append(" ordem ");
            this.sSql.append(" FROM ");
            this.sSql.append(" modulo ");
            this.sSql.append(" WHERE ");
            this.sSql.append(" codigo_modulo = ");
            this.sSql.append(codigoModulo);
            this.statement = this.connection.createStatement();
            this.resultSet = statement.executeQuery(this.sSql.toString());
            Modulo modulo = new Modulo();
            while (this.resultSet.next()) {
                modulo.setCodigoModulo(this.resultSet.getInt("codigo_modulo"));
                modulo.setNome(this.resultSet.getString("nome"));
                modulo.setDescricao(this.resultSet.getString("descricao"));
                modulo.setOrdem(this.resultSet.getInt("ordem"));
            }
            return modulo;
        } catch (SQLException e) {
            this.mensagem.append("##ERRO.MODULO.IMPLEMENTACAO.LISTAGEM::");
            this.mensagem.append("Recuperar por código.");
            this.mensagem.append(e.getSQLState());
            throw new SQLException(this.mensagem.toString());
        }
    }
    /**
     * Listagem simples
     *
     * @author Fabricio Nogueira
     * @version 1.0.0
     *
     */
    public List<Modulo> listagemSimples() throws SQLException {
        try {
            List<Modulo> listaDeModulos = new ArrayList();
            this.sSql.append(" SELECT ");
            this.sSql.append(" codigo_modulo, ");
            this.sSql.append(" nome ");
            this.sSql.append(" FROM ");
            this.sSql.append(" modulo ");
            this.sSql.append(" ORDER BY ");
            this.sSql.append(" codigo_modulo DESC ");
            this.statement = this.connection.createStatement();
            this.resultSet = statement.executeQuery(this.sSql.toString());
            while (this.resultSet.next()) {
                Modulo moduloList = new Modulo();
                moduloList.setCodigoModulo(this.resultSet.getInt("codigo_modulo"));
                moduloList.setNome(this.resultSet.getString("nome"));
                listaDeModulos.add(moduloList);
            }
            return listaDeModulos;
        } catch (SQLException e) {
            this.mensagem.append("##ERRO.MODULO.IMPLEMENTACAO.LISTAGEMSIMPLES::");
            this.mensagem.append("Erro na listagem dos dados.");
            this.mensagem.append(e.getSQLState());
            throw new SQLException(this.mensagem.toString());
        }
    }
}

