/*
 */
package com.springeetravel.businesssvcs;

import com.springeetravel.SpringApplicationContextTest;
import com.springeetravel.domain.AirSegment;
import com.springeetravel.domain.FlightDetail;
import java.util.Calendar;
import java.util.Date;
import org.junit.*;
import static org.junit.Assert.*;

/**
 *
 * @author peter
 */
public class FlightManagerTest extends SpringApplicationContextTest {

    private static FlightManager instance;

    public FlightManagerTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
        instance = (FlightManager) springContext.getBean("flightManager");
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
     * Test of createFlight method, of class FlightManager.
     */
    @Test
    public void testCreateFlight() {
        System.out.println("createFlight");
        Date time = Calendar.getInstance().getTime();
        String departureAirportCode = "JFK";
        Date departureTime = time;
        String arrivalAirportCode = "DEN";
        Date arrivalTime = time;
        String airline = "American Airlines";
        String airlineCode = "AA";
        String airlineFlightNumber = "AA4829";
        String classOfService = "Economy";
        double price = 220.00;
        AirSegment airSegmentId = null;
        boolean expResult = true;
        FlightDetail result = instance.createFlight(departureAirportCode, departureTime, arrivalAirportCode, arrivalTime, airline, airlineCode, airlineFlightNumber, classOfService, price);
        assertEquals(expResult, result.getId() != null);
    }
}
