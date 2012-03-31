/*
 */
package com.springeetravel.businesssvcs;

import com.springeetravel.SpringApplicationContextTest;
import com.springeetravel.dataaccess.dao.PassengerDetailDao;
import com.springeetravel.domain.PassengerDetail;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import org.junit.*;
import static org.junit.Assert.*;

/**
 *
 * @author peter
 */
public class PassengerDetailManagerTest extends SpringApplicationContextTest {

    private static PassengerDetailManager instance;
    private static PassengerDetailDao dao;

    public PassengerDetailManagerTest() {
        instance = (PassengerDetailManager) springContext.getBean("passengerDetailManager");
        dao = (PassengerDetailDao) springContext.getBean("passengerDetailDao");
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
     * Test of retrieveForeignCustomers method, of class PassengerDetailManager.
     */
    @Test
    public void testRetrieveForeignCustomersForCustomsDeclarations() {
        
        System.out.print("retrieveForeignCustomersForCustomsDeclarations");
        Calendar cal = Calendar.getInstance();
        Date time = cal.getTime();

        String flightNumber = "AA4829";
        Date flightDate = time;
        String firstName = "David";
        String lastName = "Jones";
        String initials = "M. H.";
        String contactPhone = "(303)764-2314";
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

        dao.create(passengerDetail);
        
        boolean expResult = true;
        List<PassengerDetail> result = instance.retrieveForeignCustomersForCustomsDeclarations(flightNumber, flightDate);
        assertEquals(expResult, result.size() > 0);
        System.out.println("\tsuccess");
        for (PassengerDetail each : result) {
            System.out.println(each);
        }
    }

    /**
     * Test of retrieveCustomersEligibleForUpgrades method, of class
     * PassengerDetailManager.
     */
    @Test
    public void testRetrieveCustomersEligibleForUpgrades() {
        System.out.print("retrieveCustomersEligibleForUpgrades");
        String flightNumber = "AA4829";
        Date flightDate = Calendar.getInstance().getTime();
        boolean expResult = true;
        List<PassengerDetail> result = instance.retrieveCustomersEligibleForUpgrades(flightNumber, flightDate);
        assertEquals(expResult, result.size() > 0);
        System.out.println("\tsuccess");
        for (PassengerDetail each : result) {
            System.out.println(each);
        }
    }
}
