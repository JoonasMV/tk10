package entity;

import jakarta.persistence.*;

@Entity
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private double amount;

    private String description;

    private String timestamp;

    @ManyToOne(fetch = FetchType.LAZY)
    private Category categoryId;

    @ManyToOne(fetch = FetchType.LAZY)
    private Account sourceAccountId;

    @ManyToOne(fetch = FetchType.LAZY)
    private Account destinationAccountId;

    public Transaction() {
    }

    public Transaction(double amount, String description, String timestamp, Category categoryId, Account sourceAccountId, Account destinationAccountId) {
        this.amount = amount;
        this.description = description;
        this.timestamp = timestamp;
        this.categoryId = categoryId;
        this.sourceAccountId = sourceAccountId;
        this.destinationAccountId = destinationAccountId;
    }

    public double getAmount() {
        return amount;
    }

    public String getDescription() {
        return description;
    }

    public Account getSourceAccountId() {
        return sourceAccountId;
    }

    public Category getCategoryId() {
        return categoryId;
    }

    public Account getDestinationAccountId() {
        return destinationAccountId;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "id=" + id +
                ", amount=" + amount +
                ", description='" + description + '\'' +
                ", timestamp='" + timestamp + '\'' +
                ", categoryId=" + categoryId +
                ", sourceAccountId=" + sourceAccountId +
                ", destinationAccountId=" + destinationAccountId +
                '}';
    }
}

