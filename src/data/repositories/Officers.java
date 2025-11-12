package data.repositories;

import data.models.Officer;
import exceptions.OfficerNotFound;

import java.util.HashMap;
public class Officers implements OfficerRepository{
    private int count;
    private HashMap<Integer,Officer> listOfOfficers = new HashMap<>();

    @Override
    public Officer save(Officer officer) {
       registerNew(officer);
       listOfOfficers.put(officer.getId(),officer);
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
    }

    @Override
    public void deleteALL() {
        listOfOfficers.clear();
    }

    @Override
    public void delete(Officer officer) {
        int id = officer.getId();
        deleteById(id);
    }

    @Override
    public long count() {
        return listOfOfficers.size();
    }

    public Officer findByNin(String nin){
        for(Officer officer : listOfOfficers.values()){
            if(officer.getNin().equals(nin)) return officer;
        }
        return null;
    }

    private int generate(){
        return count + 1;
    }
    private void validateOfficerId(int id){
        if (!listOfOfficers.containsKey(id)) throw new OfficerNotFound("Officer Is Not Yet Registered");
    }
    private Boolean isNew(Officer officer){
        return officer.getId() == 0;

    }
    private void registerNew(Officer officer){
        if(isNew(officer)) {
            officer.setId(generate());
            count++;
        }
    }
}
