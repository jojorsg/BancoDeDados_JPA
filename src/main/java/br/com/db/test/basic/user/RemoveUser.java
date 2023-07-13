package br.com.db.test.basic.user;

import br.com.db.model.basic.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class RemoveUser {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("BancoDeDados_JPA");
        EntityManager em = emf.createEntityManager();

        User user = em.find(User.class, 1L);

        if(user != null) {
            em.getTransaction().begin();
            em.remove(user);
            em.getTransaction().commit();
            System.out.println("O usuário foi removido com sucesso!");
        }

        em.close();
        emf.close();
    }
}
