package book;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class MainController implements Initializable {
    @FXML
    private Button btnDelete;

    @FXML
    private Button btnInsert;

    @FXML
    private Button btnUpdate;

    @FXML
    private TextField tfAuthor;

    @FXML
    private TextField tfID;

    @FXML
    private TextField tfPages;

    @FXML
    private TextField tfTitle;

    @FXML
    private TextField tfYear;

    @FXML
    private TableColumn<Books, String> tvAuthor;

    @FXML
    private TableView<Books> tvBook;

    @FXML
    private TableColumn<Books, Integer> tvID;

    @FXML
    private TableColumn<Books, Integer> tvPages;

    @FXML
    private TableColumn<Books, String> tvTitle;

    @FXML
    private TableColumn<Books, Integer> tvYear;

    @FXML
    private void handleButtonAction(ActionEvent event) {

        if(event.getSource() == btnInsert){
            insertRecord();
        }else if (event.getSource() == btnUpdate){
            updateRecord();
        }else if(event.getSource() == btnDelete){
            deleteButton();
        }

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        showBooks();
    }

    public Connection getConnection() {
        Connection conn;
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/library", "root", "");
            return conn;
        } catch (Exception ex) {
            System.out.println("Error: " + ex.getMessage());
            return null;
        }
    }

    public ObservableList<Books> getBooksList() {
        ObservableList<Books> bookList = FXCollections.observableArrayList();
        Connection conn = getConnection();
        String query = "select * from books";
        Statement st;
        ResultSet rs;

        try {
            st = conn.createStatement();
            rs = st.executeQuery(query);
            Books books;
            while(rs.next()) {
                books = new Books(rs.getInt("id"),
                                  rs.getString("title"),
                                  rs.getString("author"),
                                  rs.getInt("year"),
                                  rs.getInt("pages"));
                bookList.add(books);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return bookList;
    }

    public void showBooks() {
        ObservableList<Books> list = getBooksList();

        tvID.setCellValueFactory(new PropertyValueFactory<Books, Integer>("id"));
        tvTitle.setCellValueFactory(new PropertyValueFactory<Books, String>("title"));
        tvAuthor.setCellValueFactory(new PropertyValueFactory<Books, String>("author"));
        tvYear.setCellValueFactory(new PropertyValueFactory<Books, Integer>("year"));
        tvPages.setCellValueFactory(new PropertyValueFactory<Books, Integer>("pages"));

        tvBook.setItems(list);
    }

    private void insertRecord(){
        String query = "INSERT INTO books VALUES (" + tfID.getText() + ",'" + tfTitle.getText() + "','" + tfAuthor.getText() + "',"
                + tfYear.getText() + "," + tfPages.getText() + ")";
        executeQuery(query);
        showBooks();
    }
    private void updateRecord(){
        String query = "UPDATE  books SET title  = '" + tfTitle.getText() + "', author = '" + tfAuthor.getText() + "', year = " +
                tfYear.getText() + ", pages = " + tfPages.getText() + " WHERE id = " + tfID.getText() + "";
        executeQuery(query);
        showBooks();
    }
    private void deleteButton(){
        String query = "DELETE FROM books WHERE id =" + tfID.getText() + "";
        executeQuery(query);
        showBooks();
    }
    private void executeQuery(String query) {
        Connection conn = getConnection();
        Statement st;
        try {
            st = conn.createStatement();
            st.executeUpdate(query);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}
