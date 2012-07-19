/*
 */
package com.springeetravel.controller;

import com.springeetravel.domain.UniversalRecord;
import com.springeetravel.manager.UniversalRecordRetrieveService;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.inject.Inject;
import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author peter
 */
@Transactional(readOnly = true)
@Controller
@RequestMapping(value = "/UniversalRecord")
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class UniversalRecordRetrieveServiceController extends AbstractRESTController {

    public static final String UNIVERSAL_RECORD_XML_VIEW = "universalRecordXmlView";
    @Inject
    private UniversalRecordRetrieveService service;

    @RequestMapping(value = "/locatorCode/{locatorCode}", method = RequestMethod.GET)
    public ModelAndView getUniversalRecordByLocatorCode(@PathVariable String locatorCode) {
        UniversalRecord ur = service.retrieveUniversalRecordByLocatorCode(locatorCode);
        return buildModelAndView(ur);
    }

    @RequestMapping(value = "/passengerName/{passengerName}", method = RequestMethod.GET)
    public ModelAndView getUniversalRecordByBookingPassengerName(String passengerName) {
        List<UniversalRecord> urs = service.retrieveUniversalRecordByBookingPassengerName(passengerName);
        return buildModelAndView(urs);
    }

    @RequestMapping(value = "/ticketedDateFrom/{fromDate}/ticketedDateTo/{fromDate}", method = RequestMethod.GET)
    public ModelAndView getUniversalRecordByAirTicketedDate(@DateTimeFormat(iso = ISO.DATE) Date fromDate, @DateTimeFormat(iso = ISO.DATE) Date toDate) {
        List<UniversalRecord> urs = service.retrieveUniversalRecordByAirTicketedDate(fromDate, toDate);
        return buildModelAndView(urs);
    }

    @RequestMapping(value = "/agentId/{agentId}", method = RequestMethod.GET)
    public ModelAndView getUniversalRecordByAgent(String agentId) {
        List<UniversalRecord> urs = service.retrieveUniversalRecordByAgent(agentId);
        return buildModelAndView(urs);
    }

    @RequestMapping(value = "/agencyId/{agencyId}", method = RequestMethod.GET)
    public ModelAndView getUniversalRecordByAgency(String agencyId) {
        List<UniversalRecord> urs = service.retrieveUniversalRecordByAgency(agencyId);
        return buildModelAndView(urs);
    }

    private void log(Level level, Exception ex) {
        Logger.getLogger(UniversalRecordRetrieveServiceController.class.getName()).log(level, null, ex);
    }
}
