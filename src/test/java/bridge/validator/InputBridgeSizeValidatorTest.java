package bridge.validator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

class InputBridgeSizeValidatorTest {
    @DisplayName("정상 입력")
    @ParameterizedTest(name = "{displayName} : bridgeSize => {0}")
    @ValueSource(strings = {"3","9","10","19","20"})
    void goodInput(final String bridgeSize) {
        assertThatNoException()
                .isThrownBy(() -> InputBridgeSizeValidator.validate(bridgeSize));
    }

    @DisplayName("예외 처리: Null 또는 Empty 입력 시")
    @ParameterizedTest(name = "{displayName} : bridgeSize => {0}")
    @NullAndEmptySource
    void validateByBlank(final String bridgeSize) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> InputBridgeSizeValidator.validate(bridgeSize));
    }

    @DisplayName("예외 처리: 공백을 포함하여 입력 시")
    @ParameterizedTest(name = "{displayName} : bridgeSize => {0}")
    @ValueSource(strings = {" ", "  ", "3 ", " 3"})
    void validateBySpace(final String bridgeSize) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> InputBridgeSizeValidator.validate(bridgeSize));
    }

    @DisplayName("예외 처리: 허용된 범위를 벗어난 숫자 입력 시")
    @ParameterizedTest(name = "{displayName} : bridgeSize => {0}")
    @ValueSource(strings = {"-1", "0", "2", "21", "100", "03"})
    void validateByOutOfRange(final String bridgeSize) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> InputBridgeSizeValidator.validate(bridgeSize));
    }

    @DisplayName("예외 처리: 문자 입력 시")
    @ParameterizedTest(name = "{displayName} : bridgeSize => {0}")
    @ValueSource(strings = {"a", "A", "$","ㄱ","ㄴ","ㅏ","가"})
    void validateByCharacter(final String bridgeSize) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> InputBridgeSizeValidator.validate(bridgeSize));
    }
}