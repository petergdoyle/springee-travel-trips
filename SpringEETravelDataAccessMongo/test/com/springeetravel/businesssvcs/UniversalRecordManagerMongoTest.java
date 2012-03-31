/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.springeetravel.businesssvcs;

import com.springeetravel.domain.PassengerDetail;
import com.springeetravel.domain.AirSegment;
import com.springeetravel.domain.FormOfPayment;
import com.springeetravel.domain.FlightDetail;
import com.springeetravel.domain.UniversalRecord;
import com.springeetravel.businesssvcs.UniversalRecordManagerMongo;
import com.springeetravel.SpringApplicationContextTest;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import org.junit.*;
import static org.junit.Assert.*;

/**
 *
 * @author peter
 */
public class UniversalRecordManagerMongoTest extends SpringApplicationContextTest{
    
    private static UniversalRecordManagerMongo instance;

    public UniversalRecordManagerMongoTest() {
        instance = (UniversalRecordManagerMongo) springContext.getBean("universalRecordManagerMongo");
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of saveUniversalRecord method, of class UniversalRecordManagerMongo.
     */
    @Test
    public void testSaveUniversalRecord() {
        System.out.print("saveUniversalRecord");
        
        Calendar cal = Calendar.getInstance();
        Date time = cal.getTime();
        String departureAirportCode = "JFK";
        Date departureTime = time;
        String arrivalAirportCode = "DEN";
        Date arrivalTime = time;
        String airline = "American Airlines";
        String airlineCode = "AA";
        String airlineFlightNumber = "AA4829";
        String classOfService = "Economy";
        double price = 220.00;

        FlightDetail departureFlight = new FlightDetail();
        departureFlight.setAirline(airline);
        departureFlight.setAirlineCode(airlineCode);
        departureFlight.setAirlineFlightNumber(airlineFlightNumber);
        departureFlight.setArrivalAirportCode(arrivalAirportCode);
        departureFlight.setArrivalTime(arrivalTime);
        departureFlight.setClassOfService(classOfService);
        departureFlight.setDepartureAirportCode(departureAirportCode);
        departureFlight.setDepartureTime(departureTime);
        departureFlight.setPrice(price);

        FlightDetail arrivalFlight = new FlightDetail();
        arrivalFlight.setAirline(airline);
        arrivalFlight.setAirlineCode(airlineCode);
        arrivalFlight.setAirlineFlightNumber(airlineFlightNumber);
        arrivalFlight.setArrivalAirportCode(departureAirportCode);
        arrivalFlight.setArrivalTime(arrivalTime);
        arrivalFlight.setClassOfService(classOfService);
        arrivalFlight.setDepartureAirportCode(arrivalAirportCode);
        arrivalFlight.setDepartureTime(departureTime);
        arrivalFlight.setPrice(price);

        String firstName = "David";
        String lastName = "Jones";
        String initials = "M. H.";
        String contactPhone = "303 764 2311";
        String contactEmail = "djones@home.com";
        String countryOfResidenceCode = "CAN";
        String countryOfNationality = "CAN";
        String passportId = "A1001229";
        Boolean valuedCustomer = Boolean.TRUE;

        PassengerDetail passengerDetail = new PassengerDetail();
        passengerDetail.setAirSegmentId(null);
        passengerDetail.setContactEmail(contactEmail);
        passengerDetail.setContactPhone(contactPhone);
        passengerDetail.setCountryOfNationalityCode(countryOfNationality);
        passengerDetail.setCountryOfResidenceCode(countryOfResidenceCode);
        passengerDetail.setFirstName(firstName);
        passengerDetail.setInitials(initials);
        passengerDetail.setLastName(lastName);
        passengerDetail.setPassportId(passportId);
        passengerDetail.setValuedCustomer(valuedCustomer);
        cal.roll(Calendar.YEAR, -30);
        Date dob = cal.getTime();
        passengerDetail.setDateOfBirth(dob);

        String formOfPaymentType = "CC";
        String creditCardNumber = "2921 1929 1281 3282";
        String creditCardName = "Visa";
        String creditExpiry = "02/13";
        String creditCcid = "320";

        FormOfPayment formOfPayment = new FormOfPayment();
        formOfPayment.setCreditCardName(creditCardName);
        formOfPayment.setCreditCardNumber(creditCardNumber);
        formOfPayment.setCreditCcid(creditCcid);
        formOfPayment.setCreditExpiry(creditExpiry);
        formOfPayment.setFormOfPaymentType(formOfPaymentType);

        boolean expResult = true;
        List<AirSegment> airSegments = instance.createAirSegments(departureFlight, arrivalFlight, passengerDetail, formOfPayment);
        UniversalRecord result = new UniversalRecord();
        result.setAirSegmentList(airSegments);
        
        instance.saveUniversalRecord(result);
        assertEquals(expResult, result.getId() != null);
        
        System.out.println("\tsuccess");
        
    }

    /**
     * Test of retrieveUniversalRecord method, of class
     * UniversalRecordManagerMongo.
     */
    @Test
    public void testRetrieveUniversalRecord() {
        System.out.print("retrieveUniversalRecord");
        String id = "4f72e4b3e4b08b77ba0da927";
        boolean expResult = true;
        UniversalRecord result = instance.retrieveUniversalRecord(id);
        assertEquals(expResult, result.getId().equals(id));
        System.out.println("\tsuccess");
        System.out.println(result);
    }

    /**
     * Test of countUniversalRecord method, of class
     * UniversalRecordManagerMongo.
     */
//    @Test
    public void testCountUniversalRecord() {
        System.out.println("countUniversalRecord");
        int expResult = 0;
        int result = instance.countUniversalRecord();
    }
}
