package Main;

import dao.PacienteDAO;
import modelo.Paciente;
import java.text.SimpleDateFormat;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws SQLException {
        Scanner scanner = new Scanner(System.in);
        PacienteDAO pacienteDAO = new PacienteDAO();

        while (true) {
            System.out.println("=== Menu de Pacientes ===");
            System.out.println("1. Cadastrar novo paciente");
            System.out.println("2. Visualizar pacientes cadastrados");
            System.out.println("3. Sair");
            System.out.print("Escolha uma opção: ");

            int opcao = scanner.nextInt();
            scanner.nextLine(); // Consumir a quebra de linha

            switch (opcao) {
                case 1:
                    cadastrarPaciente(scanner, pacienteDAO);
                    break;
                case 2:
                    visualizarPacientes(pacienteDAO);
                    break;
                case 3:
                    System.out.println("Saindo...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
                    break;
            }
        }
    }

    private static void cadastrarPaciente(Scanner scanner, PacienteDAO pacienteDAO) {
        System.out.println("=== Cadastro de Paciente ===");

        System.out.print("Nome do Paciente: ");
        String nomePaciente = scanner.nextLine();

        System.out.print("Número do CPF: ");
        String numeroCpf = scanner.nextLine();

        System.out.print("Número do RG: ");
        String numeroRg = scanner.nextLine();

        System.out.print("Endereço do Paciente: ");
        String endereco = scanner.nextLine();

        System.out.print("Número do Telefone: ");
        String numeroTelefone = scanner.nextLine();

        System.out.print("Email do Paciente (Deixe vazio se não houver): ");
        String email = scanner.nextLine();

        System.out.print("Data de Nascimento (dd/MM/yyyy): ");
        String dataNasc = scanner.nextLine();

        System.out.print("ID do convênio: ");
        int idConvenio = scanner.nextInt();
        scanner.nextLine(); // Consumir a quebra de linha

        try {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            java.util.Date dataNascimento = sdf.parse(dataNasc);

            Paciente novoPaciente = new Paciente();
            novoPaciente.setNome(nomePaciente);
            novoPaciente.setCpf(numeroCpf);
            novoPaciente.setRg(numeroRg);
            novoPaciente.setEndereco(endereco);
            novoPaciente.setTelefone(numeroTelefone);
            novoPaciente.setEmail(email.isEmpty() ? null : email);
            novoPaciente.setDataNascimento(dataNascimento);
            novoPaciente.setIdConvenio(idConvenio);

            pacienteDAO.cadastrarPaciente(novoPaciente);

            System.out.println("Paciente cadastrado com sucesso!");

        } catch (ParseException e) {
            System.out.println("Erro ao formatar a data de nascimento. Certifique-se de usar o formato dd/MM/yyyy.");
        } catch (SQLException e) {
            System.out.println("Erro ao cadastrar o paciente no banco de dados: " + e.getMessage());
        }
    }

    private static void visualizarPacientes(PacienteDAO pacienteDAO) {
        System.out.println("=== Lista de Pacientes Cadastrados ===");
        try {
            List<Paciente> pacientes = pacienteDAO.buscarPaciente();

            if (pacientes.isEmpty()) {
                System.out.println("Nenhum paciente cadastrado.");
            } else {
                for (Paciente paciente : pacientes) {
                    System.out.println(paciente);
                }
            }
        } catch (SQLException e) {
            System.out.println("Erro ao recuperar a lista de pacientes: " + e.getMessage());
        }
    }
}
