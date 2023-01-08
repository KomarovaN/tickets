package ru.netology.domain;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;

public class TicketManager {
    private TicketRepository repo;

    public TicketManager(TicketRepository repo) {
        this.repo = repo;
    }

    public Ticket[] findAll(String from, String to, Comparator<Ticket> comparator) {
        Ticket[] result = new Ticket[0]; // тут будем хранить подошедшие запросу билеты
        for (Ticket ticket : repo.getAll()) {
            if (matches(ticket, from, to)) {
                // "добавляем в конец" массива result билет ticket
                Ticket[] tmp = new Ticket[result.length + 1];
                for (int i = 0; i < result.length; i++) {
                    tmp[i] = result[i];
                }
                tmp[tmp.length - 1] = ticket;
                result = tmp;
            }
        }
        Arrays.sort(result, comparator);
        return result;
    }

    public Ticket[] searchByFromTo(String from, String to) {
        Ticket[] result = new Ticket[0]; // тут будем хранить подошедшие запросу билеты
        for (Ticket ticket : repo.getAll()) {
            if (matches(ticket, from, to)) {
                // "добавляем в конец" массива result билет ticket
                Ticket[] tmp = new Ticket[result.length + 1];
                for (int i = 0; i < result.length; i++) {
                    tmp[i] = result[i];
                }
                tmp[tmp.length - 1] = ticket;
                result = tmp;
            }
        }
        Arrays.sort(result);
        return result;
    }

    // метод определения соответствия билета ticket поисковому запросу по аэропорту вылета и аэропорту прилета
    public boolean matches(Ticket ticket, String from, String to) {
        return ticket.matches(from, to);
    }
}
