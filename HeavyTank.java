import javax.swing.*;

public class HeavyTank extends Tank {
    
    private int increaseInHitpoints;
  
    public HeavyTank(String name, int hitpoints, int maxHitpoints, int minimumDamage, int maximumDamage, int numberOfMoves) {
        super(name, hitpoints, maxHitpoints, minimumDamage, maximumDamage, numberOfMoves);
        if (getName().equals("Tiger I")) increaseInHitpoints = 150;
        else if (getName().equals("T29")) increaseInHitpoints = 105;
    }
    
    // UPGRADES HITPOINTS
    public void upgradeHitpoints(Balance balance, JLabel infoLabel) throws NotEnoughMoneyException {
        int price = 200;
        
        if (balance.pay(price)) {
            hitpoints += increaseInHitpoints;
            maximumHitpoints += increaseInHitpoints;
            displayPurchaseSuccessful(infoLabel);
        }
        
        else {
            throw new NotEnoughMoneyException();
        }
    }
    
    // RETURNS STRING WITH TANK STATISTICS
    public String printInfo() {
        return "<html>" + super.printInfo() + "<br>Speciality: increases hitpoints by " + getIncreaseInHitpoints() + "<html>";
    }
    
    // DISPLAYS PURCHASE SUCCESSFUL
    public void displayPurchaseSuccessful(JLabel infoLabel) {
        infoLabel.setText("Purchase successful!");
    }
    
    public int getIncreaseInHitpoints() {
        return increaseInHitpoints;
    }
    
    public void setIncreaseInHitpoints(int increaseInHitpoints) {
        this.increaseInHitpoints = increaseInHitpoints;
    }
}
