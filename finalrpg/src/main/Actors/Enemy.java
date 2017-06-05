package main.Actors;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import static sun.audio.AudioPlayer.player;

/**
 * Created by Billions on 26/03/2017.
 */
public class Enemy extends Character{
    public Enemy(String name, int healthRemaining, int maxHit, int minDamage, int maxDamage) {
        super(name, maxHit, healthRemaining, minDamage, maxDamage);
    }
    private static Set<Integer>seenEnemy = new HashSet<>();
    private static int enemyCount = 3;
    private static Random random = new Random();

    public static Enemy newInstance() {
        if (seenEnemy.size() == enemyCount) {
            seenEnemy.clear();
        }
        int i;
        do {
            i = random.nextInt(enemyCount);
        } while (seenEnemy.contains(i));
        seenEnemy.add(i);
        if (i == 0) {
            return new Enemy("Whiz-robe", 30, 7, 6, 8);
        } else if (i == 1) {
            return new Enemy("Dalfos", 26, 5, 4, 6);
        } else {
            return new Enemy("KDino-fol", 18, 3, 2, 4);
        }
    }

        public static Enemy newBossInstance() {
            return new Enemy("Yanon", 40, 10, 8, 11);
    }
    @Override
    public String toString() {
        return super.getName();
    }

    public String getStatus() {
        return "Enemy health remaining: " + super.getHealthRemaining();
    }

    public int attack() {
        return random.nextInt(super.getMaxDamage() - super.getMinDamage() + 1) + super.getMinDamage();
    }

    public void defend(Player player) {
        int hitStrength = player.attackEnemy();
        super.setHealthRemaining((super.getHealthRemaining() > hitStrength) ? (super.getHealthRemaining() - hitStrength) : 0);
        System.out.printf(" %s hits %s with damage %d\n", player, super.getName(), hitStrength, getStatus());
        if(super.getHealthRemaining() == 0) {
            System.out.println(super.getName() + " has been defeated");
        }
    }
    public boolean isAlive() {
        return super.getHealthRemaining() > 0;
    }
}
