import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class AddItemDialog extends Stage {

    private TextField nameField = new TextField();
    private TextField serialNumberField = new TextField();
    private TextField pieceField = new TextField();
    private Inventory inventory;

    public AddItemDialog(Inventory inventory) {
        this.inventory = inventory;

        this.setTitle("Add Item");

        Label nameLabel = new Label("Name:");
        Label serialNumberLabel = new Label("Serial Number:");
        Label pieceLabel = new Label("Piece:");

        Button addButton = new Button("Add");
        addButton.setOnAction(event -> {
            String name = nameField.getText();
            int serialNumber = Integer.parseInt(serialNumberField.getText());
            int piece = Integer.parseInt(pieceField.getText());

            inventory.additem(name, serialNumber,piece);
            this.close();
        });

        VBox vbox = new VBox(10);
        vbox.getChildren().addAll(nameLabel, nameField, serialNumberLabel, serialNumberField,pieceLabel,pieceField ,addButton);

        Scene scene = new Scene(vbox, 300, 250);
        this.setScene(scene);
    }
}
