package redesocial;

class Instagram extends RedeSocial implements Compartilhamento {
    public Instagram(String senha, int numAmigos) {
        super(senha,numAmigos);
    }

    @Override
    public void postarFoto() {
        System.out.println("Postou uma foto no Instagram!");
    }

    @Override
    public void postarVideo() {
        System.out.println("Postou um vídeo no Instagram!");
    }

    @Override
    public void compartilhar() {
        System.out.println("Compartilhou um post no Instagram!");
    }
}