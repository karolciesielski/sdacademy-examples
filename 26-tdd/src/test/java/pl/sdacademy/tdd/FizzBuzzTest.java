package pl.sdacademy.tdd;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Java6Assertions.assertThat;


class FizzBuzzTest {

	@DisplayName("if given any number, then returned value is string according to the examples")
	@ParameterizedTest(name = "if number = {0}, then msg = {1}")
	@CsvSource({
			"1, 1",
			"2, 2",
			"3, Fizz",
			"4, 4",
			"5, Buzz",
			"6, Fizz",
			"10, Buzz",
			"15, FizzBuzz",
			"30, FizzBuzz"
	})
	void test(int number, String expected){
		// when
		String msg = FizzBuzz.msg(number);

		// then
		assertThat(msg).isEqualTo(expected);
	}

}