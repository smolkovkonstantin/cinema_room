package models;


public class Place {
    private String token;
    private Ticket ticket;

    public Place() {
    }

    public Place(String token, Ticket ticket) {
        this.token = token;
        this.ticket = ticket;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    public boolean ifFree() {
        return ticket.isFree();
    }

    public void freePlace(boolean free) {
        ticket.setFree(free);
    }
}
