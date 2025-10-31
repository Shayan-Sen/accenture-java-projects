import com.udacity.cart.model.CartItem;
import com.udacity.cart.model.CartTotals;
import com.udacity.cart.service.TotalsCalculator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;


public class TotalsCalculatorTest {

    @Test
    @DisplayName("TotalTest")
    public void getTotals_TwoAndFour_returnsSix(){
        List<CartItem> items = List.of(
                new CartItem("pressure_cooker",120,5),
                new CartItem("mixer_grinder",100,4));
        TotalsCalculator calculator = new TotalsCalculator();
        CartTotals totals = calculator.getTotals(items);
        CartTotals check = new CartTotals(220,9);
        Assertions.assertAll("Checking for all::",
        ()-> Assertions.assertEquals(totals.getTaxes(),check.getTaxes()),
        ()-> Assertions.assertEquals(totals.getSubtotal(),check.getSubtotal())
        );
    }
}
