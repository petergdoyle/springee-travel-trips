/*
 */
package com.springeetravel.businesssvcs;

import com.springeetravel.SpringApplicationContextTest;
import com.springeetravel.domain.AirSearchCriteria;
import com.springeetravel.domain.AvailableFlight;
import org.junit.*;
import static org.junit.Assert.*;

/**
 *
 * @author peter
 */
public class AirSearchResultsManagerTest extends SpringApplicationContextTest {

    public AirSearchResultsManagerTest() {
    }
    private static AirSearchResultsManager instance;

    @BeforeClass
    public static void setUpClass() throws Exception {
        instance = (AirSearchResultsManager) springContext.getBean("airSearchResultsManager");
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
     * Test of searchDepartureFlights method, of class AirSearchResultsManager.
     */
    @Test
    public void testSearchDepartureFlights() {
        System.out.print("searchDepartureFlights");
        AirSearchCriteria airSearchCriteria = new AirSearchCriteria();
        airSearchCriteria.setDepartureAirportCode("DEN");
        airSearchCriteria.setArrivalAirportCode("JFK");
        boolean expResult = true;
        Iterable<AvailableFlight> result = instance.searchDepartureFlights(airSearchCriteria);
        assertEquals(expResult, result.iterator().hasNext());
        System.out.println("\tsuccess");
    }

    /**
     * Test of searchReturnFlights method, of class AirSearchResultsManager.
     */
    @Test
    public void testSearchReturnFlights() {
        System.out.print("searchReturnFlights");
        AirSearchCriteria airSearchCriteria = new AirSearchCriteria();
        airSearchCriteria.setDepartureAirportCode("JFK");
        airSearchCriteria.setArrivalAirportCode("DEN");
        boolean expResult = true;
        Iterable<AvailableFlight> result = instance.searchReturnFlights(airSearchCriteria);
        assertEquals(expResult, result.iterator().hasNext());
        System.out.println("\tsuccess");
    }
}
