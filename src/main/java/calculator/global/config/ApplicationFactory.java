package calculator.global.config;

import calculator.domain.calculator.controller.CalculatorController;
import calculator.domain.calculator.service.CalculatorService;
import calculator.domain.calculator.service.impl.CalculatorServiceImpl;
import calculator.global.ApplicationRunner;

/**
 * 애플리케이션의 객체 생성 및 의존성 주입을 담당하는 팩토리 클래스
 */
public class ApplicationFactory {

    // 인스턴스화 방지
    private ApplicationFactory() {
    }

    /**
     * 애플리케이션 실행기를 생성하고 필요한 의존성을 주입
     *
     * @return 구성된 ApplicationRunner 객체
     */
    public static ApplicationRunner createApplicationRunner() {
        CalculatorService calculatorService = createCalculatorService();
        CalculatorController calculatorController = createCalculatorController(calculatorService);
        return new ApplicationRunner(calculatorController);
    }

    /**
     * 계산기 컨트롤러 생성
     *
     * @param calculatorService 계산기 서비스 구현체
     * @return 구성된 CalculatorController 객체
     */
    private static CalculatorController createCalculatorController(CalculatorService calculatorService) {
        return new CalculatorController(calculatorService);
    }

    /**
     * 계산기 서비스 구현체 생성
     *
     * @return 구성된 CalculatorService 객체
     */
    private static CalculatorService createCalculatorService() {
        return new CalculatorServiceImpl();
    }
}