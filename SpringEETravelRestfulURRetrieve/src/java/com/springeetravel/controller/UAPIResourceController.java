/*
 */
package com.springeetravel.controller;

import com.springeetravel.domain.UniversalRecord;
import com.springeetravel.manager.UniversalRecordResourceManager;
import javax.inject.Inject;
import javax.inject.Named;
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
@RequestMapping(value = "/rest")
public class UAPIResourceController {

    @Inject
    @Named("universalRecordResourceManager")
    private UniversalRecordResourceManager resourceManager;

    @RequestMapping(value = "/UniversalRecord/{locatorCode}/", method = RequestMethod.GET)
    public ModelAndView getUniversalRecordByLocatorCode(@PathVariable String locatorCode) {
        UniversalRecord ur = resourceManager.retrieveUniversalRecord(locatorCode);
        return new ModelAndView("universalRecordXmlView", BindingResult.MODEL_KEY_PREFIX + "UniversalRecord", ur);
    }
}
