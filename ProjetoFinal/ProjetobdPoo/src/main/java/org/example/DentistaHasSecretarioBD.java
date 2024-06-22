package org.example;

import java.sql.SQLException;

public class DentistaHasSecretarioBD extends ConexãoBD {

    public boolean insertDentistaHasSecretario(int croDentista, int idSecretario) {
        connect();
        String sql = "INSERT INTO Dentista_has_Secretario (Dentista_CRO, Secretario_IdSecretario) VALUES (?, ?)";
        boolean sucesso = false;

        try {
            pst = connection.prepareStatement(sql);
            pst.setInt(1, croDentista);
            pst.setInt(2, idSecretario);

            pst.execute();
            sucesso = true;
        } catch (SQLException ex) {
            System.out.println("Erro de conexão = " + ex.getMessage());
        }
        return sucesso;
    }

    public boolean deleteDentistaHasSecretario(int croDentista, int idSecretario) {
        connect();
        String sql = "DELETE FROM Dentista_has_Secretario WHERE Dentista_CRO = ? AND Secretario_IdSecretario = ?";
        boolean sucesso = false;

        try {
            pst = connection.prepareStatement(sql);
            pst.setInt(1, croDentista);
            pst.setInt(2, idSecretario);

            pst.execute();
            sucesso = true;
        } catch (SQLException ex) {
            System.out.println("Erro de conexão = " + ex.getMessage());
        }
        return sucesso;
    }

    public boolean deleteDentistaHasSecretarioBySecretarioId(int idSecretario) {
        connect();
        String sql = "DELETE FROM Dentista_has_Secretario WHERE Secretario_IdSecretario = ?";
        boolean sucesso = false;

        try {
            pst = connection.prepareStatement(sql);
            pst.setInt(1, idSecretario);

            pst.execute();
            sucesso = true;
        } catch (SQLException ex) {
            System.out.println("Erro de conexão = " + ex.getMessage());
        }
        return sucesso;
    }

    public boolean existsDentistaSecretarioRelation(int croDentista, int idSecretario) {
        connect();
        String sql = "SELECT * FROM Dentista_has_Secretario WHERE Dentista_CRO = ? AND Secretario_IdSecretario = ?";
        boolean exists = false;

        try {
            pst = connection.prepareStatement(sql);
            pst.setInt(1, croDentista);
            pst.setInt(2, idSecretario);

            resultSet = pst.executeQuery();
            exists = resultSet.next(); // Se houver algum resultado, a relação existe
        } catch (SQLException ex) {
            System.out.println("Erro de conexão = " + ex.getMessage());
        }
        return exists;
    }
}
