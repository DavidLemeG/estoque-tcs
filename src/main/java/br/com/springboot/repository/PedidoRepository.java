package br.com.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.springboot.models.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {

  public Pedido findOneByIdPedido(Long id);

}
