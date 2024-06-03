import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Arquivo arq = new Arquivo();
        Scanner sc = new Scanner(System.in);
        boolean flag = true;

        while (flag) {

            System.out.println("Bem vindo ao menu!");
            System.out.println("1 - Cadastrar Cliente");
            System.out.println("2 - Listar Clientes");
            System.out.println("3 - Ordenar Clientes A-Z");
            System.out.println("4 - Ordenar Clientes Z-A");
            System.out.println("5 - Sair");
            int op = sc.nextInt();
            sc.nextLine();

            switch (op) {
                case 1:
                    Cliente cliente = new Cliente();
                    System.out.println("Nome do cliente:");
                    cliente.setNomeCliente(sc.nextLine());
                    System.out.println("CPF do cliente:");
                    cliente.setCpfCliente(sc.nextLine());

                    arq.escreverCliente(cliente);
                    break;

                case 2:
                    ArrayList<Cliente> clientes = arq.lerClientes();
                    for (Cliente c : clientes) {
                        System.out.println("Nome: " + c.getNomeCliente());
                        System.out.println("CPF: " + c.getCpfCliente());
                        System.out.println("-----------");
                    }
                    break;

                case 3:
                    clientes = arq.lerClientes();
                    arq.ordenarClientesAZ(clientes);
                    for (Cliente c : clientes) {
                        System.out.println("Nome: " + c.getNomeCliente());
                        System.out.println("CPF: " + c.getCpfCliente());
                        System.out.println("-----------");
                    }
                    break;

                case 4:
                    clientes = arq.lerClientes();
                    arq.ordenarClientesZA(clientes);
                    for (Cliente c : clientes) {
                        System.out.println("Nome: " + c.getNomeCliente());
                        System.out.println("CPF: " + c.getCpfCliente());
                        System.out.println("-----------");
                    }
                    break;

                case 5:
                    flag = false;
                    break;

                default:
                    System.out.println("Opção inválida.");
                    break;
            }
        }
    }
}