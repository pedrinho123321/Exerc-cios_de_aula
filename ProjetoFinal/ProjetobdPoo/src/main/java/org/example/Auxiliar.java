package org.example;

public class Auxiliar {
    private int idAuxiliar;
    private String nome;
    private String telefone;
    private int Dentista_CRO;

    public Auxiliar(int idAuxiliar, String nome, String telefone, int dentista_CRO) {
        this.idAuxiliar = idAuxiliar;
        this.nome = nome;
        this.telefone = telefone;
        Dentista_CRO = dentista_CRO;
    }

    public int getIdAuxiliar() {
        return idAuxiliar;
    }

    public String getNome() {
        return nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public int getDentista_CRO() {
        return Dentista_CRO;
    }
}
