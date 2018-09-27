package club.coding.med.staffpayroll.employees;

import java.util.Optional;
import java.util.stream.Stream;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

/**
 * Data Access Layer Repo.
 */
@Repository
public class EmployeeDAO {

  private final static String url = "/employees";
  private final RestTemplate rest;

  EmployeeDAO(RestTemplateBuilder builder,
      @Value("${masglobal.data-repo.root-uri}") String rootUri) {
    this.rest = builder.rootUri(rootUri).build();
  }

  public Optional<Employee> getById(int id) {
    return getAll().filter(emp -> emp.id == id).findAny();
  }

  /**
   * Consumes API end-point returning all values (the API doesn't have a filtering option).
   */
  public Stream<Employee> getAll() {
    return Stream.ofNullable(rest.getForObject(url, Employee[].class)).flatMap(Stream::of);
  }
}
