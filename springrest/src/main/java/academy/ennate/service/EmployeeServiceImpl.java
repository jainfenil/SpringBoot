package academy.ennate.service;

import academy.ennate.entity.Employee;
import academy.ennate.exception.EmployeeNotFoundException;
import academy.ennate.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository repository;

    @Override
    @Transactional(readOnly = true)
    public List<Employee> findAll() {
        return (List<Employee>) repository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Employee findOne(String id) {
        Optional<Employee> employee = repository.findById(id);
        if(employee == null){
            throw new EmployeeNotFoundException("Employee with id "+id+" not found");
        }
        else{
            return employee.get();
        }
    }


    @Override
    @Transactional
    public Employee create(Employee emp) {
        Optional<Employee> existing = repository.findByEmail(emp.getEmail());
        if (existing.isPresent())
            throw new EmployeeNotFoundException("Employee with email"+ emp.getEmail()+ "already exists");
        return repository.save(emp);
    }

    @Override
    @Transactional
    public Employee update(String id, Employee emp) {
        Optional<Employee> existing = repository.findById(id);
        if(!existing.isPresent()){
            throw new EmployeeNotFoundException("Employee with id "+id+" not found");
        }
        return repository.save(emp);
    }

    @Override
    @Transactional
    public void delete(String id) {
        Optional<Employee> emp =  repository.findById(id);
        repository.delete(emp.get())  ;
    }
}
