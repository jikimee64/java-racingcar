package calculator;

public class DefaultSpliter implements Spliter {

    private static final String DELIMITER = "[,:]";

    @Override
    public String[] split(String text) {
        return text.split(DELIMITER);
    }

}
