package br.com.springboot.DTO;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import br.com.springboot.models.ItensPedido;
import br.com.springboot.models.Pedido;

public class PedidoVendaDTO {
  
  private Long idPedido;

  private LocalDate dtPedido;

  private Long idCliente;

  private BigDecimal valorTotal;

  private List<Long> idProdutos;

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

  public Long getIdCliente() {
    return this.idCliente;
  }

  public void setIdCliente(Long idCliente) {
    this.idCliente = idCliente;
  }

  public BigDecimal getValorTotal() {
    return this.valorTotal;
  }

  public void setValorTotal(BigDecimal valorTotal) {
    this.valorTotal = valorTotal;
  }

  public List<Long> getIdProdutos() {
    return this.idProdutos;
  }

  public void setIdProdutos(List<Long> idProdutos) {
    this.idProdutos = idProdutos;
  }

}
