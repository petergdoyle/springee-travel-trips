/*
 */
package com.springeetravel.dataaccess.springdata.generic;

import com.springeetravel.dataaccess.dao.PassengerDetailDao;
import com.springeetravel.dataaccess.exceptions.NonexistentEntityException;
import com.springeetravel.domain.PassengerDetail;
import com.springeetravel.domain.QPassengerDetail;
import java.util.Date;
import java.util.List;
import javax.inject.Named;
import org.springframework.data.jpa.repository.support.QueryDslRepositorySupport;
import static com.springeetravel.dataaccess.springdata.generic.PassengerDetailExpresssions.*;

/**
 *
 * @author peter
 */
@Named("passengerDetailRepository")
public class PassengerDetailRepository extends QueryDslRepositorySupport implements PassengerDetailDao {

    public static String DOMESTIC_COUNTRY_CODE = "USA";

    @Override
    public List<PassengerDetail> findAllForeignPassengers(String flightNumber, Date flightDate) {
        QPassengerDetail passengerDetail = QPassengerDetail.passengerDetail;
        return from(passengerDetail).where(passengerDetail.countryOfNationalityCode.ne(DOMESTIC_COUNTRY_CODE)).list(passengerDetail);
    }

    @Override
    public List<PassengerDetail> findSpecialCustomers(String flightNumber, Date flightDate) {
        QPassengerDetail passengerDetail = QPassengerDetail.passengerDetail;
        return from(passengerDetail).where(hasBirthDay().and(isValuedCustomer())).list(passengerDetail);
    }

    @Override
    public void create(PassengerDetail passengerDetail) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void destroy(Long id) throws NonexistentEntityException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void edit(PassengerDetail passengerDetail) throws NonexistentEntityException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public PassengerDetail find(Long id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<PassengerDetail> find() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<PassengerDetail> find(int maxResults, int firstResult) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public int getCount() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
