/*
 */
package com.springeetravel.businesssvcs;

import com.springeetravel.dataaccess.dao.PassengerDetailDao;
import com.springeetravel.domain.PassengerDetail;
import java.util.Date;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author peter
 */
@Named("passengerDetailManager")
public class PassengerDetailManager {

    @Inject
@Named("passengerDetailRepository")
    private PassengerDetailDao dao;

    public List<PassengerDetail> retrieveForeignCustomersForCustomsDeclarations(String flightNumber, Date flightDate) {
        return dao.findAllForeignPassengers(flightNumber, flightDate);
    }

    public List<PassengerDetail> retrieveCustomersEligibleForUpgrades(String flightNumber, Date flightDate) {
        return dao.findSpecialCustomers(flightNumber, flightDate);
    }
    
}
