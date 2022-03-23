package model;


public class Customer {
    private String firstName;
    private String lastName;
    private int id;
    private double balance, balanceNoSign;


    public int getId() {
        return id;
    }

    public String getFirstName() {
        return (firstName);
    }

    public String getLastName() {
        return (lastName);
    }

    public double getBalance() {
        return (balance);
    }

    public double getBalanceNoSign() {
        return ((balance < 0) ? -balance : balance);
    }


    public void setId(int id) {
        this.id = id;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
}
  
