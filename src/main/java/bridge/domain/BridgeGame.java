package bridge.domain;

import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 *
 * 참고
 *
 * InputView, OutputView 를 사용하지 않는다.
 * 인스턴스 변수 추가 가능
 * 메서드 이름 변경X
 * 인자, 반환 타입 변경 가능
 * 게임 진행을 위해 필요한 메서드를 추가 하거나 변경가능
 */
public class BridgeGame {
    private Result result;
    private int count;

    public BridgeGame(List<String> answer) {
        this(new Result(answer));
    }

    public BridgeGame(Result result) {
        this.result = result;
        count = 1;
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move(String place) {
        result.add(place);
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
        count++;
        result.clear();
    }

    public int getCount() {
        return count;
    }

    public Result getResult() {
        return result;
    }
}
