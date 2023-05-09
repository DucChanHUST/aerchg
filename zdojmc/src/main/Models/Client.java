package main.Models;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.time.LocalDate;

public class Client {
    private final StringProperty firstName;
    private final StringProperty lastName;
    private final StringProperty payeeAddress;
    private final ObjectProperty<Account> checkingAccount;
    private final ObjectProperty<Account> savingAccount;
    private final ObjectProperty<LocalDate> dateCreated;

    public Client(String firstName, String lastName, String payeeAddress, Account cAccount, Account sAccount, LocalDate date) {
        this.firstName = new SimpleStringProperty(this, "FirstName", firstName);
        this.lastName = new SimpleStringProperty(this, "LastName", lastName);
        this.payeeAddress = new SimpleStringProperty(this, "PayeeAddress", payeeAddress);
        this.checkingAccount = new SimpleObjectProperty<>(this, "CheckingAccount", cAccount);
        this.savingAccount = new SimpleObjectProperty<>(this, "SavingAccount", sAccount);
        this.dateCreated = new SimpleObjectProperty<>(this, "DateCreated", date);
    }

    public StringProperty firstNameProperty() {return firstName;}
    public StringProperty lastNameProperty() {return lastName;}
    public StringProperty payeeAddressProperty() {return payeeAddress;}
    public ObjectProperty<Account> cAccountProperty() {return checkingAccount;}
    public ObjectProperty<Account> sAccountProperty() {return savingAccount;}
    public ObjectProperty<LocalDate> dateCreatedProperty() {return dateCreated;}
}
