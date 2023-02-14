import java.io.*;
import java.util.*;

public class Level {
    
    private int level;
    
    // LOADS LEVEL FROM THE LAST GAME
    public Level() {
        try {
            FileReader fr = new FileReader("LevelSave.txt");
            Scanner s = new Scanner(fr);
            
            level = Integer.parseInt(s.nextLine());
        }
        
        catch (IOException e) {
            level = 1;
        }
    }
    
    public Level(int level) {
        this.level = level;
    }
    
    // SAVES LEVEL
    public void save() {
        try {
            FileWriter fw = new FileWriter("LevelSave.txt", false);
            PrintWriter out = new PrintWriter(fw);
            
            out.println(level);
            out.close();
        }
        
        catch (IOException e) {
            System.exit(0);
        }   
    }
    
    public int getLevel() {
        return level;
    }
    
    public void setLevel(int level) {
        this.level = level;
    }
    
}
