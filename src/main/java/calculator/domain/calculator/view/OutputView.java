package calculator.domain.calculator.view;

import calculator.global.message.MessageCode;

/**
 * 계산 결과 및 오류 메시지를 출력하는 뷰 클래스 사용자에게 정보를 표시하는 책임을 담당
 */
public class OutputView {

    /**
     * 인스턴스화 방지
     */
    private OutputView() {
    }

    /**
     * 계산 결과를 정해진 형식으로 출력
     *
     * @param result 출력할 계산 결과 값
     */
    public static void printResult(int result) {
        // 결과 형식에 계산값을 적용하여 출력
        System.out.println(String.format(MessageCode.RESULT_FORMAT.getMessage(), result));
    }

    /**
     * 오류 메시지를 정해진 형식으로 출력
     *
     * @param message 출력할 오류 메시지
     */
    public static void printError(String message) {
        // 오류 형식에 메시지를 적용하여 출력
        System.out.println(String.format(MessageCode.ERROR_FORMAT.getMessage(), message));
    }
}