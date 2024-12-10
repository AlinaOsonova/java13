import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Comparator;

public class AviaSoulsTest {

    Ticket ticket1 = new Ticket("City1", "City2", 10_000, 13, 16);
    Ticket ticket2 = new Ticket("City2", "City1", 12_000, 21, 24);
    Ticket ticket3 = new Ticket("City1", "City3", 15_000, 9, 13);
    Ticket ticket4 = new Ticket("City3", "City4", 5_000, 3, 7);
    Ticket ticket5 = new Ticket("City1", "City2", 30_000, 16, 22);
    Ticket ticket6 = new Ticket("City2", "City1", 25_000, 6, 10);
    Ticket ticket7 = new Ticket("City1", "City2", 8_000, 1, 4);

    @Test
    public void test() {
        AviaSouls manager = new AviaSouls();

        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);


        Ticket[] expected = {ticket7, ticket1, ticket5};
        Ticket[] actual = manager.search("City1", "City2");
        Assertions.assertArrayEquals(expected, actual);

    }


    @Test
    public void test1() {
        AviaSouls manager = new AviaSouls();

        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);


        Ticket[] expected = {ticket4};
        Ticket[] actual = manager.search("City3", "City4");
        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void test2() {
        AviaSouls manager = new AviaSouls();

        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);


        Ticket[] expected = {};
        Ticket[] actual = manager.search("City1", "City4");
        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void test3() {
        AviaSouls manager = new AviaSouls();

        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);

        Comparator<Ticket> comparator = new TicketTimeComparator();

        Ticket[] expected = {ticket1, ticket7, ticket5};
        Ticket[] actual = manager.searchAndSortBy("City1", "City2", comparator);
        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void test4() {
        AviaSouls manager = new AviaSouls();

        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);

        Comparator<Ticket> comparator = new TicketTimeComparator();

        Ticket[] expected = {ticket4};
        Ticket[] actual = manager.searchAndSortBy("City3", "City4", comparator);
        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void test5() {
        AviaSouls manager = new AviaSouls();

        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);

        Comparator<Ticket> comparator = new TicketTimeComparator();

        Ticket[] expected = {};
        Ticket[] actual = manager.searchAndSortBy("City1", "City4", comparator);
        Assertions.assertArrayEquals(expected, actual);

    }
}
