package main.Controllers.Client;

import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.shape.SVGPath;
import main.Models.Transaction;

import java.net.URL;
import java.util.ResourceBundle;

public class TransactionCellController implements Initializable {
    public SVGPath left_icon;
    public SVGPath right_icon;
    public Label trans_date_lbl;
    public Label sender_lbl;
    public Label receiver_lbl;
    public Label amount_lbl;

    private final Transaction transaction;

    public TransactionCellController(Transaction transaction){
        this.transaction = transaction;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
