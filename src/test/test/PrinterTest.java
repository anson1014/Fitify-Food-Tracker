package test;


import model.Print;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class PrinterTest {
    Print print = new Print();

    @BeforeEach
    void runBefore() {

    }

    @Test
    void testPrintSum() {
        print.printSumOptions();
    }

    @Test
    void testPrinter() {
        print.printer();
    }

    @Test
    void testPrintNegative() {
        print.printNegative();
    }


}
