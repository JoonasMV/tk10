package dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Dao {

    private final static EntityManagerFactory emf = Persistence.createEntityManagerFactory("DevPU");

    public void init() {
        EntityManager em = emf.createEntityManager();
        em.close();
    }
}
