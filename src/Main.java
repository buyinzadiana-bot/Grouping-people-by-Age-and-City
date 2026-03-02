import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.*;
import java.util.stream.*;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        List<Person> people = new ArrayList<>();

        // 1️⃣ Ask how many people
        System.out.print("How many people? ");
        int n = sc.nextInt();
        sc.nextLine(); // clear buffer

        // 2️⃣ Input data
        for (int i = 0; i < n; i++) {
            System.out.println("\nEnter person " + (i + 1));

            System.out.print("Name: ");
            String name = sc.nextLine();

            System.out.print("Age: ");
            int age = sc.nextInt();
            sc.nextLine();

            System.out.print("City: ");
            String city = sc.nextLine();

            people.add(new Person(name, age, city));
        }

        // 🎁 BONUS: Change name of second person
        if (people.size() >= 2) {
            people.get(1).setName("UpdatedName");
        }

        // 3️⃣ Group by age → names
        Map<Integer, List<String>> byAge =
                people.stream()
                        .collect(Collectors.groupingBy(
                                Person::getAge,
                                Collectors.mapping(Person::getName, Collectors.toList())
                        ));

        // 4️⃣ Group by city → count
        Map<String, Long> byCity =
                people.stream()
                        .collect(Collectors.groupingBy(
                                Person::getCity,
                                Collectors.counting()
                        ));

        // 5️⃣ Display results
        System.out.println("\n--- Grouped by Age ---");
        byAge.forEach((age, names) -> {
            System.out.println("Age " + age + ": " + names);
        });

        System.out.println("\n--- Count by City ---");
        byCity.forEach((city, count) -> {
            System.out.println(city + ": " + count);
        });
    }
}