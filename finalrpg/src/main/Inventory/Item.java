package main.Inventory;

import main.Actors.Player;
import main.Dungeon.Room;

import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;

import static main.Inventory.Type.FOOD;
import static main.Inventory.Type.WEAPON;

/**
 * Created by Billions on 27/03 /2017.
 */
public class Item {
    Item roomitem;

    protected String itemName;
    protected Type itemType;


    public Item(String n, Type t) {
        this.itemName = n;
        this.itemType = t;
        }

        private void initItemList() {

        itemlist = new LinkedList<>();
        itemlist.add(new ItemBanana("Banana",FOOD));
        itemlist.add(new ItemBoost("Booster Pack", WEAPON));
    }
    public  Item getInstance(String n, Type t) {
        if (itemlist == null) {
            initItemList();
        }
        return null;
    }
    class ItemBanana extends Item  {
        public ItemBanana(String n, Type t) {
            super(n,t);
        }
        public void eat(Player player) {
            player.heal();
            System.out.println("You ate some food!");
        }
    }

    class ItemBoost extends Item {
        public ItemBoost(String n, Type t) {
            super(n, t);
        }
        public void boost(Player player) {
            player.boost();
        }
    }
    public LinkedList<Item> itemlist;
}