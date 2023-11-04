package calculator;

import java.util.regex.Matcher;

import static calculator.Constant.CUSTOM_DELIMITER_PATTERN;

public class StringAddCalculator {

    public static final int DEFAULT_RETURN_VALUE = 0;

    public static int splitAndSum(String text) {
        Input input = new Input(text);

        if (input.isEmptyOrNull()) {
            return DEFAULT_RETURN_VALUE;
        }

        Matcher matcher = CUSTOM_DELIMITER_PATTERN.matcher(text);
        if (matcher.find()) {
            return sumWithCustomDelimiter(text, input, matcher);
        }
        return sumWithDefaultDelimiter(text, input);
    }

    private static int[] toIntArray(String[] tokens) {
        int[] ints = new int[tokens.length];
        for (int i = 0; i < tokens.length; i++) {
            ints[i] = toIntBy(tokens[i]);
        }
        return ints;
    }

    public static int toIntBy(String str) {
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException ex) {
            throw new NotNumberException();
        }
    }

    private static int sum(int[] numbers) {
        int sum = 0;
        for (int number : numbers) {
            sum += number;
        }
        return sum;
    }

    private static int sumWithCustomDelimiter(String text, Input input, Matcher matcher) {
        Spliter spliter = new CustomSpliter(matcher);
        int[] numbers = toIntArray(spliter.split(text));
        input.validateNegativeNumbers(numbers);
        return sum(toIntArray(spliter.split(text)));
    }

    private static int sumWithDefaultDelimiter(String text, Input input) {
        Spliter spliter = new DefaultSpliter();
        int[] numbers = toIntArray(spliter.split(text));
        input.validateNegativeNumbers(numbers);
        return sum(toIntArray(spliter.split(text)));
    }

}
