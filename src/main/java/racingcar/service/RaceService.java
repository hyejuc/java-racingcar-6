package racingcar.service;

import racingcar.model.Car;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RaceService {
    static final int MAX_NAME_LENGTH = 5;
    static final int MIN_TRY_NUMBER = 1;
    public void CarList(String carNames) {
        List<Car> carList = new ArrayList<>();

        List<String> carNameList = Arrays.stream(carNames.split(",")).toList();
        List<String> addedCarNameList = new ArrayList<>();
        for (String carName : carNameList) {
            checkNameLength(carName);
            checkBlank(carName);
            isDuplicate(addedCarNameList, carName);
            Car car = new Car(carName);
            carList.add(car);
            addedCarNameList.add(carName);
        }
    }

    public void checkNameLength(String carName) {
        if (carName.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("자동차 이름은 5자 이하로 입력해주세요.");
        }
    }

    public void checkBlank(String carName) {
        if (carName.contains(" ")) {
            throw new IllegalArgumentException("자동차 이름에 공백은 입력할 수 없습니다.");
        }
    }

    public void isDuplicate(List<String> carList, String name) {
        if (carList.contains(name)) {
            throw new IllegalArgumentException("중복된 자동차 이름이 이미 존재합니다.");
        }
    }

    public int getTryCount(String tryCountString) {
        int count = tryCountStringToInt(tryCountString);
        checkTryCount(count);
        return count;
    }

    public int tryCountStringToInt(String tryCountString) {
        try {
            return Integer.parseInt(tryCountString);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("시도 횟수는 숫자로 입력해야 합니다.");
        }
    }

    public void checkTryCount(int count) {
        if (count < MIN_TRY_NUMBER) {
            throw new IllegalArgumentException("시도 횟수는 최소 1 이상의 수를 입력해야 합니다.");
        }
    }
}
