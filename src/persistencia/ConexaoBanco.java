/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoBanco {

    private static final String URL = "jdbc:mysql://localhost:3306/hospital_uc12";
    private static final String USUARIO = "root";
    private static final String SENHA = "T#7aB3$0m2@i";
    
    private Connection con;

    public Connection getConexao() throws SQLException {
        if (con == null || con.isClosed()) {
            try {
                con = DriverManager.getConnection(URL, USUARIO, SENHA);
            } catch (SQLException se) {
                throw new SQLException("Erro ao conectar! " + se.getMessage());
            }
        }
        return con;
    }

    public void fecharConexao() {
        if (con != null) {
            try {
                con.close();
                System.out.println("Conexão fechada com sucesso.");
            } catch (SQLException e) {
                System.out.println("Erro ao fechar conexão: " + e.getMessage());
            }
        }
    }
}
