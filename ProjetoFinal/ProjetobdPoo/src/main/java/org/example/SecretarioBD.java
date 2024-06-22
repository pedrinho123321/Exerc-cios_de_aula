package org.example;

import java.sql.SQLException;

public class SecretarioBD extends ConexãoBD {

    boolean sucesso = false;
    DentistaHasSecretarioBD dentistahassecretarioBD = new DentistaHasSecretarioBD();

    public boolean insertSecretario(Secretario secretario, int croDentista) {
        connect();
        String sql = "INSERT INTO secretario (idSecretario, Nome, Telefone) VALUES (?, ?, ?)";

        try {
            pst = connection.prepareStatement(sql);
            pst.setInt(1, secretario.getIdSecretario());
            pst.setString(2, secretario.getNome());
            pst.setString(3, secretario.getTelefone());

            pst.execute();
            sucesso = true;

            // Agora insere a relação na tabela DentistaHasSecretario
            dentistahassecretarioBD.insertDentistaHasSecretario(croDentista, secretario.getIdSecretario());
        } catch (SQLException ex) {
            System.out.println("Erro de conexão = " + ex.getMessage());
            sucesso = false;
        }
        return sucesso;
    }

    public boolean deleteSecretario(int idSecretario) {
        connect();
        boolean sucesso = false;

        // Primeiro, remove as relações com dentista na tabela DentistaHasSecretario
        dentistahassecretarioBD.deleteDentistaHasSecretarioBySecretarioId(idSecretario);

        // Agora remove o secretário da tabela secretario
        String sql = "DELETE FROM secretario WHERE idSecretario = ?";

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

    // Método para selecionar um secretário pelo ID
    public Secretario selectSecretario(int idSecretario) {
        connect(); // Conectar ao banco de dados

        Secretario secretario = null;
        String sql = "SELECT * FROM secretario WHERE idSecretario = ?";

        try {
            pst = connection.prepareStatement(sql);
            pst.setInt(1, idSecretario);

            resultSet = pst.executeQuery();

            if (resultSet.next()) {
                secretario = new Secretario(
                        resultSet.getInt("idSecretario"),
                        resultSet.getString("nome"),
                        resultSet.getString("telefone")
                );
            }
        } catch (SQLException ex) {
            System.out.println("Erro de conexão = " + ex.getMessage());
        }

        return secretario;
    }
}
