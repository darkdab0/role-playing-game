package main.Interaction;

import main.Actors.Enemy;
import main.Actors.Player;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Billions on 27/03/2017.
 */

public class Battle {
    public Battle(Player player, Enemy enemy) throws IOException {
        System.out.println("You spot a " + enemy + " charging towards you");
        System.out.println("Your battle with " + enemy + " begins (" + player.getStatus() + " / "
                + enemy.getStatus() + ")");
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        while (player.isAlive() && enemy.isAlive()) {
            System.out.print("Attack (a) or heal (h)? " + "(" + player.getStatus() + ")" + " ");
            String action = in.readLine();
            if (action.equals("h")) {
                player.heal();
            } else {
                enemy.defend(player);
            }
            if (enemy.isAlive()) {
                player.enemyDefend(enemy);
            }
        }
    }

}