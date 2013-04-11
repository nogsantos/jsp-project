/**
 *
 * Descrição:Classe Connection
 *
 *
 * @author Fabricio Nogueira
 *
 * @since 10-Apr-2013
 *
 * @version 1.0.0
 *
 */

package br.com.jspproject.conexao;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Conexao {

    private static final int BANCO = 0;
    private static final int DB_ORACLE = 0;
    private static final int DB_POSTGRESQL = 1;
    
    private String url;
    private String usuario;
    private String senha;
    
    private Connection conn = null;
    private static Conexao instance = null;
    
    PrintWriter out = null;
    
    /**
     * Construtor da classe Inicializa a conexao
     */
    public Conexao() {
        switch(BANCO){
            case DB_ORACLE:
                url = "jdbc:oracle:thin:@localhost:1521:xe";
                usuario = "aluno";
                senha = "aluno";
                break;
            case DB_POSTGRESQL:
                url = "jdbc:postgresql://localhost:5432/java_oo";
                usuario = "postgres";
                senha = "123456";
                break;
        }
        try {
            inicializar();
        } catch (ClassNotFoundException ex) {
            this.out.println("##ERRO::CLASSNOTFOUD.CONEXÃO: "+ ex.getMessage());
        }catch(SQLException ex){
            this.out.println("##ERRO::SQLEXCEPTION.CONEXÃO: "+ ex.getMessage());
        }
    }
    /**
     * Metodo que carrega o driver a efetua a conexao com o banco de dados
     */
    private void inicializar() throws ClassNotFoundException, SQLException {
        try {
            Properties connectProperties = new Properties();
            connectProperties.put("user", this.usuario);
            connectProperties.put("password", this.senha);
            DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
            conn = DriverManager.getConnection(this.url, connectProperties);
        } catch (SQLException sqle) {
            this.out.println("##ERRO::SQLEXCEPTION.CONEXÃO: "+ sqle.getMessage());
        }
    }
    /**
     * Metodo invocado por outras classes para solicitar 
     * a conexao com banco de dados.
     * 
     * @return
     */
    public Connection getConnection() {
        return conn;
    }
    /**
     * Metodo chamado por outras classes para instanciar um objeto
     * do tipo conecta e poder utilizado Este metodo verifica se uma
     * instancia ja foi feita ou nao.
     *
     * @return
     */
    public static Conexao getInstance() {
        if (instance == null) {
            instance = new Conexao();
        }
        return instance;
    }
    /**
     * Metodo utilizado para fechar a conexao com o banco de dados
     */
    public void closeConnection() {
        try {
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException e) {
            this.out.println("Erro ao fechar a conexao [" +e.getMessage()+"]");
        }
    }
}
