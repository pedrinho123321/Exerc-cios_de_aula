package redesocial;
class GooglePlus extends RedeSocial implements VideoConferencia {
    public GooglePlus(String senha, int numAmigos) {
        super(senha,numAmigos);
    }

    @Override
    public void postarFoto() {
        System.out.println("Postou uma foto no GooglePlus!");
    }

    @Override
    public void postarVideo() {
        System.out.println("Postou um vídeo no GooglePlus!");
    }

    @Override
    public void fazerStreaming() {
        System.out.println("Realizou uma vídeo conferência no GooglePlus!");
    }
}