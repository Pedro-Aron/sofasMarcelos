public class Produto {
    private String nome;
    private String descricao;
    private String cpfVendedor;
    private String id;
    private Integer quantidade;
    private Float preco;

    public Produto(String nome, String descricao, String cpfVendedor, String id, Integer quantidade, Float preco) {
        this.nome = nome;
        this.descricao = descricao;
        this.cpfVendedor = cpfVendedor;
        this.id = id;
        this.quantidade = quantidade;
        this.preco = preco;
    }

    public String getNome() {
        return this.nome;
    }

    public String getDescricao() {
        return this.descricao;
    }

    public String getCpfVendedor() {
        return this.cpfVendedor;
    }

    public String getId() {
        return this.id;
    }

    public Integer getQuantidade() {
        return this.quantidade;
    }

    public Float getPreco() {
        return this.preco;
    }
}


