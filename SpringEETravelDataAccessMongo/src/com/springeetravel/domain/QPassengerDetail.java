package com.springeetravel.domain;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.*;
import com.mysema.query.types.path.*;

import javax.annotation.Generated;


/**
 * QPassengerDetail is a Querydsl query type for PassengerDetail
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QPassengerDetail extends EntityPathBase<PassengerDetail> {

    private static final long serialVersionUID = -2072494437;

    public static final QPassengerDetail passengerDetail = new QPassengerDetail("passengerDetail");

    public final SimplePath<AirSegment> airSegmentId = createSimple("airSegmentId", AirSegment.class);

    public final StringPath contactEmail = createString("contactEmail");

    public final StringPath contactPhone = createString("contactPhone");

    public final StringPath countryOfNationalityCode = createString("countryOfNationalityCode");

    public final StringPath countryOfResidenceCode = createString("countryOfResidenceCode");

    public final DateTimePath<java.util.Date> dateOfBirth = createDateTime("dateOfBirth", java.util.Date.class);

    public final StringPath firstName = createString("firstName");

    public final StringPath id = createString("id");

    public final StringPath initials = createString("initials");

    public final StringPath lastName = createString("lastName");

    public final StringPath passportId = createString("passportId");

    public final BooleanPath valuedCustomer = createBoolean("valuedCustomer");

    public QPassengerDetail(String variable) {
        super(PassengerDetail.class, forVariable(variable));
    }

    public QPassengerDetail(Path<? extends PassengerDetail> entity) {
        super(entity.getType(), entity.getMetadata());
    }

    public QPassengerDetail(PathMetadata<?> metadata) {
        super(PassengerDetail.class, metadata);
    }

}

