package redesocial;

// Classe abstrata RedeSocial
abstract class RedeSocial {
    protected String senha;
    protected int numAmigos;

    public RedeSocial(String senha, int numAmigos) {
        this.senha = senha;
        this.numAmigos = numAmigos;
    }

    // Métodos para adicionar e mostrar número de amigos
    public void adicionarAmigo() {
        numAmigos++;
        System.out.println("Um novo amigo foi adicionado! Agora você tem " + numAmigos + " amigos.");
    }

    public void mostrarAmigos() {
        System.out.println("Você tem " + numAmigos + " amigos nesta rede social.");
    }

    // Métodos abstratos e não abstratos
    public abstract void postarFoto();
    public abstract void postarVideo();
    public void postarComentario() {
        System.out.println("Postou um comentário!");
    }
    public void curtirPublicacao() {
        System.out.println("Curtiu uma publicação!");
    }
}