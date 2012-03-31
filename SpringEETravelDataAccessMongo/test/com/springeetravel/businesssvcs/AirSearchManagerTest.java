/*
 */
package com.springeetravel.businesssvcs;

import com.springeetravel.businesssvcs.AirSearchManager;
import com.springeetravel.SpringApplicationContextTest;
import com.springeetravel.domain.AirSearchCriteria;
import com.springeetravel.domain.AvailableFlight;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import org.junit.*;
import static org.junit.Assert.*;

/**
 *
 * @author peter
 */
public class AirSearchManagerTest extends SpringApplicationContextTest {

    private static AirSearchManager instance;

    public AirSearchManagerTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
        instance = (AirSearchManager) springContext.getBean("airSearchManager");
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
     * Test of addAvailableFlight method, of class AirSearchManager.
     */
//    @Test
    public void testAddAvailableFlight() {
        System.out.print("addAvailableFlight");

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

        AvailableFlight availableFlight = new AvailableFlight();
        availableFlight.setAirline(airline);
        availableFlight.setAirlineCode(airlineCode);
        availableFlight.setAirlineFlightNumber(airlineFlightNumber);
        availableFlight.setArrivalAirportCode(arrivalAirportCode);
        availableFlight.setArrivalTime(arrivalTime);
        availableFlight.setClassOfService(classOfService);
        availableFlight.setDepartureAirportCode(departureAirportCode);
        availableFlight.setDepartureTime(departureTime);
        availableFlight.setPrice(price);
        instance.addAvailableFlight(availableFlight);

        System.out.println("\tsuccess");
    }

    /**
     * Test of searchDepartureFlights method, of class AirSearchManager.
     */
    @Test
    public void testSearchDepartureFlights() {
        System.out.print("searchDepartureFlights");

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

        AvailableFlight availableFlight = new AvailableFlight();
        availableFlight.setAirline(airline);
        availableFlight.setAirlineCode(airlineCode);
        availableFlight.setAirlineFlightNumber(airlineFlightNumber);
        availableFlight.setArrivalAirportCode(arrivalAirportCode);
        availableFlight.setArrivalTime(arrivalTime);
        availableFlight.setClassOfService(classOfService);
        availableFlight.setDepartureAirportCode(departureAirportCode);
        availableFlight.setDepartureTime(departureTime);
        availableFlight.setPrice(price);
        instance.addAvailableFlight(availableFlight);

        AirSearchCriteria airSearchCriteria = new AirSearchCriteria();
        airSearchCriteria.setDepartureAirportCode(departureAirportCode);
        boolean expResult = true;
        List<AvailableFlight> result = instance.searchDepartureFlights(airSearchCriteria);
        assertEquals(expResult, result.size() > 0);
        System.out.println("\tsuccess");
    }

    /**
     * Test of searchReturnFlights method, of class AirSearchManager.
     */
    @Test
    public void testSearchReturnFlights() {
        System.out.print("searchReturnFlights");
        Calendar cal = Calendar.getInstance();
        Date time = cal.getTime();
        String departureAirportCode = "DEN";
        Date departureTime = time;
        String arrivalAirportCode = "JFK";
        Date arrivalTime = time;
        String airline = "American Airlines";
        String airlineCode = "AA";
        String airlineFlightNumber = "AA4829";
        String classOfService = "Economy";
        double price = 220.00;

        AvailableFlight availableFlight = new AvailableFlight();
        availableFlight.setAirline(airline);
        availableFlight.setAirlineCode(airlineCode);
        availableFlight.setAirlineFlightNumber(airlineFlightNumber);
        availableFlight.setArrivalAirportCode(arrivalAirportCode);
        availableFlight.setArrivalTime(arrivalTime);
        availableFlight.setClassOfService(classOfService);
        availableFlight.setDepartureAirportCode(departureAirportCode);
        availableFlight.setDepartureTime(departureTime);
        availableFlight.setPrice(price);
        instance.addAvailableFlight(availableFlight);

        AirSearchCriteria airSearchCriteria = new AirSearchCriteria();
        airSearchCriteria.setArrivalAirportCode(arrivalAirportCode);

        boolean expResult = true;
        List<AvailableFlight> result = instance.searchReturnFlights(airSearchCriteria);
        assertEquals(expResult, result.size() > 0);

        System.out.println("\tsuccess");
    }
}
