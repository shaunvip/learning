package misc;

import java.util.*;

/**
 * You have a data structure of employee information, including the employee's unique ID, importance value, and direct subordinates' IDs.
 * <p>
 * You are given an array of employees employees where:
 * <p>
 * employees[i].id is the ID of the ith employee.
 * employees[i].importance is the importance value of the ith employee.
 * employees[i].subordinates is a list of the IDs of the direct subordinates of the ith employee.
 * Given an integer id that represents an employee's ID, return the total importance value of this employee and all their direct and indirect subordinates.
 * Input: employees = [[1,5,[2,3]],[2,3,[]],[3,3,[]]], id = 1
 * Output: 11
 * Explanation: Employee 1 has an importance value of 5 and has two direct subordinates: employee 2 and employee 3.
 * They both have an importance value of 3.
 * Thus, the total importance value of employee 1 is 5 + 3 + 3 = 11.
 */
class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;

    public Employee(int id, int importance, List<Integer> subordinates) {
        this.id = id;
        this.importance = importance;
        this.subordinates = subordinates;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", importance=" + importance +
                ", subordinates=" + subordinates +
                '}';
    }
}

public class EmployeeImportance {

    public static void main(String[] args) {
        //[[1,5,[2,3]],
        // [2,3,[4]],[3,4,[]],[4,1,[]]]
        Employee e1 = new Employee(1, 5, Arrays.asList(2, 3));
        Employee e2 = new Employee(2, 3, Collections.singletonList(4));
        Employee e3 = new Employee(3, 4, Collections.emptyList());
        Employee e4 = new Employee(4, 1, Collections.emptyList());
        List<Employee> employeeList = new ArrayList<>();

        employeeList.add(e1);
        employeeList.add(e2);
        employeeList.add(e3);
        employeeList.add(e4);

        EmployeeImportance employeeImportance = new EmployeeImportance();
        employeeImportance.getImportance(employeeList, 1);
    }

    public int getImportance(List<Employee> employees, int id) {
        Map<Integer, Employee> map = new HashMap<>();
        for (Employee e : employees) {
            map.put(e.id, e);
        }
        int result = 0;
        for (Employee employee : employees) {
            if (id == employee.id) {
                result = dfs(employee, map);
            }
        }
        return result;
    }

    private int dfs(Employee employee, Map<Integer, Employee> map) {
        Set<Integer> set = new HashSet<>();
        set.add(employee.id);
        Stack<Employee> stack = new Stack<>();
        stack.add(employee);
        int result = employee.importance;
        while (!stack.isEmpty()) {
            Employee item = stack.pop();
            for (Integer sub : item.subordinates) {
                if (!set.contains(sub)) {
                    set.add(sub);
                    Employee subOrdinate = map.get(sub);
                    result += subOrdinate.importance;
                    stack.add(subOrdinate);
                }
            }
        }
        return result;
    }
}
