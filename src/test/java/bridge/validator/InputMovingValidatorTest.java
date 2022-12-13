package bridge.validator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

class InputMovingValidatorTest {
    @DisplayName("정상 입력")
    @ParameterizedTest(name = "{displayName} : moving => {0}")
    @ValueSource(strings = {"U", "D"})
    void goodInput(final String moving) {
        assertThatNoException()
                .isThrownBy(() -> InputMovingValidator.validate(moving));
    }

    @DisplayName("예외 처리: Null 또는 Empty 입력 시")
    @ParameterizedTest(name = "{displayName} : moving => {0}")
    @NullAndEmptySource
    void validateByBlank(final String moving) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> InputMovingValidator.validate(moving));
    }

    @DisplayName("예외 처리: 공백을 포함하여 입력 시")
    @ParameterizedTest(name = "{displayName} : moving => {0}")
    @ValueSource(strings = {" ", "  ", "U ", " D"})
    void validateBySpace(final String moving) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> InputMovingValidator.validate(moving));
    }

    @DisplayName("예외 처리: 허용되지 않은 값을 입력 시")
    @ParameterizedTest(name = "{displayName} : moving => {0}")
    @ValueSource(strings = {"A","ASDF","QW","ㄱ","가","ㅏ","$","#"})
    void validateByOutOfRange(final String moving) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> InputMovingValidator.validate(moving));
    }
}