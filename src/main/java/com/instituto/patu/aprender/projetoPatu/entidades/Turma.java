package com.instituto.patu.aprender.projetoPatu.entidades;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "Turmas")
public class Turma implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_Turma")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "Curso_Associado", nullable = false)
    private Curso curso;

    @ManyToOne
    @JoinColumn(name = "Professor_Responsavel", nullable = false)
    private Professor professor;

    @NotBlank
    @Size(max = 50)
    @Column(name = "Horario")
    private String horario;

    @NotBlank
    @Size(max = 20)
    @Column(name = "Sala_Aula")
    private String salaAula;

    @OneToMany(mappedBy = "turma")
    private List<Nota> notas;

    // Getters and Setters omitidos para brevidade
}
