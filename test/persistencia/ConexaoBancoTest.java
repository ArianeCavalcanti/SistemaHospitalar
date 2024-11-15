/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package persistencia;

import java.sql.Connection;
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
        // Código para configurar o ambiente de teste para a classe
    }
    
    @AfterClass
    public static void tearDownClass() {
        // Código para limpar o ambiente de teste para a classe
    }
    
    @Before
    public void setUp() {
        // Código para configurar o ambiente de teste antes de cada teste
    }
    
    @After
    public void tearDown() {
        // Código para limpar o ambiente de teste após cada teste
    }

    /**
     * Test of getConexao method, of class ConexaoBanco.
     */
    @Test
    public void testGetConexao() throws Exception {
        System.out.println("getConexao");
        ConexaoBanco instance = new ConexaoBanco();
        Connection expResult = null;
        Connection result = instance.getConexao();
        assertEquals(expResult, result);
        // TODO: Remover a chamada para fail após implementar o teste
        fail("The test case is a prototype.");
    }

    /**
     * Test of fecharConexao method, of class ConexaoBanco.
     */
    @Test
    public void testFecharConexao() {
        System.out.println("fecharConexao");
        ConexaoBanco instance = new ConexaoBanco();
        instance.fecharConexao();
        // TODO: Remover a chamada para fail após implementar o teste
        fail("The test case is a prototype.");
    }
}
