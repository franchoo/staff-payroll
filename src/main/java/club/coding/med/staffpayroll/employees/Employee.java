package club.coding.med.staffpayroll.employees;

/**
 * Data Access Layer Entity.
 */
public class Employee {

  int id;
  String name;
  String contractTypeName;
  int roleId;
  String roleName;
  String roleDescription;
  float hourlySalary;
  float monthlySalary;

  public int getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public String getContractTypeName() {
    return contractTypeName;
  }

  public int getRoleId() {
    return roleId;
  }

  public String getRoleName() {
    return roleName;
  }

  public String getRoleDescription() {
    return roleDescription;
  }

  public float getHourlySalary() {
    return hourlySalary;
  }

  public float getMonthlySalary() {
    return monthlySalary;
  }
}
