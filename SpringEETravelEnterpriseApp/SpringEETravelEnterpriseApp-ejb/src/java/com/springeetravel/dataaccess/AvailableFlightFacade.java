/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.springeetravel.dataaccess;

import com.springeetravel.domain.AvailableFlight;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author peter
 */
@Stateless
public class AvailableFlightFacade extends AbstractFacade<AvailableFlight> implements AvailableFlightFacadeLocal {

    @PersistenceContext(unitName = "SpringEETravelEnterpriseApp-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AvailableFlightFacade() {
        super(AvailableFlight.class);
    }
}
