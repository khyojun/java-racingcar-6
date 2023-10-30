package racingcar.util;

import java.util.List;

public class Validator {

    private static final String LENGTH_EXCEPTION="자동차 이름의 길이는 5이하이여야 합니다.";
    private static final String INPUT_NOT_FORMAT="자동차 이름을 다음과 같은 형태: (이름1, 이름2, 이름3) 과 같은 형태로 넣어주셔야합니다!";

    private static final String INPUT_GAME_COUNT_EXCEPTION="게임 횟수는 숫자가 와야 합니다!";

    private static final int CAR_NAME_LENGTH=5;

    public void isRightCarNameInput(List<String> splitedName) {
        checkLengthEachName(splitedName);
    }

    private void checkLengthEachName(List<String> inputCarNames) {
        for (String carName : inputCarNames) {
            if (isRightRangeCarName(carName)) {
                continue;
            }
            throw new IllegalArgumentException(LENGTH_EXCEPTION);
        }
    }

    private void checkRightInputFormat(List<String> splitedName) {
        for (String s : splitedName) {
            if(s.isBlank()){
                throw new IllegalArgumentException(INPUT_NOT_FORMAT);
            }
        }
        if(splitedName.isEmpty()){
            throw new IllegalArgumentException(INPUT_NOT_FORMAT);
        }

    }

    private boolean isRightRangeCarName(String carName) {
        return !carName.isEmpty() && carName.length() <= CAR_NAME_LENGTH;
    }

    public void isRightInputGameCount(String carGameCount) {
        try {
            Integer.parseInt(carGameCount);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INPUT_GAME_COUNT_EXCEPTION);
        }
    }

    public void isRightNameFormat(String carInput, List<String> carNames) {
        checkRightCommaContains(carInput, carNames);
        checkRightInputFormat(carNames);
    }

    private void checkRightCommaContains(String carInput, List<String> carNames) {
        long commaCount = carInput.chars().filter(c -> c == ',').count();
        if(isRightCommaCount(carNames, commaCount)){
            throw new IllegalArgumentException(INPUT_NOT_FORMAT);
        }
    }

    private static boolean isRightCommaCount(List<String> carNames, long count) {
        return count != carNames.size() - 1;
    }
}
