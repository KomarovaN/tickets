package ru.netology.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TicketRepositoryTest {
    Ticket ticket1 = new Ticket(1, "IATAFrom 1", "IATATo 1", 100, 1);
    Ticket ticket2 = new Ticket(2, "IATAFrom 2", "IATATo 2", 200, 2);
    Ticket ticket3 = new Ticket(3, "IATAFrom 3", "IATATo 3", 300, 3);

    @Test
    public void shouldSave() {
        TicketRepository repo = new TicketRepository();
        repo.save(ticket1);
        repo.save(ticket2);
        repo.save(ticket3);


        Ticket[] expected = {ticket1, ticket2, ticket3};
        Ticket[] actual = repo.getAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldRemoveById() {
        TicketRepository repo = new TicketRepository();
        repo.save(ticket1);
        repo.save(ticket2);
        repo.save(ticket3);
        repo.removeById(ticket2.getId());

        Ticket[] expected = {ticket1, ticket3};
        Ticket[] actual = repo.getAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindById() {
        TicketRepository repo = new TicketRepository();
        repo.save(ticket1);
        repo.save(ticket2);
        repo.save(ticket3);

        Assertions.assertEquals(ticket2, repo.findById(ticket2.getId()));
    }
    @Test
    public void shouldFindByIdNoExists() {
        TicketRepository repo = new TicketRepository();
        repo.save(ticket1);
        repo.save(ticket2);
        repo.save(ticket3);

        Assertions.assertEquals(null, repo.findById(10));
    }


}
