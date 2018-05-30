package academy.ennate.service;

import academy.ennate.entity.Customer;
import academy.ennate.entity.Employee;
import academy.ennate.exception.EmployeeNotFoundException;
import academy.ennate.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {


    @Override
    public List<Customer> findAll() {
        List<Customer> cust = new ArrayList<>();
        cust.add(new Customer("f","abc.com", 1000000));
        cust.add(new Customer("tanvi","abc.com", 1000000));
        cust.add(new Customer("ridhi","abc.com", 1000000));
        return cust;
    }

    @Override
    public Customer findOne(String id) {
        Customer cust = new Customer("Disha","abc.com", 1000000);
            return cust;
    }

    @Override
    public Customer create(Customer cust) {
        return null;
    }

    @Override
    public Customer update(String id, Customer cust) {
        return null;
    }

    @Override
    public void delete(String id) {

    }
}
