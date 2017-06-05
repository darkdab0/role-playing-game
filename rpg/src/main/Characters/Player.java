package main.Characters;

import java.util.Random;

/**
 * Created by c1673142 on 29/03/2017.
 */
public class Player extends Character {
    private static Random random = new Random();

    public Player(String name, int hitPoint, int maxHitPoints, int numPotions, int minDamage, int maxDamage) {
        super(name, maxHitPoints, hitPoint,numPotions, minDamage, maxDamage);

    }

   public int attackEnemy() {
        //This finds the difference between the attack strength of the character, adds 1 because of the iteration
        return random.nextInt(super.getMaxDamage() - super.getMinDamage() + 1) + super.getMinDamage();
    }

    public void defendEnemy(Enemy enemy) {

    }


}
