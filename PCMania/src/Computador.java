public class Computador {
    String marca;
    float preco;
    SistemaOperacional so;
    HardwareBasico hb;

    public Computador() {
        so = new SistemaOperacional();
        hb = new HardwareBasico();
    }


    void mostraPCConfigs(){
        System.out.println("Marca: " + this.marca);
        System.out.println("Preco: " + this.preco);
        System.out.println("Processador: " + hb.nome);
        System.out.println("Armazenamento: " + hb.capacidade);
        System.out.println("Sistema Operacional: " + so.nome + " (" + so.tipo + " bits)");
    }
    void addMemoriaUSB(MemoriaUSB musb){
        hb.capacidade += musb.capacidade;
    }
}
