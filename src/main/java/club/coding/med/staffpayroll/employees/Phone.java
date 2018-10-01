package club.coding.med.staffpayroll.employees;

import static javax.persistence.EnumType.STRING;
import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;

@Entity
public class Phone {

  @Id
  @Column(nullable = false)
  @GeneratedValue(strategy = IDENTITY)
  int id;

  @Column(nullable = false)
  @Positive
  int empId;

  @Column(nullable = false, length = 15, unique = true)
  @NotBlank
  String number;

  @Column(nullable = false, length = 10)
  @Enumerated(STRING)
  Type type;

  @SuppressWarnings("unused")
  public enum Type {
    MOBILE, HOME, WORK, FAX, OTHER
  }

  public Phone() {
  }

  public Phone(@Positive int empId, @NotBlank String number, Type type) {
    this.empId = empId;
    this.number = number;
    this.type = type;
  }

  public int getId() {
    return id;
  }

  public int getEmpId() {
    return empId;
  }

  public Type getType() {
    return type;
  }

  public String getNumber() {
    return number;
  }
}
