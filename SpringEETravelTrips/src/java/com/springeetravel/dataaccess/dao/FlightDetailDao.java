/*
 */
package com.springeetravel.dataaccess.dao;

import com.springeetravel.domain.FlightDetail;
import java.util.List;

/**
 *
 * @author peter
 */
public interface FlightDetailDao {

    void create(FlightDetail flightDetail);

    void destroy(Long id);

    void edit(FlightDetail flightDetail);

    FlightDetail find(Long id);

    List<FlightDetail> find();

    List<FlightDetail> find(int maxResults, int firstResult);

    int getCount();
}
