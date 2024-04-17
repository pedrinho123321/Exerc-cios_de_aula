public class TerraMedia {
    private Habitante[] herois = new Habitante[10];

    public void addHabitante(Habitante habitante) {
        for (int i = 0; i < herois.length; i++) {
            if (herois[i] == null) {
                herois[i] = habitante;
                break;
            }
        }
    }

    public void listarHabitantes() {
        for (int i = 0; i < herois.length; i++) {
            if (herois[i] != null) {
                if (herois[i] instanceof Anao) {
                    Anao auxAnao = (Anao) herois[i];
                    auxAnao.mostraInfo();
                    auxAnao.atacar();
                    System.out.print("\n");

                } else if (herois[i] instanceof Elfo) {
                    Elfo auxElfo = (Elfo) herois[i];
                    auxElfo.mostraInfo();
                    auxElfo.atacar();
                    auxElfo.viajar();
                    System.out.print("\n");

                } else if (herois[i] instanceof Mago) {
                    Mago auxMago = (Mago) herois[i];
                    auxMago.mostraInfo();
                    auxMago.atacar();
                    System.out.print("\n");
                }
            }
        }
    }
}
