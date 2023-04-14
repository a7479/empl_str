package pro.sky.empl_str;

import java.util.Objects;


public class Employee {


    private String name;
    private Integer departmentId;
    private Double salary;

    public Employee(String name,Integer departmentId, Double salary) {
        this.departmentId = departmentId;
        this.salary = salary;
        this.name = name;
    }



    public String getName() {
        return name;
    }


    public Integer getDepartmentId() {
        return departmentId;
    }

    public Double getSalary() {
        return salary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(name, employee.name) ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "firstName='" + name + '\'' +
                ", department=" + departmentId +
                ", salary=" + salary +
                '}';
    }
}




