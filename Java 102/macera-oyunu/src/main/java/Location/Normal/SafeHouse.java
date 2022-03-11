package Location.Normal;

import Util.Inventory;
import Util.Player;

public class SafeHouse extends NormalLoc {

    public SafeHouse(Player player) {
        super(player);
        this.setName("Safe House");
        this.setId(1);
    }

    @Override
    public boolean onLocation(){
        System.out.println("You are at safe house.");
        System.out.println("You are health restore...");
        getPlayer().setHealth(getPlayer().getGameChar().getHealth());
        return true;
    }

    public boolean isPlayerWon(){
        Inventory inventory = this.getPlayer().getInventory();
        return inventory.isFirewood() && inventory.isWater() && inventory.isFood();
    }

}
