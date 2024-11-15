package servicos;

import java.sql.SQLException;
import java.util.ArrayList;

import dao.ConvenioDAO;
import dao.DAOFactory;
import modelo.Convenio;

/*
A classe ConvenioServicos representa a camada de serviços da aplicação, ela utiliza a classe ConvenioDAO para realizar
operações de leitura e escrita no banco de dados.
*/
public class ConvenioServicos {

        // Método para buscar todos os Convenios
       public ArrayList<Convenio> buscarConvenio() throws SQLException {
           
        // Busca da Fábrica um obj. ConvenioDAO
        ConvenioDAO pacDAO = DAOFactory.getConvenioDAO();
        
        // Chamando método buscarConvenio para buscar todos os Convenios
        return pacDAO.buscarcConvenios();
    }

}
