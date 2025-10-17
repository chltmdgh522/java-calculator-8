package calculator.domain.calculator.controller;

import calculator.domain.calculator.service.CalculatorService;
import calculator.domain.calculator.view.InputView;
import calculator.domain.calculator.view.OutputView;

public class CalculatorController {
    private final CalculatorService calculatorService;

    public CalculatorController(CalculatorService calculatorService) {
        this.calculatorService = calculatorService;
    }

    public void run() {
        String input = InputView.readInput();
        int result = calculatorService.calculate(input);
        OutputView.printResult(result);
    }
}
