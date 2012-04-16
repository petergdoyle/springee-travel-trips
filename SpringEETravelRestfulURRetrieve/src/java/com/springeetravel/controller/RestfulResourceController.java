/*
 */
package com.springeetravel.controller;

import com.springeetravel.domain.UniversalRecord;
import com.springeetravel.manager.ResourceManager;
import javax.inject.Inject;
import javax.inject.Named;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author peter
 */
@Controller
public class RestfulResourceController {

    @Inject
    @Named("resourceManager")
    private ResourceManager resourceManager;

    @RequestMapping(value = "/universalRecord/{id}/")
    public ModelAndView getUniversalRecordByRecordLocatorCode(@PathVariable String id) {
        UniversalRecord ur = resourceManager.retrieveUniversalRecord(id);
        ModelAndView mav = new ModelAndView("universalRecordView", BindingResult.MODEL_KEY_PREFIX + "ur", ur);
        return mav;
    }
}
