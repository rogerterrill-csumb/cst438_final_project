package cst438_FinalProject.service;

import cst438_FinalProject.domain.Car;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.BDDMockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

@SpringBootTest
public class CarServiceTest {

  @MockBean
  private CarService carService;

  // This method is executed before each test
  @BeforeEach
  public void setUpEach() {
    MockitoAnnotations.initMocks( this);

  }

  @Test
  public void testCarFound() throws Exception {
    Car car = new Car("test@test.com", "RandomCity", "08/12/2020", "NextCity", "08/13/2020", "SUV");

    given(carService.newCarReservation(car)).willReturn(true);

    boolean result = carService.newCarReservation(car);
    boolean expectedResult = true;

    assertThat(expectedResult).isEqualTo(result);
  }
}
