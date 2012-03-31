package com.springeetravel.domain;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.*;
import com.mysema.query.types.path.*;

import javax.annotation.Generated;


/**
 * QUniversalRecordXml is a Querydsl query type for UniversalRecordXml
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QUniversalRecordXml extends EntityPathBase<UniversalRecordXml> {

    private static final long serialVersionUID = -1328154561;

    public static final QUniversalRecordXml universalRecordXml = new QUniversalRecordXml("UNIVERSAL_RECORDS_XML");

    public final DateTimePath<java.util.Date> createDate = createDateTime("CREATE_DATE", java.util.Date.class);

    public final NumberPath<Long> id = createNumber("ID", Long.class);

    public final StringPath xml = createString("XML");

    public QUniversalRecordXml(String variable) {
        super(UniversalRecordXml.class, forVariable(variable));
    }

    public QUniversalRecordXml(Path<? extends UniversalRecordXml> entity) {
        super(entity.getType(), entity.getMetadata());
    }

    public QUniversalRecordXml(PathMetadata<?> metadata) {
        super(UniversalRecordXml.class, metadata);
    }

}

