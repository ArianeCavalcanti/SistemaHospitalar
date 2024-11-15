/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

// Esta classe é responsável por fornecer instâncias dos objetos DAO (Data Access Object)
// que serão utilizados para realizar as operações de acesso ao banco de dados.
// Ao invés de criar múltiplas instâncias de DAOs, o uso de instâncias singleton melhora a performance da aplicação,
// uma vez que evita a criação desnecessária de múltiplas conexões ao banco de dados e permite que as operações de acesso
// ao banco de dados possam ser facilmente substituídas por outros tipos de operações de acesso, se necessário.

public class DAOFactory {

    /* Instancia um obj.  
       e retorna o mesmo quando solicitado */
    private static final PacienteDAO pacienteDAO = new PacienteDAO();
    private static final ConvenioDAO convenioDAO = new ConvenioDAO();

    // O método getPacienteDAO() retorna um objeto PacienteDAO que pode ser usado para realizar operações de acesso ao banco
   // de dados para a tabela Paciente.
    public static PacienteDAO getPacienteDAO() {
        return pacienteDAO;
    }

    // O método getConvenioDAO() retorna um objeto ConvenioDAO que pode ser usado para realizar operações de acesso ao banco
   // de dados para a tabela Convenio.
    public static ConvenioDAO getConvenioDAO() {
        return convenioDAO;
    }

}//fecha classe
