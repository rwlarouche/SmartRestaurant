/*
 * Config.java
 * Configuration class that manually creates a set of dish objects
 * within the SmartRestaurant system
 * @author Ryan laRouche
 */
package smartrestaurant;
import java.util.Random;

// External Lorem Ipsum library (All credit due to original author)
import de.svenjacobs.loremipsum.LoremIpsum;

public class Config {
    // ======= CONFIG PROPERTIES =======
    protected Dish [] dish;                 // Array of dishes
    private Random rand = new Random();     // Used to generate random variables internally
    private LoremIpsum lorem = new LoremIpsum(); // Used to generate random Lorem Ipsum desc internally
    // =================================
    
    // ========= CONSTRUCTOR =========
    /**
     * Constructor: Creates an array of 'size' randomly generated dish objects
     * @param size An integer describing the number of dish objects in the dish array
     */
    public Config (int size) {
        // Allocate dish size to passed size
        dish = new Dish[size];
        
        // Populate array of dishes with a random picture path, description
        // and name
        for (int i = 0; i < size; i++)
        {
            dish[i] = new Dish(randPic(), randDesc(), randPrice());
        }
    } // constructor
    // =================================
    
    // ======= ASSISTING METHODS =======
    /**
     * Randomly chooses a path from an array of valid picture paths
     * @return Picture path string
     */
    private String randPic() {
        return "images/Pic" + rand.nextInt(34) + ".jpg";
    } // randPic
    
    /**
     * Randomly generates a description string generated using
     * an external Lorem Ipsum library
     * @return Description string
     */
    private String randDesc(){
        return lorem.getWords(rand.nextInt(30)+10);
    } // randDesc
    
    /**
     * Randomly generates a price double
     * @return Price double
     */
    private double randPrice(){
        final double MAX_PRICE = 30.00; // Maximum possible random price
        return Math.round((rand.nextDouble()*MAX_PRICE+5)*100)/100;
    } // randPrice
    
    /**
     * Gets and returns the Dish object at index in dish array
     * @param index Specified index
     * @return Dish object
     */
    public Dish getDish(int index) {
        return dish[index];
    }
    // =================================
}
