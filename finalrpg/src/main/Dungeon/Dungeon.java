package main.Dungeon;

import main.Actors.Player;
import main.Inventory.Item;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.*;
/**
 * Created by Billions on 26/03/2017.
 */

public class Dungeon {

    protected Scanner scanner;
    private Map<Integer, Map<Integer, Room>> map = new HashMap<>();
    private Room currentRoom;
    private int currentX = 0;
    private int currentY = 0;

    private void putRoom(Item n, int x, int y, Room room) {
        if (!map.containsKey(x)) {
            map.put(x, new HashMap<>());
        }
        map.get(x).put(y, room);
    }

    private Room getRoom(int x, int y) {
        return map.get(x).get(y);
    }

    private boolean roomExists(int x, int y) {
        if (!map.containsKey(x)) {
            return false;
        }
        return map.get(x).containsKey(y);
    }

private boolean isComplete() {
        return currentRoom.isBossRoom() && currentRoom.isComplete();
    }

    public void movePlayer(Player player) throws IOException {
    boolean northPossible = roomExists(currentX, currentY + 1);
    boolean southPossible = roomExists(currentX, currentY - 1);
    boolean eastPossible = roomExists(currentX + 1, currentY);
    boolean westPossible = roomExists(currentX - 1, currentY);
        System.out.print("Where would you like to go :");
        if (northPossible) {
        System.out.print(" North (n)");
    }
        if (eastPossible) {
        System.out.print(" East (e)");
    }
        if (southPossible) {
        System.out.print(" South (s)");
    }
        if (westPossible) {
        System.out.print(" West (w)");
    }
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    String direction = in.readLine();
        if (direction.equals("n") && northPossible) {
        currentY++;
    } else if (direction.equals("s") && southPossible) {
        currentY--;
    } else if (direction.equals("e") && eastPossible) {
        currentX++;
    } else if (direction.equals("w") && westPossible) {
        currentX--;
    } else if (direction.equals("help") ) {
          help();
    }else if (direction.equals("inventory")) {
            checkInventory();
    }else if (direction.equals("health")) {
            System.out.println(player.getStatus());

    }
    currentRoom = getRoom(currentX, currentY);
        currentRoom.enter(player);
}

    public void startQuest(Player player) throws IOException {
        while (player.isAlive() && !isComplete()) {
            movePlayer(player);
        }
        if (player.isAlive()) {
            System.out.println("You have defeated the evil king Yanon, you have fufilled your destiny!");
        } else {
            System.out.println("Unfortunately you have perished. Please play again!");
        }
    }
    public static Dungeon newInstance() {
        Dungeon dungeon = new Dungeon();
        dungeon.putRoom(null,0,0, Room.newInstance());
        dungeon.putRoom(null,-1, 1, Room.newInstance());
        dungeon.putRoom(null,0, 1, Room.newInstance());
        dungeon.putRoom(null,1, 1, Room.newInstance());
        dungeon.putRoom(null,-1, 2, Room.newInstance());
        dungeon.putRoom(null,1, 2, Room.newInstance());
        dungeon.putRoom(null,-1, 3, Room.newInstance());
        dungeon.putRoom(null,0, 3, Room.newInstance());
        dungeon.putRoom(null,1, 3, Room.newInstance());
        dungeon.putRoom(null,0, 4, Room.newBossInstance());
        dungeon.currentRoom = dungeon.getRoom(0, 0);
        return dungeon;
    }
    LinkedList<Item> inGameItems;

    public LinkedList<Item> Inventory() {
        return inGameItems;
    }
    public void putItems(LinkedList<Item> inGameItems) {
        for(Item i : inGameItems) {
            this.inGameItems.add(i);
        }
    }

    private void checkInventory() {
        if (inGameItems != null) {
            System.out.println(inGameItems);
        } else {
            System.out.println("Your inventory is empty");
        }
    }

    public void putItem(Item item) {
        this.inGameItems.add(item);
    }

    private void help() {
        System.out.println("##################### Help #################################\n" +"type n, e, s or w to go in their respective compass directions\n" +
                "if you encounter an enemy, you can attack it by typing a\n" + "You can also use up your potions in battle if you" +
                " are low in health\n" + "take care however as you only have 10 of them\n" + "##########################################################");
    }


}