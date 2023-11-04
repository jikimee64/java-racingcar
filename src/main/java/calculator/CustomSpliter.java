package calculator;

import java.util.regex.Matcher;

public class CustomSpliter implements Spliter {

    private static final int CUSTOM_DELIMITER_INDEX = 1;
    private static final int CUSTOM_DELIMITER_TEXT = 2;

    private Matcher matcher;

    public CustomSpliter(Matcher matcher) {
        this.matcher = matcher;
    }

    @Override
    public String[] split(String text) {
        String customDelimiter = matcher.group(CUSTOM_DELIMITER_INDEX);
        return matcher.group(CUSTOM_DELIMITER_TEXT).split(customDelimiter);
    }

}
