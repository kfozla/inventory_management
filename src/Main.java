import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Main extends Application {
    private Inventory inventory;

    @Override
    public void start(Stage stage) {
        inventory = new Inventory();

        TextField tf1 = new TextField();
        tf1.setPromptText("Enter serial number");

        Label titleLabel = new Label("Inventory Search");
        titleLabel.setFont(new Font("Arial", 20));

        Button searchButton = new Button("Search");
        searchButton.setOnAction(event -> {
            String textFieldValue = tf1.getText();
            SearchHandler searchHandler = new SearchHandler(inventory);
            searchHandler.handleSearch(textFieldValue);
        });

        Button addItemButton = new Button("Add Item");
        addItemButton.setOnAction(event -> {
            AddItemDialog addItemDialog = new AddItemDialog(inventory);
            addItemDialog.showAndWait();
        });

        HBox searchBox = new HBox(tf1, searchButton);
        searchBox.setSpacing(10);

        VBox root = new VBox(titleLabel, searchBox, addItemButton);
        root.setSpacing(20);
        root.setPadding(new Insets(20));

        Scene scene = new Scene(root, 400, 250);

        stage.setTitle("Inventory Management");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}