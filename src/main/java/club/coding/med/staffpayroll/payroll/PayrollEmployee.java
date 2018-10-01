package club.coding.med.staffpayroll.payroll;

import static java.text.NumberFormat.getCurrencyInstance;

import club.coding.med.staffpayroll.employees.Employee;
import club.coding.med.staffpayroll.employees.Phone;

/**
 * DTO Abstraction.
 */
@SuppressWarnings("unused")
interface PayrollEmployee {

  int getId();

  String getName();

  String getContractTypeName();

  void setPhone(Phone phone);

  String getPhoneType();

  String getPhoneNumber();

  int getRoleId();

  String getRoleName();

  String getRoleDescription();

  double getBaseSalary();

  double getAnnualSalary();

  default String getFormattedBaseSalary() {
    return getCurrencyInstance().format(getBaseSalary());
  }

  default String getFormattedAnnualSalary() {
    return getCurrencyInstance().format(getAnnualSalary());
  }

  static PayrollEmployee from(Employee emp) {
    return emp.getContractTypeName().contains("Hourly") ?
        new HourlyEmployee(emp.getId(), emp.getName(), emp.getContractTypeName(), emp.getRoleId(),
            emp.getRoleName(), emp.getRoleDescription(), emp.getHourlySalary()) :
        new MonthlyEmployee(emp.getId(), emp.getName(), emp.getContractTypeName(), emp.getRoleId(),
            emp.getRoleName(), emp.getRoleDescription(), emp.getMonthlySalary());
  }
}
