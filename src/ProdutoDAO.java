
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProdutoDAO extends BaseDAO {

    private final static String CREATE_TABLE = """
            create table IF NOT EXISTS produto(
                                    id INTEGER PRIMARY KEY
                                    ,nome text
                                    ,valor real
                                    ,estoque integer
                                    ,data_lancamento text);
            """;

    public void criarTabela() {
        try (var con = conexao();
             var stat = con.createStatement()) {
            stat.execute(CREATE_TABLE);
            System.out.println("Deu boa criar a TABELA");
        } catch (SQLException e) {
            System.out.println("Erro ao criar tabela.");
            e.printStackTrace();
        }
    }

    public void inserir(Produto p) {
        String inserir = """
                insert into produto(nome, valor, estoque, data_lancamento, ativo) 
                            values(?, ?, ?, ?, ?);
                """;
        try (var con = conexao();
             var stat = con.prepareStatement(inserir)) {
            stat.setString(1, p.getNome());
            stat.setDouble(2, p.getValor());
            stat.setInt(3, p.getEstoque());
            stat.setString(4, p.getDataLancamento());
            stat.setString(5, p.getAtivo());
            stat.execute();
            System.out.println("Deu certo o INSERT");
        } catch (SQLException e) {
            System.out.println("Erro ao inserir tabela.");
            e.printStackTrace();
        }
    }


    //codigo para obter todos os produtos da tabela e 'printar'
    public List<Produto> obterTodos() {
        List<Produto> lista = new ArrayList<>();
        String sql = """
                select id, nome, valor, estoque, data_lancamento, ativo from produto;
                """;
        try (var con = conexao();
             var stat = con.prepareStatement(sql)) {
            ResultSet rs = stat.executeQuery();
            // Navege para o proximo registro.
            while (rs.next()) {
                Produto p = new Produto();
                p.setId(rs.getLong("id"));
                p.setNome(rs.getString("nome"));
                p.setValor(rs.getDouble("valor"));
                p.setEstoque(rs.getInt("estoque"));
                p.setDataLancamento(rs.getString("data_lancamento"));
                p.setAtivo(rs.getString("ativo"));
                lista.add(p);
                System.out.println("Deu boa OBTER TODOS");
            }
        } catch (SQLException e) {
            System.out.println("Erro ao consultar todas as pessoas.");
            e.printStackTrace();
        }
        return lista;
    }

    public List<Produto> buscarEstoqueVazio() {
        List<Produto> lista = new ArrayList<>();
        String sql = """
                select * from produto WHERE estoque = 0;
                """;
        try (var con = conexao();
             var stat = con.prepareStatement(sql)) {
            ResultSet rs = stat.executeQuery();
            // Navege para o proximo registro.
            while (rs.next()) {
                Produto p = new Produto();
                p.setId(rs.getLong("id"));
                p.setNome(rs.getString("nome"));
                p.setValor(rs.getDouble("valor"));
                p.setEstoque(rs.getInt("estoque"));
                p.setDataLancamento(rs.getString("data_lancamento"));
                p.setAtivo(rs.getString("ativo"));
                lista.add(p);
//                System.out.println("Deu boa OBTER ESTOQUE VAZIO");
            }
        } catch (SQLException e) {
            System.out.println("Erro ao consultar estoque vazio.");
            e.printStackTrace();
        }
        return lista;
    }

    public List<Produto> buscarInativos() {
        List<Produto> lista = new ArrayList<>();
        String sql = """
                select * from produto WHERE ativo = "não";
                """;
        try (var con = conexao();
             var stat = con.prepareStatement(sql)) {
            ResultSet rs = stat.executeQuery();
            // Navege para o proximo registro.
            while (rs.next()) {
                Produto p = new Produto();
                p.setId(rs.getLong("id"));
                p.setNome(rs.getString("nome"));
                p.setValor(rs.getDouble("valor"));
                p.setEstoque(rs.getInt("estoque"));
                p.setDataLancamento(rs.getString("data_lancamento"));
                p.setAtivo(rs.getString("ativo"));
                lista.add(p);
                System.out.println("Deu boa obter inativos");
            }
        } catch (SQLException e) {
            System.out.println("Erro ao consultar inativo.");
            e.printStackTrace();
        }
        return lista;
    }

    public void inserirColuna() {
        String inserir = """
                ALTER TABLE produto ADD ativo text;
                """;
        try (var con = conexao();
             var stat = con.prepareStatement(inserir)) {
            stat.execute();
            System.out.println("Deu certo inserir coluna.");
        } catch (SQLException e) {
            System.out.println("Erro ao inserir coluna.");
            e.printStackTrace();
        }
    }

    public void ativar(Produto p) {
        String sql = """
                update produto set ativo = ? where id = ?;
                """;
        try (var con = conexao();
             var stat = con.prepareStatement(sql)) {
            stat.setString(1, p.getAtivo());
            stat.setLong(2, p.getId());
            stat.execute();
            System.out.println("Deu boa atualizar o 'ativo'");
        } catch (SQLException e) {
            System.out.println("Erro ao atualizar 'ativo'.");
            e.printStackTrace();
        }
    }

}
