package calculator.domain.calculator.util;

import calculator.global.error.CalculatorException;
import calculator.global.error.ErrorCode;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DelimiterParser {
    private static final String DEFAULT_DELIMITER = "[,:]";
    private static final String CUSTOM_PATTERN = "//(.*?)\\\\n"; // //...\n 패턴

    private DelimiterParser() {
    }

    public static DelimiterResult parse(String input) {
        List<String> delimiters = new ArrayList<>();
        delimiters.add(DEFAULT_DELIMITER);

        Pattern pattern = Pattern.compile(CUSTOM_PATTERN);
        Matcher matcher = pattern.matcher(input);

        while (matcher.find()) {
            String customDelimiter = matcher.group(1);
            if (customDelimiter == null || customDelimiter.isBlank()) {
                throw new CalculatorException(ErrorCode.INVALID_CUSTOM_DELIMITER, "");
            }
            delimiters.add(Pattern.quote(customDelimiter));
        }

        // 선언부 제거 → 쉼표로 치환 (숫자 붙는 문제 방지)
        String numbers = input.replaceAll(CUSTOM_PATTERN, ",");

        String delimiterRegex = String.join("|", delimiters);
        return new DelimiterResult(delimiterRegex, numbers);
    }

    public static class DelimiterResult {
        private final String delimiter;
        private final String numbers;

        public DelimiterResult(String delimiter, String numbers) {
            this.delimiter = delimiter;
            this.numbers = numbers;
        }

        public String getDelimiter() {
            return delimiter;
        }

        public String getNumbers() {
            return numbers;
        }
    }
}
