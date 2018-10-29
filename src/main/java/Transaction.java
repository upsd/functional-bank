import java.time.LocalDate;

public class Transaction {

    private final int amount;
    private final LocalDate transactionDate;
    private TransactionType type;

    public Transaction(int amount, LocalDate transactionDate, TransactionType type) {
        this.amount = amount;
        this.transactionDate = transactionDate;
        this.type = type;
    }

    public int amount() {
        return amount;
    }

    public LocalDate date() {
        return transactionDate;
    }

    public TransactionType type() {
        return type;
    }
}
