package org.example;

public class Dentista {
    private String nome;
    private String especialidade;
    private String telefone;
    private int CRO;

    public Dentista(String nome, String especialidade, String telefone, int CRO) {
        this.nome = nome;
        this.especialidade = especialidade;
        this.telefone = telefone;
        this.CRO = CRO;
    }

    public String getNome() {
        return nome;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public String getTelefone() {
        return telefone;
    }

    public int getCRO() {
        return CRO;
    }
}