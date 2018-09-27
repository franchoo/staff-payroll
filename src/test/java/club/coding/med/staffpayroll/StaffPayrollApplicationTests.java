package club.coding.med.staffpayroll;

import static org.junit.Assert.assertEquals;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.forwardedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import com.samskivert.mustache.Mustache;
import com.samskivert.mustache.Template;
import java.util.Map;
import org.hamcrest.Matchers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
@SpringBootTest(webEnvironment = RANDOM_PORT)
public class StaffPayrollApplicationTests {

  @LocalServerPort
  private int port;

  @Autowired
  private MockMvc mockMvc;

  @Test
  public void simpleRequestReturnsEmployees() throws Exception {
    mockMvc.perform(get("/")).andExpect(status().isOk())
        .andExpect(model().attribute("employees", Matchers.hasSize(2)))
        .andExpect(view().name("payroll-employees"))
        .andExpect(forwardedUrl("payroll-employees"));
  }

  @Test
  public void mustacheNumbersCheck() {
    // Given...
    double annualSalary = 120 * 60000.0 * 12;
    Template mustach = Mustache.compiler().compile("{{uno}}");
    // When...
    String render = mustach.execute(Map.of("uno", annualSalary));
    // Then...
    assertEquals("" + annualSalary, render);
  }
}
