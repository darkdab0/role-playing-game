package main.Actors;

import java.util.Random;

/**
 * Created by Billions on 26/03/2017.
 */

public abstract class Character {

    private String name;
    private int maxHit;
    private int healthRemaining;

    private int minDamage;
    private int maxDamage;
    private Random random = new Random();

    public void setName(String name) {
        this.name = name;
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

    public Character(String name, int maxHitPoints, int hitPoint, int minDamage, int maxDamage) {
        this.name = name;
        this.maxHit = maxHitPoints;
        this.healthRemaining = hitPoint;
        this.minDamage = minDamage;
        this.maxDamage = maxDamage;
    }

    protected String getName() {
        return name;
    }

    public int getMaxHit() {
        return maxHit;
    }

    public void setMaxHit(int maxHitPoints) {
        this.maxHit = maxHit;
    }

    public int getHealthRemaining() {
        return healthRemaining;
    }

    public void setHealthRemaining(int healthRemaining) {
        this.healthRemaining = healthRemaining;
    }
}
