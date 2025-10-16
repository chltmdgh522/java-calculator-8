package calculator.domain.calculator.controller;

import calculator.domain.calculator.service.CalculatorService;
import calculator.domain.calculator.service.impl.CalculatorServiceImpl;
import calculator.domain.calculator.view.InputView;
import calculator.domain.calculator.view.OutputView;

public class CalculatorController {
    private final CalculatorService calculatorService = new CalculatorServiceImpl();

    public void run() {
        String input = InputView.readInput();
        int result = calculatorService.calculate(input);
        OutputView.printResult(result);
    }
}
