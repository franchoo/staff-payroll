package club.coding.med.staffpayroll.payroll;

import java.util.List;

/**
 * Business Logic Layer Interface.
 */
interface PayrollService {

  List<PayrollEmployee> getEmployees(String id);
}
