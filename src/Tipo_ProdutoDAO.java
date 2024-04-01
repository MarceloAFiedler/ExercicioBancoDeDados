import java.sql.SQLException;

public class Tipo_ProdutoDAO extends BaseDAO {

    private final static String CREATE_TABLE = """
            create table IF NOT EXISTS tipo_produto(
                                    id INTEGER PRIMARY KEY
                                    ,nome text
                                    );
            """;

    public void criarTabelaTipoProduto() {
        try (var con = conexao();
             var stat = con.createStatement()) {
            stat.execute(CREATE_TABLE);
            System.out.println("Deu boa criar a TABELA tipo_produto");
        } catch (SQLException e) {
            System.out.println("Erro ao criar tabela tipo_produto.");
            e.printStackTrace();
        }
    }

    public void inserir(Tipo_Produto tp) {
        String inserir = """
                insert into tipo_produto(nome) 
                            values(?);
                """;
        try (var con = conexao();
             var stat = con.prepareStatement(inserir)) {
            stat.setString(1, tp.getNome());
            stat.execute();
            System.out.println("Deu certo o INSERT na tabela tipo_produto");
        } catch (SQLException e) {
            System.out.println("Erro ao inserir na tabela tipo_produto.");
            e.printStackTrace();
        }
    }
}
