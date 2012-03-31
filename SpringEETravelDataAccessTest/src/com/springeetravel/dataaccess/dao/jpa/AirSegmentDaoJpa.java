/*
 */
package com.springeetravel.dataaccess.dao.jpa;

import com.springeetravel.domain.FlightDetail;
import com.springeetravel.domain.FormOfPayment;
import com.springeetravel.domain.AirSegment;
import com.springeetravel.domain.UniversalRecord;
import com.springeetravel.domain.PassengerDetail;
import com.springeetravel.dataaccess.dao.AirSegmentDao;
import com.springeetravel.dataaccess.exceptions.IllegalOrphanException;
import com.springeetravel.dataaccess.exceptions.NonexistentEntityException;
import java.io.Serializable;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Named;
import javax.persistence.*;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author peter
 */
@Named("airSegmentDao")
@Transactional
public class AirSegmentDaoJpa implements AirSegmentDao, Serializable {

    private static final long serialVersionUID = -6972083394842071848L;
    @PersistenceContext
    private EntityManager em;

    public void create(AirSegment airSegment) {
        if (airSegment.getFormOfPaymentList() == null) {
            airSegment.setFormOfPaymentList(new ArrayList<FormOfPayment>());
        }
        if (airSegment.getPassengerDetailList() == null) {
            airSegment.setPassengerDetailList(new ArrayList<PassengerDetail>());
        }
        FlightDetail flightDetail = airSegment.getFlightDetail();
        if (flightDetail != null) {
            flightDetail = em.getReference(flightDetail.getClass(), flightDetail.getId());
            airSegment.setFlightDetail(flightDetail);
        }
        UniversalRecord universalRecordId = airSegment.getUniversalRecordId();
        if (universalRecordId != null) {
            universalRecordId = em.getReference(universalRecordId.getClass(), universalRecordId.getId());
            airSegment.setUniversalRecordId(universalRecordId);
        }
        List<FormOfPayment> attachedFormOfPaymentList = new ArrayList<FormOfPayment>();
        for (FormOfPayment formOfPaymentListFormOfPaymentToAttach : airSegment.getFormOfPaymentList()) {
            formOfPaymentListFormOfPaymentToAttach = em.getReference(formOfPaymentListFormOfPaymentToAttach.getClass(), formOfPaymentListFormOfPaymentToAttach.getId());
            attachedFormOfPaymentList.add(formOfPaymentListFormOfPaymentToAttach);
        }
        airSegment.setFormOfPaymentList(attachedFormOfPaymentList);
        List<PassengerDetail> attachedPassengerDetailList = new ArrayList<PassengerDetail>();
        for (PassengerDetail passengerDetailListPassengerDetailToAttach : airSegment.getPassengerDetailList()) {
            passengerDetailListPassengerDetailToAttach = em.getReference(passengerDetailListPassengerDetailToAttach.getClass(), passengerDetailListPassengerDetailToAttach.getId());
            attachedPassengerDetailList.add(passengerDetailListPassengerDetailToAttach);
        }
        airSegment.setPassengerDetailList(attachedPassengerDetailList);
        em.persist(airSegment);
        if (flightDetail != null) {
            AirSegment oldAirSegmentIdOfFlight = flightDetail.getAirSegmentId();
            if (oldAirSegmentIdOfFlight != null) {
                oldAirSegmentIdOfFlight.setFlightDetail(null);
                oldAirSegmentIdOfFlight = em.merge(oldAirSegmentIdOfFlight);
            }
            flightDetail.setAirSegmentId(airSegment);
            flightDetail = em.merge(flightDetail);
        }
        if (universalRecordId != null) {
            universalRecordId.getAirSegmentList().add(airSegment);
            universalRecordId = em.merge(universalRecordId);
        }
        for (FormOfPayment formOfPaymentListFormOfPayment : airSegment.getFormOfPaymentList()) {
            AirSegment oldAirSegmentIdOfFormOfPaymentListFormOfPayment = formOfPaymentListFormOfPayment.getAirSegmentId();
            formOfPaymentListFormOfPayment.setAirSegmentId(airSegment);
            formOfPaymentListFormOfPayment = em.merge(formOfPaymentListFormOfPayment);
            if (oldAirSegmentIdOfFormOfPaymentListFormOfPayment != null) {
                oldAirSegmentIdOfFormOfPaymentListFormOfPayment.getFormOfPaymentList().remove(formOfPaymentListFormOfPayment);
                oldAirSegmentIdOfFormOfPaymentListFormOfPayment = em.merge(oldAirSegmentIdOfFormOfPaymentListFormOfPayment);
            }
        }
        for (PassengerDetail passengerDetailListPassengerDetail : airSegment.getPassengerDetailList()) {
            AirSegment oldAirSegmentIdOfPassengerDetailListPassengerDetail = passengerDetailListPassengerDetail.getAirSegmentId();
            passengerDetailListPassengerDetail.setAirSegmentId(airSegment);
            passengerDetailListPassengerDetail = em.merge(passengerDetailListPassengerDetail);
            if (oldAirSegmentIdOfPassengerDetailListPassengerDetail != null) {
                oldAirSegmentIdOfPassengerDetailListPassengerDetail.getPassengerDetailList().remove(passengerDetailListPassengerDetail);
                oldAirSegmentIdOfPassengerDetailListPassengerDetail = em.merge(oldAirSegmentIdOfPassengerDetailListPassengerDetail);
            }
        }
    }

    public void edit(AirSegment airSegment) throws IllegalOrphanException, NonexistentEntityException {
        try {
            AirSegment persistentAirSegment = em.find(AirSegment.class, airSegment.getId());
            FlightDetail flightOld = persistentAirSegment.getFlightDetail();
            FlightDetail flightNew = airSegment.getFlightDetail();
            UniversalRecord universalRecordIdOld = persistentAirSegment.getUniversalRecordId();
            UniversalRecord universalRecordIdNew = airSegment.getUniversalRecordId();
            List<FormOfPayment> formOfPaymentListOld = persistentAirSegment.getFormOfPaymentList();
            List<FormOfPayment> formOfPaymentListNew = airSegment.getFormOfPaymentList();
            List<PassengerDetail> passengerDetailListOld = persistentAirSegment.getPassengerDetailList();
            List<PassengerDetail> passengerDetailListNew = airSegment.getPassengerDetailList();
            List<String> illegalOrphanMessages = null;
            for (FormOfPayment formOfPaymentListOldFormOfPayment : formOfPaymentListOld) {
                if (!formOfPaymentListNew.contains(formOfPaymentListOldFormOfPayment)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain FormOfPayment " + formOfPaymentListOldFormOfPayment + " since its airSegmentId field is not nullable.");
                }
            }
            for (PassengerDetail passengerDetailListOldPassengerDetail : passengerDetailListOld) {
                if (!passengerDetailListNew.contains(passengerDetailListOldPassengerDetail)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain PassengerDetail " + passengerDetailListOldPassengerDetail + " since its airSegmentId field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            if (flightNew != null) {
                flightNew = em.getReference(flightNew.getClass(), flightNew.getId());
                airSegment.setFlightDetail(flightNew);
            }
            if (universalRecordIdNew != null) {
                universalRecordIdNew = em.getReference(universalRecordIdNew.getClass(), universalRecordIdNew.getId());
                airSegment.setUniversalRecordId(universalRecordIdNew);
            }
            List<FormOfPayment> attachedFormOfPaymentListNew = new ArrayList<FormOfPayment>();
            for (FormOfPayment formOfPaymentListNewFormOfPaymentToAttach : formOfPaymentListNew) {
                formOfPaymentListNewFormOfPaymentToAttach = em.getReference(formOfPaymentListNewFormOfPaymentToAttach.getClass(), formOfPaymentListNewFormOfPaymentToAttach.getId());
                attachedFormOfPaymentListNew.add(formOfPaymentListNewFormOfPaymentToAttach);
            }
            formOfPaymentListNew = attachedFormOfPaymentListNew;
            airSegment.setFormOfPaymentList(formOfPaymentListNew);
            List<PassengerDetail> attachedPassengerDetailListNew = new ArrayList<PassengerDetail>();
            for (PassengerDetail passengerDetailListNewPassengerDetailToAttach : passengerDetailListNew) {
                passengerDetailListNewPassengerDetailToAttach = em.getReference(passengerDetailListNewPassengerDetailToAttach.getClass(), passengerDetailListNewPassengerDetailToAttach.getId());
                attachedPassengerDetailListNew.add(passengerDetailListNewPassengerDetailToAttach);
            }
            passengerDetailListNew = attachedPassengerDetailListNew;
            airSegment.setPassengerDetailList(passengerDetailListNew);
            airSegment = em.merge(airSegment);
            if (flightOld != null && !flightOld.equals(flightNew)) {
                flightOld.setAirSegmentId(null);
                flightOld = em.merge(flightOld);
            }
            if (flightNew != null && !flightNew.equals(flightOld)) {
                AirSegment oldAirSegmentIdOfFlight = flightNew.getAirSegmentId();
                if (oldAirSegmentIdOfFlight != null) {
                    oldAirSegmentIdOfFlight.setFlightDetail(null);
                    oldAirSegmentIdOfFlight = em.merge(oldAirSegmentIdOfFlight);
                }
                flightNew.setAirSegmentId(airSegment);
                flightNew = em.merge(flightNew);
            }
            if (universalRecordIdOld != null && !universalRecordIdOld.equals(universalRecordIdNew)) {
                universalRecordIdOld.getAirSegmentList().remove(airSegment);
                universalRecordIdOld = em.merge(universalRecordIdOld);
            }
            if (universalRecordIdNew != null && !universalRecordIdNew.equals(universalRecordIdOld)) {
                universalRecordIdNew.getAirSegmentList().add(airSegment);
                universalRecordIdNew = em.merge(universalRecordIdNew);
            }
            for (FormOfPayment formOfPaymentListNewFormOfPayment : formOfPaymentListNew) {
                if (!formOfPaymentListOld.contains(formOfPaymentListNewFormOfPayment)) {
                    AirSegment oldAirSegmentIdOfFormOfPaymentListNewFormOfPayment = formOfPaymentListNewFormOfPayment.getAirSegmentId();
                    formOfPaymentListNewFormOfPayment.setAirSegmentId(airSegment);
                    formOfPaymentListNewFormOfPayment = em.merge(formOfPaymentListNewFormOfPayment);
                    if (oldAirSegmentIdOfFormOfPaymentListNewFormOfPayment != null && !oldAirSegmentIdOfFormOfPaymentListNewFormOfPayment.equals(airSegment)) {
                        oldAirSegmentIdOfFormOfPaymentListNewFormOfPayment.getFormOfPaymentList().remove(formOfPaymentListNewFormOfPayment);
                        oldAirSegmentIdOfFormOfPaymentListNewFormOfPayment = em.merge(oldAirSegmentIdOfFormOfPaymentListNewFormOfPayment);
                    }
                }
            }
            for (PassengerDetail passengerDetailListNewPassengerDetail : passengerDetailListNew) {
                if (!passengerDetailListOld.contains(passengerDetailListNewPassengerDetail)) {
                    AirSegment oldAirSegmentIdOfPassengerDetailListNewPassengerDetail = passengerDetailListNewPassengerDetail.getAirSegmentId();
                    passengerDetailListNewPassengerDetail.setAirSegmentId(airSegment);
                    passengerDetailListNewPassengerDetail = em.merge(passengerDetailListNewPassengerDetail);
                    if (oldAirSegmentIdOfPassengerDetailListNewPassengerDetail != null && !oldAirSegmentIdOfPassengerDetailListNewPassengerDetail.equals(airSegment)) {
                        oldAirSegmentIdOfPassengerDetailListNewPassengerDetail.getPassengerDetailList().remove(passengerDetailListNewPassengerDetail);
                        oldAirSegmentIdOfPassengerDetailListNewPassengerDetail = em.merge(oldAirSegmentIdOfPassengerDetailListNewPassengerDetail);
                    }
                }
            }
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Long id = airSegment.getId();
                if (find(id) == null) {
                    throw new NonexistentEntityException("The airSegment with id " + id + " no longer exists.");
                }
            }
        }
    }

    public void destroy(Long id) throws IllegalOrphanException, NonexistentEntityException {
        AirSegment airSegment;
        try {
            airSegment = em.getReference(AirSegment.class, id);
            airSegment.getId();
        } catch (EntityNotFoundException enfe) {
            throw new NonexistentEntityException("The airSegment with id " + id + " no longer exists.", enfe);
        }
        List<String> illegalOrphanMessages = null;
        List<FormOfPayment> formOfPaymentListOrphanCheck = airSegment.getFormOfPaymentList();
        for (FormOfPayment formOfPaymentListOrphanCheckFormOfPayment : formOfPaymentListOrphanCheck) {
            if (illegalOrphanMessages == null) {
                illegalOrphanMessages = new ArrayList<String>();
            }
            illegalOrphanMessages.add("This AirSegment (" + airSegment + ") cannot be destroyed since the FormOfPayment " + formOfPaymentListOrphanCheckFormOfPayment + " in its formOfPaymentList field has a non-nullable airSegmentId field.");
        }
        List<PassengerDetail> passengerDetailListOrphanCheck = airSegment.getPassengerDetailList();
        for (PassengerDetail passengerDetailListOrphanCheckPassengerDetail : passengerDetailListOrphanCheck) {
            if (illegalOrphanMessages == null) {
                illegalOrphanMessages = new ArrayList<String>();
            }
            illegalOrphanMessages.add("This AirSegment (" + airSegment + ") cannot be destroyed since the PassengerDetail " + passengerDetailListOrphanCheckPassengerDetail + " in its passengerDetailList field has a non-nullable airSegmentId field.");
        }
        if (illegalOrphanMessages != null) {
            throw new IllegalOrphanException(illegalOrphanMessages);
        }
        FlightDetail flightDetail = airSegment.getFlightDetail();
        if (flightDetail != null) {
            flightDetail.setAirSegmentId(null);
            flightDetail = em.merge(flightDetail);
        }
        UniversalRecord universalRecordId = airSegment.getUniversalRecordId();
        if (universalRecordId != null) {
            universalRecordId.getAirSegmentList().remove(airSegment);
            universalRecordId = em.merge(universalRecordId);
        }
        em.remove(airSegment);
    }

    public List<AirSegment> find() {
        return find(true, -1, -1);
    }

    public List<AirSegment> find(int maxResults, int firstResult) {
        return find(false, maxResults, firstResult);
    }

    private List<AirSegment> find(boolean all, int maxResults, int firstResult) {
        CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
        cq.select(cq.from(AirSegment.class));
        Query q = em.createQuery(cq);
        if (!all) {
            q.setMaxResults(maxResults);
            q.setFirstResult(firstResult);
        }
        return q.getResultList();
    }

    public AirSegment find(Long id) {
        return em.find(AirSegment.class, id);
    }

    public int getCount() {
        CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
        Root<AirSegment> rt = cq.from(AirSegment.class);
        cq.select(em.getCriteriaBuilder().count(rt));
        Query q = em.createQuery(cq);
        return ((Long) q.getSingleResult()).intValue();
    }
}
