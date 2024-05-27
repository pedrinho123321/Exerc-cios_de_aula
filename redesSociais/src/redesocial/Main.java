package redesocial;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("\nBem-vindo à central de Redes Sociais.");

        // Criação de conta
        System.out.print("Para começar, crie sua conta.\nDigite seu nome: ");
        String nome = sc.nextLine();
        System.out.print("Digite seu email: ");
        String email = sc.nextLine();
        System.out.print("Crie uma senha: ");
        String senha = sc.nextLine();

        // Instanciando as redes sociais com a senha e número inicial de amigos
        RedeSocial facebook = new Facebook(senha, 0);
        RedeSocial twitter = new Twitter(senha, 0);
        RedeSocial instagram = new Instagram(senha, 0);
        RedeSocial googlePlus = new GooglePlus(senha, 0);

        Usuario usuario = new Usuario(nome, email, facebook, twitter, instagram, googlePlus);

        boolean controle = true;
        int escolhaRede;

        while (controle) {
            System.out.println("\nEm qual rede social você quer mexer?");
            System.out.println("(1) Facebook");
            System.out.println("(2) Twitter");
            System.out.println("(3) Instagram");
            System.out.println("(4) GooglePlus");
            System.out.println("(0) Sair");
            System.out.print("Escolha uma opção: ");
            escolhaRede = sc.nextInt();
            sc.nextLine();

            switch (escolhaRede) {
                case 1:
                    acoesRedeSocial(facebook, sc, true, true);
                    break;
                case 2:
                    acoesRedeSocial(twitter, sc, true, false);
                    break;
                case 3:
                    acoesRedeSocial(instagram, sc, false, false);
                    break;
                case 4:
                    acoesRedeSocial(googlePlus, sc, true, true);
                    break;
                case 0:
                    controle = false;
                    break;
                default:
                    System.out.println("Opção inválida.");
                    break;
            }
        }
        sc.close();
        System.out.println("Sessão encerrada. Até mais!");
    }

    public static void acoesRedeSocial(RedeSocial rede, Scanner sc, boolean podeCompartilhar, boolean podeFazerVideoConferencia) {
        System.out.println("\nO que você gostaria de fazer?");
        System.out.println("(1) Postar foto");
        System.out.println("(2) Postar vídeo");
        System.out.println("(3) Postar comentário");
        System.out.println("(4) Curtir publicação");
        if (podeCompartilhar) {
            System.out.println("(5) Compartilhar");
        }
        if (podeFazerVideoConferencia) {
            System.out.println("(6) Fazer videoconferência");
        }
        System.out.println("(7) Adicionar um amigo");
        System.out.println("(8) Mostrar número de amigos");
        System.out.println("(0) Voltar");
        System.out.print("Escolha uma ação: ");
        int acao = sc.nextInt();
        sc.nextLine();

        switch (acao) {
            case 1:
                rede.postarFoto();
                break;
            case 2:
                rede.postarVideo();
                break;
            case 3:
                rede.postarComentario();
                break;
            case 4:
                rede.curtirPublicacao();
                break;
            case 5:
                if (rede instanceof Compartilhamento) {
                    ((Compartilhamento) rede).compartilhar();
                }
                break;
            case 6:
                if (rede instanceof VideoConferencia) {
                    ((VideoConferencia) rede).fazerStreaming();
                }
                break;
            case 7:
                rede.adicionarAmigo();
                break;
            case 8:
                rede.mostrarAmigos();
                break;
            case 0:
                // Nada a fazer, apenas volta ao menu anterior
                break;
            default:
                System.out.println("Ação inválida.");
                break;
        }
    }
}
