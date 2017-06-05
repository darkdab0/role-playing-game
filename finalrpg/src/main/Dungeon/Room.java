package main.Dungeon;

import main.Actors.Enemy;
import main.Actors.Player;
import main.Interaction.Battle;
import main.Inventory.Item;
import java.io.IOException;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Random;
import java.util.Set;
/**
 * Created by Billions on 26/03/2017.
 */
public class Room {
    private static Random random = new Random();
    private static Set<Integer> roomSeen = new HashSet<>();
    private static int NUM_ROOMS = 7;
    public Enemy enemy;
    public boolean isBossRoom;
    public String roomDescription;
    protected LinkedList<Item> items;

    public Room(Enemy enemy, boolean isBossRoom, String roomDescription) {
        this.enemy = enemy;
        this.isBossRoom = isBossRoom;
        this.roomDescription = roomDescription;
    }

    public static Room newInstance() {
        if (roomSeen.size() == NUM_ROOMS) {
            roomSeen.clear();
        }
        int i;
        do {
            i = random.nextInt(NUM_ROOMS);
        } while (roomSeen.contains(i));
        roomSeen.add(i);
        LinkedList<Item> items = new LinkedList<Item>();
        String roomDescription = null;
        if (i == 0) {
            roomDescription = "a large circular room, four unlit torches can be seen in the center";
        } else if (i == 1) {
            roomDescription = "a gloomy, dark corridor";
        } else if (i == 2) {
            roomDescription = "an open area with a solitary tree in the centre";
        } else if (i == 3) {
            roomDescription = "a dark room with a mound of skulls in the corner";
        } else if (i == 4) {
            roomDescription = "a large room where lava surrounds a single platform";
        } else if (i == 5) {
            roomDescription = "a dark room with cobwebs everywhere";
        } else if (i == 6) {
            roomDescription = "a room with gaps everywhere, you don't know where they lead...";
        }
        return new Room(Enemy.newInstance(),false, roomDescription);
    }
    public static Room newBossInstance() {
        return new Room(Enemy.newBossInstance(), true, "the lair of this dungeons boss, you are surrounded by stained glass windows. And an evil king is seen playing the organ");
    }

    public void putItem(Item item) {
        this.items.add(item);
    }

    public boolean isBossRoom() {
        return isBossRoom;
    }

    public boolean isComplete() {
        return !enemy.isAlive();
    }
    @Override
    public String toString() {
        return roomDescription;
    }
    public void enter(Player player) throws IOException {
        player.enterRoom();
        System.out.println("You are in " + roomDescription);
        if(enemy.isAlive()) {
            new Battle(player, enemy);
        }
    }
}

