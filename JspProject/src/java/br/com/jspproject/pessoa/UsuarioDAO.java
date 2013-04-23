/**
 *
 * Descrição:Classe UsuarioDAO
 *
 *
 * @author Fabricio Nogueira
 *
 * @since 17-Apr-2013
 *
 * @version 1.0.0
 *
 */

package br.com.jspproject.pessoa;

import br.com.jspproject.conexao.Conexao;
import br.com.jspproject.utils.Utils;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class UsuarioDAO {
    /*
     * Instancição dos atributos da classe
     */
    private Connection connection = new Conexao().getConnection();
    private StringBuilder sSql = new StringBuilder();
    private StringBuilder mensagem = new StringBuilder();
    private PreparedStatement preStatement;
    private Statement statement;
    private ResultSet resultSet;
    /*
     * Construtor
     */
    public UsuarioDAO() {
        this.preStatement = null;
        this.statement = null;
        this.resultSet = null;
    }
    /**
     * Método cadastrar
     *
     * @author Fabricio Nogueira
     * @version 1.0.0
     *
     */
    public String cadastrar(Usuario usuario, Pessoa pessoa) throws SQLException {
        try {
            this.sSql.append(" INSERT INTO usuario ( ");
            this.sSql.append(" codigo_pessoa, ");
            this.sSql.append(" login, ");
            this.sSql.append(" senha ");
            this.sSql.append(" ) VALUES ( ");
            this.sSql.append(" ?,?,? )");
            this.preStatement = this.connection.prepareStatement(this.sSql.toString());
            this.preStatement.setString(1, pessoa.getCodigoPessoa());
            this.preStatement.setString(2, usuario.getLogin());
            this.preStatement.setString(3, Utils.encryptSenha(usuario.getSenha()));
            this.connection.setAutoCommit(true);
            this.preStatement.executeUpdate();
            return "sucesso";
        } catch (SQLException e) {
            this.mensagem.append("##ERRO.USUARIO.IMPLEMENTACAO.CADASTRAR::");
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
     *
     */
    public String editar(Usuario usuario, Pessoa pessoa) throws SQLException {
        try {
            this.sSql.append(" UPDATE usuario SET  ");
            this.sSql.append(" login = ?, ");
            this.sSql.append(" senha = ? ");
            this.sSql.append(" WHERE ");
            this.sSql.append(" codigo_pessoa = ? ");
            /*
             * Editando a pessoa
             */
            PessoaDAO pessoaImpl = new PessoaDAO();
            String editar = pessoaImpl.editar(pessoa);
            if (editar.equals("sucesso")) {
                this.preStatement = this.connection.prepareStatement(this.sSql.toString());
                this.preStatement.setString(1, usuario.getLogin());
                this.preStatement.setString(2, Utils.encryptSenha(usuario.getSenha()));
                this.preStatement.setString(3, pessoa.getCodigoPessoa());
                this.connection.setAutoCommit(true);
                this.preStatement.executeUpdate();
            }
            return editar;
        } catch (SQLException e) {
            this.mensagem.append("##ERRO.USUARIO.IMPLEMENTACAO.EDITAR::");
            this.mensagem.append("Erro na inserção dos dados.");
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
    public String excluir(Usuario usuario, Pessoa pessoa) throws SQLException {
        try {
            this.sSql.append(" DELETE FROM usuario  ");
            this.sSql.append(" WHERE ");
            this.sSql.append(" codigo_pessoa = ? ");
            this.preStatement = this.connection.prepareStatement(this.sSql.toString());
            this.preStatement.setString(1, pessoa.getCodigoPessoa());
            this.connection.setAutoCommit(true);
            this.preStatement.executeUpdate();
            /*
             * Excluíndo a pessoa
             */
            PessoaDAO pessoaImpl = new PessoaDAO();
            return pessoaImpl.excluir(pessoa);
        } catch (SQLException e) {
            this.mensagem.append("##ERRO.USUARIO.IMPLEMENTACAO.EDITAR::");
            this.mensagem.append("Erro na inserção dos dados.");
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
    public List<Usuario> listar() throws SQLException {
        try {
            List<Usuario> listaDeUsuarios = new ArrayList();
            this.sSql.append(" SELECT ");
            this.sSql.append(" p.codigo_pessoa, ");
            this.sSql.append(" p.nome, ");
            this.sSql.append(" p.logradouro, ");
            this.sSql.append(" p.email, ");
            this.sSql.append(" p.telefone, ");
            this.sSql.append(" u.login, ");
            this.sSql.append(" u.senha ");
            this.sSql.append(" FROM ");
            this.sSql.append(" usuario u, pessoa p ");
            this.sSql.append(" WHERE ");
            this.sSql.append(" u.codigo_pessoa = p.codigo_pessoa ");
            this.sSql.append(" ORDER BY p.codigo_pessoa DESC ");
            this.statement = this.connection.createStatement();
            this.resultSet = statement.executeQuery(this.sSql.toString());
            while (this.resultSet.next()) {
                Usuario usuarioList = new Usuario();
                usuarioList.setCodigoPessoa(this.resultSet.getString("codigo_pessoa"));
                usuarioList.setNome(this.resultSet.getString("nome"));
                usuarioList.setLogradouro(this.resultSet.getString("logradouro"));
                usuarioList.setEmail(this.resultSet.getString("email"));
                usuarioList.setTelefone(this.resultSet.getString("telefone"));
                usuarioList.setLogin(this.resultSet.getString("login"));
                usuarioList.setSenha(this.resultSet.getString("senha"));
                listaDeUsuarios.add(usuarioList);
            }
            return listaDeUsuarios;
        } catch (SQLException e) {
            this.mensagem.append("##ERRO.USUARIO.IMPLEMENTACAO.LISTAGEM::");
            this.mensagem.append("Erro na listagem dos dados.(SQL)");
            this.mensagem.append(e.getSQLState());
            throw new SQLException(this.mensagem.toString());
        }
    }

}
