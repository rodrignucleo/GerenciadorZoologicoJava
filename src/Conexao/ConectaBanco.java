package Conexao;


import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;


public class ConectaBanco {
    
    public Statement stm;
    public ResultSet rs;
    private String driver = "com.mysql.cj.jdbc.Driver";
    private String caminho = "jdbc:mysql://localhost:3306/zoologicoadmin_mysql?useTimezone=true&serverTimezone=UTC";
    private String usuario = "root";
    private String senha = "admin";
    public Connection conn;
    
    public void conexao(){
        
        try {
            System.setProperty("jdbc.Drivers", driver);
            conn = DriverManager.getConnection(caminho, usuario, senha);
            System.out.println("Conectado com sucesso!");
        } catch (SQLException ex) {
            Logger.getLogger(ConectaBanco.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Erro de conexão! \n Erro:" + ex.getMessage());
        }
    }
    
    public void desconecta(){
        try {
            conn.close();
        } catch (SQLException ex) {
            System.out.println("Erro ao fechar a conexão! \n Erro:" + ex.getMessage());
        }
    }
    
    public void executaSQL(String sql) { 

   try {
       stm = conn.createStatement(rs.TYPE_SCROLL_INSENSITIVE,rs.CONCUR_READ_ONLY);
       rs = stm.executeQuery(sql);
       } catch (SQLException ex) {
         System.out.println("ERRO DE EXECUTA SQL!!\n ERRO: " + ex.getMessage());
       }
}
    
}
