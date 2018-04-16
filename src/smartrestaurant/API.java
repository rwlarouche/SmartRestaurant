/*
 * API.java
 * API interface that acts as a middleman between the NavController an Menu app
 * for displaying dishes regardless of client platform
 * @author Ryan laRouche
 */
package smartrestaurant;

public interface API {
    // ======= ABSTRACT METHODS ========
    public void displayPic(Dish dish);       // Abstract method to display picture of current dish
    public void displayDesc(Dish dish);      // Abstract method to display desc of current dish
    public void displayPrice(Dish dish);     // Abstract method to display price of current dish
    // =================================
}
