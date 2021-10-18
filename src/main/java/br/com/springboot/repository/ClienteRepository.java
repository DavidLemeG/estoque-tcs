package br.com.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.springboot.models.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

  public Cliente findOneByIdCliente(Long id);

}
