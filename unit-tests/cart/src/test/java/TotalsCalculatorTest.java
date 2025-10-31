import com.udacity.cart.model.CartItem;
import com.udacity.cart.model.CartTotals;
import com.udacity.cart.service.TotalsCalculator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;


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


    @ParameterizedTest(name = "[{index}]: Items: {0}")
    @DisplayName("TOTAL_TEST_MULTIPLE")
    @MethodSource("cartArgumentProvider")
    public void getTotals_multiple(List<CartItem> items,CartTotals totals){
        CartTotals check = new TotalsCalculator().getTotals(items);
        Assertions.assertAll("Checking for all::",
                ()-> Assertions.assertEquals(check.getSubtotal(),totals.getSubtotal()),
                ()-> Assertions.assertEquals(check.getTaxes(),totals.getTaxes())
        );
    }

    @org.jetbrains.annotations.NotNull
    private static Stream<Arguments> cartArgumentProvider(){
        return Stream.of(
                Arguments.of(List.of(new CartItem("pressure_cooker",120,5),
                        new CartItem("mixer_grinder",100,4)),new CartTotals(220,9)),
                Arguments.of(List.of(new CartItem("pressure_cooker",110,5),
                        new CartItem("mixer_grinder",110,4)),new CartTotals(220,9)),
                Arguments.of(List.of(new CartItem("pressure_cooker",120,5),
                        new CartItem("mixer_grinder",100,4),
                        new CartItem("soap_grinder",100,4)),new CartTotals(320,13))
        );
    }
}
