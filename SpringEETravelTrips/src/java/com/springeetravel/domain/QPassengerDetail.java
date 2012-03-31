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

    private static final PathInits INITS = PathInits.DIRECT;

    public static final QPassengerDetail passengerDetail = new QPassengerDetail("passengerDetail");

    public final QAirSegment airSegmentId;

    public final StringPath contactEmail = createString("contactEmail");

    public final StringPath contactPhone = createString("contactPhone");

    public final StringPath countryOfNationalityCode = createString("countryOfNationalityCode");

    public final StringPath countryOfResidenceCode = createString("countryOfResidenceCode");

    public final DateTimePath<java.util.Date> dateOfBirth = createDateTime("dateOfBirth", java.util.Date.class);

    public final StringPath firstName = createString("firstName");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath initials = createString("initials");

    public final StringPath lastName = createString("lastName");

    public final StringPath passportId = createString("passportId");

    public final SimplePath<java.io.Serializable> valuedCustomer = createSimple("valuedCustomer", java.io.Serializable.class);

    public QPassengerDetail(String variable) {
        this(PassengerDetail.class, forVariable(variable), INITS);
    }

    public QPassengerDetail(PathMetadata<?> metadata) {
        this(metadata, metadata.isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QPassengerDetail(PathMetadata<?> metadata, PathInits inits) {
        this(PassengerDetail.class, metadata, inits);
    }

    public QPassengerDetail(Class<? extends PassengerDetail> type, PathMetadata<?> metadata, PathInits inits) {
        super(type, metadata, inits);
        this.airSegmentId = inits.isInitialized("airSegmentId") ? new QAirSegment(forProperty("airSegmentId"), inits.get("airSegmentId")) : null;
    }

}
