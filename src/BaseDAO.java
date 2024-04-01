import java.sql.Connection;

public class BaseDAO {

    protected Connection conexao() {
        try {
            return FabricaDeConexoes.obterInstancia().conexao();
        } catch (Exception e) {
            System.err.println("Erro ao obter conexão com o banco de dados: " + e.getMessage());
            e.printStackTrace();
            return null; // ou lance uma exceção mais específica, se necessário
        }
    }
}
