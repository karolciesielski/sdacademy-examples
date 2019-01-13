package pl.sdacademy.tdd;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowableOfType;
import static pl.sdacademy.tdd.Calculator.calculate;

class CalculatorTest {

    @DisplayName("if there is an empty string, then returned value is 0")
    @ParameterizedTest(name = "if string = {0}, then expected = {1}")
    @CsvSource({
            "0,0",
            "1,1",
            "'1,2', 3",
            "'1\n2,3\n4', 10",
            "'//;\n1;2', 3",
            "'//%\n1%2', 3",
            "'//%\n1%2%3%4', 10",
    })
    void test(String input, int expected) throws Exception{
        //when
        int calculate = calculate(input);
        //then
        assertThat(calculate).isEqualTo(expected);
    }

    @DisplayName("negative number")
    @Test
    void test1()throws Exception {
        // given
        String input = "-1000";

        // when
        IllegalArgumentException ex = catchThrowableOfType(() -> calculate(input), IllegalArgumentException.class);

        // then
        assertThat(ex).hasMessage("negative number not allowed");
    }
}