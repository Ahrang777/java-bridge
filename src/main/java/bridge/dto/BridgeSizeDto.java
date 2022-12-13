package bridge.dto;

import bridge.validator.InputBridgeSizeValidator;

public class BridgeSizeDto {
    private final int bridgeSize;

    public BridgeSizeDto(final String bridgeSize) {
        InputBridgeSizeValidator.validate(bridgeSize);
        this.bridgeSize = Integer.parseInt(bridgeSize);
    }

    public int getBridgeSize() {
        return bridgeSize;
    }
}
