/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.springeetravel.controller;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.validation.BindingResult;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author peter
 */
public class AbstractRESTController {

    public AbstractRESTController() {
    }

    protected ModelAndView buildModelAndView(String viewId, Object responseObject) {
        if (responseObject == null) {
            throw new ResourceNotFoundException();
        }
        return new ModelAndView(viewId, BindingResult.MODEL_KEY_PREFIX + "UniversalRecord", responseObject);
    }

    protected void log(Level level, Exception ex) {
        Logger.getLogger(this.getClass().getName()).log(level, null, ex);
    }
}
