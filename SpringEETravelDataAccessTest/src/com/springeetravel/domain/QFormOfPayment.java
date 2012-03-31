package com.springeetravel.domain;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.*;
import com.mysema.query.types.path.*;

import javax.annotation.Generated;


/**
 * QFormOfPayment is a Querydsl query type for FormOfPayment
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QFormOfPayment extends EntityPathBase<FormOfPayment> {

    private static final long serialVersionUID = 1550560519;

    private static final PathInits INITS = PathInits.DIRECT;

    public static final QFormOfPayment formOfPayment = new QFormOfPayment("formOfPayment");

    public final QAirSegment airSegmentId;

    public final StringPath creditCardName = createString("creditCardName");

    public final StringPath creditCardNumber = createString("creditCardNumber");

    public final StringPath creditCcid = createString("creditCcid");

    public final StringPath creditExpiry = createString("creditExpiry");

    public final StringPath formOfPaymentType = createString("formOfPaymentType");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public QFormOfPayment(String variable) {
        this(FormOfPayment.class, forVariable(variable), INITS);
    }

    public QFormOfPayment(PathMetadata<?> metadata) {
        this(metadata, metadata.isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QFormOfPayment(PathMetadata<?> metadata, PathInits inits) {
        this(FormOfPayment.class, metadata, inits);
    }

    public QFormOfPayment(Class<? extends FormOfPayment> type, PathMetadata<?> metadata, PathInits inits) {
        super(type, metadata, inits);
        this.airSegmentId = inits.isInitialized("airSegmentId") ? new QAirSegment(forProperty("airSegmentId"), inits.get("airSegmentId")) : null;
    }

}

