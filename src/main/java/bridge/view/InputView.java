package bridge.view;

import bridge.dto.BridgeSizeDto;
import bridge.dto.MovingDto;
import bridge.validator.InputBridgeSizeValidator;
import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    /**
     * 다리의 길이를 입력받는다.
     */
    public BridgeSizeDto readBridgeSize(OutputView outputView) {
        outputView.printBridgeSizeInputMessage();
        try {
            String inputBridgeSize = input();
            return new BridgeSizeDto(inputBridgeSize);
        } catch (IllegalArgumentException exception) {
            outputView.printErrorMessage(exception);
            return readBridgeSize(outputView);
        }
    }

    private String input() {
        return Console.readLine();
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public MovingDto readMoving(final OutputView outputView) {
        outputView.printMovingInputMessage();
        try {
            String inputMoving = input();
            return new MovingDto(inputMoving);
        } catch (IllegalArgumentException exception) {
            outputView.printErrorMessage(exception);
            return readMoving(outputView);
        }
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        return null;
    }
}
