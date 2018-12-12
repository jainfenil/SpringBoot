package academy.ennate.controller;

import academy.ennate.entity.Employee;
import academy.ennate.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;

import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@RestController
@RequestMapping(value = "/ap1/employees")
public class EmployeeController {

    @Autowired
    public EmployeeService service;

    @RequestMapping(method = RequestMethod.GET)
     public List<Employee> findAll(){
        return service.findAll();
    }

    @RequestMapping(method = RequestMethod.GET, value = "{id}")
    public Resource<Employee> findOne(@PathVariable("id") String id){
        Employee employee = service.findOne(id);
        Resource<Employee> resource = new Resource<>(employee);
        ControllerLinkBuilder linkTo = linkTo(methodOn(this.getClass()).findAll());
        resource.add(linkTo.withRel("all-users"));
        return resource;
    }

    @RequestMapping(method = RequestMethod.POST)
    public Employee create(@RequestBody Employee employee){
        return service.create(employee);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "{id}")
    public Employee update(@PathVariable("id") String id,@RequestBody Employee employee){
        return service.update(id,employee);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "{id}")
    public void delete(@PathVariable("id") String id){
        service.delete(id);
    }


}
