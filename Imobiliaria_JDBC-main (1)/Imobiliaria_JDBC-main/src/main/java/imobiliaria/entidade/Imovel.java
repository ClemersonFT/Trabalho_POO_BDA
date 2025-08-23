package imobiliaria.entidade;

public class Imovel {
    private long id;
    private String nome;
    private String endereco;
    private float valor;

    public Imovel(long id, String nome, String endereco, float valor) {
        this.id = id;
        this.nome = nome;
        this.endereco = endereco;
        this.valor = valor;
    }

    public long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public float getValor() {
        return valor;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }
}
