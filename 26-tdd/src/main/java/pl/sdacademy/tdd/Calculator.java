package pl.sdacademy.tdd;

public class Calculator {

    private static String delimitersRegex = "[,\\n]";

    public static int calculate(String input) {

        if (isEmpty(input)) {
            return 0;
        }
        if (input.length() == 1) {
            return stringToInt(input);
        }
        return getSum(input);
    }

    private static int getSum(String input) {
        String[] numbers = extractNumbers(input);
        int sum = 0;
        for (int current = 0; current < numbers.length; current++) {
            sum += stringToInt(numbers[current]);
        }
        return sum;
    }

    private static String[] extractNumbers(String input) {
        String data = input;
        if (input.matches("^//.\n.*$")) {
            delimitersRegex += "|" + input.charAt(2);
            data = input.substring(4);
        }
        return data.split(delimitersRegex);
    }

    private static boolean isEmpty(String input) {
        return input.isEmpty();
    }

    private static int stringToInt(String input) {
        return Integer.parseInt(input);
    }

}
