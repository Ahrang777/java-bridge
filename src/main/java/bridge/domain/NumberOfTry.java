package bridge.domain;

public class NumberOfTry {
    private static final int INIT_NUMBER_OF_TRY = 1;
    private int numberOfTry;

    public NumberOfTry() {
        this.numberOfTry = INIT_NUMBER_OF_TRY;
    }

    public int getNumberOfTry() {
        return numberOfTry;
    }
}
