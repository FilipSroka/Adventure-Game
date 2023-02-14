public class MediumTankAce extends TankAce {
    
    private double increaseInNumberOfMovesByAce;
    
    public MediumTankAce(String name) {
        super(name);
        if (name.equals("Stanisław Maczek")) increaseInNumberOfMovesByAce = 1.1;
    }
    
    // RETURNS STRING WITH ACE STATISTICS
    public String printInfo() {
        return super.printInfo() + "<html><br>Bonus: increases number of<br>&emsp;&emsp;&emsp;&ensp;moves " + getSpecialVariable() + " times<html>";
    }
    
    public double getSpecialVariable() {
        return increaseInNumberOfMovesByAce;
    }
    
    public void setSpecialVariable(double increaseInNumberOfMovesByAce) {
        this.increaseInNumberOfMovesByAce = increaseInNumberOfMovesByAce;
    }
}
