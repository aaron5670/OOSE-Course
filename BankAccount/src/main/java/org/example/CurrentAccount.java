package oose.ooad;

import java.util.Currency;

public class CurrentAccount extends Account{
    private double creditLimit;
    public CurrentAccount(Bank b, String cust, double creditLimit){

    }
    public double getCreditLimit(){
    return 0;
    }
    public void setCreditLimit(double creditLimit){

    }

    @Override
    public void withdraw(double amount) {
        super.withdraw(amount);
    }
}
