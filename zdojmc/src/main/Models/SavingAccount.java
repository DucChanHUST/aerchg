package main.Models;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;

public class SavingAccount extends Account{
    private final DoubleProperty withdrawLimit;

    public SavingAccount(String owner, String accountNumber, double balance, double withdrawLimit) {
        super(owner, accountNumber, balance);
        this.withdrawLimit = new SimpleDoubleProperty(this, "WithdrawLimit", withdrawLimit);
    }

    public DoubleProperty withdrawLimitProperty() {return withdrawLimit;}
}
