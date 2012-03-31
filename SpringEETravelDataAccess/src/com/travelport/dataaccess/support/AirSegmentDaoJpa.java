/*
 */
package com.travelport.dataaccess.support;

import com.travelport.dataaccess.AirSegmentDao;
import com.travelport.dataaccess.exceptions.IllegalOrphanException;
import com.travelport.dataaccess.exceptions.NonexistentEntityException;
import com.travelport.domain.AirSegment;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import com.travelport.domain.Flight;
import java.util.ArrayList;
import java.util.List;
import com.travelport.domain.FormOfPayment;
import com.travelport.domain.PassengerDetail;
import javax.inject.Named;
import javax.persistence.*;
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
        if (airSegment.getFlightList() == null) {
            airSegment.setFlightList(new ArrayList<Flight>());
        }
        if (airSegment.getFormOfPaymentList() == null) {
            airSegment.setFormOfPaymentList(new ArrayList<FormOfPayment>());
        }
        if (airSegment.getPassengerDetailList() == null) {
            airSegment.setPassengerDetailList(new ArrayList<PassengerDetail>());
        }
        List<Flight> attachedFlightList = new ArrayList<Flight>();
        for (Flight flightListFlightToAttach : airSegment.getFlightList()) {
            flightListFlightToAttach = em.getReference(flightListFlightToAttach.getClass(), flightListFlightToAttach.getId());
            attachedFlightList.add(flightListFlightToAttach);
        }
        airSegment.setFlightList(attachedFlightList);
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
        for (Flight flightListFlight : airSegment.getFlightList()) {
            AirSegment oldAirSegmentIdOfFlightListFlight = flightListFlight.getAirSegmentId();
            flightListFlight.setAirSegmentId(airSegment);
            flightListFlight = em.merge(flightListFlight);
            if (oldAirSegmentIdOfFlightListFlight != null) {
                oldAirSegmentIdOfFlightListFlight.getFlightList().remove(flightListFlight);
                oldAirSegmentIdOfFlightListFlight = em.merge(oldAirSegmentIdOfFlightListFlight);
            }
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

    public void edit(AirSegment airSegment) throws IllegalOrphanException, NonexistentEntityException, Exception {
        try {
            AirSegment persistentAirSegment = em.find(AirSegment.class, airSegment.getId());
            List<Flight> flightListOld = persistentAirSegment.getFlightList();
            List<Flight> flightListNew = airSegment.getFlightList();
            List<FormOfPayment> formOfPaymentListOld = persistentAirSegment.getFormOfPaymentList();
            List<FormOfPayment> formOfPaymentListNew = airSegment.getFormOfPaymentList();
            List<PassengerDetail> passengerDetailListOld = persistentAirSegment.getPassengerDetailList();
            List<PassengerDetail> passengerDetailListNew = airSegment.getPassengerDetailList();
            List<String> illegalOrphanMessages = null;
            for (Flight flightListOldFlight : flightListOld) {
                if (!flightListNew.contains(flightListOldFlight)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Flight " + flightListOldFlight + " since its airSegmentId field is not nullable.");
                }
            }
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
            List<Flight> attachedFlightListNew = new ArrayList<Flight>();
            for (Flight flightListNewFlightToAttach : flightListNew) {
                flightListNewFlightToAttach = em.getReference(flightListNewFlightToAttach.getClass(), flightListNewFlightToAttach.getId());
                attachedFlightListNew.add(flightListNewFlightToAttach);
            }
            flightListNew = attachedFlightListNew;
            airSegment.setFlightList(flightListNew);
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
            for (Flight flightListNewFlight : flightListNew) {
                if (!flightListOld.contains(flightListNewFlight)) {
                    AirSegment oldAirSegmentIdOfFlightListNewFlight = flightListNewFlight.getAirSegmentId();
                    flightListNewFlight.setAirSegmentId(airSegment);
                    flightListNewFlight = em.merge(flightListNewFlight);
                    if (oldAirSegmentIdOfFlightListNewFlight != null && !oldAirSegmentIdOfFlightListNewFlight.equals(airSegment)) {
                        oldAirSegmentIdOfFlightListNewFlight.getFlightList().remove(flightListNewFlight);
                        oldAirSegmentIdOfFlightListNewFlight = em.merge(oldAirSegmentIdOfFlightListNewFlight);
                    }
                }
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
                if (findAirSegment(id) == null) {
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
        List<Flight> flightListOrphanCheck = airSegment.getFlightList();
        for (Flight flightListOrphanCheckFlight : flightListOrphanCheck) {
            if (illegalOrphanMessages == null) {
                illegalOrphanMessages = new ArrayList<String>();
            }
            illegalOrphanMessages.add("This AirSegment (" + airSegment + ") cannot be destroyed since the Flight " + flightListOrphanCheckFlight + " in its flightList field has a non-nullable airSegmentId field.");
        }
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
        em.remove(airSegment);
    }

    public List<AirSegment> findAirSegmentEntities() {
        return findAirSegmentEntities(true, -1, -1);
    }

    public List<AirSegment> findAirSegmentEntities(int maxResults, int firstResult) {
        return findAirSegmentEntities(false, maxResults, firstResult);
    }

    private List<AirSegment> findAirSegmentEntities(boolean all, int maxResults, int firstResult) {
        CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
        cq.select(cq.from(AirSegment.class));
        Query q = em.createQuery(cq);
        if (!all) {
            q.setMaxResults(maxResults);
            q.setFirstResult(firstResult);
        }
        return q.getResultList();
    }

    public AirSegment findAirSegment(Long id) {
        return em.find(AirSegment.class, id);
    }

    public int getAirSegmentCount() {
        CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
        Root<AirSegment> rt = cq.from(AirSegment.class);
        cq.select(em.getCriteriaBuilder().count(rt));
        Query q = em.createQuery(cq);
        return ((Long) q.getSingleResult()).intValue();
    }
}
