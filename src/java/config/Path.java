package config;

import model.monster.Monsters;

public class Path extends Cell {

    private boolean isEmpty;
    private Monsters monsters;
    private Cell nextPath;

    private boolean isSpawn;
    private boolean isBase;

    public Path(Path nextPath, int x, int y) {
        super(x, y);
        this.monsters = null;
        this.isEmpty = true;
        this.nextPath = nextPath;
    }

    public Path() {
        super();
        this.monsters = null;
        this.isEmpty = true;
        this.nextPath = null;
    }

    public Path(boolean isSpawn, int x, int y) {
        super(x, y);
        this.isSpawn = true;
        this.isEmpty = true;
        this.nextPath = null;
    }

    public Path(boolean isSpawn, boolean isBase, int x, int y) {
        this(false, x, y);
        this.isBase = true;
    }

    /**
     * @return boolean
     */
    public boolean isBase() {
        return isBase;
    }

    /**
     * @param next
     */
    public void setNextPath(Cell next) {
        this.nextPath = next;
    }

    public Path(int x, int y) {
        this(false, x, y);
    }

    /**
     * @param isSpawn
     */
    public void setSpawn(boolean isSpawn) {
        this.isSpawn = isSpawn;
    }

    /**
     * @return boolean
     */
    public boolean isSpawn() {
        return this.isSpawn;
    }

    /**
     * @return Cell
     */
    public Cell getNextPath() {
        return this.nextPath;
    }

    /**
     * @return boolean
     */
    public boolean isEmpty() {
        return this.isEmpty;
    }

    /**
     * @return Monsters
     */
    public Monsters getMonster() {
        return this.monsters;
    }

    /**
     * @param monsters
     */
    public void setMonster(Monsters monsters) {
        this.isEmpty = false;
        this.monsters = monsters;
    }

    public void removeMonster() {
        this.isEmpty = true;
        this.monsters = null;
    }

    /**
     * @return String
     */
    public String toString() {
        if (this.isEmpty()) {
            return "   ";
        } else {
            // TODO: With this only 1 monster can be displayed at a timer. Discuss and come
            // back to.
            return this.monsters.toString();
        }
    }

}
