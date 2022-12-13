package bridge.dto;

import bridge.validator.InputMovingValidator;

public class MovingDto {
    final private String moving;

    public MovingDto(final String moving) {
        InputMovingValidator.validate(moving);
        this.moving = moving;
    }

    public String getMoving() {
        return moving;
    }
}
