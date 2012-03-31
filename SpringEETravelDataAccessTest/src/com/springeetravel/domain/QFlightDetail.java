package com.springeetravel.domain;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.*;
import com.mysema.query.types.path.*;

import javax.annotation.Generated;


/**
 * QFlightDetail is a Querydsl query type for FlightDetail
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QFlightDetail extends EntityPathBase<FlightDetail> {

    private static final long serialVersionUID = 140880933;

    private static final PathInits INITS = PathInits.DIRECT;

    public static final QFlightDetail flightDetail = new QFlightDetail("flightDetail");

    public final StringPath airline = createString("airline");

    public final StringPath airlineCode = createString("airlineCode");

    public final StringPath airlineFlightNumber = createString("airlineFlightNumber");

    public final QAirSegment airSegmentId;

    public final StringPath arrivalAirportCode = createString("arrivalAirportCode");

    public final DateTimePath<java.util.Date> arrivalTime = createDateTime("arrivalTime", java.util.Date.class);

    public final StringPath classOfService = createString("classOfService");

    public final StringPath departureAirportCode = createString("departureAirportCode");

    public final DateTimePath<java.util.Date> departureTime = createDateTime("departureTime", java.util.Date.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final NumberPath<Double> price = createNumber("price", Double.class);

    public QFlightDetail(String variable) {
        this(FlightDetail.class, forVariable(variable), INITS);
    }

    public QFlightDetail(PathMetadata<?> metadata) {
        this(metadata, metadata.isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QFlightDetail(PathMetadata<?> metadata, PathInits inits) {
        this(FlightDetail.class, metadata, inits);
    }

    public QFlightDetail(Class<? extends FlightDetail> type, PathMetadata<?> metadata, PathInits inits) {
        super(type, metadata, inits);
        this.airSegmentId = inits.isInitialized("airSegmentId") ? new QAirSegment(forProperty("airSegmentId"), inits.get("airSegmentId")) : null;
    }

}

