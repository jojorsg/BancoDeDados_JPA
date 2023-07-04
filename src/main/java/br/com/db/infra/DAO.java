package br.com.db.infra;

import br.com.db.model.basic.Product;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

public class DAO<E> {

    private static EntityManagerFactory emf;
    private EntityManager em;
    private Class<E> classe;

    static {
        try {
            emf = Persistence.createEntityManagerFactory("BancoDeDados_JPA");
        } catch (Exception e) {

        }
    }

    public DAO() {
        this(null);
    }

    public DAO(Class<E> classe) {
        this.classe = classe;
        em = emf.createEntityManager();
    }

    public DAO<E> openTransaction() {
        em.getTransaction().begin();
        return this;
    }

    public DAO<E> closeTransaction() {
        em.getTransaction().commit();
        return this;
    }

    public DAO<E> include(E entity) {
        em.persist(entity);
        return this;
    }

    public DAO<E> includeAtomic(E entity) {
        return this.openTransaction().include(entity).closeTransaction();
    }

    public List<E> obtainAll() {
        return this.obtainAll(10, 0);
    }
    public List<E> obtainAll(int limit, int displacement) {
        if(classe == null) {
            throw new UnsupportedOperationException("Classe está nula");
        }

        String jpql = "select e from " + classe.getName() + " e";
        TypedQuery<E> query = em.createQuery(jpql, classe);
        query.setMaxResults(limit);
        query.setFirstResult(displacement);
        return query.getResultList();
    }

    public void close() {
        em.close();
    }
}
