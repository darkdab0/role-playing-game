package main.Characters;

import java.util.HashSet;
import java.util.Set;
import java.util.Random;

/**
 * Created by c1673142 on 29/03/2017.
 */
public class Enemy extends Character {

    private static Set<Integer> seenEnemy = new HashSet<>();
    private static int enemyCount = 3;
    private static Random random = new Random();

    public static Enemy newInstance() {
        //when you have fought all the planned enemies, you don't have to fight them again.
        if (seenEnemy.size() == enemyCount) {
            seenEnemy.clear();
        }
        int i;
        do {
            i = random.nextInt(enemyCount);
        }
        while (seenEnemy.contains(i));
        seenEnemy.add(i);

        if (i==0) {
            return new Enemy("Wizrobe", 30, 8, 0, 8,12);
        }
        else if (i==1){
            return new Enemy("Stalfos", 20, 5, 0,10,5);
        }
        else {
            return new Enemy("Dinofol", 10, 3, 0,6,3);
        }
    }

    public static Enemy newBossInstance() {
        return new Enemy("Ganondorf", 40,10,0,10,20);
        }

    public Enemy(String name, int hitPoint, int maxHitPoints, int numPotions, int minDamage, int maxDamage) {
        super(name, maxHitPoints, hitPoint,numPotions, minDamage, maxDamage);

    }

    @Override
    public String toString() {
        return super.getName();
    }

    public String getStatus() {
        return "Enemy health remaining: " + super.getMaxHitPoints();
    }

    public int attack() {
        return random.nextInt(super.getMaxDamage()-super.getMinDamage()+1)+super.getMinDamage();
    }

    public void defend(Player player) {
        int hitStrength = player.attackEnemy();
        super.setHitPoint( (super.getMaxHitPoints() > hitStrength) ? (super.getMaxHitPoints() - hitStrength) : 0);
        System.out.printf(" %s hits %s with damage %d\n", player, super.getName(), hitStrength, getStatus());
        if(super.getMaxHitPoints() == 0) {
            System.out.println(super.getName() + " has been defeated");
        }
    }

    public boolean isAlive() {
        return super.getMaxHitPoints() > 0;
    }

}
