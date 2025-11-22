//package services;
//
//import data.lastma-app.data.models.data.Officer;
//import data.lastma-app.data.repositories.data.OfficerRepository;
//import lastma-app.requests.dtos.requests.dtos.RegisterOfficerRequest;
//import lastma-app.OfficerExists;
//import org.junit.jupiter.api.AfterEach;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Test;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//public class officerServiceTest {
//    private OfficerService officerService;
//    private OfficerRepository officerRepository;
//
//    @BeforeEach
//    void setUp() {
//        officerService = new officerServiceImpl();
//        officerRepository = new Officers();
//    }
//
//    @AfterEach
//    void tearDown() {
//        officerRepository.deleteALL();
//    }
//
//    @Test
//    @DisplayName("test i can register an officer ")
//    void registerOfficer() {
//        RegisterOfficerRequest request = new RegisterOfficerRequest();
//        officerService.registerOfficer(request);
//        assertEquals(1,officerRepository.count());
//    }
//    @Test
//    @DisplayName("test when i register twice")
//    public void register_Twice(){
//        RegisterOfficerRequest request = new RegisterOfficerRequest();
//        request.setNin("2444");
//        officerService.registerOfficer(request);
//        assertEquals(1,officerRepository.count());
//        assertThrows(OfficerExists.class,()->officerService.registerOfficer(request));
//    }
//
//    @Test
//    @DisplayName("test that the registered officer nin")
//    public void register(){
//        RegisterOfficerRequest request = new RegisterOfficerRequest();
//        request.setNin("2444");
//        officerService.registerOfficer(request);
//        assertEquals(officerRepository.count(),1);
////        String nin = officerRepository.findByNin("2444").getNin();
//    }
//
//}