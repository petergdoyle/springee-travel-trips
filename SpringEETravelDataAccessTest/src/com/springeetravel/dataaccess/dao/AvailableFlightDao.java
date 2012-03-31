/*
 */
package com.springeetravel.dataaccess.dao;

import com.springeetravel.dataaccess.exceptions.NonexistentEntityException;
import com.springeetravel.domain.AvailableFlight;
import java.util.Date;
import java.util.List;

/**
 *
 * @author peter
 */
public interface AvailableFlightDao {

    void create(AvailableFlight availableFlight);

    void destroy(Long id) throws NonexistentEntityException;

    void edit(AvailableFlight availableFlight) throws NonexistentEntityException;

    public List<AvailableFlight> find(String departureCity, Date departureDate, String arrrivalCity, Date arrivalDate);

    AvailableFlight find(Long id);

    List<AvailableFlight> find();

    List<AvailableFlight> find(int maxResults, int firstResult);

    int getCount();
}
