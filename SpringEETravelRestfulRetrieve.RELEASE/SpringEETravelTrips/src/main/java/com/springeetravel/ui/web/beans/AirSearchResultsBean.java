/*
 */
package com.springeetravel.ui.web.beans;

import com.springeetravel.domain.AirSearchCriteria;
import com.springeetravel.domain.AvailableFlight;
import com.springeetravel.businesssvcs.AirSearchResultsManager;
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
public class AirSearchResultsBean implements Serializable {

    private static final long serialVersionUID = 4214808032466519670L;
    @ManagedProperty("#{sharedAirSearchCriteria}")
    private AirSearchCriteria sharedAirSearchCriteria;
    @ManagedProperty("#{airSearchResultsManager}")
    private AirSearchResultsManager airSearchResultsManager;
    //
    private List<AvailableFlight> departingFlights;
    private List<AvailableFlight> returningFlights;

    @PostConstruct
    public void init() {

        departingFlights = new ArrayList<AvailableFlight>();
        UIUtils.addAll(departingFlights, airSearchResultsManager.searchDepartureFlights(sharedAirSearchCriteria));
        Logger.getLogger(AirSearchResultsBean.class.getName()).log(Level.INFO, departingFlights.toString());

        returningFlights = new ArrayList<AvailableFlight>();
        UIUtils.addAll(returningFlights, airSearchResultsManager.searchReturnFlights(sharedAirSearchCriteria));
        Logger.getLogger(AirSearchResultsBean.class.getName()).log(Level.INFO, returningFlights.toString());

    }

    public void onPreRenderView(ComponentSystemEvent evt) {
    }

    public void submit() {
        setSelectedFlights();
        UIUtils.ajaxRedirect("/AirBook.jsf");
    }

    private void setSelectedFlights() {
        for (AvailableFlight each : returningFlights) {
            if (each.isSelected()) {
                sharedAirSearchCriteria.setSelectedReturnFlightId(each.getId());
                break;
            }
        }
        if (sharedAirSearchCriteria.getSelectedReturnFlightId() == null) {
            sharedAirSearchCriteria.setSelectedReturnFlightId(returningFlights.iterator().next().getId());
        }
        for (AvailableFlight each : departingFlights) {
            if (each.isSelected()) {
                sharedAirSearchCriteria.setSelectedDepartingFlightId(each.getId());
                break;
            }
        }
        if (sharedAirSearchCriteria.getSelectedDepartingFlightId() == null) {
            sharedAirSearchCriteria.setSelectedDepartingFlightId(departingFlights.iterator().next().getId());
        }
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

    public void setSharedAirSearchCriteria(AirSearchCriteria sharedAirSearchCriteria) {
        this.sharedAirSearchCriteria = sharedAirSearchCriteria;
    }

    public void setAirSearchResultsManager(AirSearchResultsManager airSearchResultsManager) {
        this.airSearchResultsManager = airSearchResultsManager;
    }

    public List<AvailableFlight> getDepartingFlights() {
        return departingFlights;
    }

    public List<AvailableFlight> getReturningFlights() {
        return returningFlights;
    }
}
