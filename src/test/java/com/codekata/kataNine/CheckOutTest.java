package com.codekata.kataNine;

// static imports from org.junit
import static org.junit.jupiter.api.Assertions.*;

// imports from org.junit
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

// imports from com.codekata.util
import com.codekata.util.KataNineUtil;

class CheckOutTest {

    private CheckOut co;

    @BeforeEach
    public void init() {
        // create a CheckOut object
        co = new CheckOut(KataNineUtil.getCurrentUnitPricingRule(), KataNineUtil.getCurrentSpecialPricingRule());
    }

    @Test
    public void checkOutEmptyCartShouldBe0() {
        int expected = 0;
        int actual = co.getTotal();
        // assert message
        String message = "0x0 = 0";
        // assert statements
        assertEquals(expected, actual, message);
    }

    @Test
    public void checkOutOneAshouldBe50() {
        // add items to checkout
        co.scanItem("A");
        // unit pricing 1x50 = 50
        int expected = 50;
        int actual = co.getTotal();
        // assert message
        String message = "1x50 = 50";
        // assert statements
        assertEquals(expected, actual, message);
    }

    @Test
    public void checkOutOneBshouldBe30() {
        // add items to checkout
        co.scanItem("B");
        // unit pricing 1x30 = 30
        int expected = 30;
        int actual = co.getTotal();
        // assert message
        String message = "1x30 = 30";
        // assert statements
        assertEquals(expected, actual, message);
    }

    @Test
    public void checkOutOneCshouldBe20() {
        // add items to checkout
        co.scanItem("C");
        // unit pricing 1x20 = 20
        int expected = 20;
        int actual = co.getTotal();
        // assert message
        String message = "1x20 = 20";
        // assert statements
        assertEquals(expected, actual, message);
    }

    @Test
    public void checkOutThreeAshouldBe130() {
        // add items to checkout
        co.scanItem("A");
        co.scanItem("A");
        co.scanItem("A");
        // special pricing 3 for 130
        int expected = 130;
        int actual = co.getTotal();
        // assert message
        String message = "3 for 130";
        // assert statements
        assertEquals(expected, actual, message);
    }

    @Test
    public void checkOutTwoBshouldBe45() {
        // add items to checkout
        co.scanItem("B");
        co.scanItem("B");
        // special pricing 2 for 45
        int expected = 45;
        int actual = co.getTotal();
        // assert message
        String message = "2 for 45";
        // assert statements
        assertEquals(expected, actual, message);
    }

    @Test
    public void checkOutFourAshouldBe180() {
        // add items to checkout
        co.scanItem("A");
        co.scanItem("A");
        co.scanItem("A");
        co.scanItem("A");
        // special pricing 3 for 130 + unit pricing 1x50
        int expected = 180;
        int actual = co.getTotal();
        // assert message
        String message = "special pricing 3 for 130 + unit pricing 1x50";
        // assert statements
        assertEquals(expected, actual, message);
    }

    @Test
    public void checkOutThreeBshouldBe75() {
        // add items to checkout
        co.scanItem("B");
        co.scanItem("B");
        co.scanItem("B");
        // special pricing 2 for 45 + unit pricing 1x30
        int expected = 75;
        int actual = co.getTotal();
        // assert message
        String message = "special pricing 2 for 45 + unit pricing 1x30";
        // assert statements
        assertEquals(expected, actual, message);
    }

    @Test
    public void checkOutRandomItemsShouldBe75() {
        // add items to checkout
        co.scanItem("B");
        co.scanItem("A");
        co.scanItem("B");
        co.scanItem("A");
        co.scanItem("A");
        co.scanItem("D");
        co.scanItem("C");
        co.scanItem("B");
        co.scanItem("B");
        co.scanItem("B");
        co.scanItem("D");

        // 3 As + 5 Bs + 1 C + 2 Ds
        int expected = 300;
        int actual = co.getTotal();

        // assert statements
        assertEquals(expected, actual);
    }

    @Test
    public void checkOutMultipleItemsShouldBe75() {
        // add items to checkout
        for (int i = 0; i < 73; i++)
            co.scanItem("B");
        for (int i = 0; i < 32; i++)
            co.scanItem("A");
        for (int i = 0; i < 41; i++)
            co.scanItem("D");
        for (int i = 0; i < 59; i++)
            co.scanItem("C");

        // 32 As + 73 Bs + 59 C + 41 Ds
        // A: special pricing 10x130 + unit pricing 2x50 = 1400
        // B: special pricing 36x45 + unit pricing 1x30 = 1650
        // C: unit pricing 59x20 = 1180
        // D: unit pricing 41x15 = 615
        // Total = 4845
        int expected = 4845;
        int actual = co.getTotal();

        // assert statements
        assertEquals(expected, actual);
    }

    @AfterEach
    public void finalize() {
        co = null;
    }

}
