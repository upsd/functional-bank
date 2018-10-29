import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Bank {

    private int amount = 0;
    private String HEADING = "date || credit || debit || balance";
    private LocalDate date;

    public String print() {
        if (amount == 0) {
            return HEADING;
        }

        return HEADING + "\n" + String.format("%s || %d.00 || || %d.00", formatDate(), amount, amount);
    }

    public Bank deposit(int amount, LocalDate transactionDate) {
        this.amount = amount;
        this.date = transactionDate;
        return this;
    }

    private String formatDate() {
        return date.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    }
}
