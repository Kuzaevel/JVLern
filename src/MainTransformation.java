import java.util.*;

public class MainTransformation {
    public static void main(String[] args) {
        System.out.println("Transformation");
        String[] colors = {"red", "blue", "green", "yellow"};
        ArrayList<String> colorsList = new ArrayList<>();

        colorsList.addAll(Arrays.asList(colors));
        System.out.println(colorsList);

        ArrayList<String> colorsList1 = new ArrayList<>(Arrays.asList(colors));
        System.out.println(colorsList1);

        HashSet<String> colorsSet = new HashSet<>(colorsList);
        System.out.println(colorsSet);

        TreeSet<String> colorsTreeSet = new TreeSet<>(colorsList);
        System.out.println(colorsTreeSet);

        TreeSet<String> colorsTreeSet1 = new TreeSet<>(new ColorComparator());
        colorsTreeSet1.addAll(colorsList);
        System.out.println(colorsTreeSet1);


        /// MAPS

        HashMap<String, Integer> basket = new HashMap<>();
        basket.put("Milk", 20);
        basket.put("Butter", 10);
        basket.put("Bread", 3);

        TreeMap<String, Integer> basketMap = new TreeMap<>(basket);
        TreeMap<String, Integer> basketMap1 = new TreeMap<>(new ProductComparatorMap());
        basketMap1.putAll(basket);

        System.out.println(colorsTreeSet1);

        System.out.println(System.lineSeparator());

        for (Map.Entry<String, Integer> e : basketMap.entrySet()) {
            System.out.println(e.getKey() + "::" + e.getValue());
        }


        System.out.println("\n" + "ITERATOR");

        Iterator<String> iterator = colorsList.iterator();
        while (iterator.hasNext()) {
            String col = iterator.next();
            if (col.equals("red")) {
                iterator.remove();
            }
        }

        System.out.println(colorsList);

        colorsList.removeIf(x->x.equals("blue"));
        System.out.println(colorsList);

        List<String> cities  = new ArrayList<>(Arrays.asList("Minsk", "Moscow" , "Kiev", "Ljubljana"));

        cities.removeIf(x -> x.length()>7 && x.startsWith("L"));

        System.out.println(cities);

        Thread thread1 = new Thread(() ->
                System.out.println("Hello World from Runnable!"));
        thread1.start();
    }
}
