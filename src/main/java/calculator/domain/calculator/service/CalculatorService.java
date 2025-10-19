package calculator.domain.calculator.service;

/**
 * 문자열 계산 기능을 정의하는 서비스 인터페이스 다양한 계산 구현체를 위한 계약
 */
public interface CalculatorService {
    /**
     * 입력 문자열을 분석하고 계산 결과 반환
     *
     * @param input 계산할 문자열 (구분자로 분리된 숫자)
     * @return 계산된 합계
     * @throws calculator.global.error.CalculatorException 입력이 유효하지 않은 경우
     */
    int calculate(String input);
}