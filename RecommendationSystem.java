import java.util.*;

public class RecommendationSystem {
    static Map<String, List<String>> userPreferences = new HashMap<>();

    public static void main(String[] args) {
        // Sample data: user -> liked products
        userPreferences.put("Ravi", Arrays.asList("Shoes", "Watch", "Sunglasses"));
        userPreferences.put("Priya", Arrays.asList("Watch", "Handbag", "Perfume"));
        userPreferences.put("Karthik", Arrays.asList("Shoes", "Backpack", "T-Shirt"));
        userPreferences.put("Divya", Arrays.asList("Perfume", "Handbag", "Shoes"));

        // Simulate recommendation
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your name (Ravi, Priya, Karthik, Divya): ");
        String username = scanner.nextLine();

        if (!userPreferences.containsKey(username)) {
            System.out.println("User not found. Try Ravi, Priya, Karthik, or Divya.");
            return;
        }

        List<String> recommendations = recommend(username);
        System.out.println("\nRecommended items for " + username + ": " + recommendations);
    }

    static List<String> recommend(String username) {
        List<String> userItems = userPreferences.get(username);
        Set<String> recommended = new HashSet<>();

        for (Map.Entry<String, List<String>> entry : userPreferences.entrySet()) {
            if (!entry.getKey().equals(username)) {
                List<String> otherUserItems = entry.getValue();
                for (String item : otherUserItems) {
                    if (!userItems.contains(item)) {
                        recommended.add(item);
                    }
                }
            }
        }

        return new ArrayList<>(recommended);
    }
}
