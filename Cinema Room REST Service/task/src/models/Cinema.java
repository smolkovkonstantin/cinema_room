package models;

import java.util.List;

public class Cinema {

    private int total_rows;
    private int total_columns;
    private List<Place> available_seats;


    public Cinema(int total_rows, int total_columns, List<Place> place) {
        this.total_rows = total_rows;
        this.total_columns = total_columns;
        this.available_seats = place;
    }


    public int getTotal_rows() {
        return total_rows;
    }

    public void setTotal_rows(int total_rows) {
        this.total_rows = total_rows;
    }

    public int getTotal_columns() {
        return total_columns;
    }

    public void setTotal_columns(int total_columns) {
        this.total_columns = total_columns;
    }

    public List<Place> getAvailable_seats() {
        return available_seats;
    }

    public void setAvailable_seats(List<Place> available_seats) {
        this.available_seats = available_seats;
    }
}

