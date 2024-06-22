package org.example;

import java.sql.SQLException;
import java.util.ArrayList;

public class PacienteBD extends ConexãoBD {

    boolean sucesso = false;

    //------------------------INSERIR NOVO REGISTRO DE Paciente NO DATABASE----------------------------
    public boolean insertPaciente(Paciente paciente) {
        connect();

        String sql = "INSERT INTO Paciente (IdPaciente, nome, idade, telefone, Dentista_CRO) VALUES (?,?,?,?,?)";

        try {
            pst = connection.prepareStatement(sql);
            pst.setInt(1, paciente.getIdPaciente());
            pst.setString(2, paciente.getNome());
            pst.setString(3, paciente.getIdade());
            pst.setString(4, paciente.getTelefone());
            pst.setInt(5, paciente.getDentista_CRO());
            pst.execute();
            sucesso = true;
        } catch (SQLException ex) {
            System.out.println("Erro de conexao  = " + ex.getMessage());
            sucesso = false;
        }
        return sucesso;
    }

    //------------------------SELECIONAR Paciente POR ID NO DATABASE----------------------------
    public Paciente selectPacienteId(int id) {
        connect();
        Paciente paciente = null;

        String sql = "SELECT * FROM Paciente WHERE IdPaciente = ?";
        try {
            pst = connection.prepareStatement(sql);
            pst.setInt(1, id);
            resultSet = pst.executeQuery();
            if (resultSet.next()) {
                paciente = new Paciente(
                        resultSet.getString("nome"),
                        resultSet.getString("idade"),
                        resultSet.getString("telefone"),
                        resultSet.getInt("IdPaciente"),
                        resultSet.getInt("Dentista_CRO")
                );
            }
        } catch (SQLException ex) {
            System.out.println("Erro = " + ex.getMessage());
        }
        return paciente;
    }

    //------------------------SELECIONAR Pacientes de um Dentista----------------------------
    public ArrayList<Paciente> selectPacientesDentista(int cro) {
        connect();
        ArrayList<Paciente> pacientes = new ArrayList<>();

        String sql = "SELECT * FROM Paciente WHERE Dentista_CRO = ?";
        try {
            pst = connection.prepareStatement(sql);
            pst.setInt(1, cro);
            resultSet = pst.executeQuery();
            while (resultSet.next()) {
                Paciente paciente = new Paciente(
                        resultSet.getString("nome"),
                        resultSet.getString("idade"),
                        resultSet.getString("telefone"),
                        resultSet.getInt("IdPaciente"),
                        resultSet.getInt("Dentista_CRO")
                );
                pacientes.add(paciente);
            }
        } catch (SQLException ex) {
            System.out.println("Erro = " + ex.getMessage());
        }
        return pacientes;
    }

    //------------------------REMOVER Paciente DO DATABASE----------------------------
    public boolean deletePaciente(int idPaciente) {
        connect();
        boolean sucesso = false;

        String sql = "DELETE FROM Paciente WHERE IdPaciente = ?";

        try {
            pst = connection.prepareStatement(sql);
            pst.setInt(1, idPaciente);
            int affectedRows = pst.executeUpdate();

            if (affectedRows > 0) {
                sucesso = true;
            } else {
                sucesso = false;
            }
        } catch (SQLException ex) {
            System.out.println("Erro de conexao  = " + ex.getMessage());
            sucesso = false;
        }
        return sucesso;
    }


}
