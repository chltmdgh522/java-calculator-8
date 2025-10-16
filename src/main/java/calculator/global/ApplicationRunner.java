package calculator.global;

import calculator.domain.calculator.controller.CalculatorController;
import calculator.domain.calculator.view.OutputView;
import calculator.global.error.CalculatorException;

public class ApplicationRunner {
    private final CalculatorController controller = new CalculatorController();

    public void run() {
        try {
            controller.run();
        } catch (CalculatorException e) {
            OutputView.printError(e.getMessage());
            throw e;
        }
    }
}
