package ru.netology.domain;

public class Ticket implements Comparable<Ticket> {
    int id;
    String IATAFrom;
    String IATATo;
    int price;
    int flightTime;

    public Ticket(int id, String IATAFrom, String IATATo, int price, int flightTime) {
        this.id = id;
        this.IATAFrom = IATAFrom;
        this.IATATo = IATATo;
        this.price = price;
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

    public int getPrice() {
        return price;
    }

    @Override
    public int compareTo(Ticket o) {
        if (this.price < o.price) {
            return -1;
        } else if (this.price > o.price) {
            return 1;
        }
        return 0;
    }
}
