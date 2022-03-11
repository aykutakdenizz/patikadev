package Location.Battle;


import Obstacle.Bear;
import Util.Player;

public class River extends BattleLoc {
    public River(Player player) {
        super(player, new Bear(), 2);
        this.setName("River");
        this.setAward("Water");
        this.setId(5);
    }

    public boolean canEnterLocation() {
        return !getPlayer().getInventory().isWater();
    }

    public void addLocationAward() {
        this.getPlayer().getInventory().setWater(true);
    }

    public void getObstacleAward(){
        getPlayer().getGameChar().setMoney(getPlayer().getGameChar().getMoney() + getObstacle().getAward());
        System.out.println("Congrats, you win award +" + getObstacle().getAward());
    }
}
