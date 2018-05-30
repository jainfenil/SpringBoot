package academy.ennate.entity;

import javax.persistence.*;
import java.util.UUID;

@Entity
public class Employee {

    @Id
    public String id;
    @Column(columnDefinition = "VARCHAR(36)")
    public String name;
    @Column(unique = true)
    public String email;
    public int salary;

    @Override
    public String toString() {
        return "Employee{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", salary=" + salary +
                '}';
    }

    public Employee(){
        this.id = UUID.randomUUID().toString();
    }

    public Employee(String name, String email, int salary) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.email = email;
        this.salary = salary;
    }

    public String getId() {
        return id;

    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }
}
