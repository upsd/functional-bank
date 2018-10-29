import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class BankShould {

    @Test
    public void print_header() {
        String statement = new Bank().print();


        assertThat(statement, is("date || credit || debit || balance"));
    }
}
