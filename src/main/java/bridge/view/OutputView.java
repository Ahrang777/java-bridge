package bridge.view;

import bridge.domain.Result;

import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 *
 * 메서드 이름 변경X
 * 인자, 반환 타입은 변경 가능
 * 값 출력을 위해 필요한 메서드 추가 가능
 */
public class OutputView {

    private static final String START_MESSAGE = "다리 건너기 게임을 시작합니다.";
    private static final String FINAL_RESULT_MESSAGE = "최종 게임 결과";
    private static final String CHECK_SUCCESS_MESSAGE = "게임 성공 여부: %s";
    private static final String TRY_COUNT = "총 시도한 횟수: %s";
    private static final String BEGIN = "[";
    private static final String END = "]";
    private static final String DELIMITER = "|";
    private static final String SUCCESS = "성공";
    private static final String FAIL = "실패";
    private static final String BLANK_LINE = "\n";
    private static final String ERROR = "[ERROR] ";

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(Result result) {
        StringBuilder context = new StringBuilder();
        addContext(result, context);
        System.out.println(context);
    }

    private void addContext(Result result, StringBuilder context) {
        for (List<String> bridge : result.getResults()) {
            context.append(BEGIN);
            appendResult(context, bridge);
            context.replace(context.length() - 1, context.length(), END);
            context.append(BLANK_LINE);
        }
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(Result result, int count) {
        System.out.println(FINAL_RESULT_MESSAGE);
        printMap(result);

        printSuccessOrFail(result);

        printTryCount(count);
    }

    private void appendResult(StringBuilder sb, List<String> r) {
        for (String s : r) {
            sb.append(" ");
            sb.append(s);
            sb.append(" ");
            sb.append(DELIMITER);
        }
    }

    private void printSuccessOrFail(Result result) {
        System.out.printf(CHECK_SUCCESS_MESSAGE, getSuccessOrFail(result));
        printBlankLine();
    }

    private void printTryCount(int count) {
        System.out.printf(TRY_COUNT, count);
        printBlankLine();
    }

    private String getSuccessOrFail(Result result) {
        if (result.hasFail()) {
            return FAIL;
        }

        return SUCCESS;
    }

    public void printBlankLine() {
        System.out.println();
    }

    public void printStart() {
        System.out.println(START_MESSAGE);
        printBlankLine();
    }

    public void printException(Exception exception) {
        System.out.println(ERROR + exception.getMessage());
    }
}
