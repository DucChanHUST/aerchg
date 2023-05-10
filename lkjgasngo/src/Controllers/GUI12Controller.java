package Controllers;

import Models.Model;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class GUI12Controller implements Initializable {
    public Button question_btn;
    public Button questionbank;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        question_btn.setOnAction(event -> showGUI21());
    }

    public void showGUI21() {
        Stage stage2 = (Stage) questionbank.getScene().getWindow();
        Model.getInstance().getViewFactory().closeStage(stage2);
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/resources/Fxml/GUI21.fxml"));
        Model.getInstance().getViewFactory().createStage(loader);
    }
}
