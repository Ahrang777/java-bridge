package bridge;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * 다리의 길이를 입력 받아서 다리를 생성해주는 역할을 한다.
 */
public class BridgeMaker {
    private static final String UP_STATE = "U";
    private static final String DOWN_STATE = "D";
    private static final int BRIDGE_EXIST_NUMBER = 1;

    private final BridgeNumberGenerator bridgeNumberGenerator;

    public BridgeMaker(BridgeNumberGenerator bridgeNumberGenerator) {
        this.bridgeNumberGenerator = bridgeNumberGenerator;
    }

    /**
     * @param size 다리의 길이
     * @return 입력받은 길이에 해당하는 다리 모양. 위 칸이면 "U", 아래 칸이면 "D"로 표현해야 한다.
     */
    public List<String> makeBridge(int size) {
        return IntStream.range(0, size)
                .mapToObj(index -> parseBridgeState())
                .collect(Collectors.toUnmodifiableList());
    }

    private String parseBridgeState() {
        if (bridgeNumberGenerator.generate() == BRIDGE_EXIST_NUMBER) {
            return UP_STATE;
        }

        return DOWN_STATE;
    }
}
