package com.springeetravel.domain;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.*;
import com.mysema.query.types.path.*;

import javax.annotation.Generated;


/**
 * QUniversalRecord is a Querydsl query type for UniversalRecord
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QUniversalRecord extends EntityPathBase<UniversalRecord> {

    private static final long serialVersionUID = -612334408;

    public static final QUniversalRecord universalRecord = new QUniversalRecord("universalRecord");

    public final ListPath<AirSegment, QAirSegment> airSegmentList = this.<AirSegment, QAirSegment>createList("airSegmentList", AirSegment.class, QAirSegment.class);

    public final DateTimePath<java.util.Date> createDate = createDateTime("createDate", java.util.Date.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public QUniversalRecord(String variable) {
        super(UniversalRecord.class, forVariable(variable));
    }

    public QUniversalRecord(Path<? extends UniversalRecord> entity) {
        super(entity.getType(), entity.getMetadata());
    }

    public QUniversalRecord(PathMetadata<?> metadata) {
        super(UniversalRecord.class, metadata);
    }

}

