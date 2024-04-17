public class Main {
    public static void main(String[] args) {
        TerraMedia terraMedia = new TerraMedia();

        //Criando armas
        Arma arma1 = new Arma();
        arma1.setNomeArma("Martelo");
        arma1.setMagica(false);

        Arma arma2 = new Arma();
        arma2.setNomeArma("Arco e flecha");
        arma2.setMagica(false);

        Arma arma3 = new Arma();
        arma3.setNomeArma("Varinha mágica");
        arma3.setMagica(true);

        //Criando os heróis
        Anao anao = new Anao();
        anao.setNome("Thorin");
        anao.setEnergia(100);
        anao.setIdade(25);
        anao.setAltura(0.2f);
        anao.setReino("Erebor");
        anao.arma = arma1;
        terraMedia.addHabitante(anao);

        Elfo elfo = new Elfo();
        elfo.setNome("Legolas");
        elfo.setEnergia(100);
        elfo.setIdade(364);
        elfo.setTribo("Floresta das Trevas");
        elfo.arma = arma2;
        terraMedia.addHabitante(elfo);

        Mago mago = new Mago();
        mago.setNome("Gandalf");
        mago.setEnergia(2000);
        mago.setIdade(4963);
        mago.setCor("Branco");
        mago.arma = arma3;
        terraMedia.addHabitante(mago);


        terraMedia.listarHabitantes();
    }
}
