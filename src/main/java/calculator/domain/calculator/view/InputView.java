package calculator.domain.calculator.view;

import calculator.global.message.MessageCode;
import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private InputView() {
    }

    public static String readInput() {
        System.out.println(MessageCode.INPUT_GUIDE.getMessage());
        return Console.readLine();
    }
}
