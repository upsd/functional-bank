import org.junit.Test;

import java.time.LocalDate;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class BankShould {

    @Test
    public void print_header() {
        String statement = new Bank().print();


        assertThat(statement, is("date || credit || debit || balance"));
    }

    @Test
    public void print_statement_with_single_deposit() {
        String statement = new Bank()
                                .deposit(1000, LocalDate.of(2012, 01, 10))
                                .print();

        assertThat(statement, is("date || credit || debit || balance\n" +
                "10/01/2012 || 1000.00 || || 1000.00"));
    }

    @Test
    public void print_statement_with_two_deposits_showing_most_recent_first() {
        String statement = new Bank()
                                .deposit(200, LocalDate.of(2012, 01, 01))
                                .deposit(100, LocalDate.of(2012, 01, 02))
                                .print();

        assertThat(statement, is("date || credit || debit || balance\n" +
                "02/01/2012 || 100.00 || || 300.00\n" +
                "01/01/2012 || 200.00 || || 200.00"));
    }
}
