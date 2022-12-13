package bridge.utils;

import bridge.exception.UtilClassCreateException;

import java.util.Objects;

public class StringUtils {
    private static final String UTILITY_CLASS_CREATE_EXCEPTION_MESSAGE = "생성할 수 없는 Utility 클래스입니다.";

    private StringUtils() {
        throw new UtilClassCreateException();
    }

    public static boolean isBlank(final String input) {
        return Objects.isNull(input) || input.isEmpty();
    }
}
