package imobiliaria.dao;

import imobiliaria.entidade.Contrato;

import java.sql.*;

public class ContratoDAO extends BaseDAO {
    
    public void contratosAtivos() throws SQLException{
        String sql = "SELECT CON_ID, CON_VALOR, IMO_VALOR, CON_OFERTA, CON_DATAINICIO, CON_DATAFIM, CLI_ID, IMO_ID " +
                " FROM CONTRATO " +
                " WHERE CON_DATAINICIO <= CURRENT_DATE AND CON_DATAFIM >= CURRENT_DATE";
        try (Connection con = con();
            PreparedStatement pre = con.prepareStatement(sql);
            ResultSet rs = pre.executeQuery()) {

            boolean encontrou = false;

            while (rs.next()) {
                encontrou = true;
                long idContrato = rs.getLong("CON_ID");
                float valor = rs.getFloat("CON_VALOR");
                float valorImovel = rs.getFloat("IMO_VALOR");
                float oferta = rs.getFloat("CON_OFERTA");
                Timestamp dataInicio = rs.getTimestamp("CON_DATAINICIO");
                Timestamp dataFim = rs.getTimestamp("CON_DATAFIM");
                long idCli = rs.getLong("CLI_ID");
                long idImovel = rs.getLong("IMO_ID");

                System.out.println("Contrato "+ idContrato +" | Valor: "+ valor +" | Valor do Imóvel: "+ valorImovel +" | Oferta: "+ oferta +
                        " | Início: "+ dataInicio +" | Fim: "+ dataFim +" | Cliente: "+ idCli +" | Imóvel: "+ idImovel);
            }
            if (!encontrou) {
                System.out.println("Nenhum contrato ativo encontrado.");
            }
        } catch (SQLException e) {
            System.out.println("Erro ao buscar contratos ativos.");
            System.out.println("Erro: " + e.getMessage());
        }
    }

    public void contratosAExpirar() throws SQLException {
        String sql = "SELECT CON_ID, CON_VALOR, IMO_VALOR, CON_OFERTA, CON_DATAINICIO, CON_DATAFIM, CLI_ID, IMO_ID " +
                " FROM CONTRATO " +
                " WHERE CON_DATAFIM BETWEEN CURRENT_DATE AND DATE_ADD(CURRENT_DATE, INTERVAL 30 DAY)";
        try (Connection con = con();
             PreparedStatement pre = con.prepareStatement(sql);
             ResultSet rs = pre.executeQuery()) {

            boolean encontrou = false;

            while (rs.next()) {
                encontrou = true;
                long idContrato = rs.getLong("CON_ID");
                float valor = rs.getFloat("CON_VALOR");
                float valorImovel = rs.getFloat("IMO_VALOR");
                float oferta = rs.getFloat("CON_OFERTA");
                Timestamp dataInicio = rs.getTimestamp("CON_DATAINICIO");
                Timestamp dataFim = rs.getTimestamp("CON_DATAFIM");
                long idCli = rs.getLong("CLI_ID");
                long idImovel = rs.getLong("IMO_ID");

                System.out.println("Contrato "+ idContrato +" | Valor: "+ valor +" | Valor do Imóvel: "+ valorImovel +" | Oferta: "+ oferta +
                        " | Início: "+ dataInicio +" | Fim: "+ dataFim +" | Cliente: "+ idCli +" | Imóvel: "+ idImovel);
            }
            if (!encontrou) {
                System.out.println("Nenhum contrato expirando em 30 dias encontrado.");
            }
        } catch (SQLException e) {
            System.out.println("Erro ao buscar contratos expirando nos próximos 30 dias.");
            System.out.println("Erro: " + e.getMessage());
        }
    }

    public void inserirContrato(Contrato c){
        String sql = "INSERT INTO CONTRATO (CON_VALOR, CON_OFERTA, CON_DATAINICIO, CON_DATAFIM, CLI_ID, IMO_ID) VALUES(?,?,?,?,?,?)";
        try (Connection con = con();
             PreparedStatement pre = con.prepareStatement(sql)){
            pre.setFloat(1,c.getValor());
            pre.setFloat(1,c.getOferta());
            pre.setTimestamp(3,c.getDataInicio());
            pre.setTimestamp(4,c.getDataFim());
            pre.setLong(5,c.getIdCliente());
            pre.setLong(6,c.getIdImovel());
            pre.execute();
        } catch (SQLException e){
            System.out.println("Erro ao inserir contrato");
            System.out.println("Erro "+e.getMessage());
        }
    }
}