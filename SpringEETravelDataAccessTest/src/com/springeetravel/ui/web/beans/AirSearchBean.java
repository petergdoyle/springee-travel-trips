/*
 */
package com.springeetravel.ui.web.beans;

import com.springeetravel.domain.AirSearchCriteria;
import java.io.Serializable;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ComponentSystemEvent;

/**
 *
 * @author peter
 */
@ManagedBean
@ViewScoped
public class AirSearchBean implements Serializable {

    private static final long serialVersionUID = -842403325947526065L;
    @ManagedProperty("#{sharedAirSearchCriteria}")
    private AirSearchCriteria sharedAirSearchCriteria;
    //
    private Map<String, String> selectableTicketTypes;
    private Map<String, String> selectableClassTypes;
    public List<AirportCode> selectableAirportCodes;
    //
    public static final String DEFAULT_TICKET_TYPE = "Round trip";
    public static final String DEFAULT_CLASS_TYPE = "Economy";

    @PostConstruct
    public void init() {
        sharedAirSearchCriteria.clear();
        constuctSelectableTicketTypes();
        sharedAirSearchCriteria.setTicketType(DEFAULT_TICKET_TYPE);
        constructSelectableClassTypes();
        sharedAirSearchCriteria.setClassType(DEFAULT_CLASS_TYPE);
        constructSelectableAirportCodes();
        initializeDates();
        initializeSeats();
    }

    public void onPreRenderView(ComponentSystemEvent evt) {
        Logger.getLogger(AirSearchBean.class.getName()).log(Level.INFO, "onPreRenderView");
    }

    public void submit() {
        UIUtils.pause(3);
        UIUtils.ajaxRedirect("/AirSearchResults.jsf");
    }

    private void constuctSelectableTicketTypes() {
        selectableTicketTypes = new HashMap<String, String>();
        selectableTicketTypes.put("Round trip", "Round trip");
        selectableTicketTypes.put("One way", "One way");
    }

    private void constructSelectableClassTypes() {
        selectableClassTypes = new HashMap<String, String>();
        selectableClassTypes.put("Economy", "Economy");
        selectableClassTypes.put("Business", "Business");
    }

    private void constructSelectableAirportCodes() {
        selectableAirportCodes = AirportCodeConverter.getSelectableAirportCodes();
    }

    private void initializeDates() {
        Calendar cal = GregorianCalendar.getInstance();
        cal.roll(Calendar.DATE, 1);
        sharedAirSearchCriteria.setDepartureDate(cal.getTime());
        cal.roll(Calendar.DATE, 1);
        sharedAirSearchCriteria.setReturnDate(cal.getTime());
    }

    private void initializeSeats() {
        sharedAirSearchCriteria.setAdultSeats(1);
        sharedAirSearchCriteria.setChildSeats(0);
    }

    public List<AirportCode> completeAirportCode(String query) {
        List<AirportCode> suggestions = new ArrayList<AirportCode>();
        for (AirportCode match : selectableAirportCodes) {
            if (match.getDescription().toLowerCase().startsWith(query.toLowerCase())) {
                suggestions.add(match);
            }
        }
        return suggestions;
    }

    public Map<String, String> getSelectableClassTypes() {
        return selectableClassTypes;
    }

    public Map<String, String> getSelectableTicketTypes() {
        return selectableTicketTypes;
    }

    public void setTicketType(String ticketType) {
        sharedAirSearchCriteria.setTicketType(ticketType);
    }

    public void setReturnDate(Date returnDate) {
        sharedAirSearchCriteria.setReturnDate(returnDate);
    }

    public void setDepartureDate(Date departureDate) {
        sharedAirSearchCriteria.setDepartureDate(departureDate);
    }

    public void setDepartureAirportCode(String departureAirportCode) {
        sharedAirSearchCriteria.setDepartureAirportCode(departureAirportCode);
    }

    public void setClassType(String classType) {
        sharedAirSearchCriteria.setClassType(classType);
    }

    public void setChildSeats(Integer childSeats) {
        sharedAirSearchCriteria.setChildSeats(childSeats);
    }

    public void setArrivalAirportCode(String arrivalAirportCode) {
        sharedAirSearchCriteria.setArrivalAirportCode(arrivalAirportCode);
    }

    public void setAdultSeats(Integer adultSeats) {
        sharedAirSearchCriteria.setAdultSeats(adultSeats);
    }

    public String getTicketType() {
        return sharedAirSearchCriteria.getTicketType();
    }

    public Date getReturnDate() {
        return sharedAirSearchCriteria.getReturnDate();
    }

    public Date getDepartureDate() {
        return sharedAirSearchCriteria.getDepartureDate();
    }

    public String getDepartureAirportCode() {
        return sharedAirSearchCriteria.getDepartureAirportCode();
    }

    public String getClassType() {
        return sharedAirSearchCriteria.getClassType();
    }

    public Integer getChildSeats() {
        return sharedAirSearchCriteria.getChildSeats();
    }

    public Date getArrivalDate() {
        return sharedAirSearchCriteria.getArrivalDate();
    }

    public String getArrivalAirportCode() {
        return sharedAirSearchCriteria.getArrivalAirportCode();
    }

    public Integer getAdultSeats() {
        return sharedAirSearchCriteria.getAdultSeats();
    }

    public List<AirportCode> getSelectableAirportCodes() {
        return selectableAirportCodes;
    }

    public void setSelectableAirportCodes(List<AirportCode> selectableAirportCodes) {
        this.selectableAirportCodes = selectableAirportCodes;
    }

    public void setSharedAirSearchCriteria(AirSearchCriteria sharedAirSearchCriteria) {
        this.sharedAirSearchCriteria = sharedAirSearchCriteria;
    }
}
