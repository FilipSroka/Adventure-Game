import java.io.*;
import java.util.*;

public class Balance {

    private int balance;
    
    // LOADS BALANCE FROM THE LAST GAME
    public Balance() {
        try {
            FileReader fr = new FileReader("BalanceSave.txt");
            Scanner s = new Scanner(fr);
            
            balance = Integer.parseInt(s.nextLine());
        }
        
        catch (IOException e) {
            balance = 2000;
        }
    }
    
    public Balance(int balance) {
        this.balance = balance;
    }
    
    // SAVES BALANCE
    public void save() {
        try {
            FileWriter fw = new FileWriter("BalanceSave.txt", false);
            PrintWriter out = new PrintWriter(fw);
            
            out.println(getBalance());
            out.close();
        }
        
        catch (IOException e) {
            System.exit(0);
        } 
    }
    
    // CHECKS IF THERE IS ENOUGH MONEY TO PAY AND IF THERE IS IT DEDUCTS THE PRICE FROM BALANCE
    public boolean pay(int price) {
        if (balance >= price) {
            balance -= price;
            return true;
        }
        
        else {
            return false;
        }
    }
    
    // ADDS MONEY TO THE BALANCE
    public void addMoney(int amount) {
        balance += amount;
    }
    
    public int getBalance() {
        return balance;
    }
    
    public void setBalance(int balance) {
        this.balance = balance;
    }
}
