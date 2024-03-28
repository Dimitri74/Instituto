package com.instituto.patu.aprender.projetoPatu.entidades;

iimport javax.persistence.*;
import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "Professores")
public class Professor implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_Professor")
    private Long id;

    @NotBlank
    @Size(max = 100)
    @Column(name = "Nome")
    private String nome;

    @NotBlank
    @Size(max = 100)
    @Column(name = "Especialidade")
    private String especialidade;

    @NotBlank
    @Email
    @Size(max = 100)
   // @Column(name = "Email")
    private String email;

    @NotBlank
    @Size(max = 20)
   // @Column(name = "Telefone")
    private String telefone;

    @NotBlank
    @Size(max = 255)
    //@Column(name = "Endereco")
    private String endereco;

    @OneToMany(mappedBy = "professor")
    private List<Turma> turmas;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEspecialidade() {
		return especialidade;
	}

	public void setEspecialidade(String especialidade) {
		this.especialidade = especialidade;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public List<Turma> getTurmas() {
		return turmas;
	}

	public void setTurmas(List<Turma> turmas) {
		this.turmas = turmas;
	}

   
}
