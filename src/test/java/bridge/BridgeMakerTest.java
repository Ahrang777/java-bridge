package bridge;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;

class BridgeMakerTest {
    @DisplayName("다리 생성")
    @ParameterizedTest(name = "{displayName} : bridgeState => {2}")
    @MethodSource("parameterProvider")
    void createBridge(final BridgeNumberGenerator generator, final int size, final List<String> expected) {
        BridgeMaker bridgeMaker = new BridgeMaker(generator);

        assertThat(bridgeMaker.makeBridge(size)).isEqualTo(expected);
    }

    static Stream<Arguments> parameterProvider() {
        return Stream.of(
                Arguments.of((BridgeNumberGenerator)() -> 1, 3, List.of("U", "U", "U")),
                Arguments.of((BridgeNumberGenerator)() -> 0, 3, List.of("D", "D", "D"))
        );
    }
}