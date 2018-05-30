package academy.ennate.controller;

import academy.ennate.entity.Customer;
import academy.ennate.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/ap2/customer")
public class CustomerController {

    @Autowired
    public CustomerService service;

    @RequestMapping(method = RequestMethod.GET)
     public List<Customer> findAll(){
        return service.findAll();
    }

    @RequestMapping(method = RequestMethod.GET, value = "{id}")
    public Customer findOne(@PathVariable("id") String id){
        return service.findOne(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    public Customer create(@RequestBody Customer cust){
        return cust;
    }

    @RequestMapping(method = RequestMethod.PUT, value = "{id}")
    public Customer update(@PathVariable("id") String id,@RequestBody Customer cust){
        return cust;
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "{id}")
    public void delete(@PathVariable("id") String id){

    }


}
