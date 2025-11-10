package data.repositories;

import data.models.Officer;
import exceptions.OfficerNotFound;

import java.util.HashMap;
public class Officers implements OfficerRepository{
    private int count;
    private HashMap<Integer,Officer> listOfOfficers = new HashMap<>();

    @Override
    public Officer save(Officer officer) {
        officer.setId(generate());
        listOfOfficers.put(officer.getId(),officer);
        count++;
        return officer;
    }

    @Override
    public Officer findById(int id) {
        validateOfficerId(id);
        return listOfOfficers.get(id);
    }

    @Override
    public HashMap<Integer, Officer> findAll() {
        return listOfOfficers;
    }

    @Override
    public void deleteById(int id) {
        validateOfficerId(id);
        listOfOfficers.get(id).setId(0);
        listOfOfficers.remove(id);
        count--;
    }

    @Override
    public void deleteALL() {
        listOfOfficers.clear();
        count = 0;
    }

    @Override
    public void delete(Officer officer) {
        int id = officer.getId();
        deleteById(id);
    }

    @Override
    public long count() {
        return count;
    }

    private int generate(){
        return count + 1;
    }
    private void validateOfficerId(int id){
        if (!listOfOfficers.containsKey(id)) throw new OfficerNotFound("Officer Is Not Yet Registered");
    }
}
