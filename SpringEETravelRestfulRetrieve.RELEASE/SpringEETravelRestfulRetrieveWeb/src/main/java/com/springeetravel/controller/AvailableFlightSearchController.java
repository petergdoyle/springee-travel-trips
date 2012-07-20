/*
 */
package com.springeetravel.controller;

import com.springeetravel.domain.AvailableFlight;
import com.springeetravel.domain.AvailableFlightSearchCriteria;
import com.springeetravel.domain.UniversalRecord;
import com.springeetravel.manager.AvailableFlightService;
import java.util.List;
import javax.inject.Inject;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author peter
 */
@Transactional(readOnly = true)
@Controller
@RequestMapping(value = "/AvailableFlight")
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class AvailableFlightSearchController extends AbstractRESTController {

    @Inject
    private AvailableFlightService service;
    public static final String AVAILABLE_FLIGHT_XML_VIEW = "availableFlightXmlView";

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView getAvailableFlight() {
        List<AvailableFlight> all = service.retrieveAll();
        return buildModelAndView(AVAILABLE_FLIGHT_XML_VIEW, all);
    }

    @RequestMapping(value = "/search", method = RequestMethod.POST)
    public @ResponseBody
    List<AvailableFlight> search(@RequestBody AvailableFlightSearchCriteria searchCriteria) {
        List<AvailableFlight> results = service.search(searchCriteria);
        return results;
    }
}
