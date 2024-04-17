public class Mago extends Habitante implements Cura, Feitico{
    String cor;

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public void atacar(){
        System.out.println("Mago atacou!!!");
        super.atacar();
    }
    public void mostraInfo(){
        System.out.println("--------------------");
        System.out.println("Info do mago");
        super.mostraInfo();
        System.out.println("Cor: " +this.cor);
        System.out.println("--------------------");
        System.out.print("\n");
    }

    @Override
    public void curar() {
        float auxEnergia = this.energia;
        auxEnergia += (auxEnergia*0.15f);
        System.out.println("Mago foi curado!!!");
    }

    @Override
    public void lancaFeitico() {
        float auxEnergia = this.energia;
        auxEnergia -= (auxEnergia*0.1f);
        this.energia = auxEnergia;
        System.out.println("Mago lançou um feitiço!!!");
    }
}
