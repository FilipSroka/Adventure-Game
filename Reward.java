public class Reward {
    
    private int chance;
    private int prize;
    
    public Reward(int chance, int prize) {
        this.chance = chance;
        this.prize = prize;
        
    }
    
    public int getChance() {
        return chance;
    }
    
    public int getPrize() {
        return prize;
    }
    
    public void setChance(int chance) {
        this.chance = chance;
    }
    
    public void setPrize(int prize) {
        this.prize = prize;
    }
}
