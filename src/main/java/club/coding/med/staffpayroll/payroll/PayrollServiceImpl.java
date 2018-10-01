package club.coding.med.staffpayroll.payroll;

import static java.lang.Integer.parseInt;
import static java.util.stream.Collectors.toList;
import static org.springframework.util.StringUtils.isEmpty;

import club.coding.med.staffpayroll.employees.Employee;
import club.coding.med.staffpayroll.employees.EmployeeDAO;
import club.coding.med.staffpayroll.employees.Phone;
import club.coding.med.staffpayroll.employees.PhoneDAO;
import java.util.List;
import java.util.stream.Stream;
import org.springframework.stereotype.Service;

/**
 * Business Logic Layer Component.
 */
@Service
class PayrollServiceImpl implements PayrollService {

  private final EmployeeDAO employeeDAO;
  private final PhoneDAO phoneDAO;

  PayrollServiceImpl(EmployeeDAO employeeDAO, PhoneDAO phoneDAO) {
    this.employeeDAO = employeeDAO;
    this.phoneDAO = phoneDAO;
  }

  @Override
  public List<PayrollEmployee> getEmployees(String id) {
    Stream<Employee> employees;
    try {
      employees = isEmpty(id) ? employeeDAO.getAll() : employeeDAO.getById(parseInt(id)).stream();
    } catch (NumberFormatException e) {
      employees = Stream.empty();
    }
    // Factory method PayrollEmployee::from for concrete instances...
    return employees.map(PayrollEmployee::from).peek(
        pe -> phoneDAO.findFirstByEmpId(pe.getId()).ifPresent(pe::setPhone)
    ).collect(toList());
  }

  @Override
  public int savePhone(int empId, String type, String number) {
    return phoneDAO.save(new Phone(empId, number, Phone.Type.valueOf(type))).getId();
  }

  @Override
  public int deletePhone(int empId) {
    phoneDAO.findFirstByEmpId(empId).ifPresent(phoneDAO::delete);
    return phoneDAO.countByEmpId(empId);
  }
}
