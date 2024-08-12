package model;

import java.sql.Connection;
import java.sql.DriverManager;

public class DAO {
    // Módulo de conexão
    
    // Parâmetros de conexão
    private String driver = "org.postgresql.Driver";
    private String url = "jdbc:postgresql://127.0.0.1:5432/db_agenda_javaee?useTimezone=true&serverTimezone=UTC";
    private String user = "postgres";
    private String password = "admin";
    
    // Métodos de conexão
    private Connection conectar() {
        Connection con = null;
        try {
            Class.forName(driver);
            con = DriverManager.getConnection(url, user, password);
            return con;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }
    
    // Teste de conexão
    public void testeConexao() {
        try {
            Connection con = conectar();
            System.out.println(con);
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

}
