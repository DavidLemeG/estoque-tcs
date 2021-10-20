package br.com.springboot.models;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity(name = "tb_itens_pedido")
public class ItensPedido {
  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id_itens_pedido")
  private Long idItensPedido;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "id_pedido")
  @JsonIgnore
  private Pedido pedido;

  @ManyToOne
  private Produto produto;

  private int quantidade;

  private BigDecimal valor;

  public ItensPedido(Long idItensPedido, Pedido pedido, Produto produto, int quantidade, BigDecimal valor) {
    this.idItensPedido = idItensPedido;
    this.pedido = pedido;
    this.produto = produto;
    this.quantidade = quantidade;
    this.valor = valor;
  }

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
    return this.produto;
  }

  public void setProduto(Produto produto) {
    this.produto = produto;
  }

  public int getQuantidade() {
    return this.quantidade;
  }

  public void setQuantidade(int quantidade) {
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
