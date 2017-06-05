package main;


import main.Actors.Player;
import main.Dungeon.Dungeon;
import main.Dungeon.Room;
import main.Inventory.Item;

import java.io.IOException;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * Created by Billions on 26/03/2017.
 */
public class Game {

    protected Player player = Player.newInstance();

    public void play() throws IOException {
        System.out.println("################## WELCOME TO DINK'S LEGEND ###################################################\n"
        + "## You are Dink, a young boy who wants to save the world ######################################\n" +
        "## Through harsh weather and other horrible events you have finally made it to Yanon's tower ##\n" +
        "## You must destroy all evil in the castle before Yanon will even bother to fight you #########\n" +
        "## only you can change to fate of the world ###################################################\n" +
        "###############################################################################################\n");
        Dungeon.newInstance().startQuest(player);
    }

    public static void main(String[] args) throws IOException {
        Game game = new Game();
        game.play();
    }

}
