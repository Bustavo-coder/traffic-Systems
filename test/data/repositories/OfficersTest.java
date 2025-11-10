package data.repositories;

import data.models.Officer;
import exceptions.OfficerNotFound;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class OfficersTest {
    private Officers officers;
    @BeforeEach
    public void setUp(){
        officers = new Officers();
    }

    @Test
    @DisplayName("test that i don't have any Officers")
    public void no_Officers(){
        assertEquals(0,officers.count());
    }

    @Test
    @DisplayName("test when i add a Vehicles")
    public void add_Officer(){
        assertEquals(0,officers.count());
        Officer officer = new Officer("Officer1");
        officers.save(officer);
        assertEquals(1, officers.count());
    }

    @Test
    @DisplayName("test that when i add an officer i can locate the officer by is id")
    public void locate_Officer(){
        Officer  officer = new Officer("Officer2");
        officers.save(officer);
        Officer savedOfficer = officers.findById(officer.getId());
        assertEquals(officer.getId(), savedOfficer.getId());
    }

    @Test
    @DisplayName("test that when i add two officers i can get two by there id")
    public void add_twoOfficer_andFind(){
        Officer  officer1 = new Officer("Officer2");
        officers.save(officer1);
        Officer savedOfficer1 = officers.findById(officer1.getId());
        Officer  officer2 = new Officer("Officer3");
        officers.save(officer2);
        Officer savedOfficer2 = officers.findById(officer2.getId());
        assertEquals(officer1.getId(),savedOfficer1.getId());
        assertEquals(officer2.getId(),2);
    }

    @Test
    @DisplayName("find officer by incorrectId")
    public void find_Un_Registerd_Officer(){
        assertThrows(OfficerNotFound.class,()->officers.findById(7000));
    }

    @Test
    @DisplayName("test that i can delete an officer by his id and my officer reduce")
    public void add_delete_By_Id(){
        Officer  officer1 = new Officer("Officer2");
        officers.save(officer1);
        officers.deleteById(officer1.getId());
        assertEquals(officers.count(),0);
    }

    @Test
    @DisplayName("test that when i delete a user he is not more in our database")
    public void delete_nd_Check(){
        Officer  officer1 = new Officer("Officer2");
        officers.save(officer1);
        officers.deleteById(officer1.getId());
        assertEquals(0, officers.count());
        assertThrows(OfficerNotFound.class,()-> officers.findById(officer1.getId()));
    }

    @Test
    @DisplayName("test that when i delete an officer by id the officer Id Is Back to default state")
    public void setOfficer_idBackToDefault(){
        Officer  officer1 = new Officer("Officer2");
        officers.save(officer1);
        officers.deleteById(officer1.getId());
        assertEquals(0,officer1.getId());
    }

    @Test
    @DisplayName("test that i can delete officer with officer")
    public void delete_Officer(){
        Officer  officer1 = new Officer("Officer2");
        officers.save(officer1);
        officers.delete(officer1);
        assertEquals(0, officers.count());
        assertThrows(OfficerNotFound.class,()-> officers.findById(officer1.getId()));
    }

    @Test
    @DisplayName("test that i can lay off all my officers")
    public void layOff_Officer(){
        Officer  officer1 = new Officer("Officer2");
        officers.save(officer1);
        Officer savedOfficer1 = officers.findById(officer1.getId());
        Officer  officer2 = new Officer("Officer3");
        officers.save(officer2);
        officers.deleteALL();
        assertEquals(officers.count(),0);
    }

    @Test
    @DisplayName("Test that when i tried deleting with and invalid id")
    public void deleteBy_WrongId(){
        assertThrows(OfficerNotFound.class,()-> officers.deleteById(90000));
    }










}