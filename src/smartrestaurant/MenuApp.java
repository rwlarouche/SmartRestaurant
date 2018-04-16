/*
 * MenuApp.java
 * The main class for the SmartRestaurant package
 * Allows for the SmartRestaurant system to run regardless of client platform by
 * communicating with the platform UI interface and the NavController via the API
 * class middleman
 *
 * Note: This MenuApp implementation is for JavaFX (this is the only class that would
 * need to change if the application is ported to another platform)
 *
 * @author Ryan laRouche
 */
package smartrestaurant;

// JavaFX imports
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class MenuApp extends Application implements API {
    // ======= MENUAPP PROPERTIES ======
    protected NavController controller = new NavController(new Config(10), this);  // Menu controller and dishes
    protected ImageView pic;    // Pic UI
    protected Label desc;       // Desc UI
    protected Label price;      // Price UI
    // =================================
    
    // ========= MAIN METHOD =========
    /**
     * Create a new MenuApp instance with a NavController and API (actually another MenuApp instance)
     * @param args the command line arguments (none used)
     */
    public static void main(String[] args) {
        launch(args);
    }
    // =================================
    
    // ======== UTILITY METHODS ========    
    // =================================

    // ========= API INTERFACE =========
    @Override
    public void displayPic(Dish dish) {
        try {
            pic.setImage(new Image(new FileInputStream(dish.pic)));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(MenuApp.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void displayDesc(Dish dish) {
        desc.setText(dish.desc);
    }

    @Override
    public void displayPrice(Dish dish) {
        price.setText("Price: $" + dish.price);
    }
    // =================================
    
    // ======== JAVAFX METHODS =========
    @Override
    public void start(Stage primaryStage) throws FileNotFoundException {
        // ===== Setup Window =====
        BorderPane root = new BorderPane();             // Create new window
        Scene scene = new Scene(root, 600, 300);        // Set window dimensions
        primaryStage.setTitle("SmartRestaurant v1.0");  // Set window title
        
        BorderPane ui_hub = new BorderPane(); // Container for desc, pic, price
        BorderPane desc_price_hub = new BorderPane();   // Container for desc and price
        BorderPane button_hub = new BorderPane();  // Container for buttons
        
        desc = new Label();   // Create description text field
        
        root.setPadding(new Insets(20));    // Space between elements and window border
        root.setTop(ui_hub);           // Desc/pic contain at center of window
        root.setBottom(button_hub);         // Buttons at bottom of window
        // ========================

        // === Prev Dish Button ===
        Button prev = new Button();      // New button (previous dish)
        prev.setText("< Prev");          // Button text
        prev.setOnAction((event) -> {    // Button action
            controller.prevDish();
            controller.displayCurrDish();
        });
        button_hub.setLeft(prev);    // Add button to window
        // ========================
        
        // === Next Dish Button ===
        Button next = new Button();      // New button (next dish)
        next.setText("Next >");          // Button text
        next.setOnAction((event) -> {    // Button action
            controller.nextDish();
            controller.displayCurrDish();
        });
        button_hub.setRight(next);    // Add button to window
        // ========================
       
        // ====== Dish Image ======
        pic = new ImageView(new Image(new FileInputStream(controller.config.getDish(controller.index).pic)));
        ui_hub.setLeft(pic);
        // ========================
        
        // ====== Dish Desc =======
        desc = new Label(controller.config.getDish(controller.index).desc);
        desc.setWrapText(true);
        desc.setMaxWidth(200);
        ui_hub.setRight(desc_price_hub);
        desc_price_hub.setTop(desc);
        // ========================
        
        // ====== Dish Price ======
        price = new Label("Price: $" + controller.config.getDish(controller.index).price);
        price.setWrapText(true);
        desc_price_hub.setBottom(price);
        // ========================
        
        // ==== Display Window ====
        primaryStage.setScene(scene);   // Add window to stage
        primaryStage.show();            // Show window
        // ========================
    }
    // =================================
}
