package calculator.domain.calculator.service.impl;

import calculator.domain.calculator.service.CalculatorService;
import calculator.domain.calculator.util.DelimiterParser;
import calculator.global.error.CalculatorException;
import calculator.global.error.ErrorCode;

public class CalculatorServiceImpl implements CalculatorService {
    private static final String NUMBER_REGEX = "\\d+";

    @Override
    public int calculate(String input) {
        if (input == null || input.isEmpty()) {
            return 0;
        }

        DelimiterParser.DelimiterResult delimiterResult = DelimiterParser.parse(input);
        String[] tokens = delimiterResult.getNumbers().split(delimiterResult.getDelimiter());

        return sumTokens(tokens);
    }

    private int sumTokens(String[] tokens) {
        int sum = 0;
        for (String token : tokens) {
            if (token.isEmpty()) {
                continue;
            }
            if (!token.matches(NUMBER_REGEX)) {
                throw new CalculatorException(ErrorCode.INVALID_NUMBER, token);
            }
            sum += Integer.parseInt(token);
        }
        return sum;
    }
}
