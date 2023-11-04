package calculatorlecture;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class StringAddCalculatorLectureTest {

    @NullAndEmptySource
    @ParameterizedTest(name = "입력값: {0}")
    public void splitAndSum_null_또는_빈문자(String input) {
        int result = StringAddCalculatorLecture.splitAndSum(input);
        assertThat(result).isEqualTo(0);

        result = StringAddCalculatorLecture.splitAndSum("");
        assertThat(result).isEqualTo(0);
    }

    @ParameterizedTest
    @CsvSource(value = {"1:1", "11:11", "111:111"}, delimiter = ':')
    public void splitAndSum_숫자하나(String text, int number) throws Exception {
        int result = StringAddCalculatorLecture.splitAndSum(text);
        assertThat(result).isEqualTo(number);
    }

    @Test
    public void splitAndSum_쉼표구분자() throws Exception {
        int result = StringAddCalculatorLecture.splitAndSum("1,2");
        assertThat(result).isEqualTo(3);
    }

    @Test
    public void splitAndSum_쉼표_또는_콜론_구분자() throws Exception {
        int result = StringAddCalculatorLecture.splitAndSum("1,2:3");
        assertThat(result).isEqualTo(6);
    }

    @Test
    public void splitAndSum_custom_구분자() throws Exception {
        int result = StringAddCalculatorLecture.splitAndSum("//;\n1;2;3");
        assertThat(result).isEqualTo(6);
    }

    @Test
    public void splitAndSum_negative() throws Exception {
        assertThatThrownBy(() -> StringAddCalculatorLecture.splitAndSum("-1,2,3"))
                .isInstanceOf(RuntimeException.class);
    }
    
}