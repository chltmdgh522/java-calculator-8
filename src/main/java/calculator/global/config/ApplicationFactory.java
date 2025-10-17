package calculator.global.config;

import calculator.domain.calculator.controller.CalculatorController;
import calculator.domain.calculator.service.CalculatorService;
import calculator.domain.calculator.service.impl.CalculatorServiceImpl;
import calculator.global.ApplicationRunner;

public class ApplicationFactory {

    private ApplicationFactory() {
        // 인스턴스화 방지
    }

    public static ApplicationRunner createApplicationRunner() {
        CalculatorService calculatorService = createCalculatorService();
        CalculatorController calculatorController = createCalculatorController(calculatorService);
        return new ApplicationRunner(calculatorController);
    }

    private static CalculatorController createCalculatorController(CalculatorService calculatorService) {
        return new CalculatorController(calculatorService);
    }

    private static CalculatorService createCalculatorService() {
        return new CalculatorServiceImpl();
    }
}