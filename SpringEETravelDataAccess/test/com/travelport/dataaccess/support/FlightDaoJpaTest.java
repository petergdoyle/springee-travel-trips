/*
 */
package com.travelport.dataaccess.support;

import com.travelport.SpringApplicationContextTest;
import com.travelport.dataaccess.FlightDao;
import com.travelport.domain.Flight;
import java.util.Calendar;
import java.util.Date;
import org.junit.*;

/**
 *
 * @author peter
 */
public class FlightDaoJpaTest extends SpringApplicationContextTest {

    private static FlightDao instance;

    public FlightDaoJpaTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
        instance = (FlightDao) springContext.getBean("flightDao");
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
     * Test of create method, of class FlightDaoJpa.
     */
    @Test
    public void testCreate() {
        System.out.println("create");
        Date time = Calendar.getInstance().getTime();
        Flight flight = new Flight();
        flight.setAirline("American Airlines");
        flight.setAirlineCode("AA");
        flight.setAirlineFlightNumber("AA3929");
        flight.setArrivalTime(time);
        flight.setArrivalAirportCode("JFK");
        flight.setClassOfService("Economy");
        flight.setDepartureAirportCode("DEN");
        flight.setDepartureTime(time);
        flight.setPrice(220.00);
        instance.create(flight);
        System.out.println("success");
    }
//
//    /**
//     * Test of edit method, of class FlightDaoJpa.
//     */
//    @Test
//    public void testEdit() throws Exception {
//        System.out.println("edit");
//        Flight flight = null;
//        FlightDaoJpa instance = new FlightDaoJpa();
//        instance.edit(flight);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of destroy method, of class FlightDaoJpa.
//     */
//    @Test
//    public void testDestroy() {
//        System.out.println("destroy");
//        Long id = null;
//        FlightDaoJpa instance = new FlightDaoJpa();
//        instance.destroy(id);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of findFlightEntities method, of class FlightDaoJpa.
//     */
//    @Test
//    public void testFindFlightEntities_0args() {
//        System.out.println("findFlightEntities");
//        FlightDaoJpa instance = new FlightDaoJpa();
//        List expResult = null;
//        List result = instance.findFlightEntities();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of findFlightEntities method, of class FlightDaoJpa.
//     */
//    @Test
//    public void testFindFlightEntities_int_int() {
//        System.out.println("findFlightEntities");
//        int maxResults = 0;
//        int firstResult = 0;
//        FlightDaoJpa instance = new FlightDaoJpa();
//        List expResult = null;
//        List result = instance.findFlightEntities(maxResults, firstResult);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of findFlight method, of class FlightDaoJpa.
//     */
//    @Test
//    public void testFindFlight() {
//        System.out.println("findFlight");
//        Long id = null;
//        FlightDaoJpa instance = new FlightDaoJpa();
//        Flight expResult = null;
//        Flight result = instance.findFlight(id);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of getFlightCount method, of class FlightDaoJpa.
//     */
//    @Test
//    public void testGetFlightCount() {
//        System.out.println("getFlightCount");
//        FlightDaoJpa instance = new FlightDaoJpa();
//        int expResult = 0;
//        int result = instance.getFlightCount();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//}
}
