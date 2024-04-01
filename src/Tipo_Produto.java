
public class Tipo_Produto {

    private long id;
    private String nome;

    public Tipo_Produto() {
    }

    public Tipo_Produto(long id, String nome) {
        this.id = id;
        this.nome = nome;
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


    public String toString() {
        return "Produto{" +
                "id=" + id +
                ", nome= " + nome +
                ", valor= " + '\'' +
                '}';
    }

}
