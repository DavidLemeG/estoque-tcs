package br.com.springboot.models;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity(name = "tb_itens_pedido")
public class ItensPedido {
  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id_itens_pedido")
  private Long idItensPedido;

  @JsonIgnore
  @ManyToOne
  private Pedido pedido;

  @ManyToOne
  private Produto idProduto;

  private Double quantidade;

  private BigDecimal valor;

  public ItensPedido() {
  }

  public Long getIdItensPedido() {
    return this.idItensPedido;
  }

  public void setIdItensPedido(Long idItensPedido) {
    this.idItensPedido = idItensPedido;
  }

  public Pedido getPedido() {
    return this.pedido;
  }

  public void setPedido(Pedido pedido) {
    this.pedido = pedido;
  }

  public Produto getProduto() {
    return this.idProduto;
  }

  public void setProduto(Produto produto) {
    this.idProduto = produto;
  }

  public Double getQuantidade() {
    return this.quantidade;
  }

  public void setQuantidade(Double quantidade) {
    this.quantidade = quantidade;
  }

  public BigDecimal getValor() {
    return this.valor;
  }

  public void setValor(BigDecimal valor) {
    this.valor = valor;
  }


  @Override
  public String toString() {
    return "{" +
      " idItensPedido='" + getIdItensPedido() + "'" +
      ", pedido='" + getPedido() + "'" +
      ", produto='" + getProduto() + "'" +
      ", quantidade='" + getQuantidade() + "'" +
      ", valor='" + getValor() + "'" +
      "}";
  }
  
}
