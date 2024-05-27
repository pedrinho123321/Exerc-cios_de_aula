package redesocial;
// Classes concretas que estendem RedeSocial e implementam as interfaces
class Facebook extends RedeSocial implements VideoConferencia, Compartilhamento {
    public Facebook(String senha, int numAmigos) {
        super(senha, numAmigos);
    }

    @Override
    public void postarFoto() {
        System.out.println("Postou uma foto no Facebook!");
    }

    @Override
    public void postarVideo() {
        System.out.println("Postou um vídeo no Facebook!");
    }

    @Override
    public void fazerStreaming() {
        System.out.println("Realizou uma vídeo conferência no Facebook!");
    }

    @Override
    public void compartilhar() {
        System.out.println("Compartilhou um post no Facebook!");
    }
}