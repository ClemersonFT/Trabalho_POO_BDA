package imobiliaria.entidade;
import java.sql.Timestamp;

public class Contrato {
    private long id;
    private long idImovel;
    private long idCliente;
    private float valor;
    private float valorImovel;
    private float oferta;
    private Timestamp dataInicio;
    private Timestamp dataFim;

    public Contrato(long id, long idImovel, long idCliente, float valor, float valorImovel, float oferta, Timestamp dataInicio, Timestamp dataFim) {
        this.id = id;
        this.idImovel = idImovel;
        this.idCliente = idCliente;
        this.valor = valor;
        this.valorImovel = valorImovel;
        this.oferta = oferta;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
    }

    public long getId() {
        return id;
    }

    public long getIdImovel() {
        return idImovel;
    }

    public long getIdCliente() {
        return idCliente;
    }

    public float getValor() {
        return valor;
    }

    public float getValorImovel() {
        return valorImovel;
    }

    public float getOferta() {
        return oferta;
    }

    public Timestamp getDataInicio() {
        return dataInicio;
    }

    public Timestamp getDataFim() {
        return dataFim;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setIdImovel(long idImovel) {
        this.idImovel = idImovel;
    }

    public void setIdCliente(long idCliente) {
        this.idCliente = idCliente;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public void setValorImovel(float valorImovel) {
        this.valorImovel = valorImovel;
    }

    public void setOferta(float oferta) {
        this.oferta = oferta;
    }

    public void setDataInicio(Timestamp dataInicio) {
        this.dataInicio = dataInicio;
    }

    public void setDataFim(Timestamp dataFim) {
        this.dataFim = dataFim;
    }
}
