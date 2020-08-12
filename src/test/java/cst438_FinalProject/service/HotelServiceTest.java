package cst438_FinalProject.service;

import static org.assertj.core.api.Assertions.assertThat;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import cst438_FinalProject.domain.Car;
import cst438_FinalProject.domain.Hotel;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.BDDMockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.junit.jupiter.api.Test;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@WebMvcTest(HotelService.class)
public class HotelServiceTest {

  @MockBean
  private HotelService hotelService;

  @Autowired
  private MockMvc mvc;

  private JacksonTester<Hotel> jsonHotelAttempt;

  @BeforeEach
  public void setUpEach() {
    MockitoAnnotations.initMocks(this);
    JacksonTester.initFields(this, new ObjectMapper());
  }

  @Test
  public void testGetAllHotelReservations() throws Exception {

    given(hotelService.getAllHotelReservations()).willReturn(true);

    boolean res = hotelService.getAllHotelReservations();

    assertThat(true).isEqualTo(res);
  }

}
