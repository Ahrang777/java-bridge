package bridge.validator;

import bridge.exception.UtilClassCreateException;

import java.util.regex.Pattern;

public class InputBridgeSizeValidator {
    private static final String BRIDGE_SIZE_FORM = "[3-9]|1\\d|20";    // 3 ~ 20
    private static final String BRIDGE_SIZE_FORM_ERROR_MESSAGE = "다리 길이는 3부터 20 사이의 숫자여야 합니다.";

    private InputBridgeSizeValidator() {
        throw new UtilClassCreateException();
    }

    public static void validate(final String inputBridgeSize) {
        validateNullOrEmpty(inputBridgeSize);
        validateBridgeSizeForm(inputBridgeSize);
    }

    private static void validateNullOrEmpty(final String inputBridgeSize) {
        InputCommonValidator.validate(inputBridgeSize);
    }

    private static void validateBridgeSizeForm(final String inputBridgeSize) {
        if (isNotMatchInputFormat(inputBridgeSize)) {
            throw new IllegalArgumentException(BRIDGE_SIZE_FORM_ERROR_MESSAGE);
        }
    }

    private static boolean isNotMatchInputFormat(final String inputBridgeSize) {
        return !Pattern.matches(BRIDGE_SIZE_FORM, inputBridgeSize);
    }
}
