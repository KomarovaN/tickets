package ru.netology.domain;

public class Ticket implements Comparable<Ticket> {
    int id;
    String IATAFrom;
    String IATATo;
    int cost;
    int flightTime;

    public Ticket(int id, String IATAFrom, String IATATo, int cost, int flightTime) {
        this.id = id;
        this.IATAFrom = IATAFrom;
        this.IATATo = IATATo;
        this.cost = cost;
        this.flightTime = flightTime;
    }

    public boolean matches(String from, String to) {
        return (getIATAFrom().equals(from) && getIATATo().equals(to));
    }

    public int getId() {
        return id;
    }

    public String getIATAFrom() {
        return IATAFrom;
    }

    public String getIATATo() {
        return IATATo;
    }


    @Override
    public int compareTo(Ticket o) {
        if (this.cost < o.cost) {
            return -1;
        } else if (this.cost > o.cost) {
            return 1;
        }
        return 0;
    }
}
