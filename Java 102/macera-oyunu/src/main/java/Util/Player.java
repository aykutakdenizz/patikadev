package Util;

import Character.*;
import Location.*;
import Location.Normal.SafeHouse;
import Location.Normal.Toolstore;

import java.util.Scanner;

public class Player {
    private GameChar gameChar;
    private String name;
    private Scanner scanner;
    private Inventory inventory;
    private int damage;
    private int health;

    public Player(String name) {
        this.scanner = new Scanner(System.in);
        this.name = name;
        this.inventory = new Inventory();
    }

    public GameChar getGameChar() {
        return gameChar;
    }

    public void setGameChar(GameChar gameChar) {
        this.gameChar = gameChar;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public int getDamage() {
        return (this.gameChar != null ? this.gameChar.getDamage() : 0) + this.inventory.getWeapon().getDamage();
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void selectChar() {
        GameChar[] charList = {new Samurai(), new Archer(), new Knight()};

        //Game characters describe itself
        for (GameChar gameChar : charList) {
            gameChar.describe();
        }
        //User input for select character
        System.out.println("*Please select your character: \n1 (Samurai)\n2 (Archer)\n3 (Knight) ");
        int selectChar = scanner.nextInt();

        //Check for out of list index and fix it
        if (selectChar > 3 || selectChar < 1) {
            selectChar = 1;
        }

        //Assign gameChar
        this.gameChar = charList[selectChar - 1];
        System.out.println("Selected Game Character: ");
        this.setHealth(gameChar.getHealth());
        this.gameChar.describe();
    }

    public void describe() {
        System.out.println("\n\n----- ----- Player Info ----- -----");
        System.out.println(String.format("Weapon: %s, Armor: %s, Block: %s, Damage: %s, Health: %s, Money: %s", inventory.getWeapon().getName(),
                inventory.getArmor().getName(), inventory.getArmor().getBlock(), gameChar.getDamage(), getHealth(), gameChar.getMoney()));
        System.out.println("----- ---- ----- ------ ----- -----");
    }

}
