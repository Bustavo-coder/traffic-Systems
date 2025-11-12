package services;

import data.repositories.OfficerRepository;
import data.repositories.Officers;
import dtos.requests.RegisterOfficerRequest;
import exceptions.OfficerExists;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class adminOfficerServiceTest {
    private adminOfficerService officerService;
    private OfficerRepository officerRepository;

    @BeforeEach
    void setUp() {
        officerRepository = new Officers();
        officerService = new adminOfficerServiceImpl();
    }

    @AfterEach
    void tearDown() {
        officerRepository.deleteALL();
    }

    @Test
    @DisplayName("test i can register an officer ")
    void registerOfficer() {
        RegisterOfficerRequest request = new RegisterOfficerRequest();
        officerService.registerOfficer(request);
        assertEquals(0,officerRepository.count());
    }
    @Test
    @DisplayName("test when i register twice")
    public void register_Twice(){
        RegisterOfficerRequest request = new RegisterOfficerRequest();
        request.setNin("2444");
        officerService.registerOfficer(request);
        assertEquals(0,officerRepository.count());
        assertThrows(OfficerExists.class,()->officerService.registerOfficer(request));
    }

    @Test
    @DisplayName("test that i can book a ticket")
    public void test_BookAnOfficer(){
        RegisterOfficerRequest request = new RegisterOfficerRequest();

    }
}