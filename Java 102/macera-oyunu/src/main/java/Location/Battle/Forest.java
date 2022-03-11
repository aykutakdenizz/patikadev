package Location.Battle;

import Obstacle.Vampire;
import Util.Player;

public class Forest extends BattleLoc {

    public Forest(Player player){
        super(player, new Vampire(), 3);
        this.setName("Forest");
        this.setAward("Firewood");
        this.setId(4);
    }

    public boolean canEnterLocation() {
        return !getPlayer().getInventory().isFirewood();
    }

    public void addLocationAward() {
        this.getPlayer().getInventory().setFirewood(true);
    }

    public void getObstacleAward(){
        getPlayer().getGameChar().setMoney(getPlayer().getGameChar().getMoney() + getObstacle().getAward());
        System.out.println("Congrats, you win award +" + getObstacle().getAward());
    }
}
