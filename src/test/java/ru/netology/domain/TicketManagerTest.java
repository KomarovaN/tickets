package ru.netology.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TicketManagerTest {
    TicketRepository repo = new TicketRepository();
    TicketManager manager = new TicketManager(repo);
    TicketByPriceAscComparator priceComparator = new TicketByPriceAscComparator();
    TicketByTimeComparator timeComparator = new TicketByTimeComparator();
    Ticket ticket1 = new Ticket(1, "IFA", "ITA", 100, 1);
    Ticket ticket2 = new Ticket(2, "IFB", "ITB", 400, 2);
    Ticket ticket3 = new Ticket(3, "IFC", "ITC", 300, 3);
    Ticket ticket4 = new Ticket(4, ticket2.getFrom(), ticket2.getTo(), 400, 4);
    Ticket ticket5 = new Ticket(5, ticket2.getFrom(), ticket2.getTo(), 500, 5);
    Ticket ticket6 = new Ticket(6, ticket2.getFrom(), ticket2.getTo(), 300, 5);
    Ticket ticket7 = new Ticket(4, ticket2.getFrom(), "ITD", 400, 4);
    Ticket ticket8 = new Ticket(5, "IFD", ticket2.getTo(), 500, 5);

    @Test
    public void shouldFindAllTimeComparator() {
        repo.save(ticket8);
        repo.save(ticket7);
        repo.save(ticket6);
        repo.save(ticket1);
        repo.save(ticket5);
        repo.save(ticket4);
        repo.save(ticket3);
        repo.save(ticket2);
        repo.save(ticket1);

        Ticket[] expected = {ticket2, ticket4, ticket6, ticket5};
        Ticket[] actual = manager.findAll(ticket2.getFrom(), ticket2.getTo(), timeComparator);

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindAllPriceComparator() {
        repo.save(ticket8);
        repo.save(ticket7);
        repo.save(ticket6);
        repo.save(ticket1);
        repo.save(ticket5);
        repo.save(ticket4);
        repo.save(ticket3);
        repo.save(ticket2);
        repo.save(ticket1);

        Ticket[] expected = {ticket6, ticket4, ticket2, ticket5};
        Ticket[] actual = manager.findAll(ticket2.getFrom(), ticket2.getTo(), priceComparator);

        Assertions.assertArrayEquals(expected, actual);
    }
    @Test
    public void shouldSearchByFromToPositive() {
        repo.save(ticket8);
        repo.save(ticket7);
        repo.save(ticket6);
        repo.save(ticket1);
        repo.save(ticket5);
        repo.save(ticket4);
        repo.save(ticket3);
        repo.save(ticket2);
        repo.save(ticket1);

        Ticket[] expected = {ticket6, ticket4, ticket2, ticket5};
        Ticket[] actual = manager.searchByFromTo(ticket2.getFrom(), ticket2.getTo());

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchByFromToPositiveOne() {
        repo.save(ticket8);
        repo.save(ticket7);
        repo.save(ticket3);
        repo.save(ticket2);
        repo.save(ticket1);

        Ticket[] expected = {ticket2};
        Ticket[] actual = manager.searchByFromTo(ticket2.getFrom(), ticket2.getTo());

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchByFromToNegative() {
        repo.save(ticket8);
        repo.save(ticket7);
        repo.save(ticket6);
        repo.save(ticket5);
        repo.save(ticket4);
        repo.save(ticket3);
        repo.save(ticket2);
        repo.save(ticket1);

        Ticket[] expected = new Ticket[0];
        Ticket[] actual = manager.searchByFromTo("XXX", "XXX");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchByFromNegative() {
        repo.save(ticket8);
        repo.save(ticket7);
        repo.save(ticket6);
        repo.save(ticket5);
        repo.save(ticket4);
        repo.save(ticket3);
        repo.save(ticket2);
        repo.save(ticket1);

        Ticket[] expected = new Ticket[0];
        Ticket[] actual = manager.searchByFromTo("XXX", ticket2.getTo());

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchByToNegative() {
        repo.save(ticket8);
        repo.save(ticket7);
        repo.save(ticket6);
        repo.save(ticket5);
        repo.save(ticket4);
        repo.save(ticket3);
        repo.save(ticket2);
        repo.save(ticket1);

        Ticket[] expected = new Ticket[0];
        Ticket[] actual = manager.searchByFromTo(ticket2.getFrom(), "XXX");

        Assertions.assertArrayEquals(expected, actual);
    }
}
