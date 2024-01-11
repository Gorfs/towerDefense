package gui;

import model.Player;

public class Log {
    private final int length = 12;
    private int index = 0;
    private final String[] log;
    public Log() {
        log = new String[length];
        for (int i = 0; i < length; i++) log[i] = "                  |";
    }

    public String[] getLog() {
        return log;
    }

    public void addLog(String log) {
        if (index < length) {
            this.log[index] = "[" + Player.INSTANCE.getTimer() + "] " + log;
            index++;
        }
        else {
            for (int i = 0; i < length - 1; i++) {
                this.log[i] = this.log[i + 1];
            } this.log[length - 1] = "[" + Player.INSTANCE.getTimer() + "] " + log;
        }
    }
}