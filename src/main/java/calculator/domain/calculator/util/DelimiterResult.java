package calculator.domain.calculator.util;

/**
 * 구분자 파싱 결과를 담는 불변 데이터 클래스 정규식 형태의 구분자와 분석할 숫자 문자열을 포함
 */
public record DelimiterResult(String delimiter, String numbers) {
    /**
     * 생성자
     *
     * @param delimiter 정규식 형태의 구분자
     * @param numbers   숫자 문자열
     */
    public DelimiterResult {
        // 유효성 검증 로직이 필요하면 여기에 추가
    }

    /**
     * @return 정규식 형태의 구분자
     */
    public String getDelimiter() {
        return delimiter;
    }

    /**
     * @return 숫자 문자열
     */
    public String getNumbers() {
        return numbers;
    }
}