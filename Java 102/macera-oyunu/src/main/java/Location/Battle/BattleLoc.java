package Location.Battle;

import Location.Location;
import Obstacle.Obstacle;
import Character.GameChar;
import Util.Player;

import java.util.Random;

public abstract class BattleLoc extends Location {
    private Obstacle obstacle;
    private String award;
    private int maxObstacle;

    public BattleLoc(Player player, Obstacle obstacle, int maxObstacle) {
        super(player);
        this.obstacle = obstacle;
        this.maxObstacle = maxObstacle;
    }

    public String getAward() {
        return award;
    }

    public void setAward(String award) {
        this.award = award;
    }

    public Obstacle getObstacle() {
        return obstacle;
    }

    public void setObstacle(Obstacle obstacle) {
        this.obstacle = obstacle;
    }

    public abstract boolean canEnterLocation();

    public abstract void addLocationAward();

    public abstract void getObstacleAward();

    public boolean onLocation() {
        if (this.canEnterLocation()) {
            int obstacleNumber = this.randomObstacleNumber();

            System.out.println("Now, you are at " + getName());
            System.out.println("There lives " + obstacleNumber + " " + this.obstacle.getName() + " in here!");

            //Describe player and obstacle, or run
            this.printDescription();

            boolean isAlive = true;

            int userChoice = scanner.nextInt();
            //User choice
            switch (userChoice) {
                case (1):
                    boolean combatResult = this.combat(obstacleNumber);
                    if (combatResult) {
                        //Obstacle or player is death. Checking which one is death
                        if (getPlayer().getHealth() <= 0) {
                            System.out.println("You are dead!");
                            isAlive = false;
                        } else if (getObstacle().getHealth() == 0) {
                            System.out.println("---- Victory ----");
                            this.addLocationAward();
                            isAlive = true;
                        } else {
                            //Player run
                            System.out.println("You run!");
                            isAlive = true;
                        }
                    }
                    break;
                default:
                    break;

            }
            return isAlive;
        } else {
            System.out.println("\n\n ! You have already finish " + this.getName() + ". You can not enter here !");
            return true;
        }
    }

    private int randomObstacleNumber() {
        return new Random().nextInt(this.maxObstacle) + 1;
    }

    public boolean combat(int obsNumber) {
        boolean isDeathOrRun = false;
        boolean isObstacleDeath = false;
        for (int i = 0; i < obsNumber; i++) {
            //Restore obstacle's health
            getObstacle().setHealth(getObstacle().getDefaultHealth());

            //Print Status
            playerStats();
            obstacleStats(i + 1, obsNumber);

            //Battle
            isObstacleDeath = false;
            while (!isDeathOrRun && !isObstacleDeath) {
                this.printPlayerOptions();
                int playerChoice = scanner.nextInt();

                if (playerChoice == 1) {
                    hit();
                    printHealths();
                } else {
                    isDeathOrRun = true;
                }
                isDeathOrRun = isDeathOrRun || (getPlayer().getHealth() <= 0);

                if (obstacle.getHealth() <= 0) {
                    isObstacleDeath = true;
                }
            }
        }

        return isDeathOrRun;
    }

    private void hit() {
        int chance = new Random().nextInt(2);
        if (chance == 0) {
            //Player first
            playerHit();
            obstacleHit();
        } else {
            //obstacle first
            obstacleHit();
            playerHit();
        }

        if (obstacle.getHealth() <= 0 && getPlayer().getHealth() > 0) {
            //Win obstacle award
            this.getObstacleAward();
        }
    }

    private void playerHit() {
        if (getPlayer().getHealth() > 0) {
            System.out.println("You hit to " + getObstacle().getName());
            getObstacle().setHealth(getObstacle().getHealth() - getPlayer().getDamage());

        }
    }

    private void obstacleHit() {
        if (getObstacle().getHealth() > 0) {
            System.out.println(getObstacle().getName() + " hit to you");
            int obstacleDamage = getObstacle().getDamage() - getPlayer().getInventory().getArmor().getBlock();

            //If player armor can not block, calculate player health
            if (obstacleDamage > 0) {
                getPlayer().setHealth(getPlayer().getHealth() - obstacleDamage);
            }
        }
    }

    private void printPlayerOptions() {
        System.out.println();
        System.out.println("Combat or run!");
        System.out.println("1- Combat");
        System.out.println("2- Run");
        System.out.println("*Please select your action:");
    }

    private void printDescription() {
        System.out.println();
        System.out.println("1- Combat Details");
        System.out.println("2- Exit");
        System.out.println("*Please select your action:");
    }

    public void playerStats() {
        System.out.println();
        System.out.println("Player Status");
        System.out.println("Health: " + getPlayer().getHealth());
        System.out.println("Damage: " + getPlayer().getDamage());
        System.out.println("Weapon:  " + getPlayer().getInventory().getWeapon().getName());
        System.out.println("Armor: " + getPlayer().getInventory().getArmor() + " (block:" + getPlayer().getInventory().getArmor().getBlock() + ")");
        System.out.println("Money: " + getPlayer().getGameChar().getMoney());
    }

    public void obstacleStats(int order, int obstacleNumber) {
        System.out.println();
        System.out.println(order + "/" + obstacleNumber + " " + this.getObstacle().getName() + " Status");
        System.out.println("Health: " + getObstacle().getHealth());
        System.out.println("Damage: " + getObstacle().getDamage());
        System.out.println("Award: " + getObstacle().getAward());
    }

    private void printHealths() {
        System.out.println();
        System.out.println("Your Health: " + getPlayer().getHealth());
        System.out.println(getObstacle().getName() + "'s Health: " + getObstacle().getHealth());
    }


}
