package racingcar.service;

import java.util.List;
import racingcar.domain.Car;
import racingcar.util.Validator;

public class CarRaceService {

    private static final String INPUT_DELIMETER = ",";

    private final RaceService raceService = new RaceService();
    private Validator validator = new Validator();



    public void initCarInfo(List<String> carNames, List<Car> cars) {
        for (String carName : carNames) {
            cars.add(new Car(carName, 0));
        }
    }

    public List<String> extractSeperator(String carInput) {
        List<String> carNames = List.of(carInput.split(INPUT_DELIMETER));
        validator.isRightInputFormat(carInput,carNames);
        validator.isRightCarNameInput(carNames);
        return carNames;
    }

    public Integer convertGameRoundToNumber(String carGameCount) {
        validator.isRightInputGameCount(carGameCount);
        return Integer.parseInt(carGameCount);
    }

    public List<String> roundResult(List<Car> cars) {
        return raceService.raceRoundResult(cars);
    }
}
