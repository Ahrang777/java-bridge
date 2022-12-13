package bridge.domain;

import bridge.domain.state.MovingResultState;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MovingResultStates {
    private final List<MovingResultState> movingResultStates;

    public MovingResultStates() {
        this.movingResultStates = new ArrayList<>();
    }

    public void clear() {
        movingResultStates.clear();
    }

    public List<MovingResultState> getMovingResultStates() {
        return Collections.unmodifiableList(movingResultStates);
    }
}
