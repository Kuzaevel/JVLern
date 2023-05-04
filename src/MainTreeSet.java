import java.util.HashSet;
import java.util.TreeSet;

public class MainTreeSet {

    public static void main(String[] args) {
        System.out.println("TreeSet");

        TreeSet<EmployeeComparable> empList = new TreeSet<>();

        empList.add(new EmployeeComparable("b23123", 123));
        empList.add(new EmployeeComparable("a123123", 121231233));
        empList.add(new EmployeeComparable("werwer", 2321445));

        for (EmployeeComparable emp : empList) {
            System.out.println(emp);
        }

        System.out.println("\n" + "TreeSet1");

        TreeSet<Employee1> empList1 = new TreeSet<>(new EmplComparator());

        empList1.add(new Employee1("b23123", 123));
        empList1.add(new Employee1("a123123", 121231233));
        empList1.add(new Employee1("werwer", 2321445));

        for (Employee1 emp : empList1) {
            System.out.println(emp);
        }

        System.out.println("\n" + "TreeSet celing");
        System.out.println(empList1.ceiling(new Employee1("b23", 123123)));
        System.out.println(empList1.floor(new Employee1("b23", 123123)));
        System.out.println(empList1.contains(new Employee1("b23", 123123)));
        System.out.println(empList1.first());
        System.out.println(empList1.last());
        System.out.println(empList1.pollFirst());



        /*long start = System.currentTimeMillis();
        for(int i = 0; i <= 1_000_000; i++) {
            Employee1 emp = new Employee1("Новенький" + (int) (1000 * Math.random()), 100 );
            employee1sList.add(emp);
        }
        System.out.println(System.currentTimeMillis() - start);
        System.out.println(employee1sList.size());*/
    }
}
