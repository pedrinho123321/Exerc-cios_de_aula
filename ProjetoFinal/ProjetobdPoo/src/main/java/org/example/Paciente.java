package org.example;

public class Paciente {
    private String Nome;
    private String Idade;
    private String Telefone;
    private int IdPaciente;
    private int Dentista_CRO;

    public Paciente(String nome, String idade, String telefone, int idPaciente, int dentista_CRO) {
        Nome = nome;
        Idade = idade;
        Telefone = telefone;
        IdPaciente = idPaciente;
        Dentista_CRO = dentista_CRO;
    }

    public String getNome() {

        return Nome;
    }

    public String getIdade() {

        return Idade;
    }

    public String getTelefone() {

        return Telefone;
    }

    public int getIdPaciente() {

        return IdPaciente;
    }

    public int getDentista_CRO() {

        return Dentista_CRO;
    }
}
