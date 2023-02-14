import java.util.*;
import javax.swing.*;

public class Chest {
    
    private int amount;
    private int price;
    private ArrayList<Reward> rewards;
    
    public Chest(int amount, int price, ArrayList<Reward> rewards) {
        this.amount = amount;
        this.price = price;
        this.rewards = rewards;
    }

    public void openChest(Balance balance, Level level, JLabel infoLabel) throws NotEnoughMoneyException {
        int price = getAmount() * getPrice();
        if (balance.pay(price)) {
            int total = 0;
            ArrayList<Integer> prizes = new ArrayList<>(100);     
        
            for(int i = 0; i < getAmount(); i++) {
                for(int j = 0; j < rewards.size(); j++) {
                    for(int z = 0; z < rewards.get(j).getChance(); z++) {
                        prizes.add(rewards.get(j).getPrize());    
                    }
                }
                int won = prizes.get(generateRandomNumber(0, 99));
                total += won;
                balance.addMoney(won);
                infoLabel.setText("You won $" + won + "!");
            }
        }
        
        else {
            throw new NotEnoughMoneyException();
        }
    }
    
    // GEMERATES RANDOM NUMBER BETWEEN LOW AND HIGH INCLUSIVE
    public int generateRandomNumber(int low, int high) {
        Random r = new Random();
        return r.nextInt(high-low+1) + low;
    }
    
    public int getAmount() {
        return amount;
    }
    
    public int getPrice() {
        return price;
    }
    
    public void setAmount(int amount) {
        this.amount = amount;
    }
    
    public void setPrice(int price) {
        this.price = price;
    }
}
