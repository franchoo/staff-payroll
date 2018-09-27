package club.coding.med.staffpayroll.payroll;

import static java.lang.Integer.parseInt;
import static java.util.stream.Collectors.toList;
import static org.springframework.util.StringUtils.isEmpty;

import club.coding.med.staffpayroll.employees.Employee;
import club.coding.med.staffpayroll.employees.EmployeeDAO;
import java.util.List;
import java.util.stream.Stream;
import org.springframework.stereotype.Service;

/**
 * Business Logic Layer Component.
 */
@Service
class PayrollServiceImpl implements PayrollService {

  private final EmployeeDAO employeeDAO;

  PayrollServiceImpl(EmployeeDAO employeeDAO) {
    this.employeeDAO = employeeDAO;
  }

  @Override
  public List<PayrollEmployee> getEmployees(String id) {
    Stream<Employee> employees;
    try {
      employees = isEmpty(id) ? employeeDAO.getAll() : employeeDAO.getById(parseInt(id)).stream();
    } catch (NumberFormatException e) {
      employees = Stream.empty();
    }
    return employees.map(PayrollEmployee::from).collect(toList());
  }
}
