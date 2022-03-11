package Location.Battle;


import Obstacle.Zombie;
import Util.Player;

public class Cave extends BattleLoc {

    public Cave(Player player) {
        super(player, new Zombie(), 3);
        this.setName("Cave");
        this.setAward("Food");
        this.setId(3);
    }

    public boolean canEnterLocation() {
        return !getPlayer().getInventory().isFood();
    }

    public void addLocationAward() {
        this.getPlayer().getInventory().setFood(true);
    }

    public void getObstacleAward(){
        getPlayer().getGameChar().setMoney(getPlayer().getGameChar().getMoney() + getObstacle().getAward());
        System.out.println("Congrats, you win award +" + getObstacle().getAward());
    }
}
