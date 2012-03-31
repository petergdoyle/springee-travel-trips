/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.springeetravel.dataaccess;

import com.springeetravel.domain.UniversalRecord;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author peter
 */
@Stateless
public class UniversalRecordFacade extends AbstractFacade<UniversalRecord> implements UniversalRecordFacadeLocal {
    @PersistenceContext(unitName = "SpringEETravelEnterpriseApp-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UniversalRecordFacade() {
        super(UniversalRecord.class);
    }
    
}
