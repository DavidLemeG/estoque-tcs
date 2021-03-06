package br.com.springboot.models;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

@Entity(name = "tb_pedido")
public class Pedido {
  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id_pedido")
  private Long idPedido;

  @DateTimeFormat(iso = ISO.DATE)
  @Column(name = "dt_pedido")
  private LocalDate dtPedido;

  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "id_cliente")
  private Cliente cliente;

  @Column(name = "valor_total")
  private BigDecimal valorTotal;
  
  @OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL, orphanRemoval = true)
  private List<ItensPedido> itens = new ArrayList<ItensPedido>();

  public Pedido() {
  }

  public Pedido(Long idPedido, LocalDate dtPedido, Cliente cliente, BigDecimal valorTotal, List<ItensPedido> itens) {
    this.idPedido = idPedido;
    this.dtPedido = dtPedido;
    this.cliente = cliente;
    this.valorTotal = valorTotal;
    this.itens = itens;
  }

  public Long getIdPedido() {
    return this.idPedido;
  }

  public void setIdPedido(Long idPedido) {
    this.idPedido = idPedido;
  }

  public LocalDate getDtPedido() {
    return this.dtPedido;
  }

  public void setDtPedido(LocalDate dtPedido) {
    this.dtPedido = dtPedido;
  }

  public Cliente getCliente() {
    return this.cliente;
  }

  public void setCliente(Cliente cliente) {
    this.cliente = cliente;
  }

  public BigDecimal getValorTotal() {
    return this.valorTotal;
  }

  public void setValorTotal(BigDecimal valorTotal) {
    this.valorTotal = valorTotal;
  }

  public List<ItensPedido> getItens() {
    return this.itens;
  }

  public void setItens(List<ItensPedido> itens) {
    this.itens = itens;
  }

  @Override
  public String toString() {
    return "{" +
      " idPedido='" + getIdPedido() + "'" +
      ", dtPedido='" + getDtPedido() + "'" +
      ", cliente='" + getCliente() + "'" +
      ", valorTotal='" + getValorTotal() + "'" +
      ", itens='" + getItens() + "'" +
      "}";
  }

}
