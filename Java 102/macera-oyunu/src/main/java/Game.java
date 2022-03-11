import java.util.Scanner;
import Location.Location;
import Location.Battle.*;
import Location.Normal.*;
import Util.Player;

public class Game {

    private Player player;
    private Location location;
    private Scanner scanner;

    public Game() {
        this.scanner = new Scanner(System.in);
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public void start(){
        System.out.println("Welcome to the adventure game !");

        System.out.println("*Please enter your name:");
        String playerName = scanner.nextLine();

        this.player = new Player(playerName);
        System.out.println("Welcome " + player.getName());


        //Select Game Character
        this.player.selectChar();


        Location location = null;
        boolean conditionChecker = true; //Check while condition
        boolean isPlayerWon = false; //Check while condition
        while(conditionChecker && !isPlayerWon){
            this.player.describe();

            //Select Location
            location = selectLoc();

            //Check player collect all location's award
            if(location instanceof SafeHouse){
                isPlayerWon = ((SafeHouse) location).isPlayerWon();
            }

            //Location checker
            conditionChecker = location.onLocation();

            if(!conditionChecker){
                System.out.println("\n\n!!! You are dead, Game is over !!!");
            }
            if(isPlayerWon){
                System.out.println("\n\n\n");
                System.out.println("***********************************");
                System.out.println("*                                 *");
                System.out.println("*         YOU WIN THE GAME        *");
                System.out.println("***********************************");
            }
        }

    }

    public Location selectLoc(){
        Location[] locations = {new SafeHouse(player), new Toolstore(player), new Cave(player), new Forest(player), new River(player), new Mine(player)};

        //Locations describe itself
        System.out.println("\n ----- Available locations ----");
        for (Location location: locations) {
            location.describe();
        }

        //User input for select location
        System.out.println("*Please select your location:");
        int locationId = scanner.nextInt();

        //Check for out of list index and fix it
        if(locationId > locations.length || locationId < 1){
            locationId = 1;
        }

        //Selected location
        return locations[locationId-1];
    }


}
