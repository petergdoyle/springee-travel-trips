package com.springeetravel.domain;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.*;
import com.mysema.query.types.path.*;

import javax.annotation.Generated;


/**
 * QAirSegment is a Querydsl query type for AirSegment
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QAirSegment extends EntityPathBase<AirSegment> {

    private static final long serialVersionUID = 1758711501;

    private static final PathInits INITS = PathInits.DIRECT;

    public static final QAirSegment airSegment = new QAirSegment("airSegment");

    public final DateTimePath<java.util.Date> createDate = createDateTime("createDate", java.util.Date.class);

    public final QFlightDetail flightDetail;

    public final ListPath<FormOfPayment, QFormOfPayment> formOfPaymentList = this.<FormOfPayment, QFormOfPayment>createList("formOfPaymentList", FormOfPayment.class, QFormOfPayment.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final ListPath<PassengerDetail, QPassengerDetail> passengerDetailList = this.<PassengerDetail, QPassengerDetail>createList("passengerDetailList", PassengerDetail.class, QPassengerDetail.class);

    public final QUniversalRecord universalRecordId;

    public QAirSegment(String variable) {
        this(AirSegment.class, forVariable(variable), INITS);
    }

    public QAirSegment(PathMetadata<?> metadata) {
        this(metadata, metadata.isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QAirSegment(PathMetadata<?> metadata, PathInits inits) {
        this(AirSegment.class, metadata, inits);
    }

    public QAirSegment(Class<? extends AirSegment> type, PathMetadata<?> metadata, PathInits inits) {
        super(type, metadata, inits);
        this.flightDetail = inits.isInitialized("flightDetail") ? new QFlightDetail(forProperty("flightDetail"), inits.get("flightDetail")) : null;
        this.universalRecordId = inits.isInitialized("universalRecordId") ? new QUniversalRecord(forProperty("universalRecordId")) : null;
    }

}

