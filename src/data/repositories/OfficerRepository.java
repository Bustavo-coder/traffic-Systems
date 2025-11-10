package data.repositories;

import data.models.Officer;
import data.models.Vehicle;

import java.util.List;

public interface OfficerRepository {
    Officer save(Officer officer);
   Officer findById(int id);
    List<Officer> findAll();
    void deleteById(int id);
    void deleteALL();
    void delete(Officer officer);
    long count();
}
