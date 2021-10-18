package br.com.springboot.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "tb_produto")
public class Produto {
  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id_produto")
  private Long idProduto;

  private String descricao;

  @Column(name = "tipo_produto", length = 100)
  private String tipoProduto;

  @Column(nullable = false)
  private Double valor;

  @Column(name = "quantidade_estoque")
  private int quantidadeEstoque;

  public Produto() {
  }

  public Long getIdProduto() {
    return this.idProduto;
  }

  public void setIdProduto(Long idProduto) {
    this.idProduto = idProduto;
  }

  public String getDescricao() {
    return this.descricao;
  }

  public void setDescricao(String descricao) {
    this.descricao = descricao;
  }

  public String getTipoProduto() {
    return this.tipoProduto;
  }

  public void setTipoProduto(String tipoProduto) {
    this.tipoProduto = tipoProduto;
  }

  public Double getValor() {
    return this.valor;
  }

  public void setValor(Double valor) {
    this.valor = valor;
  }

  public int getQuantidadeEstoque() {
    return this.quantidadeEstoque;
  }

  public void setQuantidadeEstoque(int quantidadeEstoque) {
    this.quantidadeEstoque = quantidadeEstoque;
  }

}
