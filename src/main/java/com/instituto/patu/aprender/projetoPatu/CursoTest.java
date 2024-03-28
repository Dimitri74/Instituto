/**
 * 
 */
package com.instituto.patu.aprender.projetoPatu;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.instituto.patu.aprender.projetoPatu.entidades.Curso;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class CursoTest {

    private static EntityManagerFactory entityManagerFactory;
    private static EntityManager entityManager;

    @BeforeClass
    public static void setUp() {
        entityManagerFactory = Persistence.createEntityManagerFactory("projetoPatu");
        entityManager = entityManagerFactory.createEntityManager();
    }

    @AfterClass
    public static void tearDown() {
        if (entityManager != null) {
            entityManager.close();
        }
        if (entityManagerFactory != null) {
            entityManagerFactory.close();
        }
    }

    @Test
    public void testPersistirCurso() {
        entityManager.getTransaction().begin();
        Curso curso = new Curso();
        curso.setNomeCurso("Java Avançado");
        // Preencha os demais atributos conforme necessário
        entityManager.persist(curso);
        entityManager.getTransaction().commit();

        TypedQuery<Curso> query = entityManager.createQuery("SELECT c FROM Curso c WHERE c.nomeCurso = :nomeCurso", Curso.class);
        query.setParameter("nomeCurso", "Java Avançado");
        Curso cursoPersistido = query.getSingleResult();
        assertNotNull(cursoPersistido);
        assertEquals("Java Avançado", cursoPersistido.getNomeCurso());
        // Verifique os demais atributos conforme necessário
    }
}
