import java.io.*;
import java.util.*;

public class TankAce {
    
    public String type = (this instanceof MediumTankAce) ? "Medium Tank Ace" : (this instanceof HeavyTankAce) ? "Heavy Tank Ace" : "Tank Destroyer Ace";
    public String name;
    
    // LOADS TANK ACE FROM LAST GAME
    public TankAce() {
        try {
            FileReader fr = new FileReader("AceSave.txt");
            Scanner s = new Scanner(fr);
            
            type = s.nextLine();
            name = s.nextLine();
        }
        
        catch (IOException e) {
            System.exit(0);
        }
    }
    
    public TankAce(String name) {
        this.name = name;
    }
    
    // RETURNS STRING WITH ACE STATISTICS
    public String printInfo() {
        return "<html>Ace: " + getName() + "<html>";
    }
    
    // SAVES THE ACE
    public void save() {
        try {
            FileWriter fw = new FileWriter("AceSave.txt", false);
            PrintWriter out = new PrintWriter(fw);
            
            out.println(getType());
            out.println(getName());
            out.close();
        }
        
        catch (IOException e) {
            System.exit(0);
        }
    }
    
    public String getType() {
        return type;
    }
    
    public String getName() {
        return name;
    }
    
    public void setType(String type) {
        this.type = type;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public double getSpecialVariable() {
        return 0;
    }
    
    public void setSpecialVariable(double special) {
        double d = special;
    }
}
