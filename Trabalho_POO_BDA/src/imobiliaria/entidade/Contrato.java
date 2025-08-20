package imobiliaria.entidade;
import java.sql.Timestamp;

public class Contrato {
    private long id;
    private long valor;
    private Timestamp datainicio;
    private Timestamp datafim;
    private long oferta;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getValor() {
        return valor;
    }

    public void setValor(long valor) {
        this.valor = valor;
    }

    public Timestamp getDatainicio() {
        return datainicio;
    }

    public void setDatainicio(Timestamp datainicio) {
        this.datainicio = datainicio;
    }

    public Timestamp getDatafim() {
        return datafim;
    }

    public void setDatafim(Timestamp datafim) {
        this.datafim = datafim;
    }

    public long getOferta() {
        return oferta;
    }

    public void setOferta(long oferta) {
        this.oferta = oferta;
    }
}
