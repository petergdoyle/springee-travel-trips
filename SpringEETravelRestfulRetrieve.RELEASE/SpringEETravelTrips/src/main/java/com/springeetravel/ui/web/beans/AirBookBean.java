/*
 */
package com.springeetravel.ui.web.beans;

import com.springeetravel.domain.AirSearchCriteria;
import com.springeetravel.domain.FlightDetail;
import com.springeetravel.domain.FormOfPayment;
import com.springeetravel.domain.UniversalRecord;
import com.springeetravel.domain.PassengerDetail;
import com.springeetravel.businesssvcs.AirBookManager;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ComponentSystemEvent;
import org.primefaces.event.FlowEvent;

/**
 *
 * @author peter
 */
@ManagedBean
@SessionScoped
public class AirBookBean implements Serializable {

    private static final long serialVersionUID = -8441933566511460374L;
    @ManagedProperty("#{sharedAirSearchCriteria}")
    private AirSearchCriteria sharedAirSearchCriteria;
    @ManagedProperty("#{airBookManager}")
    private AirBookManager airBookManager;
    private FormOfPayment fop;
    private PassengerDetail passenger;
    private boolean skip;

    @PostConstruct
    public void init() {
        fop = airBookManager.getInializedFormOfPaymentInstance();
        passenger = airBookManager.getInializedPassengerDetailInstance();
    }

    public void onPreRenderView(ComponentSystemEvent evt) {
        Logger.getLogger(AirSearchBean.class.getName()).log(Level.INFO, "onPreRenderView");
    }

    public void submit() {

        Long selectedDepartingFlightId = sharedAirSearchCriteria.getSelectedDepartingFlightId();
        Long selectedReturnFlightId = sharedAirSearchCriteria.getSelectedReturnFlightId();
        FlightDetail departingFlight = airBookManager.findFlightByAvailableFlight(selectedDepartingFlightId);
        FlightDetail returnFlight = airBookManager.findFlightByAvailableFlight(selectedReturnFlightId);
        UniversalRecord book = airBookManager.book(departingFlight, returnFlight, airBookManager.getInializedPassengerDetailInstance(), airBookManager.getInializedFormOfPaymentInstance());
        sharedAirSearchCriteria.setUniversalRecordId(book.getId());
        Logger.getLogger(AirSearchBean.class.getName()).log(Level.INFO, "fop: {0} passenger", new String[]{fop.toString(), passenger.toString()});

        UIUtils.pause(1);
        UIUtils.ajaxRedirect("/AirBookSuccess.jsf");
    }

    public String onFlowProcess(FlowEvent event) {
        Logger.getLogger(AirSearchBean.class.getName()).log(Level.INFO, "Current wizard step:{0}", event.getOldStep());
        Logger.getLogger(AirSearchBean.class.getName()).log(Level.INFO, "Next step:{0}", event.getNewStep());
        if (skip) {
            skip = false;   //reset in case user goes back  
            return "confirm";
        } else {
            return event.getNewStep();
        }
    }

    public FormOfPayment getFop() {
        return fop;
    }

    public void setFop(FormOfPayment fop) {
        this.fop = fop;
    }

    public PassengerDetail getPassenger() {
        return passenger;
    }

    public void setPassenger(PassengerDetail passenger) {
        this.passenger = passenger;
    }

    public void setSharedAirSearchCriteria(AirSearchCriteria sharedAirSearchCriteria) {
        this.sharedAirSearchCriteria = sharedAirSearchCriteria;
    }

    public void setAirBookManager(AirBookManager airBookManager) {
        this.airBookManager = airBookManager;
    }

    public boolean isSkip() {
        return skip;
    }

    public void setSkip(boolean skip) {
        this.skip = skip;
    }
}
