package club.coding.med.staffpayroll.payroll;

public class HourlyEmployee implements PayrollEmployee {

  private int id;
  private String name;
  private String contractTypeName;
  private int roleId;
  private String roleName;
  private String roleDescription;
  private double hourlySalary;

  /**
   * DTO Concrete Implementation of {@link PayrollEmployee}.
   */
  HourlyEmployee(int id, String name, String contractTypeName, int roleId, String roleName,
      String roleDescription, double hourlySalary) {
    this.id = id;
    this.name = name;
    this.contractTypeName = contractTypeName;
    this.roleId = roleId;
    this.roleName = roleName;
    this.roleDescription = roleDescription;
    this.hourlySalary = hourlySalary;
  }

  @Override
  public int getId() {
    return id;
  }

  @Override
  public String getName() {
    return name;
  }

  @Override
  public String getContractTypeName() {
    return contractTypeName;
  }

  @Override
  public int getRoleId() {
    return roleId;
  }

  @Override
  public String getRoleName() {
    return roleName;
  }

  @Override
  public String getRoleDescription() {
    return roleDescription;
  }

  @Override
  public double getBaseSalary() {
    return hourlySalary;
  }

  @Override
  public double getAnnualSalary() {
    return 120 * hourlySalary * 12;
  }
}
