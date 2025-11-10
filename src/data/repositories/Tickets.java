package data.repositories;

import java.util.List;

public class Tickets implements TicketsRepository{
    @Override
    public TicketsRepository save(TicketsRepository ticket) {
        return null;
    }

    @Override
    public TicketsRepository findById(int id) {
        return null;
    }

    @Override
    public List<TicketsRepository> findAll() {
        return List.of();
    }

    @Override
    public void deleteById(int id) {

    }

    @Override
    public void deleteALL() {

    }

    @Override
    public void delete(TicketsRepository ticket) {

    }

    @Override
    public long count() {
        return 0;
    }
}
