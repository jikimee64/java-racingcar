package calculator;

public class Input {

    private static final int NEGATIVE_NUMBER_STANDARD = 0;

    private final String text;

    public Input(String text) {
        this.text = text;
    }

    public boolean isEmptyOrNull() {
        return this.text == null || this.text.isBlank();
    }

    public void validateNegativeNumbers(int[] numbers) {
        for (int number : numbers) {
            validateNegativeNumber(number);
        }
    }

    private void validateNegativeNumber(int number) {
        if (number < NEGATIVE_NUMBER_STANDARD) {
            throw new NegativeNumberException();
        }
    }

}
