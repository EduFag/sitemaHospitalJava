import java.util.ArrayList;
import java.util.Scanner;

class SistemaHospital {
    private ArrayList<Paciente> pacientes = new ArrayList<>();
    private ArrayList<Consulta> consultas = new ArrayList<>();

    public void cadastrarPaciente(String nome, String cpf, int idade, String telefone) {
        pacientes.add(new Paciente(nome, cpf, idade, telefone));
        System.out.println("Paciente cadastrado com sucesso!");
    }

    public void agendarConsulta(String cpf, String data, String horario, String especialidade, String medico) {
        Paciente pacienteEncontrado = null;
        for (Paciente p : pacientes) {
            if (p.getCpf().equals(cpf)) {
                pacienteEncontrado = p;
                break;
            }
        }
        if (pacienteEncontrado != null) {
            consultas.add(new Consulta(pacienteEncontrado, data, horario, especialidade, medico));
            System.out.println("Consulta agendada com sucesso!");
        } else {
            System.out.println("Paciente não encontrado!");
        }
    }

    public void listarConsultasPaciente(String cpf) {
        boolean encontrou = false;
        for (Consulta c : consultas) {
            if (c.getCpfPaciente().equals(cpf)) {
                c.exibirDetalhes();
                encontrou = true;
            }
        }
        if (!encontrou) {
            System.out.println("Nenhuma consulta encontrada para este CPF.");
        }
    }

    public void alterarDataConsulta(String cpf, String dataAntiga, String dataNova) {
        boolean encontrou = false;
        for (Consulta c : consultas) {
            if (c.getCpfPaciente().equals(cpf) && c.getData().equals(dataAntiga)) {
                c.setData(dataNova);
                System.out.println("Data da consulta alterada com sucesso para " + dataNova + "!");
                encontrou = true;
            }
        }
        if (!encontrou) {
            System.out.println("Nenhuma consulta encontrada para este CPF na data especificada.");
        }
    }

    public void listarConsultasDoDia(String data) {
        boolean encontrou = false;
        System.out.println("\nConsultas para o dia " + data + ":");
        for (Consulta c : consultas) {
            if (c.getData().equals(data)) {
                c.exibirDetalhes();
                encontrou = true;
            }
        }
        if (!encontrou) {
            System.out.println("Nenhuma consulta agendada para o dia " + data + ".");
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SistemaHospital sistema = new SistemaHospital();

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1 - Cadastrar Paciente");
            System.out.println("2 - Agendar Consulta");
            System.out.println("3 - Listar Consultas de um Paciente");
            System.out.println("4 - Alterar Data de Consulta");
            System.out.println("5 - Listar Consultas do Dia");
            System.out.println("6 - Sair");
            System.out.print("Escolha uma opção: ");

            int opcao = scanner.nextInt();
            scanner.nextLine();

            if (opcao == 1) {
                System.out.print("Nome: ");
                String nome = scanner.nextLine();
                System.out.print("CPF: ");
                String cpf = scanner.nextLine();
                System.out.print("Idade: ");
                int idade = scanner.nextInt();
                scanner.nextLine();
                System.out.print("Telefone: ");
                String telefone = scanner.nextLine();
                sistema.cadastrarPaciente(nome, cpf, idade, telefone);

            } else if (opcao == 2) {
                System.out.print("CPF do paciente: ");
                String cpf = scanner.nextLine();
                System.out.print("Data (dd/mm/aaaa): ");
                String data = scanner.nextLine();
                System.out.print("Horário (hh:mm): ");
                String horario = scanner.nextLine();
                System.out.print("Especialidade: ");
                String especialidade = scanner.nextLine();
                System.out.print("Médico: ");
                String medico = scanner.nextLine();
                sistema.agendarConsulta(cpf, data, horario, especialidade, medico);

            } else if (opcao == 3) {
                System.out.print("CPF do paciente: ");
                String cpf = scanner.nextLine();
                sistema.listarConsultasPaciente(cpf);

            } else if (opcao == 4) {
                System.out.print("CPF do paciente: ");
                String cpf = scanner.nextLine();
                System.out.print("Data da consulta a ser alterada (dd/mm/aaaa): ");
                String dataAntiga = scanner.nextLine();
                System.out.print("Nova data da consulta (dd/mm/aaaa): ");
                String dataNova = scanner.nextLine();
                sistema.alterarDataConsulta(cpf, dataAntiga, dataNova);

            } else if (opcao == 5) {
                System.out.print("Data para listar as consultas (dd/mm/aaaa): ");
                String data = scanner.nextLine();
                sistema.listarConsultasDoDia(data);

            } else if (opcao == 6) {
                System.out.println("Saindo...");
                break;
            } else {
                System.out.println("Opção inválida! Tente novamente.");
            }
        }
        scanner.close();
    }
}