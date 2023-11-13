package fr.ylaabidi;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class StringCalculatorTest {

    private final StringCalculator stringCalculator = new StringCalculator();

    @Test
    void TestEmptyShouldReturn0() throws Exception{
        assertEquals(stringCalculator.add(""), 0);
    }

    @ParameterizedTest
    @CsvSource({
            "'', 0",
            "'3', 3",
            "'4,7', 11",
            "'1,2,3,4,5', 15"
    })
    void TestShouldReturnSum(String s, int i) throws Exception{
        assertEquals(i, stringCalculator.add(s));
    }

    @ParameterizedTest
    @CsvSource({
            "'1\n2', 3",
            "'1\n2,3', 6"
    })
    void TestWithCarrierReturnShouldReturnSum(String s, int i) throws Exception{
        assertEquals(i, stringCalculator.add(s));
    }

    @ParameterizedTest
    @CsvSource({
            "'//;1\n2;3', 6",
            "'//;1;1\n1', 3"
    })
    void TestWithSpecificDelimiterShouldReturnSum(String s, int i) throws Exception{
        assertEquals(i, stringCalculator.add(s));
    }

    @ParameterizedTest
    @CsvSource({
            "'//;-1\n2;3'",
            "'//;1;-6\n1'"
    })
    void TestWithNegativesShouldThrowException(String s){
        assertThrows(Exception.class, () -> {
            stringCalculator.add(s);
        }, "Les nombres négatifs ne sont pas autorisés");
    }
    @ParameterizedTest
    @CsvSource({
            "'//;-1\n2;-3','-1,-3'",
            "'//;1;-6\n-1','-6,-1'"
    })
    void TestWithNegativesShouldThrowDetailedException(String s, String msg){
        Exception thrown = assertThrows(Exception.class, () -> {
            stringCalculator.add(s);
        });
        assertEquals("Les nombres négatifs ne sont pas autorisés : "+msg, thrown.getMessage());
    }

    @ParameterizedTest
    @CsvSource({
            "'1,2,13', 16",
            "'1\n2', 3",
            "'//;1001\n2;3', 5",
            "'//;1;10,2000;2', 13"
    })
    void TestWithBigNumbersShouldIgnoreBigNumbersInSum(String s, int i) throws Exception{
        assertEquals(i, stringCalculator.add(s));
    }
}