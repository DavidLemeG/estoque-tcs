package br.com.springboot.controllers;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.springboot.DTO.PedidoVendaDTO;
import br.com.springboot.models.ItensPedido;
import br.com.springboot.models.Pedido;
import br.com.springboot.repository.PedidoRepository;

@RestController
@RequestMapping("/pedido")
public class PedidoController {

  @Autowired
  private PedidoRepository pedidoRepository;

  @GetMapping("/{id}")
  public Pedido getPedido(@PathVariable("id") Long id) {

    Optional<Pedido> pedidoFind = this.pedidoRepository.findById(id);

    if (pedidoFind.isPresent()) {
      return pedidoFind.get();
    }

    return null;
  }

  @GetMapping("/list")
  public List<Pedido> list() {
    return this.pedidoRepository.findAll();
  }

  @PostMapping("/")
  public ResponseEntity<Object> createPedido(@RequestBody PedidoVendaDTO pedidoRequest) {

    Pedido pedido = new Pedido();
    pedido.setCliente(pedidoRequest.getIdCliente());
    pedido.setDtPedido(pedidoRequest.getDtPedido());
    pedido.setValorTotal(pedidoRequest.getValorTotal());

    for (Long idProduto : pedidoRequest.getIdProdutos()) {
      pedido.addItemPedido(new ItensPedido(idProduto));
    }



    // pedVenda.setItens(pedidoVendaDTO.getItensPedido());
    
    // for (ItensPedido item : pedidoVendaDTO.getItensPedido()) {
    //   item.setPedido(pedidoVendaDTO.getPedidoVenda());
    //   pedidoVendaDTO.getPedidoVenda().getItens().add(item);
    // }
    // BigDecimal total = BigDecimal.ZERO;
    // for (ItensPedido item : pedidoVendaDTO.getPedidoVenda().getItens()) {
    //   BigDecimal qtde = new BigDecimal(item.getQuantidade());
    //   BigDecimal totalItem = item.getValor().multiply(qtde);
    //   total = total.add(totalItem);
    // }
    
    // pedidoVendaDTO.getPedidoVenda().setValorTotal(total);
    
    
    this.pedidoRepository.save(pedido);

    return new ResponseEntity<Object>(pedido, HttpStatus.ACCEPTED);
  }

  @DeleteMapping("/{id}")
  public Pedido deletePedido(@PathVariable("id") Long id) {
    this.pedidoRepository.deleteById(id);
    return null;
  }

}