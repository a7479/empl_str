package pro.sky.empl_str;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class EmployeeController {

    public final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }


        @GetMapping(path = "/add")
    public Employee add(@RequestParam("name") String name,
                        @RequestParam("departmentId") Integer departmentId,
                        @RequestParam("salary") Double salary) {

        return employeeService.addEmployee(name, departmentId, salary);
    }


    @GetMapping(path = "/departmens/max-salary")
    public Employee calculateMaxSalary(@RequestParam Integer departmentId) {
        return employeeService.calculateMaxSalary(departmentId);
    }

    @GetMapping(path = "/departmens/min-salary")
    public Employee calculateMinSalary(@RequestParam Integer departmentId) {
        return employeeService.calculateMinSalary(departmentId);
    }

    @GetMapping(path = "/departmens/all")
    public List<Employee> allDep(@RequestParam(value = "departmentId", required = false) Integer departmentId) {

        if (departmentId==null) {

            return employeeService.all();
        }
        return employeeService.allDep(departmentId);

        }
    }


