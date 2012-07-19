/*
 */
package com.springeetravel.controller;

import com.springeetravel.domain.AvailableFlight;
import com.springeetravel.domain.AvailableFlightSearchCriteria;
import com.springeetravel.manager.AvailableFlightService;
import java.util.List;
import javax.inject.Inject;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

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

    @RequestMapping(value = "/search", method = RequestMethod.POST)
    public @ResponseBody List<AvailableFlight> search(@RequestBody AvailableFlightSearchCriteria searchCriteria) {
        List<AvailableFlight> results = service.search(searchCriteria);
        return results;
    }
}
