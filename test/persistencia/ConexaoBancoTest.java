package persistencia;

import java.sql.Connection;
import java.sql.SQLException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author arian
 */
public class ConexaoBancoTest {
    
    public ConexaoBancoTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getConexao method, of class ConexaoBanco.
     */

 @Test
    public void testeAbrirConexao() {
        ConexaoBanco conexaoBanco = new ConexaoBanco();
        try {
            // Tenta abrir a conexão
            Connection con = conexaoBanco.getConexao();
            
            // Verifica se a conexão não é nula e está aberta
            assertNotNull("A conexão não deveria ser nula.", con);
            assertFalse("A conexão deveria estar aberta.", con.isClosed());
            System.out.println("Teste de abrir conexão realizado com sucesso.");
        } catch (SQLException ex) {
            fail("Erro ao abrir conexão: " + ex.getMessage());
        } finally {
            // Fecha a conexão
            conexaoBanco.fecharConexao();
        }
    }
  @Test
    public void testeFecharConexao() {
        ConexaoBanco conexaoBanco = new ConexaoBanco();
        try {
            // Abre a conexão
            Connection con = conexaoBanco.getConexao();
            assertNotNull("A conexão não deveria ser nula antes de fechar.", con);

            // Fecha a conexão
            conexaoBanco.fecharConexao();

            // Verifica se a conexão está fechada
            assertTrue("A conexão deveria estar fechada.", con.isClosed());
            System.out.println("Teste de fechar conexão realizado com sucesso.");
        } catch (SQLException ex) {
            fail("Erro ao fechar conexão: " + ex.getMessage());
        }
    }
}
