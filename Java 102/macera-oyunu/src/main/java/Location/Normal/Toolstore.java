package Location.Normal;


import Armors.Armor;
import Util.Player;
import Weapons.Weapon;
import Character.GameChar;

public class Toolstore extends NormalLoc {


    public Toolstore(Player player) {
        super(player);
        this.setName("Store");
        this.setId(2);
    }

    @Override
    public boolean onLocation() {
        boolean exit = false;
        while(!exit){
            //Action list prints
            System.out.println("You are at store.");
            System.out.println("1- Weapons");
            System.out.println("2- Armours");
            System.out.println("3- Exit");
            System.out.println("*Please enter your choice:");

            //User action choice
            int selection = scanner.nextInt();
            while (selection < 1 || selection > 3){
                System.out.println("*Please enter a valid choice:");
                selection = scanner.nextInt();
            }

            switch (selection){
                case 1:
                    //Buy a weapon
                    printWeapon();
                    buyWeapon();
                    break;
                case 2:
                    // Buy a armor
                    printArmor();
                    buyArmor();
                    break;
                case 3:
                    //Exit Store
                    System.out.println("Exit Store...");
                    exit = true;
                    break;
            }
        }
        return true;
    }

    private void printWeapon(){
        System.out.println(" ----- Weapons -----");
        for (Weapon weapon: Weapon.weapons()) {
            System.out.println(weapon.toString());
        }
    }

    private void buyWeapon(){
        System.out.println("\n*Please select a weapon: ");
        int selection = scanner.nextInt();
        Weapon selectedWeapon = Weapon.getWeaponById(selection);

        //Check if exist weapon
        if(selectedWeapon != null){
            if(selectedWeapon.getPrice() > this.getPlayer().getGameChar().getMoney()){
                //Can not afford to weapon
                System.out.println("You do not have enough money to buy "+ selectedWeapon.getName());
            } else {
                //Can afford to weapon
                GameChar gameChar = this.getPlayer().getGameChar();

                //Set player money
                System.out.println("You bought "+ selectedWeapon.getName());
                gameChar.setMoney(gameChar.getMoney() - selectedWeapon.getPrice());
                System.out.println("Your money: " + gameChar.getMoney());

                //Set weapon
                this.getPlayer().getInventory().setWeapon(selectedWeapon);
            }
        } else {
            System.out.println("Exit Store...");
        }
    }

    private void printArmor(){
        System.out.println(" ----- Armors -----");
        for (Armor armor: Armor.armors()) {
            System.out.println(armor.toString());
        }
    }

    private void buyArmor(){
        System.out.println("\n*Please select a armor: ");
        int selection = scanner.nextInt();
        Armor selectedArmor = Armor.getArmorById(selection);

        //Check if exist armor
        if(selectedArmor != null){
            if(selectedArmor.getPrice() > this.getPlayer().getGameChar().getMoney()){
                //Can not afford to weapon
                System.out.println("You do not have enough money to buy "+ selectedArmor.getName());
            } else {
                //Can afford to armor
                GameChar gameChar = this.getPlayer().getGameChar();

                //Set player money
                System.out.println("You bought "+ selectedArmor.getName());
                gameChar.setMoney(gameChar.getMoney() - selectedArmor.getPrice());
                System.out.println("Your money: " + gameChar.getMoney());

                //Set armor
                this.getPlayer().getInventory().setArmor(selectedArmor);
            }
        } else {
            System.out.println("Exit Store...");
        }
    }

    public void menu() {

    }

    public void buy() {

    }
}
