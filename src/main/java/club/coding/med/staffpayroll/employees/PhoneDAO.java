package club.coding.med.staffpayroll.employees;

import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Phone's Data Access Layer Repo.
 */
@Repository
public interface PhoneDAO extends CrudRepository<Phone, Integer> {

  Optional<Phone> findFirstByEmpId(int empId);

  int countByEmpId(int empId);
}
