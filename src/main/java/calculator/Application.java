package calculator;

import calculator.domain.calculator.controller.CalculatorController;
import calculator.domain.calculator.service.CalculatorService;
import calculator.domain.calculator.service.impl.CalculatorServiceImpl;
import calculator.global.ApplicationRunner;

public class Application {
    public static void main(String[] args) {
        CalculatorService calculatorService = new CalculatorServiceImpl();
        CalculatorController calculatorController = new CalculatorController(calculatorService);
        ApplicationRunner applicationRunner = new ApplicationRunner(calculatorController);

        applicationRunner.run();
    }
}
