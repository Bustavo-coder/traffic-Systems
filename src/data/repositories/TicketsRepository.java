package data.repositories;

import java.util.List;

public interface TicketsRepository {
    TicketsRepository save(TicketsRepository ticket);
    TicketsRepository findById(int id);
    List<TicketsRepository> findAll();
    void deleteById(int id);
    void deleteALL();
    void delete(TicketsRepository ticket);
    long count();
}
