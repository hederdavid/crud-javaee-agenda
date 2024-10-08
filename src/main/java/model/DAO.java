package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

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
    //CREATE
    public void inserirContato(JavaBeans contato) {
    	String create = "insert into contatos(nome, fone, email) values (?,?,?)";
    	try {
    		Connection con = conectar();
    		PreparedStatement pst = con.prepareStatement(create);
    		pst.setString(1, contato.getNome());
    		pst.setString(2, contato.getFone());
    		pst.setString(3, contato.getEmail());
    		pst.executeUpdate();
    		//Importante encerrar a conexao com o banco
    		con.close();
			
		} catch (Exception e) {
			System.out.println(e);
			
		}
    }
    
    //READ
  	public ArrayList<JavaBeans> listarContatos() {
  		ArrayList<JavaBeans> contatos = new ArrayList<>();
  		String read = "select * from contatos order by nome";
  		try {
  			Connection con = conectar();
  			PreparedStatement pst = con.prepareStatement(read);
  			ResultSet rs = pst.executeQuery();
  			while(rs.next()) {
  				String idcon = rs.getString(1);
  				String nome = rs.getString(2);
  				String fone = rs.getString(3);
  				String email = rs.getString(4);
  				
  				contatos.add(new JavaBeans(idcon, nome, fone, email));	
  			}
  			con.close();
  			return contatos;
			
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
  	}
  	
  	//Update
  	public void selecionarContato(JavaBeans contato) {
  		String read2 = "select * from contatos where idcon = ?";
  		try {
  			Connection con = conectar();
  			PreparedStatement pst = con.prepareStatement(read2);
  			int idcon = Integer.parseInt(contato.getIdcon());
  		    pst.setInt(1, idcon);
  			ResultSet rs = pst.executeQuery();
  			System.out.println(rs);
  			while (rs.next()) {
  				contato.setIdcon(rs.getString(1));
  				contato.setNome(rs.getString(2));
  				contato.setFone(rs.getString(3));
  				contato.setEmail(rs.getString(4));
  			}
  			con.close();
			
		} catch (Exception e) {
			System.out.println(e);
		}
  	}
  	
  	//editar contato
  	public void alterarContato(JavaBeans contato) {
  		String create = "update contatos set nome =?,fone=?,email=? where idcon=?";
  		try {
  			Connection con = conectar();
  			PreparedStatement pst = con.prepareStatement(create);
  			pst.setString(1, contato.getNome());
  			pst.setString(2, contato.getEmail());
  			pst.setString(3, contato.getFone());
  			int idcon = Integer.parseInt(contato.getIdcon());
  			pst.setInt(4, idcon);
  			pst.executeUpdate();
  			con.close();
			
		} catch (Exception e) {
			System.out.println(e);
			
		}
  		
  	}
  	
  	//CRUD delete
  	public void deletarContato(JavaBeans contato) {
  		String delete = "delete from contatos where idcon=?";
  		try {
  			Connection con = conectar();
  			PreparedStatement pst = con.prepareStatement(delete);
  			int idcon = Integer.parseInt(contato.getIdcon());
  		    pst.setInt(1, idcon);
  		    pst.executeUpdate();
  		    con.close();
			
		} catch (Exception e) {
			System.out.println(e);
		}
  	}
    
    
    
    // Teste de conexão
//    public void testeConexao() {
//        try {
//            Connection con = conectar();
//            System.out.println(con);
//            con.close();
//        } catch (Exception e) {
//            System.out.println(e);
//        }
//    }

}
