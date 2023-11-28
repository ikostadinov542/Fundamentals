
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        Map<String, Department> departments = new HashMap<>();

        while (n-- > 0) {
            String employeeData = scanner.nextLine();
            String[] parameters = employeeData.split("\\s+");
            String name = parameters[0];
            double salary = Double.parseDouble(parameters[1]);
            String position = parameters[2];
            String department = parameters[3];

            Employee employee = null;

            if (parameters.length == 6) {
                String email = parameters[4];
                int age = Integer.parseInt(parameters[5]);
                employee = new Employee(name, salary, position, department, email, age);

            } else if (parameters.length == 5) {
                String parameterForth = parameters[4];
                try {
                    int age = Integer.parseInt(parameterForth);
                    employee = new Employee(name, salary, position, department, age);
                } catch (NumberFormatException e) {
                    String email = parameterForth;
                    employee = new Employee(name, salary, position, department, email);
                }

                /*if (employeeData.contains("@")) {
                    String email = parameters[4];
                    Employee employee = new Employee(name, salary, position, department, email);
                } else {
                    int age = Integer.parseInt(parameters[4]);
                    Employee employee = new Employee(name, salary, position, department, age);
                }*/

            } else if (parameters.length == 4) {
                employee = new Employee(name, salary, position, department);
            }


            if (!departments.containsKey(department)) {
                departments.put(department, new Department(department));
                departments.get(department).getEmployees().add(employee);
            } else {
                departments.get(department).getEmployees().add(employee);
            }
        }
        Department maxAvgSalaryDep = departments.entrySet()
                .stream()
                .max(Comparator.comparingDouble(entry -> entry.getValue()
                        .getAvgSalary())).get().getValue();

        System.out.println("Highest Average Salary: " + maxAvgSalaryDep.getName());
        maxAvgSalaryDep.getEmployees().stream()
                .sorted((e1, e2) -> Double.compare(e2.getSalary(), e1.getSalary()))
                .forEach(employee -> System.out.println(employee.toString()));

    }
}
