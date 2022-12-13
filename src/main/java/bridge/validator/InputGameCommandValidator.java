package bridge.validator;

import bridge.exception.UtilClassCreateException;

import java.util.regex.Pattern;

// TODO validator 클래스의 내부 동작형태가 유사: 관리할 방법 고민
public class InputGameCommandValidator {
    private static final String GAME_COMMAND_FORM = "[Q|R]";  // Q or R
    private static final String GAME_COMMAND_ERROR_MESSAGE = "Q 또는 R 만 입력할 수 있습니다.";

    private InputGameCommandValidator() {
        throw new UtilClassCreateException();
    }

    public static void validate(final String inputGameCommand) {
        validateNullOrEmpty(inputGameCommand);
        validateMovingForm(inputGameCommand);
    }

    private static void validateNullOrEmpty(final String inputGameCommand) {
        InputCommonValidator.validate(inputGameCommand);
    }

    private static void validateMovingForm(final String inputGameCommand) {
        if (isNotMatchInputFormat(inputGameCommand)) {
            throw new IllegalArgumentException(GAME_COMMAND_ERROR_MESSAGE);
        }
    }

    private static boolean isNotMatchInputFormat(final String inputGameCommand) {
        return !Pattern.matches(GAME_COMMAND_FORM, inputGameCommand);
    }
}
