package org.example;

import java.sql.SQLException;
import java.util.ArrayList;


public class DentistaBD extends ConexãoBD {

    boolean sucesso = false;

    //------------------------INSERIR NOVO REGISTRO DE Dentista NO DATABASE----------------------------
    public boolean insertDentista(Dentista dentista) {
        connect();

        String sql = "INSERT INTO Dentista (CRO, nome, especialidade, telefone) values (?,?,?,?)";

        try {
            pst = connection.prepareStatement(sql);
            pst.setInt(1, dentista.getCRO());
            pst.setString(2, dentista.getNome());
            pst.setString(3, dentista.getEspecialidade());
            pst.setString(4, dentista.getTelefone());
            pst.execute();
            sucesso = true;
        } catch (SQLException ex) {
            System.out.println("Erro de conexao  = " + ex.getMessage());
            sucesso = false;
        }
        return sucesso;
    }

    //------------------------SELECIONAR Dentista POR CRO NO DATABASE----------------------------
    public Dentista selectDentistaCRO(int CRO) {
        connect();
        Dentista dentista = null;

        String sql = "SELECT * FROM Dentista WHERE CRO = ?";
        try {
            pst = connection.prepareStatement(sql);
            pst.setInt(1, CRO);
            resultSet = pst.executeQuery();

            if (resultSet.next()) {
                dentista = new Dentista(resultSet.getString("nome"), resultSet.getString("especialidade"),
                        resultSet.getString("telefone"), resultSet.getInt("CRO"));
            } else {
                System.out.println("Dentista não encontrado.");
            }
        } catch (SQLException ex) {
            System.out.println("Erro = " + ex.getMessage());
        }
        return dentista;
    }

    //------------------------SELECIONAR TODOS OS DENTISTAS DO DATABASE----------------------------
    public ArrayList<Dentista> selectAll() {
        connect();
        ArrayList<Dentista> dentistas = new ArrayList<>();

        String sql = "SELECT * FROM Dentista";
        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                Dentista dentista = new Dentista(resultSet.getString("nome"), resultSet.getString("especialidade"),
                        resultSet.getString("telefone"), resultSet.getInt("CRO"));
                dentistas.add(dentista);
            }
        } catch (SQLException ex) {
            System.out.println("Erro = " + ex.getMessage());
        }
        return dentistas;
    }

    //------------------------REMOVER Dentista DO DATABASE----------------------------
    public boolean deleteDentista(int CRO) {
        connect();

        String sql = "DELETE FROM Dentista WHERE CRO = ?";

        try {
            pst = connection.prepareStatement(sql);
            pst.setInt(1, CRO);
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
