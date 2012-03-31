/*
 */
package com.springeetravel.businesssvcs;

import com.springeetravel.domain.AirSegment;
import com.springeetravel.domain.FormOfPayment;
import com.springeetravel.domain.PassengerDetail;
import com.springeetravel.domain.FlightDetail;
import com.springeetravel.domain.UniversalRecord;
import java.util.*;

/**
 *
 * @author peter
 */
public abstract class AbstractUniversalRecordManager {

    public AbstractUniversalRecordManager() {
    }

    public List<AirSegment> createAirSegments(FlightDetail departureFlight, FlightDetail arrivalFlight, PassengerDetail passengerDetail, FormOfPayment formOfPayment) {
        List<AirSegment> airSegments = new ArrayList<AirSegment>();
        Date time = GregorianCalendar.getInstance().getTime();
        //
        AirSegment departureAirSegment = new AirSegment();
        departureAirSegment.setCreateDate(time);
        departureAirSegment.setFlightDetail(departureFlight);
        PassengerDetail passengerDetail1 = new PassengerDetail(passengerDetail.getFirstName(), passengerDetail.getLastName(), passengerDetail.getInitials(), passengerDetail.getContactPhone(), passengerDetail.getContactEmail(), passengerDetail.getCountryOfResidenceCode(), passengerDetail.getCountryOfNationalityCode(), passengerDetail.getPassportId(), passengerDetail.getDateOfBirth(), passengerDetail.getValuedCustomer());
        FormOfPayment formOfPayment1 = new FormOfPayment(formOfPayment.getFormOfPaymentType(), formOfPayment.getCreditCardNumber(), formOfPayment.getCreditCardName(), formOfPayment.getCreditExpiry(), formOfPayment.getCreditCcid());
        departureAirSegment.setPassengerDetailList(Arrays.asList(new PassengerDetail[]{passengerDetail1}));
        departureAirSegment.setFormOfPaymentList(Arrays.asList(new FormOfPayment[]{formOfPayment1}));
        airSegments.add(departureAirSegment);
        //
        AirSegment arrivalAirSegment = new AirSegment();
        arrivalAirSegment.setCreateDate(time);
        arrivalAirSegment.setFlightDetail(arrivalFlight);
        PassengerDetail passengerDetail2 = new PassengerDetail(passengerDetail.getFirstName(), passengerDetail.getLastName(), passengerDetail.getInitials(), passengerDetail.getContactPhone(), passengerDetail.getContactEmail(), passengerDetail.getCountryOfResidenceCode(), passengerDetail.getCountryOfNationalityCode(), passengerDetail.getPassportId(), passengerDetail.getDateOfBirth(), passengerDetail.getValuedCustomer());
        FormOfPayment formOfPayment2 = new FormOfPayment(formOfPayment.getFormOfPaymentType(), formOfPayment.getCreditCardNumber(), formOfPayment.getCreditCardName(), formOfPayment.getCreditExpiry(), formOfPayment.getCreditCcid());
        arrivalAirSegment.setPassengerDetailList(Arrays.asList(new PassengerDetail[]{passengerDetail2}));
        arrivalAirSegment.setFormOfPaymentList(Arrays.asList(new FormOfPayment[]{formOfPayment2}));
        airSegments.add(arrivalAirSegment);
        //
        return airSegments;
    }

    public UniversalRecord createUniversalRecord(FlightDetail departureFlight, FlightDetail arrivalFlight, PassengerDetail passengerDetail, FormOfPayment formOfPayment) {
        List<AirSegment> airSegments = createAirSegments(departureFlight, arrivalFlight, passengerDetail, formOfPayment);
        return createUniversalRecord(airSegments.toArray(new AirSegment[]{}));
    }

    public UniversalRecord createUniversalRecord(AirSegment... airSegments) {
        UniversalRecord ur = new UniversalRecord();
        Date time = GregorianCalendar.getInstance().getTime();
        ur.setCreateDate(time);
        for (AirSegment each : airSegments) {
            each.setUniversalRecordId(ur);
        }
        ur.setAirSegmentList(Arrays.asList(airSegments));
        saveUniversalRecord(ur);
        return ur;
    }

    abstract public void saveUniversalRecord(UniversalRecord ur);

    abstract public UniversalRecord retrieveUniversalRecord(String id);

    abstract public int countUniversalRecord();
}
