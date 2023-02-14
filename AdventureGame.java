import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;
import javax.swing.*;

public class AdventureGame {
    
    JFrame frame;
    Container container;
    JPanel titlePanel, infoPanel, statsPanel;
    JLabel titleLabel, infoLabel, levelLabel, statsLabel, aceLabel;
    Font titleFont = new Font("Times New Roman", Font.PLAIN, 60);
    JButton button1, button2, button3, button4, button5, button6, button7, button8, button9, button10, button11, button12, button13; 
    
    ArrayList<TankAce> aces = new ArrayList();
    ArrayList<Tank> tanks = new ArrayList();
    int sum;
    int numberOfMovesMade;
    int enemyTankHitpoints;
    
    // LOADS MAIN MENU
    public AdventureGame() {
        frame = new JFrame("Adventure Game");
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setLayout(null);
        container = frame.getContentPane();
        
        titlePanel = new JPanel();
        titlePanel.setBounds(100, 100, 600, 150);
        titleLabel = new JLabel("ADVENTURE GAME");
        titleLabel.setForeground(Color.black);
        titleLabel.setFont(titleFont);
        
        button1 = new JButton("Play");
        button1.setBounds(300, 300, 200, 50);
        button1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                startGame();
            }
        });
        
        button2 = new JButton("Load game");
        button2.setBounds(300, 375, 200, 50);
        button2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                loadGame();
            }
        });
        
        button3 = new JButton("Quit");
        button3.setBounds(300, 450, 200, 50);
        button3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        
        titlePanel.add(titleLabel);
        container.add(titlePanel);
        container.add(button1);
        container.add(button2);
        container.add(button3);
        frame.setVisible(true);
    }
    
    // LOADS GAME MENU
    public void createGameMenu(Balance balance, Tank tank, TankAce ace, Level level, String message) {
        titlePanel.setVisible(false);
        button1.setVisible(false);
        button2.setVisible(false);
        button3.setVisible(false);
        
        infoPanel = new JPanel();
        infoPanel.setBounds(350, 125, 350, 150);
        infoPanel.setBackground(Color.white);
        
        infoLabel = new JLabel(message);
        infoLabel.setBounds(350, 123, 350, 150);
        infoPanel.add(infoLabel);
        
        levelLabel = new JLabel("Level " + level.getLevel());
        levelLabel.setBounds(500, 60, 60, 100);
        
        statsLabel = new JLabel("<html>Balance: $" + balance.getBalance() + "<br>" + tank.printInfo() + "<html>");
        statsLabel.setBounds(350, 275, 350, 150);
        
        aceLabel = new JLabel(ace.printInfo());
        aceLabel.setBounds(500, 227, 350, 150);
        
        button4 = new JButton("Battle!");
        button4.setBounds(100, 60, 200, 50);
        button4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                sum = 0;
                createBattleMenu(balance, tank, ace, level);
            }
        });
        
        button5 = new JButton("Open chest");
        button5.setBounds(100, 110, 200, 50);
        button5.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)  {
                try {
                    ArrayList<Reward> rewards = new ArrayList();
                    rewards.add(new Reward(95, 50)); 
                    rewards.add(new Reward(5, 1000));
                    int amount = 1;
                    Chest chest = new Chest(amount, 100, rewards);
                    openChest(balance, tank, ace, level, chest, infoLabel);
                }
                
                catch (NotEnoughMoneyException ex) {
                    displayNotEnoughMoney();
                }
            }
        });
        
        button6 = new JButton("Repair tank");
        button6.setBounds(100, 160, 200, 50);
        button6.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    repairTank(balance, tank, ace, level);
                }
                
                catch (NotEnoughMoneyException ex) {
                    displayNotEnoughMoney();
                }
                
                catch (NothingToRepairException ex) {
                    displayNothingToRepair();
                }
            }
        });
        
        button7 = new JButton("Upgrade hitpoints");
        button7.setBounds(100, 210, 200, 50);
        button7.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    upgradeTankHitpoints(balance, tank, ace, level);
                }
                
                catch (NotEnoughMoneyException ex) {
                    displayNotEnoughMoney();
                }
            }
        });
        
        button8 = new JButton("Upgrade damage");
        button8.setBounds(100, 260, 200, 50);
        button8.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    upgradeTankDamage(balance, tank, ace, level);
                }
                
                catch (NotEnoughMoneyException ex) {
                    displayNotEnoughMoney();
                }
            }
        });
        
        button9 = new JButton("Upgrade number of moves");
        button9.setBounds(100, 310, 200, 50);
        button9.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e)  {
                try {
                    upgradeTankNumberOfMoves(balance, tank, ace, level);
                }
                
                catch (NotEnoughMoneyException ex) {
                    displayNotEnoughMoney();
                }
            }
        });
        
        button10 = new JButton("Quit");
        button10.setBounds(100, 360, 200, 50);
        button10.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        
        container.add(infoPanel);
        container.add(levelLabel);
        container.add(statsLabel);
        container.add(aceLabel);
        container.add(button4);
        container.add(button5);
        container.add(button6);
        container.add(button7);
        container.add(button8);
        container.add(button9);
        container.add(button10);
    }
    
    // LOADS BATTLE MENU
    public void createBattleMenu(Balance balance, Tank tank, TankAce ace, Level level) {
        
        button4.setVisible(false);
        button5.setVisible(false);
        button6.setVisible(false);
        button7.setVisible(false);
        button8.setVisible(false);
        button9.setVisible(false);
        button10.setVisible(false);
        
        numberOfMovesMade = 0;
        enemyTankHitpoints = level.getLevel() * 100 + 200;
        
        button11 = new JButton("Fire!");
        button11.setBounds(100, 110, 200, 50);
        button11.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                shootEnemyTank(balance, tank, ace, level);
                }
        });
        
        button12 = new JButton("Repair tank");
        button12.setBounds(100, 170, 200, 50);
        button12.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                
                try {
                    repairTankInBattle(balance, tank, ace, level);
                }
                
                catch (NotEnoughMoneyException ex) {
                    displayNotEnoughMoney();
                }
                
                catch (NothingToRepairException ex) {
                    displayNothingToRepair();
                }
            }
        });
        
        button13 = new JButton("Surrender");
        button13.setBounds(100, 230, 200, 50);
        button13.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                surrender(balance, tank, ace, level);
            }
        });
        
        container.add(button11);
        container.add(button12);
        container.add(button13);
    }
    
    // SETS UP BALANCE, TANK AND LEVEL TO INITIAL VALUES
    public void startGame() {
        
        Balance balance = new Balance(2000);
        
        fillArrayListOfAces();
        TankAce ace = aces.get(generateRandomNumber(0, aces.size()-1));
        
        
        fillArrayListOfTanks();
        Tank tank = tanks.get(generateRandomNumber(0, tanks.size()-1));
        
        applyTankAceBonus(tank, ace);
                    
        Level level = new Level(1);
        
        saveGame(balance, tank, ace, level);
        createGameMenu(balance, tank, ace, level, "");
    }
    
    // FILLS THE ARRAY LIST WITH TANK ACES
    public void fillArrayListOfAces() {
        aces.add(new MediumTankAce("Stanisław Maczek"));
        aces.add(new HeavyTankAce("Michael Wittmann"));
        aces.add(new TankDestroyerAce("Edmund Roman Orlik"));   
    }
    
    // FILLS THE ARRAY LIST WITH TANKS
    public void fillArrayListOfTanks() {
        tanks.add(new MediumTank("T-34-85 Rudy", 1100, 1100, 150, 250, 2));
        tanks.add(new MediumTank("M4A3E8 Fury", 980, 980, 120, 200, 3));
        tanks.add(new HeavyTank("Tiger I", 1450, 1450, 165, 275, 1));
        tanks.add(new HeavyTank("T29", 1250, 1250, 233, 388, 1));
        tanks.add(new TankDestroyer("Archer", 1050, 1050, 250, 350, 1));
        tanks.add(new TankDestroyer("Sturer Emil", 1000, 1000, 345, 575, 1)); 
    }
    
    // APPLIES ALL BONUSES
    public void applyTankAceBonus(Tank tank, TankAce ace) {
        applyTankAceBonusToNumberOfMoves(tank, ace);
        applyTankAceBonusToHitpoints(tank, ace);
        applyTankAceBonusToDamage(tank, ace);
    }
    
    // APPLIES BONUS TO NUMBER OF MOVES
    public void applyTankAceBonusToNumberOfMoves(Tank tank, TankAce ace) {
        if (ace.getType().equals("Medium Tank Ace")) {
            tank.setNumberOfMoves((int)(tank.getNumberOfMoves() * ace.getSpecialVariable()));
        }
    }
    
    // APPLIES BONUS TO HITPOINTS
    public void applyTankAceBonusToHitpoints(Tank tank, TankAce ace) {
        if (ace.getType().equals("Heavy Tank Ace")) {
            tank.setHitpoints((int)(tank.getHitpoints() * ace.getSpecialVariable()));
            tank.setMaximumHitpoints((int)(tank.getMaximumHitpoints() * ace.getSpecialVariable()));
        }
    }
    
    // APPLIES BONUS TO DAMAGE
    public void applyTankAceBonusToDamage(Tank tank, TankAce ace) {
        if (ace.getType().equals("Tank Destroyer Ace")) {
            int averageDamage = (tank.getMinimumDamage() + tank.getMaximumDamage()) / 2;
            int bonusDamage = (int)(averageDamage * ace.getSpecialVariable() - averageDamage);
            tank.setMinimumDamage((int)(tank.getMinimumDamage() + bonusDamage));
            tank.setMaximumDamage((int)(tank.getMaximumDamage() + bonusDamage));
        }
    }
    
    // GENERATES RANDOM NUMBER BETWEEN LOW AND HIGH, INCLUSIVE
    public int generateRandomNumber(int low, int high) {
        Random r = new Random();
        return r.nextInt(high-low+1) + low;
    }
    
    // CALLS SAVE METHOD ON OBJECTS TO SAVE THE STATE OF THE GAME
    public void saveGame(Balance balance, Tank tank, TankAce ace, Level level) {
        balance.save();
        tank.save();
        ace.save();
        level.save();
    }
    
    // LOADS THE LAST GAME
    public void loadGame() {
        Balance balance = new Balance();
        
        TankAce ace = new TankAce();
        String type = ace.getType();
        ace = (type.equals("Medium Tank Ace")) ? new MediumTankAce(ace.getName()) :
        (type.equals("Heavy Tank Ace")) ? new HeavyTankAce(ace.getName()) :
        new TankDestroyerAce(ace.getName());
        
        
        Tank tank = new Tank();
        type = tank.getType();
        tank = (type.equals("Medium Tank") ? new MediumTank(tank.getName(), tank.getHitpoints(), tank.getMaximumHitpoints(), tank.getMinimumDamage(), tank.getMaximumDamage(), tank.getNumberOfMoves()) :
        (type.equals("Heavy Tank") ? new HeavyTank(tank.getName(), tank.getHitpoints(), tank.getMaximumHitpoints(), tank.getMinimumDamage(), tank.getMaximumDamage(), tank.getNumberOfMoves()) :
        new TankDestroyer(tank.getName(), tank.getHitpoints(), tank.getMaximumHitpoints(), tank.getMinimumDamage(), tank.getMaximumDamage(), tank.getNumberOfMoves())));
        
        Level level = new Level();
        createGameMenu(balance, tank, ace, level, "");
    }
    
    // OPENS CHEST WITH RANDOM MONEY REWARD
    public void openChest(Balance balance, Tank tank, TankAce ace, Level level, Chest chest, JLabel infoLabel) throws NotEnoughMoneyException {
        chest.openChest(balance, level, infoLabel);
        updateStatsLabel(balance, tank, ace, level);
    }
    
    // REPAIRS THE TANK
    public void repairTank(Balance balance, Tank tank, TankAce ace, Level level) throws NotEnoughMoneyException, NothingToRepairException {
        tank.repairTank(balance, infoLabel);
        updateStatsLabel(balance, tank, ace, level);
    }
    
    // INCREASES THE AMOUNT OF TANK'S HITPOINTS
    public void upgradeTankHitpoints(Balance balance, Tank tank, TankAce ace, Level level) throws NotEnoughMoneyException {
        prepareForHitpointsUpgrade(tank, ace);
        tank.upgradeHitpoints(balance, infoLabel);
        applyTankAceBonusToHitpoints(tank, ace);
        updateStatsLabel(balance, tank, ace, level);
    }
    
    // INCREASES THE AMOUNT OF DAMAGE DEALT BY TANK
    public void upgradeTankDamage(Balance balance, Tank tank, TankAce ace, Level level) throws NotEnoughMoneyException {
        tank.upgradeDamage(balance, infoLabel);
        applyTankAceBonusToDamage(tank, ace);
        updateStatsLabel(balance, tank, ace, level);
    }
    
    // INCREASES THE NUMBER OF MOVES THE PLAYER CAN MAKE EACH TURN
    public void upgradeTankNumberOfMoves(Balance balance, Tank tank, TankAce ace, Level level) throws NotEnoughMoneyException {
        tank.upgradeNumberOfMoves(balance, infoLabel);
        applyTankAceBonusToNumberOfMoves(tank, ace);
        updateStatsLabel(balance, tank, ace, level);
    }
    
    // PREPARES HITPOINTS FOR UPGRADE
    public void prepareForHitpointsUpgrade(Tank tank, TankAce ace) {
        if (ace.getType().equals("Heavy Tank Ace")) {
            tank.setHitpoints((int)(tank.getHitpoints() / ace.getSpecialVariable()));
            tank.setMaximumHitpoints((int)(tank.getMaximumHitpoints() / ace.getSpecialVariable()));
        }
    }
    
    // SHOOTS ENEMY TANK
    public void shootEnemyTank(Balance balance, Tank tank, TankAce ace, Level level) {
        sum += tank.shoot();
        numberOfMovesMade++;
        
        if (numberOfMovesMade == tank.getNumberOfMoves() || sum >= enemyTankHitpoints) {
            determineResultOfAction(balance, tank, ace, level);
        }
        
        else {
            printEnemyTankHitpointsInfo();
        }
    }
    
    // DETERMINES WHAT HAPPENS NEXT AFTER PLAYER'S TURN IS OVER
    public void determineResultOfAction(Balance balance, Tank tank, TankAce ace, Level level) {
        numberOfMovesMade = 0;
        
        if (sum >= enemyTankHitpoints) {
            printBattleWon(balance, tank, ace, level);
        }
                
        else {
            takeShot(balance, tank, ace, level);
        }
                
        if (tank.isDestroyed()) {
            resetGame();
        }
    }
    
    // ADDS MONEY FOR WON BATTLE AND INCREASES LEVEL BY ONE
    public void printBattleWon(Balance balance, Tank tank, TankAce ace, Level level) {
        balance.addMoney(500);
        level.setLevel(level.getLevel() + 1);
        saveGame(balance, tank, ace, level);
        
        infoPanel.setVisible(false);
        levelLabel.setVisible(false);
        statsLabel.setVisible(false);
        aceLabel.setVisible(false);
        
        button11.setVisible(false);
        button12.setVisible(false);
        button13.setVisible(false);
        
        createGameMenu(balance, tank, ace, level, "You won the battle!");
    }
    
    // TAKES AWAY HITPOINTS FROM PLAYER'S TANK
    public void takeShot(Balance balance, Tank tank, TankAce ace, Level level) {
        int randomNumber = generateRandomNumber(0, 10);
        if (randomNumber != 0) {
            int damageTaken = tank.getHitpoints() - (tank.getMaximumHitpoints() + level.getLevel()) * generateRandomNumber(0, 10) / 100;
            tank.setHitpoints(damageTaken);
            infoLabel.setText(printEnemyTankHitpointsInfo() + "<br><br>We got hit!<br><br>We have " + tank.getHitpoints() + " hitpoints left!<html>");
            updateStatsLabel(balance, tank, ace, level);
        }
        
        else {
            infoLabel.setText(printEnemyTankHitpointsInfo() + "<br><br>They didn't penetrate our armor!<html>");
        }
    }
    
    // RESETS THE GAME
    public void resetGame() {
        infoPanel.setVisible(false);
        levelLabel.setVisible(false);
        statsLabel.setVisible(false);
        aceLabel.setVisible(false);
            
        button11.setVisible(false);
        button12.setVisible(false);
        button13.setVisible(false);
        
        startGame();
    }
    
    // DISLAYS INFO ABOUT ENEMY TANK HITPOINTS
    public String printEnemyTankHitpointsInfo() {
           String message = "<html>" + getRandomAttackMessage() + "<br><br>The enemy has " + (enemyTankHitpoints - sum) + " hitpoints left!<html>";
           infoLabel.setText(message);
           return message;
    }
    
    // RETURNS RANDOM MESSAGE ABOUT ATTACK
    public String getRandomAttackMessage() {
        ArrayList<String> message = new ArrayList();
        message.add("Punched right through their armor!");
        message.add("We've hit them hard!");
        message.add("They're hit!");
        message.add("Another one like that should finish them off!");
        message.add("Nice shot!");
        message.add("Enemy is hit.");
        message.add("Enemy armor is damaged.");
        message.add("Penetration.");
        message.add("We've got them.");
        message.add("Critical hit!");
        message.add("We nailed them bad!");
        message.add("Thats gotta hurt!");
        message.add("Looks like that one went right through!");
        return message.get(generateRandomNumber(0, message.size()-1));
    }
    
    // REPAIRS TANK WHILE IN BATTLE
    public void repairTankInBattle(Balance balance, Tank tank, TankAce ace, Level level) throws NotEnoughMoneyException, NothingToRepairException {
        repairTank(balance, tank, ace, level);
        numberOfMovesMade++;
        if (numberOfMovesMade == tank.getNumberOfMoves()) {
            determineResultOfAction(balance, tank, ace, level);
        }
    }
   
    // DESTROYS PLAYER'S TANK
    public void surrender(Balance balance, Tank tank, TankAce ace, Level level) {
        tank.setHitpoints(0);
        determineResultOfAction(balance, tank, ace, level);
    }
    
    // DISPLAYS NOT ENOUGH MONEY
    public void displayNotEnoughMoney() {
        infoLabel.setText("You don't have enough money!");
    }
    
    // DISPLAYS NOTHING TO REPAIR
    public void displayNothingToRepair() {
        infoLabel.setText("There is nothing to repair!");
    }
    
    // UPDATES INFO ABOUT BALANCE, TANK STATISTICS AND SAVES THE GAME
    public void updateStatsLabel(Balance balance, Tank tank, TankAce ace, Level level) {
        statsLabel.setText("<html>Balance: $" + balance.getBalance() + "<br>" + tank.printInfo() + "<html>");
        saveGame(balance, tank, ace, level);
    }
}
