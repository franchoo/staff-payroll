package club.coding.med.staffpayroll.payroll;

import club.coding.med.staffpayroll.employees.Employee;
import java.text.NumberFormat;

/**
 * DTO Abstraction.
 */
@SuppressWarnings("unused")
interface PayrollEmployee {

  int getId();

  String getName();

  String getContractTypeName();

  int getRoleId();

  String getRoleName();

  String getRoleDescription();

  double getBaseSalary();

  double getAnnualSalary();

  default String getFormattedBaseSalary() {
    return NumberFormat.getCurrencyInstance().format(getBaseSalary());
  }

  default String getFormattedAnnualSalary() {
    return NumberFormat.getCurrencyInstance().format(getAnnualSalary());
  }

  static PayrollEmployee from(Employee emp) {
    return emp.getContractTypeName().contains("Hourly") ?
        new HourlyEmployee(emp.getId(), emp.getName(), emp.getContractTypeName(), emp.getRoleId(),
            emp.getRoleName(), emp.getRoleDescription(), emp.getHourlySalary()) :
        new MonthlyEmployee(emp.getId(), emp.getName(), emp.getContractTypeName(), emp.getRoleId(),
            emp.getRoleName(), emp.getRoleDescription(), emp.getMonthlySalary());
  }
}
