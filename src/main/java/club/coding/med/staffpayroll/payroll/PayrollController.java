package club.coding.med.staffpayroll.payroll;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Web Service / API to be consumed by the UI.
 */
@Controller
public class PayrollController {

  private final PayrollService service;

  PayrollController(PayrollService service) {
    this.service = service;
  }

  @RequestMapping("/")
  String findAll(Model model, @RequestParam(required = false) String id) {
    model.addAttribute("employees", service.getEmployees(id));
    return "payroll-employees";
  }
}
