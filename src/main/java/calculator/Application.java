package calculator;

import calculator.global.ApplicationRunner;
import calculator.global.config.ApplicationFactory;

public class Application {
    public static void main(String[] args) {
        ApplicationRunner applicationRunner = ApplicationFactory.createApplicationRunner();
        applicationRunner.run();
    }
}