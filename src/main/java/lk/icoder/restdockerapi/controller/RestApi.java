package lk.icoder.restdockerapi.controller;

import lk.icoder.restdockerapi.entity.Employee;
import lk.icoder.restdockerapi.repo.EmployeeRepo;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class RestApi {

    private final EmployeeRepo employeeRepo;

    public RestApi(EmployeeRepo employeeRepo) {
        this.employeeRepo = employeeRepo;
    }

    @PostMapping
    public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee) {
        return new ResponseEntity<>(employeeRepo.save(employee), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployee(@PathVariable Long id) {
        return new ResponseEntity<>(employeeRepo.findById(id).get(), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<String> healthCheck() {
        return new ResponseEntity<>("Working...", HttpStatus.OK);
    }
}
