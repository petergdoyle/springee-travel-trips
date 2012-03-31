/*
 */
package com.travelport.dataaccess;

import com.travelport.dataaccess.exceptions.IllegalOrphanException;
import com.travelport.dataaccess.exceptions.NonexistentEntityException;
import com.travelport.domain.FormOfPayment;
import java.util.List;

/**
 *
 * @author peter
 */
public interface FormOfPaymentDao {

    void create(FormOfPayment formOfPayment);

    void destroy(Long id) throws IllegalOrphanException, NonexistentEntityException;

    void edit(FormOfPayment formOfPayment) throws IllegalOrphanException, NonexistentEntityException, Exception;

    FormOfPayment findFormOfPayment(Long id);

    List<FormOfPayment> findFormOfPaymentEntities();

    List<FormOfPayment> findFormOfPaymentEntities(int maxResults, int firstResult);

    int getFormOfPaymentCount();
    
}
