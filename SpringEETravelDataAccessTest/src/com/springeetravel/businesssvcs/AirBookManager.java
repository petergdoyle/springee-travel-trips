/*
 */
package com.springeetravel.businesssvcs;

import com.springeetravel.domain.AvailableFlight;
import com.springeetravel.domain.FlightDetail;
import com.springeetravel.domain.FormOfPayment;
import com.springeetravel.domain.UniversalRecord;
import com.springeetravel.domain.PassengerDetail;
import com.springeetravel.dataaccess.dao.AvailableFlightDao;
import com.springeetravel.dataaccess.dao.FlightDetailDao;
import java.io.Serializable;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author peter
 */
@Named("airBookManager")
public class AirBookManager implements Serializable {

    private static final long serialVersionUID = -7114942495679762999L;
    @Named("universalRecordManagerJpa")
    @Inject
    private UniversalRecordManager universalRecordManager;
    @Named("flightDetailDao")
    @Inject
    private FlightDetailDao flightDetailDao;
    @Named("availableFlightDao")
    @Inject
    private AvailableFlightDao availableFlightDao;

    public FlightDetail findFlightByAvailableFlight(Long availableFlightId) {
        AvailableFlight availableFlight = availableFlightDao.find(availableFlightId);
        FlightDetail flightDetail = new FlightDetail();
        flightDetail.setAirline(availableFlight.getAirline());
        flightDetail.setAirlineCode(availableFlight.getAirlineCode());
        flightDetail.setAirlineFlightNumber(availableFlight.getAirlineFlightNumber());
        flightDetail.setArrivalAirportCode(availableFlight.getArrivalAirportCode());
        flightDetail.setArrivalTime(availableFlight.getArrivalTime());
        flightDetail.setClassOfService(availableFlight.getClassOfService());
        flightDetail.setDepartureAirportCode(availableFlight.getDepartureAirportCode());
        flightDetail.setDepartureTime(availableFlight.getDepartureTime());
        flightDetail.setPrice(availableFlight.getPrice());
        return flightDetail;
    }

    public UniversalRecord book(FlightDetail departureFlight, FlightDetail returnFlight, PassengerDetail passengerDetail, FormOfPayment formOfPayment) {
        //        AirSegment airSegment = universalRecordManager.createAirSegment(departureFlight, returnFlight, passengerDetail, formOfPayment);
        //        UniversalRecord universalRecord = universalRecordManager.createUniversalRecord(Arrays.asList(new AirSegment[]{airSegment}));
        UniversalRecord universalRecord = universalRecordManager.createUniversalRecord(departureFlight, returnFlight, passengerDetail, formOfPayment);
        return universalRecord;
    }

    public FormOfPayment getInializedFormOfPaymentInstance() {
        FormOfPayment fop = new FormOfPayment();
        fop.setCreditCardName("Peter G Doyle");
        fop.setCreditCardNumber("3999 2992 92992711");
        fop.setCreditCcid("900");
        fop.setCreditExpiry("10/12");
        fop.setFormOfPaymentType("VS");
        return fop;
    }

    public PassengerDetail getInializedPassengerDetailInstance() {
        PassengerDetail passenger = new PassengerDetail();
        passenger.setContactEmail("peter.g.doyle@comcast.net");
        passenger.setContactPhone("(303)765-3487");
        passenger.setCountryOfNationalityCode("CAN");
        passenger.setCountryOfResidenceCode("USA");
        passenger.setFirstName("Peter");
        passenger.setInitials("G");
        passenger.setLastName("Doyle");
        passenger.setPassportId("A2003999-33");
        return passenger;
    }
}
