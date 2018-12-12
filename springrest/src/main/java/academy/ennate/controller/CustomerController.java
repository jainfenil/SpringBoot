package academy.ennate.controller;

import academy.ennate.entity.Customer;
import academy.ennate.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

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
    public Resource<Customer> findOne(@PathVariable("id") String id){
        Customer customer = service.findOne(id);
        Resource<Customer> resource = new Resource<>(customer);
        ControllerLinkBuilder linkTo = linkTo(methodOn(this.getClass()).findAll());
        resource.add(linkTo.withRel("all-customers"));
        return resource;
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
