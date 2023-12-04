package dao;

import entity.Account;
import entity.Category;
import entity.Transaction;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.checkerframework.checker.units.qual.A;

public class TestDao {

    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("DevPU");

    public <T> T saveObject(T t) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        em.persist(t);

        em.getTransaction().commit();
        em.close();
        return t;
    }

    public void saveTransaction(Transaction transaction) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();


        Account sourceAccount = transaction.getSourceAccountId();
        if(sourceAccount != null) {
            sourceAccount.changeBalance(-transaction.getAmount());
            em.merge(sourceAccount);
        }

        Account destinationAccount = transaction.getDestinationAccountId();
        if(destinationAccount != null) {
            destinationAccount.changeBalance(transaction.getAmount());
            em.merge(destinationAccount);
        }

        em.persist(transaction);

        em.getTransaction().commit();
        em.close();
    }

}
