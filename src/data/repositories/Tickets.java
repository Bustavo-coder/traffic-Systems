package data.repositories;

import data.models.Ticket;
import data.repositories.TicketsRepository;

import java.util.List;

public class Tickets implements TicketsRepository {
    @Override
    public Ticket save(Ticket ticket) {
        return null;
    }

    @Override
    public Ticket findById(int id) {
        return null;
    }

    @Override
    public List<Ticket> findAll() {
        return List.of();
    }

    @Override
    public void deleteById(int id) {

    }

    @Override
    public void deleteALL() {

    }

    @Override
    public void delete(Ticket ticket) {

    }

    @Override
    public long count() {
        return 0;
    }
}