import java.util.HashMap;
import java.util.Map;

public class HashMapOperations {
    public static void main(String[] args) {

        // 1. Create a HashMap using Generics
        HashMap<Integer, String> students = new HashMap<>();

        // 2. put() - Add key-value pairs
        students.put(101, "Ad");
        students.put(102, "Rahul");
        students.put(103, "Priya");
        System.out.println("Map: " + students);

        // 3. get() - Retrieve value using key
        System.out.println("Student 101: " + students.get(101));

        // 4. Update a value
        students.put(102, "Aman");
        System.out.println("After update: " + students);

        // 5. putIfAbsent() - Add only if key is absent
        students.putIfAbsent(104, "Neha");

        // 6. containsKey() and containsValue()
        System.out.println("Has key 101? " + students.containsKey(101));
        System.out.println("Has value Ad? " + students.containsValue("Ad"));

        // 7. getOrDefault() - Return fallback if key is absent
        System.out.println("105: "
                + students.getOrDefault(105, "Not Found"));

        // 8. remove() - Remove by key
        students.remove(103);
        System.out.println("After removal: " + students);

        // 9. size() and isEmpty()
        System.out.println("Size: " + students.size());
        System.out.println("Is empty? " + students.isEmpty());

        // 10. Iterate through entries
        for (Map.Entry<Integer, String> entry : students.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }

        // 11. Get all keys and values
        System.out.println("Keys: " + students.keySet());
        System.out.println("Values: " + students.values());

        // 12. replace() - Update only if key exists
        students.replace(101, "Adarsh");

        // 13. clear() - Remove all entries
        students.clear();
        System.out.println("After clear: " + students);
    }
}