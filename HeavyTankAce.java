public class HeavyTankAce extends TankAce {
    
    private double increaseInHitpointsByAce;
    
    public HeavyTankAce(String name) {
        super(name);
        if (name.equals("Michael Wittmann")) increaseInHitpointsByAce = 1.05;
    }
    
    // RETURNS STRING WITH ACE STATISTICS
    public String printInfo() {
        return super.printInfo() + "<html><br>Bonus: increases hitpoints " + getSpecialVariable() + "<br>&emsp;&emsp;&emsp;&ensp;times<html>";
    }
    
    public double getSpecialVariable() {
        return increaseInHitpointsByAce;
    }
    
    public void setSpecialVariable(double increaseInNumberOfMovesByAce) {
        this.increaseInHitpointsByAce = increaseInHitpointsByAce;
    }
}
