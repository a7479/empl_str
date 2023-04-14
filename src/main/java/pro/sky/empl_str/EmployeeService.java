package pro.sky.empl_str;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeService {

    private final List<Employee> staff = new ArrayList<>();

    EmployeeService() {

        staff.add(new Employee("Aleks", 5, 45322.22));
        staff.add(new Employee("Roman", 3, 45367.22));
        staff.add(new Employee("Sergey",3,25634.50));
        staff.add(new Employee("Elena",2,37654.40));
        staff.add(new Employee("Alena",4,17654.40));


    }


    public Employee addEmployee(String name, Integer departmentId, Double salary) {

        Employee temp = new Employee(name, departmentId, salary);

        staff.add(temp);
        return temp;


    }


    public Employee calculateMinSalary(int departmentId) {
        return staff.stream()
                .filter(e -> e.getDepartmentId() == departmentId)
                .min(Comparator.comparingDouble(employee -> employee.getSalary()))
                .get();
    }
    public Employee calculateMaxSalary(int departmentId) {
        return staff.stream()
                .filter(e -> e.getDepartmentId() == departmentId)
                .max(Comparator.comparingDouble(employee -> employee.getSalary()))
                .get();
    }

    public List<Employee> all() {
        return staff.stream()
                .sorted(Comparator.comparingInt(Employee::getDepartmentId))
                .collect(Collectors.toList());
    }
    public List<Employee> allDep(int departmentId) {
        return staff.stream()
                .filter(e -> e.getDepartmentId() == departmentId)
                .collect(Collectors.toList());
    }


}
