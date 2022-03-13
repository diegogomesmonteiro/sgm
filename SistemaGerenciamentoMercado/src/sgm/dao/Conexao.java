package sgm.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {

    public Connection conectar(){
        try {
            String url = "jdbc:mysql://localhost:3306/sgm";
            return DriverManager.getConnection(url, "root", "admin");
           
        } catch (SQLException erro) {
            System.out.println("Conexão: " + erro.getMessage());
        }
        return null;
    }
}
