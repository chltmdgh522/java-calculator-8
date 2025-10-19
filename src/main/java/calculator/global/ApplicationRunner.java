package calculator.global;

import calculator.domain.calculator.controller.CalculatorController;
import calculator.domain.calculator.view.OutputView;
import calculator.global.error.CalculatorException;

/**
 * 애플리케이션의 실행과 예외 처리를 담당하는 클래스 컨트롤러를 실행하고 발생하는 예외를 중앙에서 처리
 */
public class ApplicationRunner {
    private final CalculatorController controller;

    /**
     * 생성자를 통한 의존성 주입
     *
     * @param controller 계산기 컨트롤러
     */
    public ApplicationRunner(CalculatorController controller) {
        this.controller = controller;
    }

    /**
     * 애플리케이션 실행 및 예외 처리 예외 발생 시 오류 메시지를 출력하고 예외를 다시 던짐
     */
    public void run() {
        try {
            controller.run();
        } catch (CalculatorException e) {
            // 사용자 친화적인 에러 메시지 출력
            OutputView.printError(e.getMessage());
            // 디버깅을 위해 예외를 상위로 전파
            throw e;
        }
    }
}