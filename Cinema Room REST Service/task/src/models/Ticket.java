package models;

public class Ticket {

    private int row;
    private int column;
    private int price;
    private boolean free;

    public Ticket() {
    }

    public Ticket(int row, int column, int price) {
        this.row = row;
        this.column = column;
        this.price = price;
        this.free = true;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    protected boolean isFree() {
        return free;
    }

    protected void setFree(boolean free) {
        this.free = free;
    }
}
