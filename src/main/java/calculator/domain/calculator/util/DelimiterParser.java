package calculator.domain.calculator.util;


import calculator.global.error.CalculatorException;
import calculator.global.error.ErrorCode;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 문자열 계산기의 구분자를 파싱하는 유틸리티 클래스 기본 구분자(,/:)와 커스텀 구분자(//X\n) 모두 처리
 */
public class DelimiterParser {
    /**
     * 기본 구분자: 쉼표(,)와 콜론(:)
     */
    private static final String DEFAULT_DELIMITER = "[,:]";

    /**
     * 커스텀 구분자 패턴: //와 \n 사이의 문자열을 구분자로 인식
     */
    private static final String CUSTOM_PATTERN = "//(.*?)\\\\n";

    /**
     * 인스턴스화 방지
     */
    private DelimiterParser() {
    }

    /**
     * 입력 문자열에서 구분자와 숫자 부분을 분리
     *
     * @param input 사용자 입력 문자열
     * @return 구분자와 숫자 문자열이 담긴 결과 객체
     * @throws CalculatorException 커스텀 구분자가 유효하지 않은 경우
     */
    public static DelimiterResult parse(String input) {
        // 구분자 목록 초기화 (기본 구분자 추가)
        List<String> delimiters = new ArrayList<>();
        delimiters.add(DEFAULT_DELIMITER);

        // 커스텀 구분자 처리
        Pattern pattern = Pattern.compile(CUSTOM_PATTERN);
        Matcher matcher = pattern.matcher(input);

        while (matcher.find()) {
            String customDelimiter = matcher.group(1);
            if (customDelimiter == null || customDelimiter.isBlank()) {
                throw new CalculatorException(ErrorCode.INVALID_CUSTOM_DELIMITER, "");
            }
            // 특수문자가 구분자인 경우 정규식 문자로 처리되지 않도록 이스케이프
            delimiters.add(Pattern.quote(customDelimiter));
        }

        // 커스텀 구분자 선언부 제거 후 숫자 문자열 추출
        // 선언부 사이에 숫자가 없도록 쉼표로 치환
        String numbers = input.replaceAll(CUSTOM_PATTERN, ",");

        // 모든 구분자를 OR(|) 연산자로 결합
        String delimiterRegex = String.join("|", delimiters);

        return new DelimiterResult(delimiterRegex, numbers);
    }
}