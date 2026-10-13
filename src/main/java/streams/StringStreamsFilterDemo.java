
package streams;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StringStreamsFilterDemo {

    public static void main(String[] args) {

        ArrayList<String> names = new ArrayList<>();

        names.add("Adarsh");
        names.add("Aman");
        names.add("Ananya");
        names.add("Rahul");
        names.add("Rohit");
        names.add("Karan");
        names.add("Aarav");
        names.add("aditya");

        System.out.println("Original List: " + names);

        // 1. Strings starting with "A"
        List<String> startsWithA = names.stream()
                .filter(name -> name.startsWith("A"))
                .collect(Collectors.toList());

        System.out.println("\nNames starting with A: " + startsWithA);

        // 2. Strings ending with "n"
        List<String> endsWithN = names.stream()
                .filter(name -> name.endsWith("n"))
                .collect(Collectors.toList());

        System.out.println("Names ending with n: " + endsWithN);

        // 3. Strings containing "ar"
        List<String> containsAr = names.stream()
                .filter(name -> name.contains("ar"))
                .collect(Collectors.toList());

        System.out.println("Names containing 'ar': " + containsAr);

        // 4. Strings with length greater than 5
        List<String> longNames = names.stream()
                .filter(name -> name.length() > 5)
                .collect(Collectors.toList());

        System.out.println("Names with length > 5: " + longNames);

        // 5. Case-insensitive filtering
        List<String> startsWithAIgnoreCase = names.stream()
                .filter(name -> name.toLowerCase().startsWith("a"))
                .collect(Collectors.toList());

        System.out.println("Names starting with A (ignore case): "
                + startsWithAIgnoreCase);

        // 6. Exact match, ignoring case
        List<String> matchingAditya = names.stream()
                .filter(name -> name.equalsIgnoreCase("ADITYA"))
                .collect(Collectors.toList());

        System.out.println("Matching ADITYA: " + matchingAditya);

        // 7. Filter and transform to uppercase
        List<String> uppercaseNames = names.stream()
                .filter(name -> name.startsWith("R"))
                .map(String::toUpperCase)
                .collect(Collectors.toList());

        System.out.println("R names in uppercase: " + uppercaseNames);

        // 8. Sort strings alphabetically
        List<String> sortedNames = names.stream()
                .sorted(String.CASE_INSENSITIVE_ORDER)
                .collect(Collectors.toList());

        System.out.println("Alphabetically sorted: " + sortedNames);

        // 9. Count strings containing "a" (case-insensitive)
        long count = names.stream()
                .filter(name -> name.toLowerCase().contains("a"))
                .count();

        System.out.println("Names containing 'a': " + count);

        // 10. Check if any name starts with "K"
        boolean hasKName = names.stream()
                .anyMatch(name -> name.startsWith("K"));

        System.out.println("Any name starting with K: " + hasKName);
    }
}
