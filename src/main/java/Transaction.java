import java.time.LocalDate;

public class Transaction {

    private final int amount;
    private final LocalDate transactionDate;

    public Transaction(int amount, LocalDate transactionDate) {
        this.amount = amount;
        this.transactionDate = transactionDate;
    }

    public int amount() {
        return amount;
    }

    public LocalDate date() {
        return transactionDate;
    }
}
