package academy.ennate.service;

import academy.ennate.entity.Customer;
import academy.ennate.entity.Employee;

import java.util.List;

public interface CustomerService {
    List<Customer> findAll();
    Customer findOne(String id);

    Customer create(Customer cust);

    Customer update(String id, Customer cust);

    void delete(String id);
}
