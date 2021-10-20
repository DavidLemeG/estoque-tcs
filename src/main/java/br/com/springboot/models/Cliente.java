package br.com.springboot.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "tb_cliente")
public class Cliente {
  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id_cliente")
  private Long idCliente;

  @Column(length = 100, nullable = false)
  private String nome;

  @Column(length = 14, nullable = false)
  private String cpf;

  @Column(length = 1, nullable = false)
  private String sexo;

  private String logradouro;

  private String cep;

  private String bairro;

  private String cidade;

  private String uf;

  @Column(length = 14)
  private String telefone;

  @Column(length = 15)
  private String celular;

  public Cliente() {
  }

  public Cliente(Long idCliente, String nome, String cpf, String sexo, String logradouro, String cep, String bairro, String cidade, String uf, String telefone, String celular) {
    this.idCliente = idCliente;
    this.nome = nome;
    this.cpf = cpf;
    this.sexo = sexo;
    this.logradouro = logradouro;
    this.cep = cep;
    this.bairro = bairro;
    this.cidade = cidade;
    this.uf = uf;
    this.telefone = telefone;
    this.celular = celular;
  }

  public Long getIdCliente() {
    return this.idCliente;
  }

  public void setIdCliente(Long idCliente) {
    this.idCliente = idCliente;
  }

  public String getNome() {
    return this.nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public String getCpf() {
    return this.cpf;
  }

  public void setCpf(String cpf) {
    this.cpf = cpf;
  }

  public String getSexo() {
    return this.sexo;
  }

  public void setSexo(String sexo) {
    this.sexo = sexo;
  }

  public String getLogradouro() {
    return this.logradouro;
  }

  public void setLogradouro(String logradouro) {
    this.logradouro = logradouro;
  }

  public String getCep() {
    return this.cep;
  }

  public void setCep(String cep) {
    this.cep = cep;
  }

  public String getBairro() {
    return this.bairro;
  }

  public void setBairro(String bairro) {
    this.bairro = bairro;
  }

  public String getCidade() {
    return this.cidade;
  }

  public void setCidade(String cidade) {
    this.cidade = cidade;
  }

  public String getUf() {
    return this.uf;
  }

  public void setUf(String uf) {
    this.uf = uf;
  }

  public String getTelefone() {
    return this.telefone;
  }

  public void setTelefone(String telefone) {
    this.telefone = telefone;
  }

  public String getCelular() {
    return this.celular;
  }

  public void setCelular(String celular) {
    this.celular = celular;
  }

  @Override
  public String toString() {
    return "{" +
      " idCliente='" + getIdCliente() + "'" +
      ", nome='" + getNome() + "'" +
      ", cpf='" + getCpf() + "'" +
      ", sexo='" + getSexo() + "'" +
      ", logradouro='" + getLogradouro() + "'" +
      ", cep='" + getCep() + "'" +
      ", bairro='" + getBairro() + "'" +
      ", cidade='" + getCidade() + "'" +
      ", uf='" + getUf() + "'" +
      ", telefone='" + getTelefone() + "'" +
      ", celular='" + getCelular() + "'" +
      "}";
  } 

}
