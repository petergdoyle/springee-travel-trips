/*
 */
package com.travelport.business;

import com.travelport.dataaccess.AirSegmentDao;
import com.travelport.dataaccess.FlightDao;
import com.travelport.dataaccess.UniversalRecordDao;
import com.travelport.domain.*;
import java.util.Date;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Named;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author peter
 */
@Named("universalRecordManager")
@Transactional
public class UniversalRecordManager {

    @Inject
    @Named("universalRecordDao")
    private UniversalRecordDao universalRecordDao;
    @Inject
    @Named("airSegmentDao")
    private AirSegmentDao airSegmentDao;
    
    public AirSegment createAirSegment(Flight departureFlight, Flight arrivalFlight, PassengerDetail passengerDetail, FormOfPayment formOfPayment) {
        AirSegment airSegment = new AirSegment();
        airSegment.getFormOfPaymentList().add(formOfPayment);
        airSegment.getPassengerDetailList().add(passengerDetail);
        airSegment.getFlightList().add(departureFlight);
        airSegment.getFlightList().add(arrivalFlight);
        return airSegment;
    }

    public UniversalRecord createUniversalRecord(List<AirSegment> airSegments) {
        UniversalRecord ur = new UniversalRecord();
        ur.getAirSegmentList().addAll(airSegments);
        universalRecordDao.create(ur);
        return ur;
    }
}
