package calculator.domain.calculator.controller;

import calculator.domain.calculator.service.CalculatorService;
import calculator.domain.calculator.view.InputView;
import calculator.domain.calculator.view.OutputView;

/**
 * 계산기의 입력, 계산 처리, 출력 흐름을 제어하는 컨트롤러
 */
public class CalculatorController {
    private final CalculatorService calculatorService;

    /**
     * 생성자를 통한 계산기 서비스 주입
     *
     * @param calculatorService 계산 로직을 담당하는 서비스
     */
    public CalculatorController(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }

    /**
     * 계산기 실행 흐름 제어 1. 사용자로부터 입력 받기 2. 계산 서비스를 통한 결과 계산 3. 결과 출력
     */
    public void run() {
        String input = InputView.readInput();
        int result = calculatorService.calculate(input);
        OutputView.printResult(result);
    }
}