/*
 */
package com.springeetravel.businesssvcs;

import com.springeetravel.domain.*;
import java.util.List;

/**
 *
 * @author peter
 */
public interface UniversalRecordManager {

    int countUniversalRecord();

    List<AirSegment> createAirSegments(FlightDetail departureFlight, FlightDetail arrivalFlight, PassengerDetail passengerDetail, FormOfPayment formOfPayment);

    UniversalRecord createUniversalRecord(FlightDetail departureFlight, FlightDetail arrivalFlight, PassengerDetail passengerDetail, FormOfPayment formOfPayment);

    UniversalRecord createUniversalRecord(AirSegment... airSegments);

    UniversalRecord retrieveUniversalRecord(Long id);

    void saveUniversalRecord(UniversalRecord ur);
    
}
