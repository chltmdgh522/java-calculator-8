package calculator.global.error;

public enum ErrorCode {
    INVALID_CUSTOM_DELIMITER("잘못된 커스텀 구분자 입력입니다."),
    INVALID_NUMBER("허용되지 않은 값이 포함되어 있습니다: {0}");

    private final String message;

    ErrorCode(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
