package config;


public record Cell(Cell.Content content) {
    public enum Content {BASE, PATH, SPAWN, SLOT};

    // TODO: Once class for towers is done, add a variable that can stock a tower if content = SLOT.
    // private Tower slot(Tower tower) {}

    public static Cell slot(Content c) {
        return new Cell(c);
    }

    /**
    * @return the content of the cell to print it in the console.
    * */
    public String termPrint() {
        if (content == Content.PATH) return ("[] ");
        else if (content == Content.SLOT) return ("XX ");
        else return ("-> ");
    }

    @Override
    public String toString() {
        return (content + "");
    }
}
