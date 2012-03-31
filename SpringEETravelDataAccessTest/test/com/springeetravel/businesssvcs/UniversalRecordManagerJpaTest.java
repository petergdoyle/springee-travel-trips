/*
 */
package com.springeetravel.businesssvcs;

import com.springeetravel.SpringApplicationContextTest;
import com.springeetravel.domain.FlightDetail;
import com.springeetravel.domain.FormOfPayment;
import com.springeetravel.domain.PassengerDetail;
import com.springeetravel.domain.UniversalRecord;
import java.util.Calendar;
import java.util.Date;
import org.junit.*;
import static org.junit.Assert.*;

/**
 *
 * @author peter
 */
public class UniversalRecordManagerJpaTest extends SpringApplicationContextTest {

    private static UniversalRecordManager instance;

    public UniversalRecordManagerJpaTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
        instance = (UniversalRecordManager) springContext.getBean("universalRecordManagerJpa");
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
     * Test of createAirSegment method, of class UniversalRecordManagerJpa.
     */
    @Test
    public void testCreateAirSegment() {
        System.out.println("createAirSegment");
    }

    /**
     * Test of createUniversalRecord method, of class UniversalRecordManagerJpa.
     */
    @Test
    public void testCreateUniversalRecord() {
        System.out.println("createUniversalRecord");
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
        String contactPhone = "(303)764-2311";
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
        UniversalRecord result = instance.createUniversalRecord(departureFlight, arrivalFlight, passengerDetail, formOfPayment);
        assertEquals(expResult, result.getId() != null);

        System.out.println("success");
    }

    /**
     * Test of createUniversalRecord method, of class UniversalRecordManagerJpa.
     */
    @Test
    public void testValidationFailureCreateUniversalRecord() {
        System.out.println("createUniversalRecord");
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
        String contactPhone = "3037642311";
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
        UniversalRecord result = null;
        try {
            result = instance.createUniversalRecord(departureFlight, arrivalFlight, passengerDetail, formOfPayment);
        } catch (javax.validation.ConstraintViolationException cve) {
            assertEquals(expResult, cve.getConstraintViolations().size() > 0);
        }

        System.out.println("success");
    }
}
