import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Stream;


public class MainLambda {
    private static String staffFile = "data/staff.txt";
    private static String dateFormat = "dd.MM.yyyy";
    private static String jsonFile = "data/staff.json";

    public static void main(String[] args) throws IOException {
        ArrayList<Employee> staff = loadStaffFromFile();

        Collections.sort(staff, (o1,o2)->o2.getSalary().compareTo(o1.getSalary()));
        for(Employee employee : staff) {
            System.out.println(employee);
        }
        System.out.println(System.lineSeparator());

        Collections.sort(staff, new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                return o1.getSalary().compareTo(o2.getSalary());
            }
        });

        for(Employee employee : staff) {
            System.out.println(employee);
        }
        System.out.println(System.lineSeparator());

        /* Записываем JSON  */

/*        staff.stream().forEach(e-> {
            String content = "{\r\n \"name\": \"" + e.getName() + "\",\r\n \"salary\": " + e.getSalary() + ", \r\n \"workStart\": \"" + (new SimpleDateFormat("dd.MM.yyyy")).format(e.getWorkStart()) + "\"\r\n},";
            try {
                Files.writeString(Paths.get(jsonFile), (content + System.lineSeparator()), StandardOpenOption.CREATE,StandardOpenOption.APPEND);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });
*/

/*
        */
/* Читаем данные из Json файла *//*

        try {

            System.out.println("Читаем данные из json ");
            String data = getDataFromFile(jsonFile);
//            System.out.println(data);
            JSONParser parser = new JSONParser();
            JSONArray array = (JSONArray) parser.parse(data);

            for(Object item:array)
            {
                JSONObject jsonObject = (JSONObject) item;
                System.out.println(jsonObject.get("name"));
            }
            System.out.println();
            System.out.println();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
*/


        /* указатели на методы */
        Collections.sort(staff, Comparator.comparing(Employee::getSalary));

        /* одновременная сортировка по двум параметрам */
//        Collections.sort(staff, (o1, o2) -> {
//            int compareSalary = o1.getSalary().compareTo(o2.getSalary());
//            if(compareSalary == 0){
//                int compareName = o1.getName().compareTo(o2.getName());
//                return compareName;
//            }
//            return compareSalary;
//        });

        // Lambda Expressions
//        staff.forEach(employee -> System.out.println(employee.toString()));

        // forEach
        System.out.println("Old salaries");
        staff.forEach(System.out::println);

        int salaryIncrease = 10000;
        staff.forEach(e->e.setSalary(e.getSalary() + salaryIncrease));

        System.out.println("New salaries");
        staff.forEach(System.out::println);
//        for(Employee empl: staff) {
//            System.out.println(empl.toString());
//        }


        //  Stream - is part of collection
//        Stream<Employee> stream = staff.stream();
//        stream.filter(employee -> employee.getSalary() >= 100000).forEach(System.out::println);
        System.out.println("----Stream----");
        staff.stream().filter(e->e.getSalary()>=100000).forEach(System.out::println);


        // Создать stream и работать с ним
        System.out.println();
        System.out.println("----Stream Numbers----");
        Stream<Integer> numbers = Stream.of(1,2,3,4,5,6,7,8,9,10);
        numbers.filter(n -> n%2==0).forEach(System.out::println);

        // Stream из массива
        System.out.println();
        System.out.println("----Stream from Array----");
        Integer[] numbersi = {1,2,3,4,5,6,7,8,9,10};
        Arrays.stream(numbersi).filter(n -> n >= 6).forEach(System.out::println);

        // Endless Stream
        System.out.println();
        System.out.println("----Endless Stream----");
        // Stream.iterate(1, n -> n+1).filter(n -> n <= 100).forEach(System.out::println);

        // Generate Stream
        System.out.println();
        System.out.println("----Generate Stream----");
        // Stream.generate(()->"aaa").forEach(System.out::print);

        "asdaksdljgbajksgd".chars().forEach(System.out::print);


        // Sorting with stream
        System.out.println();
        System.out.println("----Sorting with stream----");
        staff.stream().sorted(Comparator.comparing(Employee::getName)).sorted(Comparator.comparing(Employee::getSalary)).forEach(System.out::println);

        // Max Min with streams
        System.out.println();
        System.out.println("----Max Min with streams----");
        Optional<Employee> optional = staff.stream().max(Comparator.comparing(Employee::getSalary));
        Employee employee1 = optional.get();
        // OR safety
        staff.stream().max(Comparator.comparing(Employee::getSalary)).ifPresent(System.out::println);

        // Map Reduce
        System.out.println();
        System.out.println("----Map Reduce----");
        staff.stream().map(e->e.getSalary()).filter(s->s>=100000).reduce((s1,s2)->s1 +s2).ifPresent(System.out::println);

        // Stream without objects
        System.out.println();
        System.out.println("----Stream without objects----");
        Stream.of(1,2,3,4,5,6).forEach(System.out::println);



/*        // Generics
        System.out.println();
        System.out.println("----Generics----");
        LRUCache<Employee> cache = new LRUCache<>(5);
        for(Employee empl: staff)
        {
            cache.addElement(empl);
        }
        cache.getAllElements().forEach(System.out::println);

        System.out.println("----Generics get one Element----");
        System.out.println(cache.getElement(4).getSalary());*/
    }

    private static ArrayList<Employee> loadStaffFromFile()
    {
        ArrayList<Employee> staff = new ArrayList<>();
        try
        {
            List<String> lines = Files.readAllLines(Paths.get(staffFile));
            for(String line : lines)
            {
                String[] fragments = line.split("\t");
                if(fragments.length != 3) {
                    System.out.println("Wrong line: " + line);
                    continue;
                }
                staff.add(new Employee(
                        fragments[0],
                        Integer.parseInt(fragments[1]),
                        (new SimpleDateFormat(dateFormat)).parse(fragments[2])
                ));
            }
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
        return staff;
    }


    private static String getDataFromFile(String path)
    {
        StringBuilder builder = new StringBuilder();
        try
        {
            List<String> lines = Files.readAllLines(Paths.get(path));
            for(String line : lines)
            {
                builder.append(line);
            }
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }

        return builder.toString();
    }
}
