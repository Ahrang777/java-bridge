package bridge.validator;

import bridge.exception.UtilClassCreateException;

import java.util.regex.Pattern;

public class InputMovingValidator {
    private static final String MOVING_FORM = "[U|D]";  // U or D
    private static final String MOVING_FORM_ERROR_MESSAGE = "U 또는 D 만 입력할 수 있습니다.";

    private InputMovingValidator() {
        throw new UtilClassCreateException();
    }

    public static void validate(final String inputMoving) {
        validateNullOrEmpty(inputMoving);
        validateMovingForm(inputMoving);
    }

    private static void validateNullOrEmpty(final String inputMoving) {
        InputCommonValidator.validate(inputMoving);
    }

    private static void validateMovingForm(final String inputMoving) {
        if (isNotMatchInputFormat(inputMoving)) {
            throw new IllegalArgumentException(MOVING_FORM_ERROR_MESSAGE);
        }
    }

    private static boolean isNotMatchInputFormat(final String inputMoving) {
        return !Pattern.matches(MOVING_FORM, inputMoving);
    }
}
