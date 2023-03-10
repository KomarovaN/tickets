package ru.netology.domain;

public class TicketRepository {
    private Ticket[] tickets = new Ticket[0];

    public void save(Ticket ticket) {
        //if (findById(ticket.getId()) == null) {
        Ticket[] tmp = new Ticket[tickets.length + 1];
        for (int i = 0; i < tickets.length; i++) {
            tmp[i] = tickets[i];
        }
        tmp[tmp.length - 1] = ticket;
        tickets = tmp;
        // } else {
        //     throw new AlreadyExistsException("Element with id: " + ticket.getId() + " already exists");
        // }
    }

    public void removeById(int id) {
        //if (findById(id) != null) {
        Ticket[] tmp = new Ticket[tickets.length - 1];
        int copyToIndex = 0;
        for (Ticket ticket : tickets) {
            if (ticket.getId() != id) {
                tmp[copyToIndex] = ticket;
                copyToIndex++;
            }
        }
        tickets = tmp;
        //} else {
        //  throw new NotFoundException("Element with id: " + id + " not found");
        //}
    }

    public Ticket findById(int id) {
        for (Ticket ticket : tickets) {
            if (ticket.getId() == id) {
                return ticket;
            }
        }
        return null;
    }

    public Ticket[] findAll() {
        return tickets;
    }

}
