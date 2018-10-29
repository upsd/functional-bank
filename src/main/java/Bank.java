import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Bank {

    private String HEADING = "date || credit || debit || balance";
    private List<Transaction> transactions;

    public Bank() {
        transactions = new ArrayList<>();
    }

    public String print() {
        if (transactions.size() == 0) {
            return HEADING;
        }

        return HEADING + "\n" + formattedTransactions().stream()
                .collect(Collectors.joining("\n"));
    }

    public Bank deposit(int amount, LocalDate transactionDate) {
        this.transactions.add(new Transaction(amount, transactionDate));
        return this;
    }

    private List<String> formattedTransactions() {
        final int[] balance = {0};

        List<String> formattedTransactions = transactions.stream()
                .map(t -> String.format("%s || %d.00 || || %d.00", formatDate(t.date()), t.amount(), balance[0] += t.amount()))
                .collect(Collectors.toList());

        Collections.reverse(formattedTransactions);

        return formattedTransactions;
    }

    private String formatDate(LocalDate date) {
        return date.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    }
}
