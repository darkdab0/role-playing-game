package main.Actors;

import main.Dungeon.Room;
import main.Inventory.Item;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Random;

/**
 * Created by Billions on 26/03/2017.
 */
public class Player extends Character {
    public Player(String name, int maxHit, int healthRemaining, int minDamage, int maxDamage, int numPotions) {
        super(name, maxHit, healthRemaining, minDamage, maxDamage);
        this.numPotions = numPotions;
    }
    private int numPotions;
    private static Random random = new Random();

    public int attackEnemy() {
        return random.nextInt(super.getMaxDamage() - super.getMinDamage() + 1) + super.getMinDamage();
    }
    public void heal() {
        if (numPotions > 0) {
            setHealthRemaining(Math.max(getHealthRemaining(), getHealthRemaining() + 10));
            System.out.printf("  %s drinks healing potion (%s, %d potions left)\n", getName(),
                    getStatus(), --numPotions);
        } else {
            System.out.println("You have no more magic potions left... go scavenge some food!!!");
        }
    }
public void boost() {
       if (getMaxDamage() < 13) {
        setMaxDamage(Math.max(getMaxDamage(), getMaxDamage() + 20));
        System.out.println("Your maximum damage has been increased!");
    }else{
        System.out.println("You already have the maximum damage inflictor");
    }

}

    public void enemyDefend(Enemy enemy) {
        int AttackHit = enemy.attack();
        super.setHealthRemaining((super.getHealthRemaining() > AttackHit) ? (super.getHealthRemaining() - AttackHit) : 0);
        System.out.printf(" " + getName() + " is hit with %d amount of damage\n", AttackHit, getStatus());
        if (getHealthRemaining() == 0) {
            System.out.println(getName() + " has died");
        }
    }
    public boolean isAlive() {
        return getHealthRemaining() > 0;
    }
    public String getStatus() {
        return "Health " + getHealthRemaining();
    }
    public void pick(Item item) {
        this.items.add(item);
    }
    public boolean pickup(Item item){

        this.pick(item);
        return true;
    }
    public boolean hasItem(Item item) {
        if(item == null) return false;
        return this.items.contains(item);
    }
    public void enterRoom() {
        setHealthRemaining(Math.min(getHealthRemaining(), getHealthRemaining() - 5));
    }
    @Override
    public String toString(){
        return getName();
    }
    public static Player newInstance() {
        return new Player("Dink", 15, 100,10, 20,10);
    }
    protected LinkedList<Item> items;
}
