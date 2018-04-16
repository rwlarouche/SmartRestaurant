/*
 * NavController.java
 * Navigation controller class that provides a set of methods needed to navigation
 * between next and previous dishes as well as connect to the API class to display
 * a dish when a navigation button is interacted with
 * @author Ryan laRouche
 */
package smartrestaurant;
import java.util.Random;

public class NavController {
    // ======= CONFIG PROPERTIES =======
    protected Config config;        // Config object containing an array of Dish objects
    protected int index;            // Index of current dish (in config array of dishes)
    private API api;                // Used to reference API interface internally
    private Random rand = new Random();    // Used to generate random variables internally
    // =================================
    
    // ========= CONSTRUCTOR =========
    public NavController(Config config, API MenuApp){
        // Create a config object containing a random number (<20) of dish
        // objects
        this.config = config;
        this.index = 0;          // Start index at 0
        this.api = MenuApp;
    }
    // =================================
    
    // ======== UTILITY METHODS ========
    /**
     * Used by the program navigation controller to navigate to the next dish
     */
    public void nextDish(){
        if (index < config.dish.length -1) index++;
    }
    
     /**
     * Used by the program navigation controller to navigate to the previous dish
     */
    public void prevDish() {
        if (index > 0) index--;
    }  
    
    /**
     * Used by the program navigation controller to display the current dish
     */
    public void displayCurrDish() {
        Dish currDish = config.getDish(index);
        api.displayDesc(currDish);
        api.displayPic(currDish);
        api.displayPrice(currDish);
    }
    // =================================
}
