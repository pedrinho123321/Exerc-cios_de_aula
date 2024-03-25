public class Cliente {

    String nome;
    Long cpf;

    Computador[] pcAdiquirido = new Computador[3];

    float calculaTotalCompra() {
        float valorFinal = 0;
        for (int i = 0; i < pcAdiquirido.length; i++) {
            if (pcAdiquirido[i] != null)
                valorFinal += pcAdiquirido[i].preco;
        }
        return valorFinal;
    }
    void addPC(Computador pc) {
        for (int i = 0; i < pcAdiquirido.length; i++) {
            if (pcAdiquirido[i] == null) {
                pcAdiquirido[i] = pc;
                break;
            }
        }
    }
}
