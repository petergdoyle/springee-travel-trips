/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.springeetravel.controller;

import org.springframework.validation.BindingResult;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author peter
 */
public class AbstractRESTController {

    public AbstractRESTController() {
    }

    protected ModelAndView buildModelAndView(Object responseObject) {
        if (responseObject == null) {
            throw new ResourceNotFoundException();
        }
        return new ModelAndView(UniversalRecordRetrieveServiceController.UNIVERSAL_RECORD_XML_VIEW, BindingResult.MODEL_KEY_PREFIX + "UniversalRecord", responseObject);
    }
    
}
