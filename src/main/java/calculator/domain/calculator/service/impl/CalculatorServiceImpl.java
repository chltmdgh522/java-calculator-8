package calculator.domain.calculator.service.impl;

import calculator.domain.calculator.service.CalculatorService;
import calculator.domain.calculator.util.DelimiterParser;
import calculator.domain.calculator.util.DelimiterResult;
import calculator.global.error.CalculatorException;
import calculator.global.error.ErrorCode;

/**
 * 문자열 계산기의 핵심 비즈니스 로직을 구현하는 서비스 문자열 분리, 숫자 검증 및 합산 수행
 */
public class CalculatorServiceImpl implements CalculatorService {
    // 유효한 숫자만 매칭하는 정규식
    private static final String NUMBER_REGEX = "\\d+";

    /**
     * 입력 문자열을 분석하고 숫자의 합을 계산
     *
     * @param input 사용자 입력 문자열
     * @return 합산 결과
     * @throws CalculatorException 유효하지 않은 숫자가 있는 경우
     */
    @Override
    public int calculate(String input) {
        // 빈 입력 검사 (null, 빈 문자열, 공백)
        if (input == null || input.isBlank()) {
            return 0;
        }

        // 구분자 분석 및 문자열 분리
        DelimiterResult delimiterResult = DelimiterParser.parse(input);
        String[] tokens = delimiterResult.getNumbers().split(delimiterResult.getDelimiter());

        // 토큰을 숫자로 변환하고 합산
        return sumTokens(tokens);
    }

    /**
     * 문자열 토큰들을 숫자로 변환하고 합산
     *
     * @param tokens 분리된 문자열 토큰 배열
     * @return 합산 결과
     * @throws CalculatorException 유효하지 않은 숫자가 있는 경우
     */
    private int sumTokens(String[] tokens) {
        int sum = 0;
        for (String token : tokens) {
            // 빈 토큰 무시 (연속된 구분자 경우)
            if (token.isBlank()) {
                continue;
            }
            // 숫자 형식 검증
            if (!token.matches(NUMBER_REGEX)) {
                throw new CalculatorException(ErrorCode.INVALID_NUMBER, token);
            }
            // 숫자로 변환 후 합산
            sum += Integer.parseInt(token);
        }
        return sum;
    }
}