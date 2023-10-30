package racingcar.service;

import static racingcar.constant.Delimiter.WINNER_OUTPUT_DELIMITER;

import java.util.ArrayList;
import java.util.List;
import racingcar.domain.Car;

public class WinnerService {


    public String findWinners(List<Car> cars) {
        int max = 0;
        List<String> winners = new ArrayList<>();
        max = getMaxMove(cars, max);
        makeWinnersOutput(cars, winners, max);
        return String.join(WINNER_OUTPUT_DELIMITER.getDelimiter(), winners);
    }

    private void makeWinnersOutput(List<Car> cars, List<String> winners, int max) {
        for (Car car : cars) {
            if (max == car.getMoveCount()) {
                winners.add(car.getName());
            }
        }
    }

    private int getMaxMove(List<Car> cars, int max) {
        for (Car car : cars) {
            max = getMax(car, max);
        }
        return max;
    }

    private int getMax(Car car, int max) {
        if (max < car.getMoveCount()) {
            max = car.getMoveCount();
        }
        return max;
    }
}
