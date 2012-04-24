/*
 */
package com.springeetravel.controller;

import com.springeetravel.domain.UniversalRecord;
import com.springeetravel.manager.UniversalRecordsRetrieveService;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.inject.Inject;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author peter
 */
@Transactional(readOnly = true)
@Controller
@RequestMapping(value = "/UniversalRecord")
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class UniversalRecordRetrieveServiceController {

    public static final String UNIVERSAL_RECORD_XML_VIEW = "universalRecordXmlView";
    @Inject
    private UniversalRecordsRetrieveService service;

    @RequestMapping(value = "/locatorCode/{locatorCode}", method = RequestMethod.GET)
    public ModelAndView getUniversalRecordByLocatorCode(@PathVariable String locatorCode) {
        try {
            UniversalRecord ur = service.retrieveUniversalRecordByLocatorCode(locatorCode);
            return buildModelAndView(ur);
        } catch (Exception ex) {
            log(Level.SEVERE, ex);
            throw new InternalServerErrorException();
        }
    }

    @RequestMapping(value = "/passengerName/{passengerName}", method = RequestMethod.GET)
    public ModelAndView getUniversalRecordByBookingPassengerName(String passengerName) {
        try {
            List<UniversalRecord> urs = service.retrieveUniversalRecordByBookingPassengerName(passengerName);
            return buildModelAndView(urs);
        } catch (Exception ex) {
            log(Level.SEVERE, ex);
            throw new InternalServerErrorException();
        }
    }

    @RequestMapping(value = "/ticketedDateFrom/{fromDate}/ticketedDateTo/{fromDate}", method = RequestMethod.GET)
    public ModelAndView getUniversalRecordByAirTicketedDate(@DateTimeFormat(iso = ISO.DATE) Date fromDate, @DateTimeFormat(iso = ISO.DATE) Date toDate) {
        try {
            List<UniversalRecord> urs = service.retrieveUniversalRecordByAirTicketedDate(fromDate, toDate);
            return buildModelAndView(urs);
        } catch (Exception ex) {
            log(Level.SEVERE, ex);
            throw new InternalServerErrorException();
        }
    }

    @RequestMapping(value = "/agentId/{agentId}", method = RequestMethod.GET)
    public ModelAndView getUniversalRecordByAgent(String agentId) {
        try {
            List<UniversalRecord> urs = service.retrieveUniversalRecordByAgent(agentId);
            return buildModelAndView(urs);
        } catch (Exception ex) {
            log(Level.SEVERE, ex);
            throw new InternalServerErrorException();
        }
    }

    @RequestMapping(value = "/agencyId/{agencyId}", method = RequestMethod.GET)
    public ModelAndView getUniversalRecordByAgency(String agencyId) {
        try {
            List<UniversalRecord> urs = service.retrieveUniversalRecordByAgency(agencyId);
            return buildModelAndView(urs);
        } catch (Exception ex) {
            log(Level.SEVERE, ex);
            throw new InternalServerErrorException();
        }
    }

    private ModelAndView buildModelAndView(Object responseObject) {
        if (responseObject == null) {
            throw new ResourceNotFoundException();
        }
        return new ModelAndView(UNIVERSAL_RECORD_XML_VIEW, BindingResult.MODEL_KEY_PREFIX + "UniversalRecord", responseObject);
    }

    private void log(Level level, Exception ex) {
        Logger.getLogger(UniversalRecordRetrieveServiceController.class.getName()).log(level, null, ex);
    }
}
