package Location.Battle;

import Obstacle.*;
import Util.Player;
import Weapons.*;
import Armors.*;

import java.util.Random;

public class Mine extends BattleLoc {

    public Mine(Player player) {
        super(player, new Snake(), 5);
        this.setName("Mine");
        this.setId(6);
    }

    public boolean canEnterLocation() {
        return true;
    }

    public void addLocationAward() {

    }

    public void getObstacleAward() {
        int chance = new Random().nextInt(100) + 1;

        if (chance <= 15) {
            wonWeapon();
        } else if (chance <= 30) {
            wonArmor();
        } else if (chance <= 55) {
            wonMoney();
        } else {
            System.out.println("You can not win award :(");
        }

    }

    private void wonMoney() {
        int chance = new Random().nextInt(100) + 1;
        int playerMoney = getPlayer().getGameChar().getMoney();
        if (chance <= 20) {
            getPlayer().getGameChar().setMoney(playerMoney + 10);
            System.out.println("You won +10 money");
        } else if (chance <= 50) {
            getPlayer().getGameChar().setMoney(playerMoney + 5);
            System.out.println("You won +5 money");
        } else {
            getPlayer().getGameChar().setMoney(playerMoney + 1);
            System.out.println("You won +1 money");
        }
    }

    private void wonArmor() {
        int chance = new Random().nextInt(100) + 1;

        if (chance <= 20) {
            Armor newArmor = Armor.getArmorById(3);
            if (askPlayerArmor(newArmor)) {
                this.getPlayer().getInventory().setArmor(newArmor);
                System.out.println("Your new armor: " + newArmor.toString());
            }
        } else if (chance <= 50) {
            Armor newArmor = Armor.getArmorById(2);
            if (askPlayerArmor(newArmor)) {
                this.getPlayer().getInventory().setArmor(newArmor);
                System.out.println("Your new armor: " + newArmor.toString());
            }
        } else {
            Armor newArmor = Armor.getArmorById(1);
            if (askPlayerArmor(newArmor)) {
                this.getPlayer().getInventory().setArmor(newArmor);
                System.out.println("Your new armor: " + newArmor.toString());
            }
        }
    }

    private void wonWeapon() {
        int chance = new Random().nextInt(100) + 1;

        if (chance <= 20) {
            Weapon newWeapon = Weapon.getWeaponById(3);
            if (askPlayerWeapon(newWeapon)) {
                this.getPlayer().getInventory().setWeapon(newWeapon);
                System.out.println("Your new weapon: " + newWeapon.toString());
            }
        } else if (chance <= 50) {
            Weapon newWeapon = Weapon.getWeaponById(2);
            if (askPlayerWeapon(newWeapon)) {
                this.getPlayer().getInventory().setWeapon(newWeapon);
                System.out.println("Your new weapon: " + newWeapon.toString());
            }
        } else {
            Weapon newWeapon = Weapon.getWeaponById(1);
            if (askPlayerWeapon(newWeapon)) {
                this.getPlayer().getInventory().setWeapon(newWeapon);
                System.out.println("Your new weapon: " + newWeapon.toString());
            }
        }
    }

    private boolean askPlayerWeapon(Weapon newWeapon) {
        System.out.println("You won: " + newWeapon.toString());
        System.out.println("Your old weapon: " + getPlayer().getInventory().getWeapon().toString());
        System.out.println("*Do you want to change ?\n1- Yes\n2- No");
        int choice = scanner.nextInt();
        return (choice == 1);
    }

    private boolean askPlayerArmor(Armor newArmor) {
        System.out.println("You won: " + newArmor.toString());
        System.out.println("Your old armor: " + getPlayer().getInventory().getArmor().toString());
        System.out.println("*Do you want to change ?\n1- Yes\n2- No");
        int choice = scanner.nextInt();
        return (choice == 1);
    }
}
