/**
 *
 * Descrição:Classe PerfilDAO
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

import br.com.jspproject.conexao.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class PerfilDAO {
    /*
     * Instancição dos atributos da classe
     */
    private Connection connection = new Conexao().getConnection();
    private StringBuilder sSql = new StringBuilder();
    private StringBuilder mensagem = new StringBuilder();
    private PreparedStatement preStatement;
    private Statement statement;
    private ResultSet resultSet;
    /**
     * Contrutor
     */
    public PerfilDAO() {
        this.preStatement = null;
        this.statement = null;
        this.resultSet = null;
    }
    /**
     * Método cadastrar
     *
     * @author Fabricio Nogueira
     * @version 1.0.0
     * @return boolean
     */
    public String cadastrar(Perfil perfil) throws SQLException {
        try {
            this.sSql.append(" INSERT INTO perfil ( ");
            this.sSql.append(" codigo_perfil, ");
            this.sSql.append(" nome, ");
            this.sSql.append(" descricao ");
            this.sSql.append(" ) values ( ");
            this.sSql.append(" ?,?,? ");
            this.sSql.append(" ) ");
            this.preStatement = this.connection.prepareStatement(this.sSql.toString());
            this.preStatement.setInt(1, perfil.getCodigoPerfil());
            this.preStatement.setString(2, perfil.getNome());
            this.preStatement.setString(3, perfil.getDescricao());
            this.connection.setAutoCommit(true);
            this.preStatement.executeUpdate();
            return "sucesso";
        } catch (SQLException e) {
            this.mensagem.append("##ERRO.PERFIL.CADASTRAR::");
            this.mensagem.append("Erro na inserção dos dados.");
            this.mensagem.append(e.getMessage());
            return this.mensagem.toString();
        }
    }
    /**
     * Retorna o próximo número da sequência na listagem dos perfis.
     *
     * @author Fabricio Nogueira
     * @version 1.0.0
     * @return Integer Próximo codigo na sequencia regitrado na tabela
     */
    public Integer perfilNextVal() throws SQLException {
        String valor = "";
        try {
            this.sSql.append(" SELECT MAX(codigo_perfil) + 1 as max FROM perfil ");
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
     * @return boolean
     */
    public String editar(Perfil perfil) throws SQLException {
        try {
            this.sSql.append(" UPDATE perfil SET ");
            this.sSql.append(" nome = ?, ");
            this.sSql.append(" descricao = ? ");
            this.sSql.append(" WHERE ");
            this.sSql.append(" codigo_perfil = ? ");
            this.preStatement = this.connection.prepareStatement(
                    this.sSql.toString());
            this.preStatement.setString(1, perfil.getNome());
            this.preStatement.setString(2, perfil.getDescricao());
            this.preStatement.setInt(3, perfil.getCodigoPerfil());
            this.connection.setAutoCommit(true);
            this.preStatement.executeUpdate();
            return "sucesso";
        } catch (SQLException e) {
            this.mensagem.append("##ERRO.PERFIL.EDITAR::");
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
    public String excluir(Perfil perfil) throws SQLException {
        try {
            this.sSql.append(" DELETE ");
            this.sSql.append(" FROM perfil ");
            this.sSql.append(" WHERE ");
            this.sSql.append(" codigo_perfil = ? ");
            this.preStatement = this.connection.prepareStatement(
                    this.sSql.toString());
            this.preStatement.setInt(1, perfil.getCodigoPerfil());
            this.connection.setAutoCommit(true);
            this.preStatement.executeUpdate();
            return "sucesso";
        } catch (SQLException e) {
            this.mensagem.append("##ERRO.PERFIL.EXCLUIR::");
            this.mensagem.append("Erro na exclusão do dado.");
            this.mensagem.append(e.getMessage());
            return this.mensagem.toString();
        }
    }
    /**
     * Método listar.
     * Lista todos os registros cadastrados
     *
     * @author Fabricio Nogueira
     * @version 1.0.0
     * @return Mixed
     */
    public List<Perfil> listar() throws SQLException {
        try {
            List<Perfil> listaDePerfis = new ArrayList();
            this.sSql.append(" SELECT ");
            this.sSql.append(" codigo_perfil, ");
            this.sSql.append(" nome, ");
            this.sSql.append(" descricao ");
            this.sSql.append(" FROM ");
            this.sSql.append(" perfil ");
            this.sSql.append(" ORDER BY ");
            this.sSql.append(" codigo_perfil DESC ");
            this.statement = this.connection.createStatement();
            this.resultSet = statement.executeQuery(this.sSql.toString());
            while (this.resultSet.next()) {
                Perfil perfilList = new Perfil();
                perfilList.setCodigoPerfil(this.resultSet.getInt("codigo_perfil"));
                perfilList.setNome(this.resultSet.getString("nome"));
                perfilList.setDescricao(this.resultSet.getString("descricao"));

                listaDePerfis.add(perfilList);
            }
            return listaDePerfis;
        } catch (SQLException e) {
            this.mensagem.append("##ERRO.PERFIL.LISTAR::");
            this.mensagem.append("Erro na listagem dos dados.");
            this.mensagem.append(e.getSQLState());
            throw new SQLException(this.mensagem.toString());
        }
    }
    /**
     * Método getByCodigo.
     * Recupera um perfil por código.
     *
     * @author Fabricio Nogueira
     * @version 1.0.0
     * @return Mixed
     */
    public Perfil recuperarPorCodigo(int codigoPerfil) throws SQLException {
        if (codigoPerfil >= 0) {
            try {
                this.sSql.append(" SELECT ");
                this.sSql.append(" codigo_perfil, ");
                this.sSql.append(" nome, ");
                this.sSql.append(" descricao ");
                this.sSql.append(" FROM perfil ");
                this.sSql.append(" WHERE ");
                this.sSql.append(" codigo_perfil = ");
                this.sSql.append(codigoPerfil);
                this.statement = this.connection.createStatement();
                this.connection.setAutoCommit(true);
                this.resultSet = statement.executeQuery(this.sSql.toString());
                Perfil perfil = new Perfil();
                while (this.resultSet.next()) {
                    perfil.setCodigoPerfil(this.resultSet.getInt("CODIGO_PERFIL"));
                    perfil.setNome(this.resultSet.getString("NOME"));
                    perfil.setDescricao(this.resultSet.getString("DESCRICAO"));
                }
                return perfil;
            } catch (SQLException e) {
                this.mensagem.append("##ERRO.PERFIL.RECUPERARPORCODIGO::");
                this.mensagem.append("Erro na recuperação do dado.");
                this.mensagem.append(e.getSQLState());
                throw new SQLException(this.mensagem.toString());
            }
        } else {
            this.mensagem.append("##ERRO.PERFIL.RECUPERARPORCODIGO::");
            this.mensagem.append("Código Inválido");
            System.err.println(this.mensagem.toString());
            return null;
        }
    }
    /**
     * Método confirmaPerfil.
     * Confirma a existencia de um perfil por código.
     *
     * @author Fabricio Nogueira
     * @version 1.0.0
     *
     * @return boolean
     */
    public boolean confirmarExistencia(int codigoPerfil) throws SQLException {
        if (codigoPerfil >= 0) {
            try {
                this.sSql.append(" SELECT ");
                this.sSql.append(" codigo_perfil, ");
                this.sSql.append(" nome, ");
                this.sSql.append(" descricao ");
                this.sSql.append(" FROM perfil ");
                this.sSql.append(" WHERE ");
                this.sSql.append(" codigo_perfil = ");
                this.sSql.append(codigoPerfil);
                this.statement = this.connection.createStatement();
                this.connection.setAutoCommit(true);
                this.resultSet = this.statement.executeQuery(this.sSql.toString());
                if (this.resultSet.wasNull()) {
                    return false;
                } else {
                    return true;
                }
            } catch (SQLException e) {
                this.mensagem.append("##ERRO.PERFIL.CONFIRMAR");
                this.mensagem.append("CONFIRMAPERFIL::");
                this.mensagem.append("Código Inválido");
                this.mensagem.append(e.getMessage());
                throw new SQLException(this.mensagem.toString());
            }
        } else {
            this.mensagem.append("##ERRO.PERFIL.CONFIRMAPERFIL::");
            this.mensagem.append("Código Inválido");
            System.err.println(this.mensagem.toString());
            return false;
        }
    }
    /**
     * Lista perfil por usuário.
     *
     * @author Fabricio Nogueira
     * @version 1.0.0
     * @return Mixed
     */
    public List<Perfil> listarPorUsuario(String codigoUsuario) throws SQLException {
        try {
            List<Perfil> listaDePerfis = new ArrayList();
            this.sSql.append(" SELECT ");
            this.sSql.append(" pf.codigo_perfil, ");
            this.sSql.append(" pf.nome ");
            this.sSql.append(" FROM ");
            this.sSql.append(" usuario_perfil up, perfil pf ");
            this.sSql.append(" WHERE ");
            this.sSql.append(" up.codigo_perfil = pf.codigo_perfil ");
            this.sSql.append(" AND up.codigo_pessoa =  ");
            this.sSql.append(codigoUsuario);
            this.statement = this.connection.createStatement();
            this.resultSet = statement.executeQuery(this.sSql.toString());
            while (this.resultSet.next()) {
                Perfil perfilList = new Perfil();
                perfilList.setCodigoPerfil(this.resultSet.getInt("codigo_perfil"));
                perfilList.setNome(this.resultSet.getString("nome"));

                listaDePerfis.add(perfilList);
            }
            return listaDePerfis;
        } catch (SQLException e) {
            this.mensagem.append("##ERRO.PERFIL.LISTARPERFILPORUSUARIO::");
            this.mensagem.append(e.getSQLState());
            throw new SQLException(this.mensagem.toString());
        }
    }
    /**
     * Lista os perfis não cadastrados para o usuário.
     *
     * @author Fabricio Nogueira
     * @version 1.0.0
     * @return Mixed
     */
    public List<Perfil> listarNaoCadastradoParaUsuario(
            String codigoPessoa) throws SQLException {
        try {
            List<Perfil> listaDePerfis = new ArrayList();
            this.sSql.append(" SELECT ");
            this.sSql.append(" pf.codigo_perfil, ");
            this.sSql.append(" pf.nome ");
            this.sSql.append(" FROM ");
            this.sSql.append(" perfil pf ");
            this.sSql.append(" WHERE ");
            this.sSql.append(" pf.codigo_perfil not in ( ");
            this.sSql.append(" select up2.codigo_perfil from usuario_perfil ");
            this.sSql.append(" up2 where up2.codigo_pessoa =  ");
            this.sSql.append(codigoPessoa);
            this.sSql.append(" ) ");
            this.statement = this.connection.createStatement();
            this.resultSet = statement.executeQuery(this.sSql.toString());
            while (this.resultSet.next()) {
                Perfil perfilList = new Perfil();
                perfilList.setCodigoPerfil(this.resultSet.getInt("codigo_perfil"));
                perfilList.setNome(this.resultSet.getString("nome"));

                listaDePerfis.add(perfilList);
            }
            return listaDePerfis;
        } catch (SQLException e) {
            this.mensagem.append("##ERRO.PERFIL.LISTARPERFILPORUSUARIO::");
            this.mensagem.append(e.getSQLState());
            throw new SQLException(this.mensagem.toString());
        }
    }
}