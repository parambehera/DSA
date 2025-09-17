import java.util.*;

class FoodRatings {
    private Map<String, String> foodToCuisine;
    private Map<String, Integer> foodToRating;
    private Map<String, TreeSet<String>> cuisineToSet;

    public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
        foodToCuisine = new HashMap<>();
        foodToRating = new HashMap<>();
        cuisineToSet = new HashMap<>();

        for (int i = 0; i < foods.length; i++) {
            String food = foods[i];
            String cuisine = cuisines[i];
            int rating = ratings[i];

            foodToCuisine.put(food, cuisine);
            foodToRating.put(food, rating);

            cuisineToSet.computeIfAbsent(cuisine, k -> new TreeSet<>(
                (a, b) -> {
                    int cmp = Integer.compare(foodToRating.get(b), foodToRating.get(a));
                    if (cmp == 0) return a.compareTo(b);
                    return cmp;
                }
            )).add(food);
        }
    }

    public void changeRating(String food, int newRating) {
        String cuisine = foodToCuisine.get(food);
        TreeSet<String> set = cuisineToSet.get(cuisine);

        // Remove old version
        set.remove(food);
        // Update rating
        foodToRating.put(food, newRating);
        // Reinsert with new rating
        set.add(food);
    }

    public String highestRated(String cuisine) {
        return cuisineToSet.get(cuisine).first(); // best food
    }
}
