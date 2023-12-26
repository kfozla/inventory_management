import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class SearchHandler {
    private Inventory inventory;

    public SearchHandler(Inventory inventory) {
        this.inventory = inventory;
    }

    public void handleSearch(String textFieldValue) {
        if (!textFieldValue.isEmpty()) {
            try {
                int value = Integer.parseInt(textFieldValue);
                Item searchItem = new Item(null, value,0);
                Item item = inventory.search(searchItem);

                if (item != null) {
                    displayItemFound(item);
                } else {
                    handleItemNotFound(value);
                }
            } catch (NumberFormatException e) {
                handleInvalidInput();
            }
        }
    }

    private void displayItemFound(Item item) {
        Stage stg = new Stage();
        BorderPane border = new BorderPane();
        Scene scn = new Scene(border, 300, 100);
        Label lbl = new Label("found "+item.getPiece()+" piece of"+item.getName());
        border.setCenter(lbl);
        stg.setTitle("app");
        stg.setScene(scn);
        stg.show();
        stg.setResizable(false);
    }

    private void handleItemNotFound(int value) {
        System.out.println("No item found for serial number: " + value);
    }

    private void handleInvalidInput() {
        System.out.println("Invalid input. Please enter a valid integer.");
    }
}

