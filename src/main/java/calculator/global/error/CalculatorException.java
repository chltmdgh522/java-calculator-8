package calculator.global.error;

public class CalculatorException extends IllegalArgumentException {
    private final ErrorCode errorCode;
    private final String detail;

    public CalculatorException(ErrorCode errorCode, String detail) {
        super(errorCode.getMessage().replace("{0}", detail));
        this.errorCode = errorCode;
        this.detail = detail;
    }

    public ErrorCode getErrorCode() {
        return errorCode;
    }

    public String getDetail() {
        return detail;
    }
}
