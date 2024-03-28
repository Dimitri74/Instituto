package com.instituto.patu.aprender.projetoPatu.entidades;

import java.io.Serializable;
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
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "Cursos")
public class Curso implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_Curso")
	private Long id;

	@NotBlank
	@Size(max = 100)
	@Column(name = "Nome_Curso")
	private String nomeCurso;

	@NotBlank
	@Column(name = "Descricao")
	private String descricao;

	@NotNull
	@Min(1)
	@Column(name = "Carga_Horaria")
	private Integer cargaHoraria;

	@NotNull
	@Enumerated(EnumType.STRING)
	@Column(name = "Nivel")
	private NivelCursoEnum nivel;

	/* @OneToMany(mappedBy = "curso") */
	private List<Turma> turmas;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNomeCurso() {
		return nomeCurso;
	}

	public void setNomeCurso(String nomeCurso) {
		this.nomeCurso = nomeCurso;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Integer getCargaHoraria() {
		return cargaHoraria;
	}

	public void setCargaHoraria(Integer cargaHoraria) {
		this.cargaHoraria = cargaHoraria;
	}

	public NivelCursoEnum getNivel() {
		return nivel;
	}

	public void setNivel(NivelCursoEnum nivel) {
		this.nivel = nivel;
	}

	public List<Turma> getTurmas() {
		return turmas;
	}

	public void setTurmas(List<Turma> turmas) {
		this.turmas = turmas;
	}

	
}
