public class Anao extends Habitante implements Mineracao{
    private float altura;
    private String reino;

    public void atacar(){
        System.out.println("Anão atacou!!!");
        super.atacar();
    }
    public void mostraInfo(){
        System.out.println("--------------------");
        System.out.println("Info do anão");
        super.mostraInfo();
        System.out.println("Altura: " + this.altura);
        System.out.println("Reino: " + this.reino);
        System.out.println("--------------------");
        System.out.print("\n");
    }

    public float getAltura() {
        return altura;
    }

    public void setAltura(float altura) {
        this.altura = altura;
    }

    public String getReino() {
        return reino;
    }

    public void setReino(String reino) {
        this.reino = reino;
    }

    @Override
    public void minerar() {
        System.out.println("O anão está minerando...");
    }
}
