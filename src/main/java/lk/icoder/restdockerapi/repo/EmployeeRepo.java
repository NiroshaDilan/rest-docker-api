package lk.icoder.restdockerapi.repo;

import lk.icoder.restdockerapi.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepo extends JpaRepository<Employee, Long> {
}
