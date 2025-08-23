package imobiliaria.dao;

import imobiliaria.entidade.Cliente;

import java.sql.*;

public class ClienteDAO extends BaseDAO{

    public void clientesComMaisContratos() throws SQLException{
        String sql = "SELECT CLI_NOME, COUNT(CON_ID) AS TOTAL " +
                " FROM CONTRATO CON " +
                " JOIN CLIENTE CLI " +
                "    ON CLI.CLI_ID = CON.CLI_ID " +
                " GROUP BY CON.CLI_ID, CLI.CLI_NOME " +
                " ORDER BY TOTAL DESC" +
                " LIMIT 30 ";
        try (Connection con = con();
             PreparedStatement pre = con.prepareStatement(sql);
             ResultSet rs = pre.executeQuery()) {

            boolean encontrou = false;

            while (rs.next()) {
                encontrou = true;
                String nome = rs.getString("CLI_NOME");
                int quantidadeContratos = rs.getInt("TOTAL");

                System.out.println("Cliente: "+ nome +" | Quantidade de Contratos: "+ quantidadeContratos);
            }
            if (!encontrou) {
                System.out.println("Nenhum cliente encontrado.");
            }
        } catch (SQLException e) {
            System.out.println("Erro ao buscar clientes.");
            System.out.println("Erro: " + e.getMessage());
        }
    }

    public void inserirCliente (Cliente c) {
        String sql = "INSERT INTO CLIENTE (CLI_NOME, CLI_CPF, CLI_IDADE) VALUES(?,?,?)";
        try (Connection con = con();
             PreparedStatement pre = con.prepareStatement(sql)){
            pre.setString(1,c.getNome());
            pre.setString(2,c.getCpf());
            pre.setInt(3,c.getIdade());
            pre.execute();
        } catch (SQLException e){
            System.out.println("Erro ao inserir cliente");
            System.out.println("Erro "+e.getMessage());
        }
    }
}