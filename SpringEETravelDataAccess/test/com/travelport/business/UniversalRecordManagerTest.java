/*
 */
package com.travelport.business;

import com.travelport.SpringApplicationContextTest;
import com.travelport.domain.*;
import java.util.List;
import org.junit.*;
import static org.junit.Assert.*;

/**
 *
 * @author peter
 */
public class UniversalRecordManagerTest extends SpringApplicationContextTest {

    private static UniversalRecordManager instance;

    public UniversalRecordManagerTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
        instance = (UniversalRecordManager) springContext.getBean("universalRecordManager");
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
     * Test of createAirSegment method, of class UniversalRecordManager.
     */
    @Test
    public void testCreateAirSegment() {
        System.out.println("createAirSegment");
        Flight departureFlight = null;
        Flight arrivalFlight = null;
        PassengerDetail passengerDetail = null;
        FormOfPayment formOfPayment = null;
        AirSegment expResult = null;
        AirSegment result = instance.createAirSegment(departureFlight, arrivalFlight, passengerDetail, formOfPayment);
        assertEquals(expResult, result);
        System.out.println("success");
    }

    /**
     * Test of createUniversalRecord method, of class UniversalRecordManager.
     */
    @Test
    public void testCreateUniversalRecord() {
        System.out.println("createUniversalRecord");
        List<AirSegment> airSegments = null;
        UniversalRecord expResult = null;
        UniversalRecord result = instance.createUniversalRecord(airSegments);
        assertEquals(expResult, result);
        System.out.println("success");
    }
}
