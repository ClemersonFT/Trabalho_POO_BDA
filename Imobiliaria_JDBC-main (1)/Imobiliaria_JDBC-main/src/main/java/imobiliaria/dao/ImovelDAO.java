package imobiliaria.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import imobiliaria.entidade.Imovel;

public class ImovelDAO extends BaseDAO{

    public void imoveisDisponiveis() throws SQLException{
        String sql = "SELECT IMO_NOME " +
                " FROM IMOVEIS IMO " +
                " LEFT JOIN CONTRATO CON " +
                "    ON IMO.IMO_ID = CON.IMO_ID " +
                "    AND CON.CON_DATAINICIO <= CURRENT_DATE " +
                "    AND CON.CON_DATAFIM >= CURRENT_DATE " +
                " WHERE CON_ID IS NULL ";
        try (Connection con = con();
             PreparedStatement pre = con.prepareStatement(sql);
             ResultSet rs = pre.executeQuery()) {

            boolean encontrou = false;

            while (rs.next()) {
                encontrou = true;
                String nome = rs.getString("IMO_NOME");
                System.out.println("Imóvel: " + nome);
            }
            if (!encontrou) {
                System.out.println("Nenhum imóvel encontrado.");
            }
        } catch (SQLException e) {
            System.out.println("Erro ao buscar imóveis.");
            System.out.println("Erro: " + e.getMessage());
        }
    }

    public void inserirImovel(Imovel i){
        String sql = "INSERT INTO IMOVEL (IMO_NOME, IMO_ENDERECO, IMO_VALOR) VALUES(?,?,?)";
        try (Connection con = con();
             PreparedStatement pre = con.prepareStatement(sql)){
            pre.setString(1,i.getNome());
            pre.setString(2,i.getEndereco());
            pre.setFloat(3,i.getValor());
            pre.execute();
        } catch (SQLException e){
            System.out.println("Erro ao inserir imóvel");
            System.out.println("Erro "+e.getMessage());
        }
    }
}
