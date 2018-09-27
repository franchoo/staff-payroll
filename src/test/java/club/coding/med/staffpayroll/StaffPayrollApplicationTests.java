package club.coding.med.staffpayroll;

import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.empty;
import static org.hamcrest.Matchers.hasProperty;
import static org.hamcrest.Matchers.is;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

/**
 * End to end integration test.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = RANDOM_PORT)
@AutoConfigureMockMvc
public class StaffPayrollApplicationTests {

  private static final String PAYROLL_EMPLOYEES = "payroll-employees";

  @LocalServerPort
  private int port;
  @Autowired
  private MockMvc mockMvc;

  @Test
  public void simpleRequestReturnsEmployee() throws Exception {
    mockMvc.perform(get("/").param("id", "1")).andExpect(status().isOk())
        .andExpect(model().attribute("employees", contains(hasProperty("id", is(1)))))
        .andExpect(view().name(PAYROLL_EMPLOYEES));
  }

  @Test
  public void badIdReturnsNone() throws Exception {
    mockMvc.perform(get("/").param("id", "dos")).andExpect(status().isOk())
        .andExpect(model().attribute("employees", empty()))
        .andExpect(view().name(PAYROLL_EMPLOYEES));
  }
}
