package Views;

import Models.Model;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class ViewFactory {
    public void showGUI11() {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/resources/Fxml/GUI11.fxml"));
        createStage(loader);
    }

    public void showGUI12() {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/resources/Fxml/GUI12.fxml"));
        createStage(loader);
    }

//    public void showGUI21() {
//        FXMLLoader loader = new FXMLLoader(getClass().getResource("/resources/Fxml/GUI21.fxml"));
//        createStage(loader);
//    }
    public void createStage(FXMLLoader loader) {
        Scene scene = null;
        try {
            scene = new Scene(loader.load());
        } catch (Exception e){
            e.printStackTrace();
        }
        Stage stage = new Stage();
        stage.setScene(scene);
//        stage.setResizable(false);
        stage.show();
    }

    public void closeStage(Stage stage) {
        stage.close();
    }
}
