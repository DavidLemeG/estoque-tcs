package br.com.springboot.DTO;

import java.util.ArrayList;
import java.util.List;

import br.com.springboot.models.ItensPedido;
import br.com.springboot.models.Pedido;

public class PedidoVendaDTO {
  
  private Pedido pedidoVenda;

  private List<ItensPedido> itensPedido = new ArrayList<ItensPedido>();

  public PedidoVendaDTO(Pedido pedido) {
		this.pedidoVenda = pedido;
		this.itensPedido = pedido.getItens();
	}

  public Pedido getPedidoVenda() {
    return this.pedidoVenda;
  }

  public void setPedidoVenda(Pedido pedidoVenda) {
    this.pedidoVenda = pedidoVenda;
  }

  public List<ItensPedido> getItensPedido() {
    return this.itensPedido;
  }

  public void setItensPedido(List<ItensPedido> itensPedido) {
    this.itensPedido = itensPedido;
  }

}
