package bridge.dto;

import bridge.validator.InputGameCommandValidator;

public class GameCommandDto {
    private final String gameCommand;

    public GameCommandDto(final String gameCommand) {
        InputGameCommandValidator.validate(gameCommand);
        this.gameCommand = gameCommand;
    }

    public String getGameCommand() {
        return gameCommand;
    }
}
