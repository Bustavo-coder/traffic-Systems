package data.repositories;

import data.models.Ticket;
import exceptions.TicketNotFound;

import java.util.HashMap;

public class Tickets implements TicketsRepository {
    private int count;
    private static final HashMap<Integer,Ticket> listOfTicket = new HashMap<>();

    @Override
    public Ticket save(Ticket ticket) {
        saveNew(ticket);
        listOfTicket.put(ticket.getId(),ticket);
        return ticket;
    }

    @Override
    public Ticket findById(int id) {
//        validateId(id);
        return listOfTicket.get(id);
    }

    @Override
    public HashMap<Integer, Ticket> findAll() {
        return listOfTicket;
    }

    @Override
    public void deleteById(int id) {
//        validateId(id);
        listOfTicket.remove(id);
    }

    @Override
    public void deleteALL() {
        listOfTicket.clear();

    }

    @Override
    public void delete(Ticket ticket) {
        int id = ticket.getId();
        deleteById(id);
    }

    @Override
    public long count() {
        return listOfTicket.size();
    }
    private int generateId(){
        return count + 1;
    }
    private boolean isNew(Ticket ticket){
        return ticket.getId() == 0;
    }

    private void saveNew(Ticket ticket){
        if(isNew(ticket)){
            ticket.setId(generateId());
            count++;
        }

    }

//    private void validateId(int id){
//        if(!listOfTicket.containsKey(id)) throw new TicketNotFound("Ticket Not Found");
//    }



}