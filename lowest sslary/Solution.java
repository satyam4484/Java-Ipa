import java.util.*;

public class Main {

    static Employee function_one(ArrayList<Employee> employees) {
        // Your function code here
        Collections.sort(employees, new Comparator<Employee>() {
            @Override
            public int compare(Employee e1, Employee e2) {
                return Double.compare(e1.salary, e2.salary);
            }
        });
        
        if (employees.size() >= 2) {
            return employees.get(1);
        }
        return null;
    }

    static int function_two(ArrayList<Employee> employees, int age) {
        // Your function code here
        int sum = 0;
        for (Employee employee : employees) {
            if (employee.age == age) {
                sum++;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        sc.nextLine(); // Consume the newline character

        ArrayList<Employee> employees = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int id = sc.nextInt();
            sc.nextLine(); // Consume the newline character
            String name = sc.nextLine();
            int age = sc.nextInt();
            char gender = sc.next().charAt(0);
            double salary = sc.nextDouble();

            employees.add(new Employee(id, name, age, gender, salary));
        }

        int age = sc.nextInt();
        Employee f1 = function_one(employees);
        if (f1 != null) {

            System.out.println(f1.id + "#" + f1.name);
        } else {
            System.out.println("Null");
        }

        int sum = function_two(employees, age);
        if (sum == 0) {
            System.out.println("No employee found for the given age");
        } else {

            System.out.println(sum);
        }

        sc.close();
    }
}

class Employee {
    int id;
    String name;
    int age;
    char gender;
    double salary;

    public Employee(int id, String name, int age, char gender, double salary) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.salary = salary;
    }
}
