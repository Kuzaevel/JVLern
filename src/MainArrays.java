import java.util.*;

public class MainArrays {

    public static void main(String[] args) {
        System.out.println("Arrays" + System.lineSeparator());

        int[] roomCounts = new int[6];
        int[] roomCounts1 = {3,4,5,6,};

        roomCounts[0] = 1;
        roomCounts[1] = 45;
        roomCounts[2] = 34;
        roomCounts[3] = 28;

        for (int i = 0 ; i < roomCounts1.length; i++)
        {
            System.out.println(roomCounts[i]);
            System.out.println(roomCounts1[i]);
        }

        System.out.println(System.lineSeparator());

        String[] colors = {"r", "o"};
        String text = "r o b  s o n";

        colors = text.split(",?\\s+");

        for (int i = 0 ; i < colors.length; i++)
        {
            System.out.println(colors[i]);
        }

        System.out.println(System.lineSeparator());

        /// Tickets
        int[] ticketsNumber = new int[1000];

        int[] winTickets = new int[10];

        for (int i = 0; i < ticketsNumber.length; i++)
        {
            int value = 1000000 + (int) Math.round (1000000 * Math.random());
            ticketsNumber[i] = value;
            if (i % 100 == 0) {
                winTickets[i / 100] = value;
            }
        }

        System.out.println(ticketsNumber[125]);
        System.out.println(System.lineSeparator());

        for (int num : winTickets)
        {
            System.out.println("\t" + num);
        }

        System.out.println(System.lineSeparator());
        System.out.println("Array List" + System.lineSeparator());

        ArrayList<String> todoList = new ArrayList<>();
        todoList.add("123");
        todoList.add(1, "123");

        for (String num : todoList)
        {
            System.out.println("\t" + num);
        }

        System.out.println("Array List" + System.lineSeparator());

        ArrayList<String> todoList1 = new ArrayList<>() {{
           add("1");
           add("2");
           add("3");
           add("4");
        }};

        todoList1.remove(todoList1.size() - 1);

        for (String item : todoList1)
        {
            System.out.println("\t" + item);
        }

        System.out.println(System.lineSeparator());
        System.out.println("HashSet" + System.lineSeparator());

        HashSet<String> words = new HashSet<>(){{
            add("Первое");
            add("Второе");
            add("Третье");
            add("Второе");
        }};

        System.out.println(words.contains("Второе"));

        for (String item : words)
        {
            System.out.println("\t" + item);
        }

        System.out.println(System.lineSeparator());


        System.out.println("TreeSet" + System.lineSeparator());

        TreeSet<String> words1 = new TreeSet<>(){{
            add("Первое");
            add("Второе");
            add("Третье");
            add("Второе");
        }};

        System.out.println(words1.contains("Второе"));

        for (String item : words1)
        {
            System.out.println("\t" + item);
        }

        System.out.println(System.lineSeparator());
        System.out.println("MAP INTERFACE" + System.lineSeparator());
        System.out.println("Hash map" + System.lineSeparator());

        HashMap<String, Integer> words2 = new HashMap<>(){{
            put("Первое", 1);
            put("Второе", 2);
            put("Третье", 3);
            put("Второе", 4);
        }};

        PrintMap(words2);

        TreeMap<String, Integer> word3 = new TreeMap<>(){{
            put("Первое", 1);
            put("Второе", 2);
            put("Третье", 3);
            put("Второе", 4);
        }};

        System.out.println(System.lineSeparator());
        System.out.println("Tree map" + System.lineSeparator());
        PrintMap(word3);

        System.out.println(System.lineSeparator());
        System.out.println("Tree map second print" + System.lineSeparator());
        PrintMap1(word3);

    }

    //Map<String, Integer> map = new Map<String, Integer>() {

    public static void PrintMap(Map<String, Integer> map)
    {
        for (String key : map.keySet()) {
            System.out.println(key + " => " + map.get(key));
        }
    }

    public static void PrintMap1(Map<String, Integer> map)
    {
        Set<String> keys = map.keySet();
        for (String key : keys) {
            System.out.println(key + " => " + map.get(key));
        }
    }

}
