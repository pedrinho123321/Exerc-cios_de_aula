package org.example;

import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        boolean sair = false;
        SecretarioBD secretarioBD = new SecretarioBD();


        while (!sair) {
            System.out.println("+-------------------------------------------------------------+");
            System.out.println("|                   Bem vindo à Clinica Vilas                 |");
            System.out.println("+-------------------------------------------------------------+");
            System.out.println("\nPor favor selecione uma das opções abaixo: ");
            System.out.println("1 - Sou Dentista");
            System.out.println("2 - Sou Paciente");
            System.out.println("3 - Sou Secretário");
            System.out.println("4 - Sair");
            System.out.print("\nOpção: ");
            int opcaoPrincipal = sc.nextInt();
            sc.nextLine();

            switch (opcaoPrincipal) {
                case 1:
                    menuDentista(sc);
                    break;
                case 2:
                    menuPaciente(sc);
                    break;
                case 3:
                    menuSecretario(sc, secretarioBD);
                    break;
                case 4:
                    System.out.println("Saindo do programa");
                    sair = true;
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
        }

        sc.close();
    }

    public static void menuDentista(Scanner sc) {
        DentistaBD dentistaBD = new DentistaBD();
        PacienteBD pacienteBD = new PacienteBD();
        SecretarioBD secretarioBD = new SecretarioBD();
        AuxiliarBD auxiliarBD = new AuxiliarBD();
        boolean voltarMenu = false;

        while (!voltarMenu) {
            System.out.println("\n+-------------------------------------------------------------+");
            System.out.println("|                        Menu Dentista                        |");
            System.out.println("+-------------------------------------------------------------+");
            System.out.println("Por favor selecione uma das opções abaixo: ");
            System.out.println("1 - Adicionar Dentista");
            System.out.println("2 - Remover Dentista");
            System.out.println("3 - Ver Dentistas");
            System.out.println("4 - Ver Pacientes do Dentista");
            System.out.println("5 - Remover Paciente");
            System.out.println("6 - Adicionar Auxiliar");
            System.out.println("7 - Buscar Secretário pelo ID");
            System.out.println("8 - Buscar Auxiliar pelo ID");
            System.out.println("9 - Remover Auxiliar");
            System.out.println("10 - Voltar ao Menu Principal");
            System.out.print("\nOpção: ");
            int opcaoDentista = sc.nextInt();
            sc.nextLine();

            switch (opcaoDentista) {
                case 1:
                    System.out.println("\n=================================================================");
                    System.out.println("                    Adicionando Dentista                   ");
                    System.out.println("=================================================================");
                    System.out.print("\nEntre com seu nome: ");
                    String nomeDentista = sc.nextLine();
                    System.out.print("\nEntre com sua especialidade: ");
                    String especialidadeDentista = sc.nextLine();
                    System.out.print("\nEntre com o seu CRO: ");
                    int CRO = sc.nextInt();
                    sc.nextLine();
                    System.out.print("\nEntre com o seu telefone: ");
                    String telefoneDentista = sc.nextLine();

                    Dentista dentista = new Dentista(nomeDentista, especialidadeDentista, telefoneDentista, CRO);
                    dentistaBD.insertDentista(dentista);
                    System.out.println("Conta criada com sucesso. Aperte enter para continuar.");
                    sc.nextLine();
                    break;
                case 2:
                    System.out.println("\n=================================================================");
                    System.out.println("                    Removendo Dentista                   ");
                    System.out.println("=================================================================");
                    System.out.print("\nDigite o CRO do dentista que deseja remover: ");
                    int croRemover = sc.nextInt();
                    sc.nextLine();

                    if (dentistaBD.deleteDentista(croRemover)) {
                        System.out.println("Dentista removido com sucesso.");
                    } else {
                        System.out.println("Não foi possível remover o dentista.");
                    }
                    System.out.println("Aperte enter para continuar.");
                    sc.nextLine();
                    break;
                case 3:
                    System.out.println("\n=================================================================");
                    System.out.println("                    Ver Dentistas                   ");
                    System.out.println("=================================================================");
                    System.out.println("\nDigite o CRO do dentista que deseja visualizar: ");
                    int croVer = sc.nextInt();
                    sc.nextLine();

                    Dentista dentistaRetorno = dentistaBD.selectDentistaCRO(croVer);
                    if (dentistaRetorno == null) {
                        System.out.println("Dentista não encontrado.");
                    } else {
                        System.out.println("\nNome: " + dentistaRetorno.getNome());
                        System.out.println("Especialidade: " + dentistaRetorno.getEspecialidade());
                        System.out.println("Telefone: " + dentistaRetorno.getTelefone());
                        System.out.println("CRO: " + dentistaRetorno.getCRO());
                    }
                    System.out.println("Aperte enter para continuar.");
                    sc.nextLine();
                    break;
                case 4:
                    System.out.println("\n=================================================================");
                    System.out.println("                    Ver Pacientes do Dentista                   ");
                    System.out.println("=================================================================");
                    System.out.println("\nDigite o CRO do dentista para ver seus pacientes: ");
                    int croVerPacientes = sc.nextInt();
                    sc.nextLine();

                    ArrayList<Paciente> pacientes = pacienteBD.selectPacientesDentista(croVerPacientes);
                    if (pacientes.isEmpty()) {
                        System.out.println("O dentista não possui pacientes registrados.");
                    } else {
                        for (Paciente p : pacientes) {
                            System.out.println("\nNome: " + p.getNome());
                            System.out.println("Idade: " + p.getIdade());
                            System.out.println("Telefone: " + p.getTelefone());
                            System.out.println("ID: " + p.getIdPaciente());
                        }
                    }
                    System.out.println("Aperte enter para continuar.");
                    sc.nextLine();
                    break;
                case 5:
                    System.out.println("\n=================================================================");
                    System.out.println("                    Removendo Paciente                   ");
                    System.out.println("=================================================================");
                    System.out.print("\nDigite o ID do paciente que deseja remover: ");
                    int idPacienteRemover = sc.nextInt();
                    sc.nextLine();

                    if (pacienteBD.deletePaciente(idPacienteRemover)) {
                        System.out.println("Paciente removido com sucesso.");
                    } else {
                        System.out.println("Não foi possível remover o paciente.");
                    }
                    System.out.println("Aperte enter para continuar.");
                    sc.nextLine();
                    break;
                case 6:
                    System.out.println("\n=================================================================");
                    System.out.println("                    Adicionando Auxiliar                   ");
                    System.out.println("=================================================================");
                    System.out.print("\nEntre com o ID do auxiliar: ");
                    int idAuxiliar = sc.nextInt();
                    sc.nextLine();
                    System.out.print("\nEntre com o nome do auxiliar: ");
                    String nomeAuxiliar = sc.nextLine();
                    System.out.print("\nEntre com o telefone do auxiliar: ");
                    String telefoneAuxiliar = sc.nextLine();
                    System.out.print("\nEntre com o CRO do dentista associado: ");
                    int croDentistaAuxiliar = sc.nextInt();
                    sc.nextLine();

                    Auxiliar auxiliar = new Auxiliar(idAuxiliar, nomeAuxiliar, telefoneAuxiliar, croDentistaAuxiliar);
                    if (auxiliarBD.insertAuxiliar(auxiliar)) {
                        System.out.println("Auxiliar adicionado com sucesso.");
                    } else {
                        System.out.println("Não foi possível adicionar o auxiliar.");
                    }
                    System.out.println("Aperte enter para continuar.");
                    sc.nextLine();
                    break;
                case 7:
                    System.out.println("\n=================================================================");
                    System.out.println("               Buscar Secretário pelo ID                   ");
                    System.out.println("=================================================================");
                    System.out.print("\nDigite o ID do secretário que deseja buscar: ");
                    int idSecretarioBuscar = sc.nextInt();
                    sc.nextLine();

                    Secretario secretarioEncontrado = secretarioBD.selectSecretario(idSecretarioBuscar);
                    if (secretarioEncontrado == null) {
                        System.out.println("Secretário não encontrado.");
                    } else {
                        System.out.println("\nID: " + secretarioEncontrado.getIdSecretario());
                        System.out.println("Nome: " + secretarioEncontrado.getNome());
                        System.out.println("Telefone: " + secretarioEncontrado.getTelefone());
                    }
                    System.out.println("Aperte enter para continuar.");
                    sc.nextLine();
                    break;
                case 8:
                    System.out.println("\n=================================================================");
                    System.out.println("                    Buscar Auxiliar pelo ID                   ");
                    System.out.println("=================================================================");
                    System.out.print("\nDigite o ID do auxiliar que deseja buscar: ");
                    int idAuxiliarBuscar = sc.nextInt();
                    sc.nextLine();

                    Auxiliar auxiliarBuscado = auxiliarBD.selectAuxiliarId(idAuxiliarBuscar);
                    if (auxiliarBuscado == null) {
                        System.out.println("Auxiliar não encontrado.");
                    } else {
                        System.out.println("\nID: " + auxiliarBuscado.getIdAuxiliar());
                        System.out.println("Nome: " + auxiliarBuscado.getNome());
                        System.out.println("Telefone: " + auxiliarBuscado.getTelefone());
                    }
                    System.out.println("Aperte enter para continuar.");
                    sc.nextLine();
                    break;
                case 9:
                    System.out.println("\n=================================================================");
                    System.out.println("                    Remover Auxiliar                   ");
                    System.out.println("=================================================================");
                    System.out.print("\nDigite o ID do auxiliar que deseja remover: ");
                    int idAuxiliarRemover = sc.nextInt();
                    sc.nextLine();

                    if (auxiliarBD.deleteAuxiliar(idAuxiliarRemover)) {
                        System.out.println("Auxiliar removido com sucesso.");
                    } else {
                        System.out.println("Não foi possível remover o auxiliar.");
                    }
                    System.out.println("Aperte enter para continuar.");
                    sc.nextLine();
                    break;
                case 10:
                    voltarMenu = true;
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
        }
    }

    public static void menuPaciente(Scanner sc) {
        DentistaBD dentistaBD = new DentistaBD();
        PacienteBD pacienteBD = new PacienteBD();
        boolean voltarMenu = false;

        while (!voltarMenu) {
            System.out.println("\n+-------------------------------------------------------------+");
            System.out.println("|                        Menu Paciente                        |");
            System.out.println("+-------------------------------------------------------------+");
            System.out.println("Por favor selecione uma das opções abaixo: ");
            System.out.println("1 - Criar conta para Paciente");
            System.out.println("2 - Ver informações do Paciente");
            System.out.println("3 - Listar todos os Dentistas");
            System.out.println("4 - Voltar ao Menu Principal");
            System.out.print("\nOpção: ");
            int opcaoPaciente = sc.nextInt();
            sc.nextLine();

            switch (opcaoPaciente) {
                case 1:
                    System.out.println("\n=================================================================");
                    System.out.println("                    Adicionando Paciente                   ");
                    System.out.println("=================================================================");
                    System.out.print("\nEntre com seu nome: ");
                    String nomePaciente = sc.nextLine();
                    System.out.print("\nEntre com sua idade: ");
                    String idadePaciente = sc.nextLine();
                    System.out.print("\nEntre com o seu telefone: ");
                    String telefonePaciente = sc.nextLine();
                    System.out.print("\nEntre com o ID do paciente: ");
                    int idPaciente = sc.nextInt();
                    sc.nextLine();
                    System.out.print("\nEntre com o CRO do seu dentista: ");
                    int dentistaCRO = sc.nextInt();
                    sc.nextLine();

                    // Verificar se o Dentista existe antes de adicionar o paciente
                    Dentista dentista = dentistaBD.selectDentistaCRO(dentistaCRO);
                    if (dentista == null) {
                        System.out.println("Dentista não encontrado. Não é possível adicionar o paciente.");
                    } else {
                        Paciente paciente = new Paciente(nomePaciente, idadePaciente, telefonePaciente, idPaciente, dentistaCRO);
                        if (pacienteBD.insertPaciente(paciente)) {
                            System.out.println("Paciente adicionado com sucesso.");
                        } else {
                            System.out.println("Não foi possível adicionar o paciente.");
                        }
                    }
                    System.out.println("Aperte enter para continuar.");
                    sc.nextLine();
                    break;
                case 2:
                    System.out.println("\n=================================================================");
                    System.out.println("                    Ver Paciente                   ");
                    System.out.println("=================================================================");
                    System.out.print("\nDigite o ID do paciente que deseja visualizar: ");
                    int idVer = sc.nextInt();
                    sc.nextLine();

                    Paciente pacienteRetorno = pacienteBD.selectPacienteId(idVer);
                    if (pacienteRetorno == null) {
                        System.out.println("Paciente não encontrado.");
                    } else {
                        System.out.println("\nNome: " + pacienteRetorno.getNome());
                        System.out.println("\nIdade: " + pacienteRetorno.getIdade());
                        System.out.println("\nTelefone: " + pacienteRetorno.getTelefone());
                        System.out.println("\nID: " + pacienteRetorno.getIdPaciente());
                    }
                    System.out.println("Aperte enter para continuar.");
                    sc.nextLine();
                    break;
                case 3:
                    System.out.println("\n=================================================================");
                    System.out.println("                    Lista de Dentistas                   ");
                    System.out.println("=================================================================");
                    ArrayList<Dentista> dentistas = dentistaBD.selectAll();
                    if (dentistas.isEmpty()) {
                        System.out.println("Nenhum dentista encontrado.");
                    } else {
                        for (Dentista d : dentistas) {
                            System.out.println("\nNome: " + d.getNome());
                            System.out.println("Especialidade: " + d.getEspecialidade());
                            System.out.println("Telefone: " + d.getTelefone());
                            System.out.println("CRO: " + d.getCRO());
                            System.out.println("-----------------------------------");
                        }
                    }
                    System.out.println("Aperte enter para continuar.");
                    sc.nextLine();
                    break;
                case 4:
                    voltarMenu = true;
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
        }
    }

    public static void menuSecretario(Scanner sc, SecretarioBD secretarioBD) {
        DentistaHasSecretarioBD dentistahassecretarioBD = new DentistaHasSecretarioBD();
        DentistaBD dentistaBD = new DentistaBD();
        PacienteBD pacienteBD = new PacienteBD();
        boolean voltarMenu = false;

        while (!voltarMenu) {
            System.out.println("\n+-------------------------------------------------------------+");
            System.out.println("|                       Menu Secretário                       |");
            System.out.println("+-------------------------------------------------------------+");
            System.out.println("Por favor selecione uma das opções abaixo: ");
            System.out.println("1 - Adicionar Secretário");
            System.out.println("2 - Remover Secretário");
            System.out.println("3 - Relacionar Secretário a um Dentista");
            System.out.println("4 - Adicionar Paciente");
            System.out.println("5 - Voltar ao Menu Principal");
            System.out.print("\nOpção: ");
            int opcaoSecretario = sc.nextInt();
            sc.nextLine();

            switch (opcaoSecretario) {
                case 1:
                    System.out.println("\n=================================================================");
                    System.out.println("                    Adicionando Secretário                   ");
                    System.out.println("=================================================================");
                    System.out.print("\nEntre com o ID do secretário: ");
                    int idSecretario = sc.nextInt();
                    sc.nextLine();
                    System.out.print("\nEntre com o nome do secretário: ");
                    String nomeSecretario = sc.nextLine();
                    System.out.print("\nEntre com o telefone do secretário: ");
                    String telefoneSecretario = sc.nextLine();
                    System.out.print("\nEntre com o CRO do dentista associado: ");
                    int croDentista = sc.nextInt();
                    sc.nextLine();

                    Secretario secretario = new Secretario(idSecretario, nomeSecretario, telefoneSecretario);
                    if (secretarioBD.insertSecretario(secretario, croDentista)) {
                        System.out.println("Secretário adicionado com sucesso.");
                    } else {
                        System.out.println("Não foi possível adicionar o secretário.");
                    }
                    System.out.println("Aperte enter para continuar.");
                    sc.nextLine();
                    break;
                case 2:
                    System.out.println("\n=================================================================");
                    System.out.println("                    Removendo Secretário                   ");
                    System.out.println("=================================================================");
                    System.out.print("\nDigite o ID do secretário que deseja remover: ");
                    int idRemover = sc.nextInt();
                    sc.nextLine();

                    if (secretarioBD.deleteSecretario(idRemover)) {
                        System.out.println("Secretário removido com sucesso.");
                    } else {
                        System.out.println("Não foi possível remover o secretário.");
                    }
                    System.out.println("Aperte enter para continuar.");
                    sc.nextLine();
                    break;
                case 3:
                    System.out.println("\n=================================================================");
                    System.out.println("   Relacionar Secretário a um Dentista   ");
                    System.out.println("=================================================================");
                    System.out.print("\nDigite o ID do secretário: ");
                    int idSecretarioRelacionar = sc.nextInt();
                    sc.nextLine();
                    System.out.print("\nDigite o CRO do dentista: ");
                    int croDentistaRelacionar = sc.nextInt();
                    sc.nextLine();

                    if (dentistahassecretarioBD.insertDentistaHasSecretario(croDentistaRelacionar, idSecretarioRelacionar)) {
                        System.out.println("Relacionamento entre secretário e dentista criado com sucesso.");
                    } else {
                        System.out.println("Não foi possível criar o relacionamento.");
                    }
                    System.out.println("Aperte enter para continuar.");
                    sc.nextLine();
                    break;
                case 4:
                    System.out.println("\n=================================================================");
                    System.out.println("                    Adicionando Paciente                   ");
                    System.out.println("=================================================================");
                    System.out.print("\nEntre com o nome do paciente: ");
                    String nomePaciente = sc.nextLine();
                    System.out.print("\nEntre com a idade do paciente: ");
                    String idadePaciente = sc.nextLine();
                    System.out.print("\nEntre com o telefone do paciente: ");
                    String telefonePaciente = sc.nextLine();
                    System.out.print("\nEntre com o ID do paciente: ");
                    int idPaciente = sc.nextInt();
                    sc.nextLine();
                    System.out.print("\nEntre com o CRO do dentista associado: ");
                    croDentista = sc.nextInt();
                    sc.nextLine();

                    // Verificar se o Dentista existe antes de adicionar o paciente
                    Dentista dentista = dentistaBD.selectDentistaCRO(croDentista);
                    if (dentista == null) {
                        System.out.println("Dentista não encontrado. Não é possível adicionar o paciente.");
                    } else {
                        Paciente paciente = new Paciente(nomePaciente, idadePaciente, telefonePaciente, idPaciente, croDentista);
                        if (pacienteBD.insertPaciente(paciente)) {
                            System.out.println("Paciente adicionado com sucesso.");
                        } else {
                            System.out.println("Não foi possível adicionar o paciente.");
                        }
                    }
                    System.out.println("Aperte enter para continuar.");
                    sc.nextLine();
                    break;
                case 5:
                    voltarMenu = true;
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
        }
    }
}



