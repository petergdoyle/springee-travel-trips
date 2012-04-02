/*
 */
package com.springeetravel.dataaccess.springdata.mongo;

import com.mysema.query.types.expr.BooleanExpression;
import com.springeetravel.domain.QPassengerDetail;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author peter
 */
public class PassengerDetailExpresssions {

    public static BooleanExpression hasBirthDay() {
        Date today = Calendar.getInstance().getTime();
        return QPassengerDetail.passengerDetail.dateOfBirth.before(today);
    }

    public static BooleanExpression isValuedCustomer() {
        return QPassengerDetail.passengerDetail.valuedCustomer.eq(true);
    }
}
