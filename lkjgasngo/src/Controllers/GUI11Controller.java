package Controllers;

import Models.Model;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class GUI11Controller implements Initializable{
    public Label it_lbl;
    public MenuItem questions_btn;

    public void showGUI21() {
        Stage stage = (Stage)it_lbl.getScene().getWindow();
        Model.getInstance().getViewFactory().closeStage(stage);
        Model.getInstance().getViewFactory().showGUI21();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        questions_btn.setOnAction(event -> showGUI21());
    }
}
