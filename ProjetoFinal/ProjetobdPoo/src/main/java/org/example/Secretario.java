package org.example;

public class Secretario {
    private int IdSecretario;
    private String nome;
    private String telefone;


    public Secretario(int idSecretario, String nome, String telefone) {
        IdSecretario = idSecretario;
        this.nome = nome;
        this.telefone = telefone;
    }

    public int getIdSecretario() {
        return IdSecretario;
    }

    public String getNome() {
        return nome;
    }

    public String getTelefone() {
        return telefone;
    }

}
