/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import modelo.Paciente;
import persistencia.ConexaoBanco;


/*A classe PacienteDAO é responsável pela comunicação entre a aplicação e o banco de dados, ou seja,
ela é responsável por realizar as operações de cadastro e busca de pacientes no banco de dados.
 */
public class PacienteDAO {

    private ConexaoBanco conexao;
    private Connection con;

    /*No construtor da classe, a instância de ConexaoBanco é criada e 
    armazenada no atributo conexao. 
    Essa instância será usada posteriormente para obter a conexão com o banco de dados.
     */
    public PacienteDAO() {
        this.conexao = new ConexaoBanco();
    }

    // método cadastrarPaciente
    public void cadastrarPaciente(Paciente pac) throws SQLException {

        try {

            con = conexao.getConexao();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");

            // String que receberá instrução SQL
            String sql = "insert into PACIENTE(NOME, ENDERECO, DATA_NASC, TELEFONE, CPF, RG, ID_CONVENIO_FK) values(?,?,?,?,?,?,?)";

            PreparedStatement pst = this.con.prepareStatement(sql);

            // Atribuindo valores aos parâmetros
            pst.setString(1, pac.getNome());
            pst.setString(2, pac.getEndereco());
            pst.setString(3, sdf.format(pac.getDataNascimento()));
            pst.setString(4, pac.getTelefone());
            pst.setString(5, pac.getCpf());
            pst.setString(6, pac.getRg());
            pst.setInt(7, pac.getIdConvenio());

            // Executando o PreparedStatement
            pst.execute();

        } catch (SQLException se) {
            throw new SQLException("Erro ao inserir dados no Banco de Dados! " + se.getMessage());
        } finally {

            // Encerrando as conexões
            con.close();

        } // fecha finally
    }// fecha método cadastrarPaciente

    // método buscarPaciente com condição
    public ArrayList<Paciente> buscarPacienteFiltro(String query) throws SQLException {

        /*
         * Criando obj. capaz de executar instruções
         * SQL no banco de dados
         */
        ResultSet rs;

        try {
            // Criando variável sql vazia
            String sql;

            /* Montando o sql com a consulta desejada pelo usuário.
            A consulta foi enviada para o método em uma String chamada query */
            sql = "SELECT * FROM paciente " + query;

            this.con = this.conexao.getConexao();
            PreparedStatement pst = con.prepareStatement(sql);

            rs = pst.executeQuery();


            /* Criando ArrayList para armazenar objetos do tipo Paciente */
            ArrayList<Paciente> pacientes = new ArrayList<>();

            /* Enquanto houver uma próxima linha no
           banco de dados o while roda */
            while (rs.next()) {

                // Criando um novo obj. Paciente
                Paciente pac = new Paciente();

                /* Mapeando a tabela do banco para objeto chamado pac */
                pac.setIdPaciente(rs.getInt("ID_PACIENTE"));
                pac.setNome(rs.getString("NOME"));
                pac.setEndereco(rs.getString("ENDERECO"));
                pac.setDataNascimento(rs.getDate("DATA_NASC"));
                pac.setTelefone(rs.getString("TELEFONE"));
                pac.setCpf(rs.getString("CPF"));
                pac.setRg(rs.getString("RG"));
                pac.setIdConvenio(rs.getInt("ID_CONVENIO_FK"));


                /* Inserindo o objeto Paciente no ArrayList */
                pacientes.add(pac);
            }

            // Retornando o ArrayList com todos objetos
            return pacientes;

        } catch (SQLException se) {
            throw new SQLException("Erro ao buscar dados do Banco! " + se.getMessage());
        } finally {
            con.close();
        }
    }

    public ArrayList<Paciente> buscarPaciente() throws SQLException {


        /*
         * Criando obj. capaz de executar instruções
         * SQL no banco de dados
         */
        ResultSet rs;

        try {

            // String que receberá instrução SQL
            String sql = "SELECT * FROM PACIENTE";

            this.con = this.conexao.getConexao();
            PreparedStatement pst = con.prepareStatement(sql);

            rs = pst.executeQuery();


            /* Criando ArrayList para armazenar objetos do tipo Paciente */
            ArrayList<Paciente> pacientes = new ArrayList<>();

            /* Enquanto houver uma próxima linha no banco de dados o while roda */
            while (rs.next()) {

                // Criando um novo objeto Paciente
                Paciente pac = new Paciente();

                /* Mapeando a tabela do banco para objeto chamado pac */
                pac.setIdPaciente(rs.getInt("ID_PACIENTE"));
                pac.setNome(rs.getString("NOME"));
                pac.setEndereco(rs.getString("ENDERECO"));
                pac.setDataNascimento(rs.getDate("DATA_NASC"));
                pac.setTelefone(rs.getString("TELEFONE"));
                pac.setCpf(rs.getString("CPF"));
                pac.setRg(rs.getString("RG"));
                pac.setIdConvenio(rs.getInt("ID_CONVENIO_FK"));

                /* Inserindo o objeto pac no ArrayList */
                pacientes.add(pac);
            }

            // Retornando o ArrayList com todos objetos
            return pacientes;
        } catch (SQLException se) {

            throw new SQLException("Erro ao buscar dados do Banco! " + se.getMessage());
        } finally {
            con.close();
        }
    }

}
