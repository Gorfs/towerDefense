package model;

import misc.Debug;

public class Player {
    public static Player INSTANCE = new Player();
    private final int[] health = new int[]{100,100};
    private double timer = 0.0;
    private int money = 70;
    private int wave = 1;

    public void resetPlayer() {
        health[1] = health[0];
        timer = 0.0;
        money = 70;
    }

    
    /** 
     * @return int
     */
    public int getMoney() {
        return money;
    }

    
    /** 
     * @param w
     */
    public void updateWave(int w){
        this.wave = w;
    }

    
    /** 
     * @param money
     */
    public void updateMoney(int money) {
        this.money += money;
    }

    
    /** 
     * @param price
     */
    public void removeMoney(int price) {
        Debug.out("Money removed");
        money -= price;
        Debug.out("money = " + money);
    }

    
    /** 
     * @return int[]
     */
    public int[] getHealth() {
        return health;
    }

    
    /** 
     * @param health
     */
    public void heal(int health) {
        this.health[1] += health;
    }

    
    /** 
     * @return String
     */
    public String getTimer() {
        String STimer;
        // Minutes
        double minutes = timer/60;
        String doubleAsString = String.valueOf(minutes);
        int indexOfDecimal = doubleAsString.indexOf(".");

        if (minutes >= 10) STimer = doubleAsString.substring(0, indexOfDecimal);
        else STimer = "0" + doubleAsString.substring(0, indexOfDecimal);
        STimer = STimer + ":";

        // Seconds
        double seconds = (Double.parseDouble("0" + doubleAsString.substring(indexOfDecimal))*60);
        doubleAsString = String.valueOf(seconds);
        indexOfDecimal = doubleAsString.indexOf(".");

        if (seconds >= 10) STimer = STimer + doubleAsString.substring(0, indexOfDecimal);
        else STimer = STimer + "0" + doubleAsString.substring(0, indexOfDecimal);

        // return result
        return STimer;
    }

    
    /** 
     * @param timer
     */
    public void updateTimer(double timer) {
        this.timer += timer * 1E-9;
    }

    
    /** 
     * @return int
     */
    public int getWave() {
        return wave;
    }

    public void setWave(int wave) {
        this.wave = wave;
    }

    public void takeDamage(int hp) {
        this.health[1] -= hp;
        if(this.health[1] <= 0){
            GameState.lose();
        }
    }
}
