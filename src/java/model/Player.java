package model;

public class Player {
    public static Player INSTANCE = new Player();
    private final int[] health = new int[]{100,100};
    private int money = 0;
    public Player() {
        money = 0;
    }

    public static Player getInstance() {
        INSTANCE = new Player();
        return INSTANCE;
    }

    public void resetPlayer() {
        health[1] = health[0];
        money = 0;
    }

    public int getMoney() {
        return money;
    }

    public void addMoney(int money) {
        this.money += money;
    }

    public void removeMoney(int money) {
        this.money -= money;
    }

    public int[] getHealth() {
        return health;
    }

    public void heal(int health) {
        this.health[1] += health;
    }

    public void takeDamage(int health) {
        this.health[1] -= health;
    }
}
