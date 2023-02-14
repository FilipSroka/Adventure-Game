import javax.swing.*;

public class MediumTank extends Tank {
    
    private int increaseInNumberOfMoves;
    
    public MediumTank(String name, int hitpoints, int maxHitpoints, int minimumDamage, int maximumDamage, int numberOfMoves) {
        super(name, hitpoints, maxHitpoints, minimumDamage, maximumDamage, numberOfMoves);
        if (getName().equals("T-34-85 Rudy")) increaseInNumberOfMoves = 2;
        else if (getName().equals("M4A3E8 Fury")) increaseInNumberOfMoves = 3;
    }
    
    // UPGRADES NUMBER OF MOVES
    public void upgradeNumberOfMoves(Balance balance, JLabel infoLabel) throws NotEnoughMoneyException {
        int price = 200;
        
        if (balance.pay(price)) {
            numberOfMoves += increaseInNumberOfMoves;
            displayPurchaseSuccessful(infoLabel);
        }
        
        else {
            throw new NotEnoughMoneyException();
        }
    }
    
    // RETURNS STRING WITH TANK STATISTICS
    public String printInfo() {
        return "<html>" + super.printInfo() + "<br>Speciality: increases number of moves by " + getIncreaseInNumberOfMoves() + "<html>";
    }
    
    public int getIncreaseInNumberOfMoves() {
        return increaseInNumberOfMoves;
    }
    
    public void setIncreaseInNumberOfMoves(int increaseInNumberOfMoves) {
        this.increaseInNumberOfMoves = increaseInNumberOfMoves;
    }
}
