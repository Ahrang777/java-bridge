package bridge.validator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

class InputGameCommandValidatorTest {
    @DisplayName("정상 입력")
    @ParameterizedTest(name = "{displayName} : gameCommand => {0}")
    @ValueSource(strings = {"Q", "R"})
    void goodInput(final String gameCommand) {
        assertThatNoException()
                .isThrownBy(() -> InputGameCommandValidator.validate(gameCommand));
    }

    @DisplayName("예외 처리: Null 또는 Empty 입력 시")
    @ParameterizedTest(name = "{displayName} : gameCommand => {0}")
    @NullAndEmptySource
    void validateByBlank(final String gameCommand) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> InputGameCommandValidator.validate(gameCommand));
    }

    @DisplayName("예외 처리: 공백을 포함하여 입력 시")
    @ParameterizedTest(name = "{displayName} : gameCommand => {0}")
    @ValueSource(strings = {" ", "  ", "Q ", " Q"})
    void validateBySpace(final String gameCommand) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> InputGameCommandValidator.validate(gameCommand));
    }

    @DisplayName("예외 처리: 허용되지 않은 값을 입력 시")
    @ParameterizedTest(name = "{displayName} : gameCommand => {0}")
    @ValueSource(strings = {"A","ASDF","QW","ㄱ","가","ㅏ","$","#"})
    void validateByOutOfRange(final String gameCommand) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> InputGameCommandValidator.validate(gameCommand));
    }
}