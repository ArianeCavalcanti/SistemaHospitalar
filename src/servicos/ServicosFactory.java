/*
*A classe ServicosFactory é responsável por instanciar e fornecer objetos da
*classe MedicoServicos, que contém a lógica de negócio do sistema relacionada a médicos.

*Essa fábrica de serviços é um exemplo do padrão de projeto
*Factory Method, que é utilizado para criar e fornecer objetos sem expor a lógica de criação para outras classes.
 */
package servicos;

public class ServicosFactory {

    /* Criação de objetos estáticos das classes de serviços */
    private static final PacienteServicos pacienteServicos = new PacienteServicos();
    private static final ConvenioServicos convenioServicos = new ConvenioServicos();


    /* Métodos para obter os objetos de serviços */
    public static PacienteServicos getPacienteServicos() {
        return pacienteServicos;
    }

    public static ConvenioServicos getConvenioServicos() {
        return convenioServicos;
    }

}//fecha classe
