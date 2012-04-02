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

    private static final long serialVersionUID = -2092403828;

    public static final QUniversalRecord universalRecord = new QUniversalRecord("universalRecord");

    public final ListPath<AirSegment, SimplePath<AirSegment>> airSegmentList = this.<AirSegment, SimplePath<AirSegment>>createList("airSegmentList", AirSegment.class, SimplePath.class);

    public final DateTimePath<java.util.Date> createDate = createDateTime("createDate", java.util.Date.class);

    public final StringPath id = createString("id");

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

