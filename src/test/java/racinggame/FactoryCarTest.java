package racinggame;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class FactoryCarTest {

    @Test
    @DisplayName("성공 - 자동차 대수 만큼 position 값이 0인 자동차를 생성한다.")
    void success_generate_cars() {
        // given
        int carSize = 3;
        GenerateNumber generateNumber = new TestNumber(0);
        FactoryCar factoryCar = new FactoryCar();

        // when
        List<Car> cars = factoryCar.generateCar(carSize, generateNumber);

        //then
        assertThat(cars).hasSize(carSize)
                .extracting("position")
                .containsOnly(0, 0, 0);
    }

}