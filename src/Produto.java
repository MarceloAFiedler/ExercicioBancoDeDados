
public class Produto {

    private long id;
    private String nome;
    private double valor;
    private int estoque;
    private String dataLancamento;
    private String ativo;

    public Produto() {
    }

    public Produto(long id, String nome, double valor, int estoque, String dataLancamento, String ativo) {
        this.id = id;
        this.nome = nome;
        this.valor = valor;
        this.estoque = estoque;
        this.dataLancamento = dataLancamento;
        this.ativo = ativo;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public int getEstoque() {
        return estoque;
    }

    public void setEstoque(int estoque) {
        this.estoque = estoque;
    }

    public String getDataLancamento() {
        return dataLancamento;
    }

    public void setDataLancamento(String dataLancamento) {
        this.dataLancamento = dataLancamento;
    }

    public String getAtivo() {
        return ativo;
    }

    public void setAtivo(String ativo) {
        this.ativo = ativo;
    }

    public String toString() {
        return "Produto{" +
                "id=" + id +
                ", nome= " + nome +
                ", valor= " + valor +
                ", estoque= " + estoque +
                ", data_de_lancamento= " + dataLancamento +
                ", ativo= " + ativo + '\'' +
                '}';
    }

}
