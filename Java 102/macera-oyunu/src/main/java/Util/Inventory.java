package Util;

import Armors.Armor;
import Weapons.Weapon;

public class Inventory {
    private boolean water;
    private boolean food;
    private boolean firewood;
    private Armor armor;
    private Weapon weapon;

    public Inventory() {
        this.weapon = new Weapon(0, "Punch", 0, 0);
        this.armor = new Armor(0, "None", 0,0);
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public Armor getArmor() {
        return armor;
    }

    public void setArmor(Armor armor) {
        this.armor = armor;
    }

    public boolean isWater() {
        return water;
    }

    public void setWater(boolean water) {
        this.water = water;
    }

    public boolean isFood() {
        return food;
    }

    public void setFood(boolean food) {
        this.food = food;
    }

    public boolean isFirewood() {
        return firewood;
    }

    public void setFirewood(boolean firewood) {
        this.firewood = firewood;
    }
}
