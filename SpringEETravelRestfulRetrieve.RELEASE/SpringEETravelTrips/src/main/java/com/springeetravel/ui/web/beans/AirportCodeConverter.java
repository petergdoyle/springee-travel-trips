/*
 */
package com.springeetravel.ui.web.beans;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author peter
 */
@FacesConverter(value="airportCodeConverter")
public class AirportCodeConverter implements Converter {

    private static List<AirportCode> selectableAirportCodes = Arrays.asList(new AirportCode[]{
                new AirportCode("BOS", "BOS (Logan Intl)"),
                new AirportCode("LNK", "LNK (Lincoln)"),
                new AirportCode("DEN", "DEN (Denver Intl)"),
                new AirportCode("JFK", "JFK (John F Kennedy Intl)"),
                new AirportCode("LAX", "LAX (Los Angeles Intl)")});

    public static List<AirportCode> getSelectableAirportCodes() {
        return selectableAirportCodes;
    }

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if (value.trim().equals("")) {
            return null;
        } else {
            for (AirportCode each : selectableAirportCodes) {
                if (each.getDescription().equals(value)) {
                    return each;
                }
            }
        }

        return null;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if (value == null || value.equals("")) {
            return "";
        } else {
            return ((AirportCode) value).getCode();
        }
    }
}
