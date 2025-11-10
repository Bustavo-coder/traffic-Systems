package data.repositories;

import data.models.Officer;

import java.util.List;

public class Officers implements OfficerRepository{
    @Override
    public Officer save(Officer officer) {
        return null;
    }

    @Override
    public Officer findById(int id) {
        return null;
    }

    @Override
    public List<Officer> findAll() {
        return List.of();
    }

    @Override
    public void deleteById(int id) {

    }

    @Override
    public void deleteALL() {

    }

    @Override
    public void delete(Officer officer) {

    }

    @Override
    public long count() {
        return 0;
    }
}
