package domain;

public class Ticket implements Comparable<Ticket> {
    private int id;
    private int price;
    private String airportFrom;
    private String airportTo;
    private int time;

    public Ticket(int id, int price, String airportFrom, String airportTo, int time) {
        this.id = id;
        this.price = price;
        this.airportFrom = airportFrom;
        this.airportTo = airportTo;
        this.time = time;
    }

    public Ticket() {

    }

    public int getId() {

        return id;
    }

    public int getPrice() {

        return price;
    }

    public String getAirportFrom() {

        return airportFrom;
    }

    public String getAirportTo() {

        return airportTo;
    }

    public int getTime() {

        return time;
    }

    @Override
    public int compareTo(Ticket o) {
        Ticket t = (Ticket) o;
        return price - t.price;
    }
}

