public abstract class Habitante {
    public static int contador = 0;
    protected int id;
    protected String nome;
    protected int idade;
    protected float energia;

    public Habitante() {
        this.contador++;
        this.id = contador;
    }

    Arma arma; // Habitante pode ou não ter uma arma

    public void atacar() {
        if (this.arma == null) {
            System.out.println("Arma não foi adicionada");
        } else {
            System.out.println("Info da arma");
            System.out.println("Nome: " + arma.getNomeArma());
            System.out.println("Mágica: " + arma.isMagica());

            if (arma.isMagica()) {
                System.out.println("Atace com arma mágica");
                this.energia -= 20;
            } else {
                System.out.println("Ataque sem arma mágica");
                this.energia -= 10;
            }
            System.out.println("Energia após o ataque: " + this.energia);
        }
    }

    public void mostraInfo() {
        System.out.println("ID: " + this.id);
        System.out.println("Nome: " + this.nome);
        System.out.println("Idade: " + this.idade);
        System.out.println("Energia: " + this.energia);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public float getEnergia() {
        return energia;
    }

    public void setEnergia(float energia) {
        this.energia = energia;
    }
}
