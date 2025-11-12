package data.repositories;

import data.models.Ticket;

import java.util.HashMap;
import java.util.List;

public interface TicketsRepository {
    Ticket save(Ticket ticket);
    Ticket findById(int id);
    HashMap<Integer,Ticket> findAll();
    void deleteById(int id);
    void deleteALL();
    void delete(Ticket ticket);
    long count();
}
