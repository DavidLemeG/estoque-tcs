package br.com.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.springboot.models.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {

  public Produto findOneByIdProduto(Long id);

}
