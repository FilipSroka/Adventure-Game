public class TankDestroyerAce extends TankAce {
    
    private double increaseInDamageByAce;

    public TankDestroyerAce(String name) {
       super(name);
       if (name.equals("Edmund Roman Orlik")) increaseInDamageByAce = 1.05;
    }
    
    // RETURNS STRING WITH ACE STATISTICS
    public String printInfo() {
        return super.printInfo() + "<html><br>Bonus: increases damage " + getSpecialVariable() + "<br>&emsp;&emsp;&emsp;&ensp;times<html>";
    }

    public double getSpecialVariable() {
        return increaseInDamageByAce;
    }
    
    public void setSpecialVariable(double increaseInDamageByAce) {
        this.increaseInDamageByAce = increaseInDamageByAce;
    }
}
