/*
 */
package com.springeetravel.controller;

import com.springeetravel.dataaccess.UniversalRecordService;
import com.springeetravel.domain.UniversalRecord;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author peter
 */
@Controller
public class UniversalRecordServiceController {

    public static final String UNIVERSAL_RECORD_XML_VIEW = "universalRecordXmlView";
    @Autowired
    private UniversalRecordService universalRecordService;

    @RequestMapping(value = "/UniversalRecord/locatorCode/{locatorCode}", method = RequestMethod.GET)
    public ModelAndView getUniversalRecordByLocatorCode(@PathVariable String locatorCode) {
        UniversalRecord ur = universalRecordService.findByLocatorCode(locatorCode);
        return new ModelAndView(UNIVERSAL_RECORD_XML_VIEW, BindingResult.MODEL_KEY_PREFIX + "UniversalRecord", ur);
    }

    @RequestMapping(value = "/UniversalRecord/passengerName/{passengerName}", method = RequestMethod.GET)
    public ModelAndView getUniversalRecordByBookingPassengerName(String passengerName) {
        List<UniversalRecord> urs = universalRecordService.findByBookingPassengerName(passengerName);
        return new ModelAndView(UNIVERSAL_RECORD_XML_VIEW, BindingResult.MODEL_KEY_PREFIX + "UniversalRecord", urs);
    }

    @RequestMapping(value = "/UniversalRecord/ticketedDateFrom/{fromDate}/ticketedDateTo/{fromDate}", method = RequestMethod.GET)
    public ModelAndView getUniversalRecordByAirTicketedDate(Date fromDate, Date toDate) {
        List<UniversalRecord> urs = universalRecordService.findByAirTicketedDate(fromDate, toDate);
        return new ModelAndView(UNIVERSAL_RECORD_XML_VIEW, BindingResult.MODEL_KEY_PREFIX + "UniversalRecord", urs);
    }

    @RequestMapping(value = "/UniversalRecord/agentId/{agentId}", method = RequestMethod.GET)
    public ModelAndView getUniversalRecordByAgent(String agentId) {
        List<UniversalRecord> urs = universalRecordService.findByAgent(agentId);
        return new ModelAndView(UNIVERSAL_RECORD_XML_VIEW, BindingResult.MODEL_KEY_PREFIX + "UniversalRecord", urs);
    }

    @RequestMapping(value = "/UniversalRecord/agencyId/{agencyId}", method = RequestMethod.GET)
    public ModelAndView getUniversalRecordByAgency(String agencyId) {
        List<UniversalRecord> urs = universalRecordService.findByAgency(agencyId);
        return new ModelAndView(UNIVERSAL_RECORD_XML_VIEW, BindingResult.MODEL_KEY_PREFIX + "UniversalRecord", urs);
    }
}
