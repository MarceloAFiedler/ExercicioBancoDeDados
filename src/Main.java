
public class Main {
    public static void main(String[] args) {
        Produto p1 = new Produto(0,"Caderno",25.5,20,"25/01/2023","sim");
        Produto p2 = new Produto(1,"Lápis",0.5,0,"25/01/2023","não");
        Produto p3 = new Produto(2,"Caneta",2.5,0,"25/01/2023", "não");
        Produto p4 = new Produto(3,"Corretivo",5.0,10,"25/01/2023", "sim");
        ProdutoDAO produtoDAO = new ProdutoDAO();

        Tipo_ProdutoDAO tipo_produtoDAO = new Tipo_ProdutoDAO();
        //criar tabela tipo_produto
        tipo_produtoDAO.criarTabelaTipoProduto();

//        //cria a tabela produtoDAO
//        produtoDAO.criarTabela();

//        //insere na tabela
//        produtoDAO.inserir(p2);
//        produtoDAO.inserir(p3);
//        produtoDAO.inserir(p4);

        //obter todos os produtos
//        for (Produto p : produtoDAO.obterTodos()){
//            System.out.println(p);
//        }

        //obter produtos com estoque vazio
//        for (Produto p : produtoDAO.buscarEstoqueVazio()){
//            System.out.println(p);
//        }

//        produtoDAO.inserirColuna();

        //atualiza a coluna 'ativo' da tabela produto
//        p2.setAtivo("não");
//        p2.setId(2);
//        produtoDAO.ativar(p2);
//        p3.setAtivo("não");
//        p3.setId(3);
//        produtoDAO.ativar(p3);
//
//        for (Produto p : produtoDAO.buscarInativos()){
//            System.out.println(p);
//        }



    }
}
