package ru.netology.domain;

public class Ticket implements Comparable<Ticket> {
    int id;
    String From;
    String To;
    int price;
    int time;

    public Ticket(int id, String From, String To, int price, int time) {
        this.id = id;
        this.From = From;
        this.To = To;
        this.price = price;
        this.time = time;
    }

    public boolean matches(String from, String to) {
        return (getFrom().equals(from) && getTo().equals(to));
    }

    public int getId() {
        return id;
    }

    public String getFrom() {
        return From;
    }

    public String getTo() {
        return To;
    }

    public int getPrice() {
        return price;
    }

    public int getTime() {
        return time;
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
