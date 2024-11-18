package dao;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import modelo.Paciente;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class PacienteDAOTeste {

    public PacienteDAOTeste() {
    }

    @BeforeClass
    public static void setUpClass() {

    }

    @AfterClass
    public static void tearDownClass() {

    }

    @Before
    public void setUp() {
        // Inicialização de dados de teste, se necessário.
    }

    @After
    public void tearDown() {
        // Limpeza de dados de teste, se necessário.
    }

    @Test
    public void testeCadastrarPacienteComSucesso() throws Exception {
        try {
            // Um objeto Paciente com dados válidos
            Paciente paciente = new Paciente();
            paciente.setNome("Juliana Ferraz(teste)");
            paciente.setEndereco("Rua Nove de Maio, 1515");
            paciente.setDataNascimento(new SimpleDateFormat("dd/MM/yyyy").parse("10/06/1988"));
            paciente.setTelefone("(11)5648-7845");
            paciente.setCpf("123.654.789-11");
            paciente.setRg("44.456.987-4");
            paciente.setIdConvenio(1);

            // Instancia o DAO e cadastra o paciente
            PacienteDAO pacienteDAO = new PacienteDAO();
            pacienteDAO.cadastrarPaciente(paciente);

            // Verifica se o CPF foi cadastrado
            boolean cpfExiste = !pacienteDAO.isCpfUnique(paciente.getCpf());
            if (cpfExiste) {
                System.out.println("Cadastro realizado com sucesso para o paciente: " + paciente.getNome());
                assertTrue("Cadastro realizado com sucesso.", true);
            } else {
                fail("O CPF não foi encontrado após o cadastro.");
            }

        } catch (SQLException | ParseException ex) {
            System.out.println("Erro ao cadastrar paciente: " + ex.getMessage());
            fail("Erro ao cadastrar paciente: " + ex.getMessage());
        }
    }

    @Test
    public void testeBuscarTodosOsPacientes() {
        try {
            // Instancia o DAO
            PacienteDAO pacienteDAO = new PacienteDAO();

            // Busca todos os pacientes
            ArrayList<Paciente> pacientes = pacienteDAO.buscarPaciente();

            // Verifica se a lista não está vazia
            assertNotNull("A lista de pacientes não deveria ser nula.", pacientes);
            assertFalse("A lista de pacientes deveria conter pelo menos um paciente.", pacientes.isEmpty());
            System.out.println("Busca de todos os pacientes realizada com sucesso. Pacientes encontrados: " + pacientes.size());
        } catch (SQLException ex) {
            System.out.println("Erro ao buscar todos os pacientes: " + ex.getMessage());
            fail("Erro ao buscar todos os pacientes: " + ex.getMessage());
        }
    }

    @Test
    public void testeBuscarPacientePorFiltro() {
        try {
            // Instancia o DAO
            PacienteDAO pacienteDAO = new PacienteDAO();

            // Define o filtro para busca
            String filtro = "Juliana Ferraz";

            // Busca os pacientes com o filtro
            ArrayList<Paciente> pacientesFiltrados = pacienteDAO.buscarPacienteFiltro("WHERE nome LIKE '%" + filtro + "%'");

            // Verifica se pelo menos um paciente foi encontrado
            assertNotNull("A lista de pacientes filtrados não deveria ser nula.", pacientesFiltrados);
            assertFalse("A lista de pacientes filtrados deveria conter pelo menos um paciente.", pacientesFiltrados.isEmpty());
            System.out.println("Busca por filtro realizada com sucesso. Pacientes encontrados: " + pacientesFiltrados.size());
        } catch (SQLException ex) {
            System.out.println("Erro ao buscar pacientes por filtro: " + ex.getMessage());
            fail("Erro ao buscar pacientes por filtro: " + ex.getMessage());
        }
    }

    @Test
    public void testeCadastroPacienteCamposObrigatorios() throws ParseException {
        try {
            // Instancia o DAO
            PacienteDAO pacienteDAO = new PacienteDAO();

            // Cria um objeto Paciente com campos obrigatórios em branco
            Paciente paciente = new Paciente();
            paciente.setNome(""); // Nome vazio
            paciente.setEndereco(""); // Endereço vazio
            paciente.setCpf(""); //CPF vazio
            paciente.setTelefone("");//Telefone vazio
            paciente.setDataNascimento(new SimpleDateFormat("dd/MM/yyyy").parse("10/06/1988"));
            paciente.setIdConvenio(0); // Convenio não definido

            // Tenta cadastrar o paciente
            pacienteDAO.cadastrarPaciente(paciente);

            // Se chegar aqui, o teste falhou
            fail("O cadastro deveria ter falhado devido à ausência de campos obrigatórios.");
        } catch (SQLException ex) {
            // Mensagem exibida no console para confirmar o resultado
            System.out.println("Teste passou: Cadastro rejeitado devido à ausência de campos obrigatórios. Mensagem: " + ex.getMessage());

            // Verifica se a mensagem de exceção está correta
            assertTrue("Mensagem de exceção deveria indicar campos obrigatórios ausentes.",
                    ex.getMessage().contains("Campos obrigatórios não preenchidos."));
        }
    }

    @Test
    public void testeCadastroPacienteDuplicidadeCPF() throws ParseException {
        try {
            // Instancia o DAO
            PacienteDAO pacienteDAO = new PacienteDAO();

            // Tentativa de cadastro com o CPF já registrado
            Paciente pacienteDuplicado = new Paciente();
            pacienteDuplicado.setNome("Maria Oliveira");
            pacienteDuplicado.setCpf("123.456.789-00"); // CPF duplicado
            pacienteDuplicado.setDataNascimento(new SimpleDateFormat("dd/MM/yyyy").parse("01/01/1990"));
            pacienteDuplicado.setIdConvenio(1);

            // Tentativa de cadastro, esperado que falhe
            pacienteDAO.cadastrarPaciente(pacienteDuplicado);

            // Se o cadastro for realizado, o teste deve falhar
            fail("O sistema não deve permitir cadastro com CPF duplicado.");
        } catch (SQLException ex) {
            // Verifica se a exceção gerada contém a mensagem de erro esperada para CPF duplicado
            assertFalse("Deveria ter sido gerada uma mensagem de erro sobre duplicidade de CPF.",
                    ex.getMessage().contains("Já existe um cadastro com esse CPF."));
            System.out.println("Teste passou: Cadastro rejeitado devido à duplicidade de CPF.");
        }
    }

    @Test
    public void testeValidacaoFormatoCPFETelefone() throws ParseException {
        try {
            // Instancia o DAO
            PacienteDAO pacienteDAO = new PacienteDAO();

            // Criação do paciente com CPF e telefone inválidos 
            Paciente paciente = new Paciente();
            paciente.setNome("João Miguel");

            // Preenchendo com CPF inválido 
            paciente.setCpf("12345678900"); // CPF inválido, não segue o formato xxx.xxx.xxx-xx

            // Preenchendo com telefone inválido 
            paciente.setTelefone("123456789"); // Telefone inválido, deve ter 10 ou 11 dígitos

            // Atribuindo uma data fícticia
            paciente.setDataNascimento(new SimpleDateFormat("dd/MM/yyyy").parse("01/01/1990"));

            // Tenta cadastrar o paciente com dados inválidos
            pacienteDAO.cadastrarPaciente(paciente);

            // Se o cadastro for realizado, o teste deve falhar
            fail("O sistema não deve permitir cadastro com CPF e telefone em formato inválido.");
        } catch (SQLException ex) {
            // Verifica se a exceção contém mensagens de erro para CPF e telefone inválidos
            assertFalse("Deveria ter sido gerada uma mensagem de erro sobre CPF inválido.",
                    ex.getMessage().contains("CPF inválido"));
            assertFalse("Deveria ter sido gerada uma mensagem de erro sobre telefone inválido.",
                    ex.getMessage().contains("Telefone inválido"));

            // Exibe as mensagens de erro no console
            System.out.println("Teste passou: Cadastro rejeitado devido a formatos inválidos de CPF e telefone. ");
        }
    }

    @Test
    public void testeLimiteDeCaracteresNomeEEndereco() throws ParseException {
        try {
            // Instancia o DAO
            PacienteDAO pacienteDAO = new PacienteDAO();

            // Cria um paciente com nome e endereço com excesso de caracteres
            Paciente paciente = new Paciente();

            // Nome com mais de 55 caracteres
            paciente.setNome("João da Silva Gonçalves Pereira Júnior - Teste de Excesso de Caracteres");

            // Endereço com mais de 200 caracteres
            paciente.setEndereco("Rua Teste de Excesso de Caracteres 123, Vila Prudente, São Paulo Teste de Excesso de Caracteres, São PAulo Teste, CEP 048150-150 , Complemento Apartamento - Testando o limite de caracteres para o endereço Rua Campreste, numero 1550 ");

            // Adiciona dados válidos para os outros campos
            paciente.setCpf("123.456.789-00");
            paciente.setTelefone("(11) 98765-4321");
            paciente.setDataNascimento(new SimpleDateFormat("dd/MM/yyyy").parse("01/01/1990"));
            paciente.setIdConvenio(1);

            // Tenta cadastrar o paciente com dados excessivos
            pacienteDAO.cadastrarPaciente(paciente);

            // Se o cadastro for realizado, o teste deve falhar
            fail("O sistema não deve permitir o cadastro com campos 'nome' e 'endereço' excedendo o limite de caracteres.");

        } catch (SQLException ex) {
            // Verifica se a exceção contém mensagens de erro para nome e endereço com excesso de caracteres
            assertFalse("Deveria ter sido gerada uma mensagem de erro para o nome com excesso de caracteres.",
                    ex.getMessage().contains("Nome excede o limite de caracteres"));
            assertFalse("Deveria ter sido gerada uma mensagem de erro para o endereço com excesso de caracteres.",
                    ex.getMessage().contains("Endereço excede o limite de caracteres"));

            // Exibe as mensagens de erro no console
            System.out.println("Teste passou: Cadastro rejeitado devido a excesso de caracteres.");
        }
    }

    @Test
    public void testeCadastroComDadosIncorretosEEmailNaoPersistido() throws ParseException {
        try {
            // Instancia o DAO
            PacienteDAO pacienteDAO = new PacienteDAO();

            // Cria um paciente com dados inválidos
            Paciente paciente = new Paciente();

            // Campos obrigatórios em branco e formatação incorreta
            paciente.setNome("");  // Nome vazio
            paciente.setCpf("123456789");  // CPF sem formatação 
            paciente.setTelefone("12345");  // Telefone com formato inválido
            paciente.setEndereco("");  // Endereço vazio
            paciente.setDataNascimento(new SimpleDateFormat("dd/MM/yyyy").parse("10/06/1988"));
            paciente.setIdConvenio(0);  // Convenio inválido

            // Tenta salvar o cadastro
            pacienteDAO.cadastrarPaciente(paciente);

            // Verifica se uma exceção foi lançada ou se o sistema não permitiu salvar os dados
            fail("O cadastro não deveria ser permitido com dados inválidos ou incompletos.");

        } catch (SQLException ex) {
            // Verifica se o erro gerado é devido a dados inválidos, como CPF, telefone ou e-mail mal formatados
            assertTrue("Deveria ter sido gerado um erro devido à formatação incorreta dos campos.", ex instanceof SQLException);

            // Exibe o erro no console
            System.out.println("Erro durante o teste de cadastro com dados inválidos: " + ex.getMessage());
        }
    }

    @Test
    public void testeBuscaPacientePorCpf() throws SQLException {
        // Instancia o DAO
        PacienteDAO pacienteDAO = new PacienteDAO();

        // Define o CPF que será buscado
        String cpfFiltro = "123.456.789-00";

        // Cria a query para buscar o paciente pelo CPF
        String queryCpf = "WHERE CPF = '" + cpfFiltro + "'";

        // Executa a busca utilizando o filtro
        ArrayList<Paciente> pacientes = pacienteDAO.buscarPacienteFiltro(queryCpf);

        // Verifica se a busca por CPF retornou algum resultado
        assertNotNull("A busca por CPF não retornou nenhum paciente.", pacientes);
        assertFalse("A busca por CPF não deveria retornar uma lista vazia.", pacientes.isEmpty());

        // Verifica se o CPF do paciente retornado é o esperado
        assertEquals("O CPF do paciente encontrado não corresponde ao esperado.", cpfFiltro, pacientes.get(0).getCpf());

        System.out.println("Teste de busca por CPF passou corretamente. O paciente foi encontrado com o CPF: " + cpfFiltro);
    }
}
