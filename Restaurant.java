import java.util.ArrayList;
public class Restaurant {
    private String name ;
    private ArrayList<String> menuItems ;
    private ArrayList<Integer> prices ;
    private ArrayList<Integer> ratings ;

    public Restaurant(String name) {

        this.name = name;
        this.menuItems = new ArrayList<>();
        this.prices = new ArrayList<>();
        this.ratings = new ArrayList<>();
    }
    public void addMenuItems(String menuItem, int price, int rating) {
        this.menuItems.add(menuItem);
        this.prices.add(price);
        this.ratings.add(rating);
    }
    public void removeMenuItem(String menuItem) {
        this.menuItems.remove(menuItem);
        this.prices.remove(menuItem);
        this.ratings.remove(menuItem);
    }
    public int getAverageRating(String menuItem) {
        int totalRatings = 0;
        for (int rating : this.ratings) {
            if (this.menuItems.get(rating - 1).equals(menuItem)) {
                totalRatings += rating;
            }
        }
        return totalRatings / this.ratings.size();
}
public void displayMenu() {
        for (int i = 0; i < this.menuItems.size(); i++) {
            System.out.println(this.menuItems.get(i) + " - " + this.prices.get(i) + " - " + this.ratings.get(i));
        }
}
public static void main(String[] args) {
        Restaurant restaurant = new Restaurant("Kumar Hotel");
        restaurant.addMenuItems("rice", 5, 7);
        restaurant.addMenuItems("Biryani", 10, 9);
        restaurant.addMenuItems("Chicken Curry", 8, 7);

        System.out.println("Average rating of rice " + restaurant.getAverageRating("rice"));
        System.out.println("Average rating of Biryani " + restaurant.getAverageRating("Biryani"));
        System.out.println("Average rating of Chicken curry " + restaurant.getAverageRating("Chicken curry"));

        restaurant.removeMenuItem("rice");
        restaurant.displayMenu();
}
}