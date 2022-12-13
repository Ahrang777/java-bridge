package bridge.validator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.Assertions.*;

class InputCommonValidatorTest {
    @DisplayName("예외 처리: Null 또는 Empty 입력 시")
    @ParameterizedTest(name = "{displayName} : input => {0}")
    @NullAndEmptySource
    void validateByBlank(final String input) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> InputCommonValidator.validate(input));
    }
}