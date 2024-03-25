import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Cliente cliente = new Cliente();
        MemoriaUSB memoria1 = new MemoriaUSB();
        MemoriaUSB memoria2 = new MemoriaUSB();
        MemoriaUSB memoria3 = new MemoriaUSB();
        Computador computador1 = new Computador();
        Computador computador2 = new Computador();
        Computador computador3 = new Computador();

        computador1.marca = "Positivo";
        computador1.preco = 2300;
        computador1.so.nome = "Linux Ubuntu";
        computador1.so.tipo = 32;
        computador1.hb.nome = "Pentium Core i3 (2200 Mhz)";
        computador1.hb.capacidade = 500;
        memoria1.nome = "Pen-drive";
        memoria1.capacidade = 16;

        computador2.marca = "Acer";
        computador2.preco = 5800;
        computador2.so.nome = "Windows 8";
        computador2.so.tipo = 64;
        computador2.hb.nome = "Pentium Core i5 (3370 Mhz)";
        computador2.hb.capacidade = 1000;
        memoria2.nome = "Pen-drive";
        memoria2.capacidade = 32;

        computador3.marca = "Vaio";
        computador3.preco = 1800;
        computador3.so.nome = "Windows 10";
        computador3.so.tipo = 64;
        computador3.hb.nome = "Pentium Core i7 (4500 Mhz)";
        computador3.hb.capacidade = 2000;
        memoria3.nome = "HD externo";
        memoria3.capacidade = 1000;

        boolean controle = true;

        System.out.println("\n Criando o seu Cadastro.");
        System.out.print("Seu nome: ");
        cliente.nome = sc.nextLine();
        System.out.print("CPF: ");
        cliente.cpf = sc.nextLong();

        while (controle){
            System.out.println("\n ⧽ Melhores promoções");
            System.out.println("(1) Promoção POSITIVO");
            System.out.println("(2) Promoção ACER");
            System.out.println("(3) Promoção VAIO");
            System.out.println("(0) Checkout");
            System.out.print("Digite uma opção: ");
            int opcao = sc.nextInt();
            sc.nextLine();
            switch (opcao){
                case 1:
                    System.out.println("\n");
                    System.out.println("PROMOÇÃO 1");
                    computador1.mostraPCConfigs();
                    System.out.println("Brinde: pen-drive 16Gb");
                    System.out.println("\nAdiconar ao carrinho?");
                    System.out.println("(S)im (N)ão");
                    String carrinho = sc.nextLine();
                    if (carrinho.equalsIgnoreCase("S")) {
                        System.out.println("Computador adicionado no carrinho junto com o brinde!!!");
                        cliente.addPC(computador1);
                    }

                    break;
                case 2:
                    System.out.println("\n");
                    System.out.println("PROMOÇÃO 2");
                    computador2.mostraPCConfigs();
                    System.out.println("Brinde: pen-drive 32Gb");
                    System.out.println("\nAdiconar ao carrinho?");
                    System.out.println("(S)im (N)ão");
                    carrinho = sc.nextLine();
                    if (carrinho.equalsIgnoreCase("S")) {
                        System.out.println("Computador adicionado no carrinho junto com o brinde!!!");
                        cliente.addPC(computador2);
                    }

                    break;

                case 3:
                    System.out.println("\n");
                    System.out.println("PROMOÇÃO 3");
                    computador3.mostraPCConfigs();
                    System.out.println("Brinde: HD externo de 1Tb ");
                    System.out.println("\nAdiconar ao carrinho?");
                    System.out.println("(S)im (N)ão");
                    carrinho = sc.nextLine();
                    if (carrinho.equalsIgnoreCase("S")) {
                        System.out.println("Computador adicionado no carrinho junto com o brinde!!!");
                        cliente.addPC(computador3);
                    }

                    break;
                case 0:
                    controle = false;

                    break;
                default:
                    System.out.println("Opção inválida");

                    break;
            }
        }
        for (int i = 0; i < cliente.pcAdiquirido.length; i++) {
            if (cliente.pcAdiquirido[i] != null) {
                if (cliente.pcAdiquirido[i].marca.equalsIgnoreCase("Positivo"))
                    computador1.addMemoriaUSB(memoria1);
                if (cliente.pcAdiquirido[i].marca.equalsIgnoreCase("Acer"))
                    computador2.addMemoriaUSB(memoria2);
                if (cliente.pcAdiquirido[i].marca.equalsIgnoreCase("Vaio"))
                    computador3.addMemoriaUSB(memoria3);
            }
        }
        System.out.println("\nCarrinho");
        for (int i = 0; i < cliente.pcAdiquirido.length; i++) {
            if (cliente.pcAdiquirido[i] != null) {
                cliente.pcAdiquirido[i].mostraPCConfigs();
            }
        }
        System.out.println("Valor total: R$" + cliente.calculaTotalCompra());
    }
}