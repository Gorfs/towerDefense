package model;

import gui.Game;
import misc.Debug;

public class Player {
    private static final int[] health = new int[] { 100, 100 };
    private static int money = 100;

    public static void resetPlayer() {
        health[1] = health[0];
        money = 0;
    }

    public static int getMoney() {
        return money;
    }

    public static void addMoney(int price) {
        Debug.out("Money added");
        money += price;
        Debug.out("money = " + money);
    }

    public static void removeMoney(int price) {
        Debug.out("Money removed");
        money -= price;
        Debug.out("money = " + money);
    }

    public static int[] getHealth() {
        return health;
    }

    public static void heal(int hp) {
        health[0] += hp;
    }

    public static void takeDamage(int hp) {
        health[0] -= hp;
    }
}
