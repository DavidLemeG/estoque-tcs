package br.com.springboot.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.springboot.models.Produto;
import br.com.springboot.repository.ProdutoRepository;

@RestController
@RequestMapping("/produto")
public class ProdutoController {
  
  @Autowired
  private ProdutoRepository produtoRepository;

  @GetMapping("/{id}")
  public Produto getProduto(@PathVariable("id") Long id) {

    Optional<Produto> produtoFind = this.produtoRepository.findById(id);

    if (produtoFind.isPresent()) {
      return produtoFind.get();
    }

    return null;
  }

  @PutMapping(value = "/{id}")
  public ResponseEntity update(@PathVariable("id") long id, @RequestBody Produto produto) {
    return produtoRepository.findById(id).map(record -> {
      record.setDescricao(produto.getDescricao());
      record.setTipoProduto(produto.getTipoProduto());
      record.setValor(produto.getValor());
      Produto updated = produtoRepository.save(record);
      return ResponseEntity.ok().body(updated);
    }).orElse(ResponseEntity.notFound().build());
  }

  @GetMapping("/list")
  public List<Produto> list() {
    return this.produtoRepository.findAll();
  }

  @PostMapping("/")
  public Produto createProduto(@RequestBody Produto produto) {
    return this.produtoRepository.save(produto);
  }

  @DeleteMapping("/{id}")
  public Produto deleteProduto(@PathVariable("id") Long id) {
    this.produtoRepository.deleteById(id);
    return null;
  }

}
