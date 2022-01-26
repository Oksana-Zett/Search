package manager;

import domain.Ticket;
import repository.TicketRepository;

import java.util.Arrays;

public class TicketManager {
    private TicketRepository repository;

    public TicketManager(TicketRepository repository) {

        this.repository = repository;
    }


    public void add(Ticket ticket) {

        repository.save(ticket);
    }

    public Ticket[] searchByAirport(String airportFrom, String airportTo) {
        Ticket[] result = new Ticket[0];
        for (Ticket ticket : repository.findAll()) {
            if (matchesAirportFrom(ticket, airportFrom) && matchesAirportTo(ticket, airportTo)) {
                Ticket[] tmp = new Ticket[result.length + 1];
                System.arraycopy(result, 0, tmp, 0, result.length);// используйте System.arraycopy, чтобы скопировать всё из result в tmp
                tmp[tmp.length - 1] = ticket;
                result = tmp;
            }
        }
        Arrays.sort(result);
        return result;
    }

    public boolean matchesAirportFrom(Ticket ticket, String search) {
        if (ticket.getAirportFrom().contains(search)) { // проверим есть ли поисковое слово в данных об аэропорте вылета
            return true;
        }
        return false;
    }

    public boolean matchesAirportTo(Ticket ticket, String search) {
        if (ticket.getAirportTo().contains(search)) { // проверим есть ли поисковое слово в данных об аэропорте прилета
            return true;
        }
        return false;
    }
}
