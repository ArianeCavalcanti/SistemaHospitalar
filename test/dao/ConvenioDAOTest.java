package dao;

import java.sql.SQLException;
import java.util.ArrayList;
import modelo.Convenio;
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
public class ConvenioDAOTest {

    public ConvenioDAOTest() {
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
     * Test of buscarConvenioFiltro method, of class ConvenioDAO.
     */
    @Test
    public void testeBuscarConvenios() {
        ConvenioDAO convenioDAO = new ConvenioDAO();
        try {
            // Tenta buscar todos os convênios
            ArrayList<Convenio> convenios = convenioDAO.buscarcConvenios();

            // Verifica se a lista não é nula e contém ao menos um item
            assertNotNull("A lista de convênios não deveria ser nula.", convenios);
            assertFalse("A lista de convênios deveria conter pelo menos um item.", convenios.isEmpty());

            // Exibe os resultados para validação
            for (Convenio convenio : convenios) {
                System.out.println("Convênio encontrado: " + convenio.getNomeConvenio());
            }
        } catch (SQLException ex) {
            fail("Erro ao buscar todos os convênios: " + ex.getMessage());
        }
    }

    @Test
    public void testeBuscarConvenioFiltroNaoEncontrado() {
        ConvenioDAO convenioDAO = new ConvenioDAO();
        String filtro = "Convênio Inexistente";

        try {
            // Tenta buscar um convênio pelo filtro
            Convenio convenio = convenioDAO.buscarConvenioFiltro(filtro);

            // Verifica se nenhum convênio foi encontrado
            assertNull("Nenhum convênio deveria ser encontrado para o filtro inexistente.", convenio);

            System.out.println("Nenhum convênio encontrado para o filtro: " + filtro);
        } catch (SQLException ex) {
            fail("Erro ao buscar convênio pelo filtro: " + ex.getMessage());
        }
    }
}
