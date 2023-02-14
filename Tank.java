import java.io.*;
import java.util.*;
import javax.swing.*;

public class Tank {
    
    public String type = (this instanceof MediumTank) ? "Medium Tank" : (this instanceof HeavyTank) ? "Heavy Tank" : "Tank Destroyer";
    public String name;
    public int hitpoints;
    public int maximumHitpoints;
    public int minimumDamage;
    public int maximumDamage;
    public int numberOfMoves;
    
    // LOADS TANK FROM THE LAST GAME
    public Tank() {
        try {
            FileReader fr = new FileReader("TankSave.txt");
            Scanner s = new Scanner(fr);
            
            type = s.nextLine();
            name = s.nextLine();
            hitpoints = Integer.parseInt(s.nextLine());
            maximumHitpoints = Integer.parseInt(s.nextLine());
            minimumDamage = Integer.parseInt(s.nextLine());
            maximumDamage = Integer.parseInt(s.nextLine());
            numberOfMoves = Integer.parseInt(s.nextLine());
        }
        
        catch (IOException e) {
            System.exit(0);
        }
    }
    
    public Tank(String name, int hitpoints, int maximumHitpoints, int minimumDamage, int maximumDamage, int numberOfMoves) {
        this.name = name;
        this.hitpoints = hitpoints;
        this.maximumHitpoints = maximumHitpoints;
        this.minimumDamage = minimumDamage;
        this.maximumDamage = maximumDamage;
        this.numberOfMoves = numberOfMoves;
    }
    
    // RETURNS STRING WITH TANK STATISTICS
    public String printInfo() {
        return "<html>Tank: " + getName() + 
               "<br>Hitpoints: " + getHitpoints() +
               "<br>Maximum Hitpoints: " + getMaximumHitpoints() +
               "<br>Minimum Damage: " + getMinimumDamage() + 
               "<br>Maximum Damage: " + getMaximumDamage() +
               "<br>Average Damage: " + (getMinimumDamage() + getMaximumDamage()) / 2 +
               "<br>Number of Moves: " + getNumberOfMoves() + "<html>";
        
    }
    
    // RETURNS RANDOM NUMBER WITHIN TANK DAMAGE RANGE 
    public int shoot() {
        return generateRandomNumber(getMinimumDamage(), getMaximumDamage());
    }
    
    // UPGRADES HISTPOINTS
    public void upgradeHitpoints(Balance balance, JLabel infoLabel) throws NotEnoughMoneyException {
        int price = 200;
        
        if (balance.pay(price)) {
            hitpoints += 100;
            maximumHitpoints += 100;
            displayPurchaseSuccessful(infoLabel);
        }
        
        else {
            throw new NotEnoughMoneyException();
        }
    }
    
    // UPGRADES DAMAGE
    public void upgradeDamage(Balance balance, JLabel infoLabel) throws NotEnoughMoneyException {
        int price = 200;
        
        if (balance.pay(price)) {
            minimumDamage += 10;
            maximumDamage += 10;
            displayPurchaseSuccessful(infoLabel);
        }
        
        else {
            throw new NotEnoughMoneyException();
        }
    }
    
    // UPGRADES NUMBER OF MOVES
    public void upgradeNumberOfMoves(Balance balance, JLabel infoLabel) throws NotEnoughMoneyException {
        int price = 200;
        
        if (balance.pay(price)) {
            numberOfMoves += 1;
            displayPurchaseSuccessful(infoLabel);
        }
        
        else {
            throw new NotEnoughMoneyException();
        }
    }
    
    // CHECHS IF PLAYER'S TANK IS DESTROYED
    public boolean isDestroyed() {
        return hitpoints <= 0;
    }
    
    // REPAIRS THE TANK
    public void repairTank(Balance balance, JLabel infoLabel) throws NotEnoughMoneyException, NothingToRepairException {
        if (getHitpoints() != getMaximumHitpoints()) {
            int price = (1 - getHitpoints() / getMaximumHitpoints()) * 500;
            if (balance.pay(price)) {
                setHitpoints(getMaximumHitpoints());
                infoLabel.setText("Repair successful!");
            }
            
            else {
                throw new NotEnoughMoneyException();
            }
        }
        
        else {
            throw new NothingToRepairException();
        }
    }
    
    // SAVES THE TANK
    public void save() {
        try {
            FileWriter fw = new FileWriter("TankSave.txt", false);
            PrintWriter out = new PrintWriter(fw);
            
            out.println(getType());
            out.println(getName());
            out.println(getHitpoints());
            out.println(getMaximumHitpoints());
            out.println(getMinimumDamage());
            out.println(getMaximumDamage());
            out.println(getNumberOfMoves());
            out.close();
        }
        
        catch (IOException e) {
            System.exit(0);
        }
    }
    
    // GENERATES RANDOM NUMBER BETWEEN LOW AND HIGH INCLUSIVE
    public int generateRandomNumber(int low, int high) {
        Random r = new Random();
        return r.nextInt(high-low+1) + low;
    }
    
    
    // DISPLAYS PUCHASE SUCCESSFUL
    public void displayPurchaseSuccessful(JLabel infoLabel) {
        infoLabel.setText("Purchase successful!");
    }
    
    public String getType() {
        return type;
    }
    
    public String getName() {
        return name;
    }
    
    public int getHitpoints() {
        return hitpoints;
    }
    
    public int getMaximumHitpoints() {
        return maximumHitpoints;
    }
    
    public int getMinimumDamage() {
        return minimumDamage;
    }
    
    public int getMaximumDamage() {
        return maximumDamage;
    }
    
    public int getNumberOfMoves() {
        return numberOfMoves;
    }
    
    public void setType(String type) {
        this.type = type;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public void setHitpoints(int hitpoints) {
        this.hitpoints = hitpoints;
    }
    
    public void setMaximumHitpoints(int maximumHitpoints) {
        this.maximumHitpoints = maximumHitpoints;
    }
    
    public void setMinimumDamage(int minimumDamage) {
        this.minimumDamage = minimumDamage;
    } 
    
    public void setMaximumDamage(int maximumDamage) {
        this.maximumDamage = maximumDamage;
    }
    
    public void setNumberOfMoves(int numberOfMoves) {
        this.numberOfMoves = numberOfMoves;
    }
 }
