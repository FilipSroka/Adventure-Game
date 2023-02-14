Student name: Filip Sroka
Student number: 190076421
Skype login: live:.cid.81ed2296858070aa

LEVEL YOU WISH THE MINI-PROJECT TO BE MARKED FOR: 3 [Delete as appropriate]

Now complete the statements below for each level you wish to be marked. Replace all text in square brackets.

LEVEL ONE

My code demonstrates inheritance in the following way...

I have a superclass called [Tank]

This superclass is extended into at least three subclasses called [MediumTank, HeavyTank, TankDestroyer]

For each of the named subclasses complete the following...

Subclass 1.

Subclass [MediumTank] extends the superclass by adding at least one property and its getters and setters. The name(s) of the added properties are [increaseInNumberOfMoves]

These/this new properties/property are used by the subclass in the following way: [It increases the number of moves by a specified number rather than by 1 as other tanks do. Line: 18. It also creates a String that informs that it is tank's speciality. Line: 29]

Subclass [MediumTank] extends the superclass by overriding the following methods (there must be at least one): [upgradeNumberOfMoves() Lines: 14-25 and printInfo() Lines: 28-30]

These overridden methods are used in the working code in the following places: [upgradeNumberOfMoves is used in File: AdventureGame.java Line: 389 and printInfo() is used in File: AdventureGame.java Line: 87 and 533]

Subclass 2.

Subclass [HeavyTank] extends the superclass by adding at least one property and its getters and setters. The name(s) of the added properties are [increaseInHitpoints]

These/this new properties/property are used by the subclass in the following way: [It increases the number of hit points by a specified number rather than by 100 as other tanks do. Lines: 18-19 It also creates a String that informs that it is tank's speciality. Line: 30]

Subclass [HeavyTank] extends the superclass by overriding the following methods (there must be at least one): [upgradeHitpoints() Lines: 14-26 and printInfo() Lines: 29-31]

These overridden methods are used in the working code in the following places: [upgradeHitpoints() is used in File: AdventureGame.java Line: 375 and printInfo() is used in File: AdventureGame.java Line: 87 and 533]

Subclass 3.

Subclass [TankDestroyer] extends the superclass by adding at least one property and its getters and setters. The name(s) of the added properties are [increaseInDamage]

These/this new properties/property are used by the subclass in the following way: [It increases the damage by a specified number rather than by 10. Lines: 18-19. It also creates a String that informs that it is tank's speciality. Line: 30]

Subclass [TankDestroyer] extends the superclass by overriding the following methods (there must be at least one): [upgradeDamage() Lines: 14-26 and printInfo() Lines: 29-31]

These overridden methods are used in the working code in the following places: [upgradeDamage() is used in File: AdventureGame.java Line: 382 and printInfo() is used in File: AdventureGame.java Line: 87 and 533]

[If you have more than three subclasses you want to tell us about, copy and paste the above text for as many subclasses as you want.]

LEVEL TWO

[Polymorphism gets implemented as both the substitution principle and late dynamic binding. Substitution principle allows creating an object of superclass type which uses constructor and methods of its subclass. Late dynamic binding gets resolved at run time, and it determines which method is going to get executed base on the reference.]

[File: AdventureGame.java Lines: 87, 262, 266, 278-280, 285-290, 303, 310-311, 319, 345-347, 352-354, 375, 382, 389, 533]

[It reduces the amount of code I have to write. Without the polymorphism, my code would be about three times longer as I would have to write separate methods for each type MediumTank, HeavyTank and TankDestroyer. It would be longer because I wouldn't be able to use the same method on all of them since they have different types.]

LEVEL THREE

[Some buttons load a new menu. Other change the tank statistics. Other open chests with money rewards. Other attack the enemy tank. File name: AdventureGame.java Lines: 39-43, 47-51, 55-59, 95-100, 104-119, 123-137, 141-151, 155-165, 169-179, 183-187, 218-222, 226-241, 245-249]

[File: AdventureGame.java Lines: 105-118, 124-136, 142-150, 156-164, 170-178 File: Tank.java Lines: 16-33 File: TankAce.java Lines: 10-22 File: Balance.java Lines: 9-20 File: Level.java Lines: 9-20]

[File: AdventureGame.java Lines: 16-17, 107-109, 111, 262, 266, 278-280, 285-290 File: Chest.java Lines: 8, 10, 13, 16-38]

[In AdventureGame.java file, I have saveGame() method. This method calls the save method on each object that needs to get saved from their class. Each object gets saved to a separate text file.]

ANYTHING ELSE

[Run code from Main.java]
