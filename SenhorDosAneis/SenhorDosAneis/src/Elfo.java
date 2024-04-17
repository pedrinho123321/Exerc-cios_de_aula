public class Elfo extends Habitante implements Cura{
    private String tribo;

    public String getTribo() {
        return tribo;
    }

    public void setTribo(String tribo) {
        this.tribo = tribo;
    }

    public void viajar(){
        System.out.println("O elfo está viajando...");
    }
    public void atacar(){
        System.out.println("Elfo atacou!!!");
        super.atacar();
    }
    public void mostraInfo(){
        System.out.println("--------------------");
        System.out.println("Info do elfo");
        super.mostraInfo();
        System.out.println("Tribo: " + this.tribo);
        System.out.println("--------------------");
        System.out.print("\n");
    }

    @Override
    public void curar() {
        float auxEnergia = this.energia;
        auxEnergia += (auxEnergia*0.15f);
        System.out.println("Elfo foi curado!!!");

    }
}
