package academy.ennate.repository;

import academy.ennate.entity.Employee;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface EmployeeRepository extends CrudRepository<Employee, String> {

    Optional<Employee> findByEmail(String email);
    List<Employee> findByNameAndEmail(String name, String email);
}
