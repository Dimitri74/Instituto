package com.instituto.patu.aprender.projetoPatu;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.instituto.patu.aprender.projetoPatu.entidades.Usuario;

public class Main {

	 public static void main(String[] args) {
	        EntityManagerFactory entityManagerFactory = null;

	        try {
	            // Nome da unidade de persistência no arquivo persistence.xml
	            String persistenceUnitName = "projetoPatu";

	            // Cria o EntityManagerFactory com base na unidade de persistência especificada
	            entityManagerFactory = Persistence.createEntityManagerFactory(persistenceUnitName);

	            // Se o EntityManagerFactory foi criado com sucesso, a conexão com o banco de dados foi estabelecida
	            System.out.println("Conexão com o banco de dados estabelecida com sucesso!");
	        } catch (Exception e) {
	            // Em caso de erro, exibe a mensagem de erro
	            System.err.println("Erro ao conectar ao banco de dados: " + e.getMessage());
	        } finally {
	            // Fecha o EntityManagerFactory, liberando os recursos
	            if (entityManagerFactory != null) {
	                entityManagerFactory.close();
	            }
	        }
	    }
	 
	 private static void inserirUsuario(EntityManagerFactory entityManagerFactory) {
	        EntityManager entityManager = entityManagerFactory.createEntityManager();
	        try {
	            entityManager.getTransaction().begin();

	            // Crie uma instância de Usuário e atribua os valores desejados
	            Usuario usuario = new Usuario();
	            usuario.setNomeUsuario("Nome do Usuário");
	         
	            // Outros atributos...

	            // Persista o usuário no banco de dados
	            entityManager.persist(usuario);

	            entityManager.getTransaction().commit();
	            System.out.println("Usuário inserido com sucesso!");
	        } catch (Exception e) {
	            // Em caso de erro, faça rollback da transação
	            if (entityManager.getTransaction().isActive()) {
	                entityManager.getTransaction().rollback();
	            }
	            System.err.println("Erro ao inserir usuário: " + e.getMessage());
	        } finally {
	            // Feche o EntityManager, liberando os recursos
	            entityManager.close();
	        }
	    }
	}



