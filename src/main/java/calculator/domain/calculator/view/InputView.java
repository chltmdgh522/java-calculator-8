package calculator.domain.calculator.view;

import calculator.global.message.MessageCode;
import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 뷰 클래스 콘솔 입력을 처리하고 사용자에게 안내 메시지 출력
 */
public class InputView {
    /**
     * 인스턴스화 방지
     */
    private InputView() {
    }

    /**
     * 사용자에게 입력 안내 메시지를 출력하고 콘솔 입력을 받음
     *
     * @return 사용자가 입력한 문자열
     */
    public static String readInput() {
        // 입력 안내 메시지 출력
        System.out.println(MessageCode.INPUT_GUIDE.getMessage());
        // Console 유틸리티를 사용하여 사용자 입력 획득
        return Console.readLine();
    }
}