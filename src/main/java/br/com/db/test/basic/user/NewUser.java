package br.com.db.test.basic.user;

import br.com.db.model.basic.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class NewUser {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("BancoDeDados_JPA");
        EntityManager em = emf.createEntityManager();

        User newUser = new User("Josué", "josue@gmail.com");

        em.getTransaction().begin();
        em.persist(newUser);
        em.getTransaction().commit();

        String message = "O ID gerado para este usuário é: " + newUser.getId();
        System.out.println(message);

        em.close();
        emf.close();
    }
}
