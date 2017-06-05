package main.Characters;

import java.util.Random;

/**
 * Created by c1673142 on 30/03/2017.
 */
public class Character {

    private String name;
    private int maxHitPoints;
    private int hitPoint;
    private int numPotions;
    private int minDamage;
    private int maxDamage;
    private Random random = new Random();

    public Character(String name, int maxHitPoints, int hitPoint, int numPotions, int minDamage, int maxDamage) {
        this.name = name;
        this.maxHitPoints = maxHitPoints;
        this.hitPoint = hitPoint;
        this.numPotions = numPotions;
        this.minDamage = minDamage;
        this.maxDamage = maxDamage;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMaxHitPoints() {
        return maxHitPoints;
    }

    public void setMaxHitPoints(int maxHitPoints) {
        this.maxHitPoints = maxHitPoints;
    }

    public int getHitPoint() {
        return hitPoint;
    }

    public void setHitPoint(int hitPoint) {
        this.hitPoint = hitPoint;
    }

    public int getNumPotions() {
        return numPotions;
    }

    public void setNumPotions(int numPotions) {
        this.numPotions = numPotions;
    }

    public int getMinDamage() {
        return minDamage;
    }

    public void setMinDamage(int minDamage) {
        this.minDamage = minDamage;
    }

    public int getMaxDamage() {
        return maxDamage;
    }

    public void setMaxDamage(int maxDamage) {
        this.maxDamage = maxDamage;
    }

    public Random getRandom() {
        return random;
    }

    public void setRandom(Random random) {
        this.random = random;
    }


}
