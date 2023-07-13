package br.com.db.test.basic.user;

import br.com.db.model.basic.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class GetUser {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("BancoDeDados_JPA");
        EntityManager em = emf.createEntityManager();

        User user = em.find(User.class, 1L);

        String message = "O usuário que possui o ID " + user.getId() + " é: " + user.getName();
        System.out.println(message);

        em.close();
        emf.close();
    }
}
