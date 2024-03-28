package com.instituto.patu.aprender.projetoPatu.entidades;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

@Entity
@Table(name = "Alunos")
public class Aluno implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_Aluno")
    private Long id;

    @NotBlank
    @Size(max = 100)
    @Column(name = "Nome")
    private String nome;

    @NotNull
    @Past
    @Column(name = "Data_Nascimento")
    @Temporal(TemporalType.DATE)
    private Date dataNascimento;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "Genero")
    private GeneroEnum genero;

    @NotBlank
    @Email
    @Size(max = 100)
    @Column(name = "Email")
    private String email;

    @NotBlank
    @Size(max = 20)
    @Column(name = "Telefone")
    private String telefone;

    @NotBlank
    @Size(max = 255)
    @Column(name = "Endereco")
    private String endereco;

    @NotBlank
    @Size(max = 10)
    @Column(name = "CEP")
    private String cep;

    @OneToMany(mappedBy = "aluno")
    private List<Nota> notas;

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

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public GeneroEnum getGenero() {
		return genero;
	}

	public void setGenero(GeneroEnum genero) {
		this.genero = genero;
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

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public List<Nota> getNotas() {
		return notas;
	}

	public void setNotas(List<Nota> notas) {
		this.notas = notas;
	}

    
}


