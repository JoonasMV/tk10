package application;

import dao.TestDao;
import entity.Account;
import entity.Category;
import entity.Transaction;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class FinanceTest {
    public static void main(String[] args) {
        TestDao dao = new TestDao();
        //Generate a few categories (food, leisure, school, gifts, internal transfer etc.).
        List<Category> categories = new ArrayList<>();
        categories.add(new Category("food"));
        categories.add(new Category("school"));

        for (Category category : categories) {
            dao.saveObject(category);
        }

        Category leisure = dao.saveObject(new Category("leisure"));
        Category gifts = dao.saveObject(new Category("gifts"));
        Category transfer = dao.saveObject(new Category("internal transfer"));


        //Generate a savings account with a € 400.00 balance.
        Account savings = dao.saveObject(new Account("savings", 400));

        //Generate a wallet with a € 14.50 balance.
        Account wallet = dao.saveObject(new Account("wallet", 14.50));

//        //Receive a gift of € 100.00 from Aunt Mary to the savings account. (The source account should be null.)
        Transaction maryGift = new Transaction(100, "gift", LocalDateTime.now().toString(), gifts, null, savings);
        dao.saveTransaction(maryGift);

        //Transfer € 40.00 from the savings account to the wallet (internal transfer; specify both the source and destination accounts).
        Transaction beerMoney = new Transaction(40, "Money for beer", LocalDateTime.now().toString(), transfer, savings, wallet);
        dao.saveTransaction(beerMoney);

        //Spend € 8.40 from the wallet in the pub. (The target account should be null).
        Transaction beer = new Transaction(8.4, "Beer", LocalDateTime.now().toString(), leisure, wallet, null);
        dao.saveTransaction(beer);
    }
}
