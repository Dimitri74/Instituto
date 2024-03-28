package com.instituto.patu.aprender.projetoPatu.entidades;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the notas database table.
 * 
 */
@Entity
@Table(name="notas")
@NamedQuery(name="Nota.findAll", query="SELECT n FROM Nota n")
public class Nota implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id_nota")
	private Integer idNota;

	@Temporal(TemporalType.DATE)
	@Column(name="data_avaliacao")
	private Date dataAvaliacao;

	@Column(name="nota_obtida")
	private BigDecimal notaObtida;

	@Column(name="tipo_avaliacao")
	private String tipoAvaliacao;

	//bi-directional many-to-one association to Aluno
	@ManyToOne
	@JoinColumn(name="aluno")
	private Aluno alunoBean;

	//bi-directional many-to-one association to Turma
	@ManyToOne
	@JoinColumn(name="turma")
	private Turma turmaBean;

	public Nota() {
	}

	public Integer getIdNota() {
		return this.idNota;
	}

	public void setIdNota(Integer idNota) {
		this.idNota = idNota;
	}

	public Date getDataAvaliacao() {
		return this.dataAvaliacao;
	}

	public void setDataAvaliacao(Date dataAvaliacao) {
		this.dataAvaliacao = dataAvaliacao;
	}

	public BigDecimal getNotaObtida() {
		return this.notaObtida;
	}

	public void setNotaObtida(BigDecimal notaObtida) {
		this.notaObtida = notaObtida;
	}

	public String getTipoAvaliacao() {
		return this.tipoAvaliacao;
	}

	public void setTipoAvaliacao(String tipoAvaliacao) {
		this.tipoAvaliacao = tipoAvaliacao;
	}

	public Aluno getAlunoBean() {
		return this.alunoBean;
	}

	public void setAlunoBean(Aluno alunoBean) {
		this.alunoBean = alunoBean;
	}

	public Turma getTurmaBean() {
		return this.turmaBean;
	}

	public void setTurmaBean(Turma turmaBean) {
		this.turmaBean = turmaBean;
	}

}