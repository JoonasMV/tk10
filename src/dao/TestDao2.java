package dao;

import entity.Transaction;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class TestDao2 {

    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("DevPU2");

    public <T> T getOne(int id, Class<T> entityType) {

        EntityManager em = emf.createEntityManager();
        T entity = em.find(entityType, id);
        em.close();
        return entity;
    }

    public Transaction getOneWithDetails(int id) {
        EntityManager em = emf.createEntityManager();

        return em.find(Transaction.class, id);
    }
}
