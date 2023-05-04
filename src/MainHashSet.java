import java.util.HashSet;

public class MainHashSet {

    public static void main(String[] args) {
        System.out.println("HashSet");

        HashSet<Employee1> employee1sList = new HashSet<>();
        long start = System.currentTimeMillis();
        for(int i = 0; i <= 1_000_000; i++) {
            Employee1 emp = new Employee1("Новенький" + (int) (1000 * Math.random()), 100 );
            employee1sList.add(emp);
        }
        System.out.println(System.currentTimeMillis() - start);
        System.out.println(employee1sList.size());
    }
}
