package application;

import dao.TestDao2;
import entity.Transaction;

public class FinanceTest2 {
    public static void main(String[] args) {

        TestDao2 dao = new TestDao2();

        Transaction transaction = dao.getOne(1, Transaction.class);
        System.out.println(transaction.getDescription());
        System.out.println(transaction.getCategoryId().getId());

        Transaction transactionWithDetails = dao.getOneWithDetails(1);
        System.out.println(transactionWithDetails);
    }
}
