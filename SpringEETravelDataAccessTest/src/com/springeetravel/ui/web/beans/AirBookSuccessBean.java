/*
 */
package com.springeetravel.ui.web.beans;

import com.springeetravel.businesssvcs.UniversalRecordManager;
import com.springeetravel.businesssvcs.UniversalRecordManagerJpa;
import com.springeetravel.domain.AirSearchCriteria;
import com.springeetravel.domain.UniversalRecord;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author peter
 */
@ManagedBean
@ViewScoped
public class AirBookSuccessBean {

    @ManagedProperty("#{sharedAirSearchCriteria}")
    private AirSearchCriteria sharedAirSearchCriteria;
    @ManagedProperty("#{universalRecordManagerJpa}")
    private UniversalRecordManager universalRecordManager;
    private UniversalRecord univeralsalRecord;

    @PostConstruct
    public void init() {
        univeralsalRecord = universalRecordManager.retrieveUniversalRecord(sharedAirSearchCriteria.getUniversalRecordId());
    }

    public UniversalRecord getUniveralsalRecord() {
        return univeralsalRecord;
    }

    public void setUniversalRecordManager(UniversalRecordManager universalRecordManager) {
        this.universalRecordManager = universalRecordManager;
    }

    public void setSharedAirSearchCriteria(AirSearchCriteria sharedAirSearchCriteria) {
        this.sharedAirSearchCriteria = sharedAirSearchCriteria;
    }
}
