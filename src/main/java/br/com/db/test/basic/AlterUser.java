package br.com.db.test.basic;

import br.com.db.model.basic.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class AlterUser {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("BancoDeDados_JPA");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        User user = em.find(User.class, 1L);
        user.setName("Rebeca");
        user.setEmail("rebeca@gmail.com");

        em.merge(user);
        System.out.println("O usuário foi alterado com sucesso!");

        em.getTransaction().commit();

        em.close();
        emf.close();
    }
}
