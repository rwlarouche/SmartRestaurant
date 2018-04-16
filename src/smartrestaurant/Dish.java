
/*
 * Dish.java
 * Dish class for individual dish objects within the SmartRestaurant system
 * @author Ryan laRouche
 */
package smartrestaurant;

public class Dish {
    // ======= DISH PROPERTIES =======
    protected String pic;     // Dish picture
    protected String desc;     // Dish decription
    protected Double price;   // Dish price
    // ===============================
    
    // ========= CONSTRUCTOR =========
    /**
     * Constructor: Creates a dish object with a picture price, and description
     * @param pic String of picture file path
     * @param desc String of description for dish
     * @param price Double of price of dish
     */
    public Dish(String pic, String desc, Double price){
        this.pic = pic;
        this.desc = desc;
        this.price = price;
    } // constructor
    // ===============================
    
    // ====== ACCESSOR METHODS =======
    /**
     * Returns the file path of the dish's picture
     * @return String of the picture path
     */
    public String getPic() {
        return pic;
    } // getPic
    
    /**
     * Returns the dish's description
     * @return String of the description
     */
    public String getDesc() {
        return desc;
    } // getDesc
    
    /**
     * Returns the dish's price
     * @return String of the price
     */
    public double getPrice() {
        return price;
    } // getPrice
    // ===============================
}
