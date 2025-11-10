package data.repositories;

import data.models.Ticket;

import java.util.List;

public interface TicketsRepository {
    Ticket save(Ticket ticket);
    Ticket findById(int id);
    List<Ticket> findAll();
    void deleteById(int id);
    void deleteALL();
    void delete(Ticket ticket);
    long count();
}
