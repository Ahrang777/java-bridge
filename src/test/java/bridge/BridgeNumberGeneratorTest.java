package bridge;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;

class BridgeNumberGeneratorTest {
    @DisplayName("숫자 생성")
    @ParameterizedTest(name = "{displayName} : bridgeNumber => {1}")
    @MethodSource("generateArguments")
    void generate(final BridgeNumberGenerator generator, final int expected) {
        assertThat(generator.generate()).isEqualTo(expected);
    }

    private static Stream<Arguments> generateArguments() {
        return Stream.of(
                Arguments.of((BridgeNumberGenerator) () -> 1, 1),
                Arguments.of((BridgeNumberGenerator) () -> 0, 0)
        );
    }
}