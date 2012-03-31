/*
 */
package com.springeetravel.dataaccess.dao;

import com.springeetravel.dataaccess.exceptions.IllegalOrphanException;
import com.springeetravel.dataaccess.exceptions.NonexistentEntityException;
import com.springeetravel.domain.FormOfPayment;
import java.util.List;

/**
 *
 * @author peter
 */
public interface FormOfPaymentDao {

    void create(FormOfPayment formOfPayment);

    void destroy(Long id) throws IllegalOrphanException, NonexistentEntityException;

    void edit(FormOfPayment formOfPayment) throws IllegalOrphanException, NonexistentEntityException;

    FormOfPayment find(Long id);

    List<FormOfPayment> find();

    List<FormOfPayment> find(int maxResults, int firstResult);

    int getCount();
}
