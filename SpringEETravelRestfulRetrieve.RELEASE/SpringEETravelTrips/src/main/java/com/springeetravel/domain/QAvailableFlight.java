package com.springeetravel.domain;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.*;
import com.mysema.query.types.path.*;

import javax.annotation.Generated;


/**
 * QAvailableFlight is a Querydsl query type for AvailableFlight
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QAvailableFlight extends EntityPathBase<AvailableFlight> {

    private static final long serialVersionUID = -28421419;

    public static final QAvailableFlight availableFlight = new QAvailableFlight("availableFlight");

    public final StringPath airline = createString("airline");

    public final StringPath airlineCode = createString("airlineCode");

    public final StringPath airlineFlightNumber = createString("airlineFlightNumber");

    public final StringPath arrivalAirportCode = createString("arrivalAirportCode");

    public final DateTimePath<java.util.Date> arrivalTime = createDateTime("arrivalTime", java.util.Date.class);

    public final StringPath classOfService = createString("classOfService");

    public final StringPath departureAirportCode = createString("departureAirportCode");

    public final DateTimePath<java.util.Date> departureTime = createDateTime("departureTime", java.util.Date.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final NumberPath<Double> price = createNumber("price", Double.class);

    public QAvailableFlight(String variable) {
        super(AvailableFlight.class, forVariable(variable));
    }

    public QAvailableFlight(Path<? extends AvailableFlight> entity) {
        super(entity.getType(), entity.getMetadata());
    }

    public QAvailableFlight(PathMetadata<?> metadata) {
        super(AvailableFlight.class, metadata);
    }

}

