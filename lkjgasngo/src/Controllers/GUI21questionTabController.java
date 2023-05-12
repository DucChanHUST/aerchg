package Controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.util.StringConverter;

import java.net.URL;
import java.util.ResourceBundle;

public class GUI21questionTabController implements Initializable {
    @FXML
    private ChoiceBox<String> choiceBox;
    private String[] data = {null, "1", "2", "3"};

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        choiceBox.getItems().addAll(data);
        choiceBox.setConverter(new StringConverter<String>() {
            @Override
            public String toString(String s) {
                return (s == null) ? "Default" : s;
            }

            @Override
            public String fromString(String s) {
                return null;
            }
        });
    }
}
