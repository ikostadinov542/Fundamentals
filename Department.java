import java.util.ArrayList;
import java.util.List;

public class Department {

    private String name;
    private List<Employee> employees;


    public Department(String name) {
        this.name = name;
        this.employees = new ArrayList<>();
    }

    public double getAvgSalary() {
        return employees.stream()
                .mapToDouble(Employee::getSalary)
                .average().orElse(0.0);

        /*   double sum = 0;
        for (Employee employee : employees) {
            sum += employee.getSalary();
        }
        return sum / employees.size();
        */
    }
    public String getName() {
        return name;
    }


    public List<Employee> getEmployees() {
        return this.employees;
    }
}
