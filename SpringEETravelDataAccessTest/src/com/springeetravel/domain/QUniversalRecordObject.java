package com.springeetravel.domain;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.*;
import com.mysema.query.types.path.*;

import javax.annotation.Generated;


/**
 * QUniversalRecordObject is a Querydsl query type for UniversalRecordObject
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QUniversalRecordObject extends EntityPathBase<UniversalRecordObject> {

    private static final long serialVersionUID = -2081576425;

    public static final QUniversalRecordObject universalRecordObject = new QUniversalRecordObject("universalRecordObject");

    public final DateTimePath<java.util.Date> createDate = createDateTime("createDate", java.util.Date.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final ArrayPath<Byte> objectValue = createArray("objectValue", Byte[].class);

    public QUniversalRecordObject(String variable) {
        super(UniversalRecordObject.class, forVariable(variable));
    }

    public QUniversalRecordObject(Path<? extends UniversalRecordObject> entity) {
        super(entity.getType(), entity.getMetadata());
    }

    public QUniversalRecordObject(PathMetadata<?> metadata) {
        super(UniversalRecordObject.class, metadata);
    }

}

