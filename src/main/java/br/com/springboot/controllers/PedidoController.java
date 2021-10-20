package br.com.springboot.controllers;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import br.com.springboot.models.Cliente;
import br.com.springboot.models.ItensPedido;
import br.com.springboot.models.Pedido;
import br.com.springboot.models.Produto;
import br.com.springboot.repository.ClienteRepository;
import br.com.springboot.repository.PedidoRepository;
import br.com.springboot.repository.ProdutoRepository;

@RestController
@CrossOrigin
@RequestMapping("/pedido")
public class PedidoController {

  @Autowired
  private ProdutoRepository produtoRepository;

  @Autowired
  private ClienteRepository cliRepository;

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
  public ResponseEntity<Object> createPedido(@RequestBody Pedido pedido) {
    for (ItensPedido item : pedido.getItens()) {
      Produto produto = produtoRepository.findOneByIdProduto(item.getProduto().getIdProduto());
      if(produto.getQuantidadeEstoque() < item.getQuantidade()){
        throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Quantidade requisitada não disponivel");
      }
    }

    Cliente cliente = cliRepository.findOneByIdCliente(pedido.getCliente().getIdCliente());
    Pedido pedVenda = new Pedido();
    pedVenda.setCliente(cliente);
    pedVenda.setDtPedido(pedido.getDtPedido());
    pedVenda.setValorTotal(pedido.getValorTotal());

    for (ItensPedido item : pedido.getItens()) {
      Produto produto = produtoRepository.findOneByIdProduto(item.getProduto().getIdProduto());
      item.setProduto(produto);
      item.setPedido(pedVenda);
      pedVenda.getItens().add(item);

      produto.setQuantidadeEstoque(produto.getQuantidadeEstoque() - item.getQuantidade());

      produtoRepository.save(produto);
    }

    this.pedidoRepository.save(pedVenda);

    return new ResponseEntity<Object>(pedido, HttpStatus.ACCEPTED);
  }

  @DeleteMapping("/{id}")
  public Pedido deletePedido(@PathVariable("id") Long id) {
    this.pedidoRepository.deleteById(id);
    return null;
  }

}
