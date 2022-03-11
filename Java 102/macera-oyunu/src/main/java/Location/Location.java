package Location;

import Util.Player;

import java.util.Scanner;

public abstract class Location {
    private int id;
    private Player player;
    private String name;
    public static Scanner scanner = new Scanner(System.in);

    public Location(Player player) {
        this.player = player;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public abstract boolean onLocation();

    public void describe(){
        System.out.println(this.getId() + " " + this.getName());
    }

}
