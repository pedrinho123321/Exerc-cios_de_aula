package org.example;

import java.sql.SQLException;
import java.util.ArrayList;

public class AuxiliarBD extends ConexãoBD {

    boolean sucesso = false;

    //------------------------INSERIR NOVO REGISTRO DE Auxiliar NO DATABASE----------------------------
    public boolean insertAuxiliar(Auxiliar auxiliar) {
        connect();

        String sql = "INSERT INTO Auxiliar (idAuxiliar, nome, telefone, Dentista_CRO) VALUES (?,?,?,?)";

        try {
            pst = connection.prepareStatement(sql);
            pst.setInt(1, auxiliar.getIdAuxiliar());
            pst.setString(2, auxiliar.getNome());
            pst.setString(3, auxiliar.getTelefone());
            pst.setInt(4, auxiliar.getDentista_CRO());
            pst.execute();
            sucesso = true;
        } catch (SQLException ex) {
            System.out.println("Erro de conexao  = " + ex.getMessage());
            sucesso = false;
        }
        return sucesso;
    }

    //------------------------SELECIONAR Auxiliar POR ID NO DATABASE----------------------------
    public Auxiliar selectAuxiliarId(int id) {
        connect();
        Auxiliar auxiliar = null;

        String sql = "SELECT * FROM Auxiliar WHERE idAuxiliar = ?";
        try {
            pst = connection.prepareStatement(sql);
            pst.setInt(1, id);
            resultSet = pst.executeQuery();
            if (resultSet.next()) {
                auxiliar = new Auxiliar(
                        resultSet.getInt("idAuxiliar"),
                        resultSet.getString("nome"),
                        resultSet.getString("telefone"),
                        resultSet.getInt("Dentista_CRO")
                );
            }
        } catch (SQLException ex) {
            System.out.println("Erro = " + ex.getMessage());
        }
        return auxiliar;
    }

    //------------------------REMOVER Auxiliar DO DATABASE----------------------------
    public boolean deleteAuxiliar(int idAuxiliar) {
        connect();
        boolean sucesso = false;

        String sql = "DELETE FROM Auxiliar WHERE idAuxiliar = ?";

        try {
            pst = connection.prepareStatement(sql);
            pst.setInt(1, idAuxiliar);
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
