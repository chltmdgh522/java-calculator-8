package calculator.domain.calculator.view;

import calculator.global.message.MessageCode;

public class OutputView {
    private OutputView() {}

    public static void printResult(int result) {
        System.out.println(String.format(MessageCode.RESULT_FORMAT.getMessage(), result));
    }

    public static void printError(String message) {
        System.out.println(String.format(MessageCode.ERROR_FORMAT.getMessage(), message));
    }
}
