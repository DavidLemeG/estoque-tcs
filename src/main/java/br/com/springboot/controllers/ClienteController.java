package br.com.springboot.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.springboot.models.Cliente;
import br.com.springboot.repository.ClienteRepository;

@RestController
@CrossOrigin
@RequestMapping("/cliente")
public class ClienteController {

  @Autowired
  private ClienteRepository cliRepository;

  @GetMapping("/{id}")
  public Cliente getCliente(@PathVariable("id") Long id) {

    Optional<Cliente> clienteFind = this.cliRepository.findById(id);

    if (clienteFind.isPresent()) {
      return clienteFind.get();
    }

    return null;
  }

  @PutMapping(value = "/{id}")
  public ResponseEntity update(@PathVariable("id") long id, @RequestBody Cliente cliente) {
    return cliRepository.findById(id).map(record -> {
      record.setNome(cliente.getNome());
      record.setSexo(cliente.getSexo());
      record.setLogradouro(cliente.getLogradouro());
      record.setCep(cliente.getCep());
      record.setBairro(cliente.getBairro());
      record.setCidade(cliente.getCidade());
      record.setUf(cliente.getUf());
      record.setTelefone(cliente.getTelefone());
      record.setCelular(cliente.getCelular());
      Cliente updated = cliRepository.save(record);
      return ResponseEntity.ok().body(updated);
    }).orElse(ResponseEntity.notFound().build());
  }

  @GetMapping("/list")
  public List<Cliente> list() {
    return this.cliRepository.findAll();
  }

  @PostMapping("/")
  public Cliente createCliente(@RequestBody Cliente cliente) {
    return this.cliRepository.save(cliente);
  }

  @DeleteMapping("/{id}")
  public Cliente deleteCliente(@PathVariable("id") Long id) {
    this.cliRepository.deleteById(id);
      return null; 
  }

}
