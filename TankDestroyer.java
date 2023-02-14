import javax.swing.*;

public class TankDestroyer extends Tank {
    
    private int increaseInDamage;

    public TankDestroyer(String name, int hitpoints, int maxHitpoints, int minimumDamage, int maximumDamage, int numberOfMoves) {
        super(name, hitpoints, maxHitpoints, minimumDamage, maximumDamage, numberOfMoves);
        if (getName().equals("Archer")) increaseInDamage = 15;
        else if (getName().equals("Sturer Emil")) increaseInDamage = 11;
    }
    
    // UPGRADES DAMAGE
    public void upgradeDamage(Balance balance, JLabel infoLabel) throws NotEnoughMoneyException {
        int price = 200;
        
        if (balance.pay(price)) {
            minimumDamage += increaseInDamage;
            maximumDamage += increaseInDamage;
            displayPurchaseSuccessful(infoLabel);
        }
        
        else {
            throw new NotEnoughMoneyException();
        }
    }
    
    // RETURNS STRING WITH TANK STATISTICS
    public String printInfo() {
        return "<html>" + super.printInfo() + "<br>Speciality: increases damage by " + getIncreaseInDamage() + "<html>";
    }
    
    // DISPLAYS PURCHASE SUCCESSFUL
    public void displayPurchaseSuccessful(JLabel infoLabel) {
        infoLabel.setText("Purchase successful!");
    }
    
    public int getIncreaseInDamage() {
        return increaseInDamage;
    }
    
    public void setIncreaseInDamage(int increaseInDamage) {
        this.increaseInDamage = increaseInDamage;
    }
}
