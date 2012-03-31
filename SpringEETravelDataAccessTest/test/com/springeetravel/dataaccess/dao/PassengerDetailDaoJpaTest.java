/*
 */
package com.springeetravel.dataaccess.dao;

import com.springeetravel.SpringApplicationContextTest;
import com.springeetravel.dataaccess.dao.jpa.PassengerDetailDaoJpa;
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
public class PassengerDetailDaoJpaTest extends SpringApplicationContextTest {

    private static PassengerDetailDao instance;

    public PassengerDetailDaoJpaTest() {
        instance = (PassengerDetailDao) springContext.getBean("passengerDetailDao");
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
     * Test of create method, of class PassengerDetailDaoJpa.
     */
    @Test
    public void testCreate() {
        System.out.println("create");

        Calendar cal = Calendar.getInstance();
        Date time = cal.getTime();

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

        instance.create(passengerDetail);

        boolean expResult = true;
        assertEquals(expResult, passengerDetail.getId()!=null);
    }

    /**
     * Test of edit method, of class PassengerDetailDaoJpa.
     */
//    @Test
    public void testEdit() {
        System.out.println("edit");
        PassengerDetail passengerDetail = null;
        PassengerDetailDaoJpa instance = new PassengerDetailDaoJpa();
        instance.edit(passengerDetail);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of destroy method, of class PassengerDetailDaoJpa.
     */
//    @Test
    public void testDestroy() {
        System.out.println("destroy");
        Long id = null;
        PassengerDetailDaoJpa instance = new PassengerDetailDaoJpa();
        instance.destroy(id);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of find method, of class PassengerDetailDaoJpa.
     */
//    @Test
    public void testFind_0args() {
        System.out.println("find");
        PassengerDetailDaoJpa instance = new PassengerDetailDaoJpa();
        List expResult = null;
        List result = instance.find();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of find method, of class PassengerDetailDaoJpa.
     */
//    @Test
    public void testFind_int_int() {
        System.out.println("find");
        int maxResults = 0;
        int firstResult = 0;
        PassengerDetailDaoJpa instance = new PassengerDetailDaoJpa();
        List expResult = null;
        List result = instance.find(maxResults, firstResult);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of find method, of class PassengerDetailDaoJpa.
     */
//    @Test
    public void testFind_Long() {
        System.out.println("find");
        Long id = null;
        PassengerDetailDaoJpa instance = new PassengerDetailDaoJpa();
        PassengerDetail expResult = null;
        PassengerDetail result = instance.find(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCount method, of class PassengerDetailDaoJpa.
     */
//    @Test
    public void testGetCount() {
        System.out.println("getCount");
        PassengerDetailDaoJpa instance = new PassengerDetailDaoJpa();
        int expResult = 0;
        int result = instance.getCount();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findAllForeignPassengers method, of class PassengerDetailDaoJpa.
     */
//    @Test
    public void testFindAllForeignPassengers() {
        System.out.println("findAllForeignPassengers");
        String flightNumber = "";
        Date flightDate = null;
        PassengerDetailDaoJpa instance = new PassengerDetailDaoJpa();
        List expResult = null;
        List result = instance.findAllForeignPassengers(flightNumber, flightDate);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findSpecialCustomers method, of class PassengerDetailDaoJpa.
     */
//    @Test
    public void testFindSpecialCustomers() {
        System.out.println("findSpecialCustomers");
        String flightNumber = "";
        Date flightDate = null;
        PassengerDetailDaoJpa instance = new PassengerDetailDaoJpa();
        List expResult = null;
        List result = instance.findSpecialCustomers(flightNumber, flightDate);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}
